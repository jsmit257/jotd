package com.jotd.http;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import com.jotd.data.IJokes;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;

public final class GetTests {

  private static class TestCase {
    String input, expected;
    int sc;
    IJokes mockJokes;
  }

  @Test
  public void doGet() {
    Map<String, GetTests.TestCase> tcs = new HashMap<String, GetTests.TestCase>() {
      {
        put("happy path", new TestCase() {
          {
            input = "{\"day\":\"2023-09-23\"}";
            sc = HttpURLConnection.HTTP_OK;
            mockJokes = new MockJokes() {
              @Override
              public Joke readJoke(Date d) throws SQLException, NotFoundException {
                return new Joke(Date.valueOf("2023-09-23"), "happy path", null);
              }
            };
            expected = "{\"day\":\"2023-09-23\",\"id\":0,\"text\":\"happy path\"}";
          }
        });
        put("not found", new TestCase() {
          {
            input = "{\"day\":\"2023-09-23\"}";
            sc = HttpURLConnection.HTTP_NOT_FOUND;
            mockJokes = new MockJokes() {
              @Override
              public Joke readJoke(Date d) throws SQLException, NotFoundException {
                throw new NotFoundException("not found");
              }
            };
            expected = "{\"error\":\"no joke found\"}";
          }
        });
        put("bad date format", new TestCase() {
          {
            input = "{\"day\":\"foobar\"}";
            sc = HttpURLConnection.HTTP_BAD_REQUEST;
            expected = "{\"error\":\"day field is malformed\"}";
          }
        });
        put("missing date", new TestCase() {
          {
            input = "{}";
            sc = HttpURLConnection.HTTP_BAD_REQUEST;
            expected = "{\"error\":\"request is missing required 'day' field\"}";
          }
        });
        put("missing input", new TestCase() {
          {
            input = "";
            sc = HttpURLConnection.HTTP_BAD_REQUEST;
            expected = "{\"error\":\"couldn't parse json data ''\"}";
          }
        });
        put("internal server error", new TestCase() {
          {
            input = "{\"day\":\"2023-09-23\"}";
            sc = HttpURLConnection.HTTP_INTERNAL_ERROR;
            mockJokes = new MockJokes() {
              @Override
              public Joke readJoke(Date d) throws SQLException, NotFoundException {
                throw new SQLException("internal server error");
              }
            };
            expected = "{\"error\":\"couldn't fetch joke\"}";
          }
        });
      };
    };

    for (Entry<String, GetTests.TestCase> es : tcs.entrySet()) {
      String name = es.getKey();
      GetTests.TestCase tc = es.getValue();

      JokeHandler handler = new JokeHandler(tc.mockJokes, LoggerFactory.getLogger(JokeHandlerTests.class));

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      MockHttpExchange xchg = new MockHttpExchange("GET", tc.input, out);
      handler.handle(xchg);

      assertEquals(String.format("%s, status code", name), tc.sc, xchg.getResponseCode());

      assertEquals(String.format("%s comparing getJoke output", name), tc.expected, new String(out.toByteArray()));

    }
  }

}