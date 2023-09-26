package com.jotd.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.sql.Date;
import java.sql.SQLException;

import com.jotd.data.IJokes;
import com.jotd.exceptions.DuplicateKeyException;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

public class JokeHandlerTests {
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
