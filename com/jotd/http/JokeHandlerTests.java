package com.jotd.http;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jotd.data.IJokes;
import com.jotd.exceptions.DuplicateKeyException;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

public class JokeHandlerTests {

  class TestCase {
    String input, expected, params = "";
    int sc;
    IJokes mockJokes;

    TestCase(String input, String expected, int sc) {
      this.input = input;
      this.expected = expected;
      this.sc = sc;
    }

    TestCase(String input, String expected, int sc, IJokes mockJokes) {
      this(input, expected, sc);
      this.mockJokes = mockJokes;
    }

    TestCase(String input, String expected, int sc, IJokes mockJokes, String params) {
      this(input, expected, sc, mockJokes);
      this.params = params;
    }

    TestCase(String input, String expected, int sc, String params) {
      this(input, expected, sc, (IJokes) null);
      this.params = params;
    }
  }

  @Test
  public void doGet() {
    Map<String, TestCase> tcs = new HashMap<String, TestCase>();
    tcs.put("happy path", new TestCase(
        "",
        "{\"day\":\"2023-09-23\",\"id\":0,\"text\":\"happy path\"}",
        HttpURLConnection.HTTP_OK,
        new MockJokes() {
          @Override
          public Joke readJoke(Date d) throws SQLException, NotFoundException {
            return new Joke(Date.valueOf("2023-09-23"), "happy path", null);
          }
        },
        "day=2023-09-23"));
    tcs.put("not found", new TestCase(
        "",
        "{\"error\":\"no joke found\"}",
        HttpURLConnection.HTTP_NOT_FOUND,
        new MockJokes() {
          @Override
          public Joke readJoke(Date d) throws SQLException, NotFoundException {
            throw new NotFoundException("not found");
          }
        },
        "day=2023-09-23"));
    tcs.put("bad date format", new TestCase(
        "",
        "{\"error\":\"query string must include a properly formed 'day' parameter\"}",
        HttpURLConnection.HTTP_BAD_REQUEST,
        "day=foobar"));
    tcs.put("missing date", new TestCase(
        "{}",
        "{\"error\":\"query string must include a properly formed 'day' parameter\"}",
        HttpURLConnection.HTTP_BAD_REQUEST,
        "day="));
    tcs.put("missing input", new TestCase(
        "",
        "{\"error\":\"query string must include a properly formed 'day' parameter\"}",
        HttpURLConnection.HTTP_BAD_REQUEST));
    tcs.put("internal server error", new TestCase(
        "",
        "{\"error\":\"couldn't fetch joke\"}",
        HttpURLConnection.HTTP_INTERNAL_ERROR,
        new MockJokes() {
          @Override
          public Joke readJoke(Date d) throws SQLException, NotFoundException {
            throw new SQLException("internal server error");
          }
        },
        "day=2023-09-23"));

    doRequest("GET", tcs);
  }

  @Test
  public void doPost() {
    Map<String, TestCase> tcs = new HashMap<String, TestCase>();

    doRequest("POST", tcs);
  }

  @Test
  public void doPatch() {
    Map<String, TestCase> tcs = new HashMap<String, TestCase>();

    doRequest("PATCH", tcs);
  }

  @Test
  public void doDelete() {
    Map<String, TestCase> tcs = new HashMap<String, TestCase>();

    doRequest("DELETE", tcs);
  }

  private void doRequest(String method, Map<String, TestCase> tcs) {

    Logger log = LoggerFactory.getLogger(JokeHandlerTests.class);

    for (

    Entry<String, TestCase> es : tcs.entrySet()) {
      String name = es.getKey();
      System.err.println(String.format("running test, method: '%s', name: '%s'", method, name));
      TestCase tc = es.getValue();

      JokeHandler handler = new JokeHandler(tc.mockJokes, log);

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      MockHttpExchange xchg = new MockHttpExchange(method, tc.params, tc.input, out);
      handler.handle(xchg);

      assertEquals(String.format("method: '%s', name: '%s' status code", method, name), tc.sc, xchg.getResponseCode());
      assertEquals(
          String.format("%s comparing %s output", name, method),
          tc.expected,
          new String(out.toByteArray()));

    }
  }

}

abstract class MockJokes implements IJokes {

  @Override
  public Joke createJoke(Joke j) throws SQLException, DuplicateKeyException {
    throw new UnsupportedOperationException("Unimplemented method 'createJoke'");
  }

  @Override
  public Joke readJoke(Date d) throws SQLException, NotFoundException {
    throw new UnsupportedOperationException("Unimplemented method 'readJoke'");
  }

  @Override
  public Joke updateJoke(Date d, Joke j) throws SQLException, DuplicateKeyException, NotFoundException {
    throw new UnsupportedOperationException("Unimplemented method 'updateJoke'");
  }

  @Override
  public Joke deleteJoke(Date d) throws SQLException, NotFoundException {
    throw new UnsupportedOperationException("Unimplemented method 'deleteJoke'");
  }

}

class MockHttpExchange extends HttpExchange {
  private String params;
  private InputStream requestBody;
  private Headers headers;
  private OutputStream responseBody;
  private String method;
  private int statusCode;

  public MockHttpExchange(String method, String params, String data, OutputStream responseBody) {
    this.method = method;
    this.params = params;
    this.responseBody = responseBody;
    requestBody = new ByteArrayInputStream(data.getBytes());
    headers = new Headers();
  }

  @Override
  public InputStream getRequestBody() {
    return requestBody;
  }

  @Override
  public int getResponseCode() {
    return statusCode;
  }

  @Override
  public OutputStream getResponseBody() {
    return responseBody;
  }

  @Override
  public String getRequestMethod() {
    return method;
  }

  @Override
  public void sendResponseHeaders(int sc, long l) throws IOException {
    statusCode = sc;
  }

  @Override
  public Headers getResponseHeaders() {
    return headers;
  }

  @Override
  public void close() {
  }

  @Override
  public Object getAttribute(String arg0) {
    throw new UnsupportedOperationException("Unimplemented method 'getAttribute'");
  }

  @Override
  public HttpContext getHttpContext() {
    throw new UnsupportedOperationException("Unimplemented method 'getHttpContext'");
  }

  @Override
  public InetSocketAddress getLocalAddress() {
    throw new UnsupportedOperationException("Unimplemented method 'getLocalAddress'");
  }

  @Override
  public HttpPrincipal getPrincipal() {
    throw new UnsupportedOperationException("Unimplemented method 'getPrincipal'");
  }

  @Override
  public String getProtocol() {
    throw new UnsupportedOperationException("Unimplemented method 'getProtocol'");
  }

  @Override
  public InetSocketAddress getRemoteAddress() {
    throw new UnsupportedOperationException("Unimplemented method 'getRemoteAddress'");
  }

  @Override
  public Headers getRequestHeaders() {
    throw new UnsupportedOperationException("Unimplemented method 'getRequestHeaders'");
  }

  @Override
  public URI getRequestURI() {
    try {
      return new URI("snakeoil?" + params);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void setAttribute(String arg0, Object arg1) {
    throw new UnsupportedOperationException("Unimplemented method 'setAttribute'");
  }

  @Override
  public void setStreams(InputStream arg0, OutputStream arg1) {
    throw new UnsupportedOperationException("Unimplemented method 'setStreams'");
  }
}
