package com.jotd.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;

import com.jotd.data.IJokes;
import com.jotd.exceptions.BadRequestException;
import com.jotd.exceptions.DuplicateKeyException;
import com.jotd.exceptions.InternalErrorException;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class JokeHandler implements HttpHandler {

  private Logger log;
  private IJokes jokes;

  private JokeHandler() {
  }

  public JokeHandler(IJokes jokes, Logger log) {
    this();
    this.jokes = jokes;
    this.log = log;
    this.log.info("successfully initilized JokeHandler");
  }

  @Override
  public void handle(HttpExchange xchg) {

    int sc = HttpURLConnection.HTTP_OK;
    Map<String, Object> result = new HashMap<String, Object>();

    String reqText = new BufferedReader(new InputStreamReader(xchg.getRequestBody(), StandardCharsets.UTF_8))
        .lines()
        .collect(Collectors.joining("\n"));

    String method = xchg.getRequestMethod().toLowerCase();

    JSONObject reqData = null;
    try {
      reqData = new JSONObject(reqText);
    } catch (JSONException json) {
      method = "fail";
      log.error("couldn't parse json data", json);
    }

    try {
      switch (method) {
        case "get":
          result.putAll(getJoke(reqData));
          break;
        case "post":
          result.putAll(postJoke(reqData));
          sc = HttpURLConnection.HTTP_CREATED;
          break;
        case "patch":
          patchJoke(reqData);
          sc = HttpURLConnection.HTTP_NO_CONTENT;
          break;
        case "delete":
          deleteJoke(reqData);
          sc = HttpURLConnection.HTTP_NO_CONTENT;
          break;
        case "fail":
          result.put("error", String.format("couldn't parse json data '%s'", reqText));
          break;
        default:
          result.put("error", "invalid method");
          sc = HttpURLConnection.HTTP_BAD_METHOD;
      }
    } catch (NotFoundException e) {
      result.put("error", "no joke found");
      log.error("no joke found", e);
      sc = 404;
    } catch (BadRequestException e) {
      result.put("error", e.getMessage());
      log.error(e.getMessage(), e);
      sc = HttpURLConnection.HTTP_BAD_REQUEST;
    } catch (InternalErrorException e) {
      result.put("error", e.getMessage());
      log.error(e.getMessage(), e);
      sc = HttpURLConnection.HTTP_INTERNAL_ERROR;
    } catch (RuntimeException e) {
      result.put("error", e.getMessage());
      log.error(e.getMessage(), e);
      sc = 404;
    }

    int contentLength = -1;
    byte[] b = null;

    if (sc != HttpURLConnection.HTTP_NO_CONTENT) {
      b = JSONObject.valueToString(result).getBytes();
      contentLength = b.length;
    }

    OutputStream response = xchg.getResponseBody();
    try {
      xchg.sendResponseHeaders(sc, contentLength);
      xchg.getResponseHeaders().add("Content-Type", "application/json");

      response.write(b);
      response.flush();
    } catch (IOException e) {
      log.error("an error occurred writing the results", e);
    } finally {
      try {
        response.close();
      } catch (Exception e) {
        log.error("an error occurred closing the response body", e);
      }
    }

    log.info("successfully completed JokeHandler::handle with status code {}", sc);

  }

  public Map<String, Object> getJoke(JSONObject data)
      throws NotFoundException, InternalErrorException, BadRequestException {
    Date day = JokeHandler.getDay(data);
    Joke joke;

    try {
      joke = jokes.readJoke(day);
    } catch (SQLException e) {
      throw new InternalErrorException("couldn't fetch joke", e);
    }

    return new HashMap<String, Object>() {
      {
        put("id", joke.getId());
        put("day", joke.getDay());
        put("text", joke.getText());
        if (joke.getDesc() != null) {
          put("desc", joke.getDesc());
        }
      }
    };
  }

  public Map<String, Object> postJoke(JSONObject data) throws InternalErrorException, BadRequestException {
    Joke joke;

    try {
      joke = jokes.createJoke(JokeHandler.dataToJoke(data));
    } catch (SQLException e) {
      throw new InternalErrorException("couldn't create joke", e);
    } catch (DuplicateKeyException e) {
      throw new BadRequestException("a joke already exists for this day", e);
    }

    return new HashMap<String, Object>() {
      {
        put("id", joke.getId());
        put("day", joke.getDay());
        put("text", joke.getText());
        if (joke.getDesc() != null) {
          put("desc", joke.getDesc());
        }
      }
    };
  }

  public Map<String, Object> patchJoke(JSONObject data)
      throws BadRequestException, NotFoundException, InternalErrorException {
    Date originalDay;
    Joke joke;

    try {
      originalDay = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(data.getString("old-day")).getTime());
    } catch (JSONException e) {
      throw new BadRequestException("request is missing required 'old-day' field", e);
    } catch (ParseException e) {
      throw new BadRequestException("old-day field is malformed", e);
    }

    try {
      joke = jokes.updateJoke(originalDay, JokeHandler.dataToJoke(data));
    } catch (SQLException e) {
      throw new InternalErrorException("couldn't update joke", e);
    } catch (DuplicateKeyException e) {
      throw new BadRequestException("a joke already exists for the requested day", e);
    }

    return new HashMap<String, Object>() {
      {
        put("id", joke.getId());
        put("day", joke.getDay());
        put("text", joke.getText());
        if (joke.getDesc() != null) {
          put("desc", joke.getDesc());
        }
      }
    };
  }

  public Map<String, Object> deleteJoke(JSONObject data)
      throws NotFoundException, InternalErrorException, BadRequestException {
    Date day = JokeHandler.getDay(data);
    Joke joke;

    try {
      joke = jokes.deleteJoke(day);
    } catch (SQLException e) {
      throw new InternalErrorException("couldn't delete joke", e);
    }

    return new HashMap<String, Object>() {
      {
        put("id", joke.getId());
        put("day", joke.getDay());
        put("text", joke.getText());
        if (joke.getDesc() != null) {
          put("desc", joke.getDesc());
        }
      }
    };
  }

  private static Joke dataToJoke(JSONObject data) throws BadRequestException {
    Date day = JokeHandler.getDay(data);
    String text, desc = "";
    try {
      desc = data.getString("desc");
    } catch (JSONException e) {
      // desc is optional, so ignore this
    }
    try {
      text = data.getString("text");
    } catch (JSONException e) {
      throw new BadRequestException("request is missing required field(s)", e);
    }
    return new Joke(day, text, desc);
  }

  private static Date getDay(JSONObject data) throws BadRequestException {
    try {
      return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(data.getString("day")).getTime());
    } catch (JSONException e) {
      throw new BadRequestException("request is missing required 'day' field", e);
    } catch (ParseException e) {
      throw new BadRequestException("day field is malformed", e);
    }
  }
}
