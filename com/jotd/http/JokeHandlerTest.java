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
import org.slf4j.LoggerFactory;

import com.jotd.data.IJokes;
import com.jotd.exceptions.DuplicateKeyException;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

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

public class JokeHandlerTest {

  public static final class GetTest {

    private static class GetTestCase {
      String input, expected;
      int sc;
      IJokes jokes;
    }

    @Test
    public static void TestGet() {
      Map<String, GetTestCase> tcs = new HashMap<String, GetTestCase>() {
        {
          put("happy path", new GetTestCase() {
            {
              input = "{\"day\":\"2023-09-23\"}";
              sc = HttpURLConnection.HTTP_OK;
              jokes = new MockJokes() {
                @Override
                public Joke readJoke(Date d) throws SQLException, NotFoundException {
                  return new Joke(new Date(2023, 9, 23), "happy path", null);
                }
              };
              expected = "{\"day\":\"2023-09-23\",\"text\":\"happy path\"}";
            }
          });
          put("not found", new GetTestCase() {
            {
              input = "{\"day\":\"2023-09-23\"}";
              sc = HttpURLConnection.HTTP_NOT_FOUND;
              jokes = new MockJokes() {
                @Override
                public Joke readJoke(Date d) throws SQLException, NotFoundException {
                  throw new NotFoundException("not found");
                }
              };
              expected = "{\"error\":\"no joke found\"}";
            }
          });
          put("bad date format", new GetTestCase() {
            {
              input = "{\"day\":\"foobar\"}";
              sc = HttpURLConnection.HTTP_BAD_REQUEST;
            }
          });
          put("missing date", new GetTestCase() {
            {
              input = "{}";
              sc = HttpURLConnection.HTTP_BAD_REQUEST;
            }
          });
          put("missing input", new GetTestCase() {
            {
              input = "";
              sc = HttpURLConnection.HTTP_BAD_REQUEST;
              expected = "{\"error\":\"couldn't parse json data ''\"}";
            }
          });
          put("internal server error", new GetTestCase() {
            {
              input = "{\"day\":\"2023-09-23\"}";
              sc = HttpURLConnection.HTTP_INTERNAL_ERROR;
              jokes = new MockJokes() {
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
      for (Entry<String, GetTestCase> es : tcs.entrySet()) {
        // String name = es.getKey();
        GetTestCase tc = es.getValue();

        JokeHandler handler = new JokeHandler(tc.jokes, LoggerFactory.getLogger(JokeHandlerTest.class));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MockHttpExchange xchg = new MockHttpExchange("GET", tc.input, out);
        handler.handle(xchg);

        assertEquals("status code", tc.sc, xchg.getResponseCode());

        assertEquals("comparing getJoke output", tc.expected, new String(out.toByteArray()));

      }
    }

  }

}

class MockHttpExchange extends HttpExchange {
  private InputStream requestBody;
  private Headers headers;
  private OutputStream responseBody;
  private String method;
  private int statusCode;

  public MockHttpExchange(String method, String data, OutputStream out) {
    this.method = method;
    requestBody = new ByteArrayInputStream(data.getBytes());
    headers = new Headers();
    responseBody = out;
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
    throw new UnsupportedOperationException("Unimplemented method 'getRequestURI'");
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
