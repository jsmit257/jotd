package com.jotd.http;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import org.slf4j.Logger;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class SimpleFileHandler implements HttpHandler {

  private Logger log;

  /**
   * SimpleFileHandler exists to handle index.html so it can call /jotd without
   * violating xss rules; should work as-is for js, css, etc, if needed
   */
  private SimpleFileHandler() {
  }

  public SimpleFileHandler(Logger log) {
    this();
    this.log = log;
  }

  @Override
  public void handle(HttpExchange xchg) {

    String file = xchg.getRequestURI().getPath();

    FileInputStream fis = null;
    byte[] data;
    try {
      fis = new FileInputStream("./www" + file);
      data = fis.readAllBytes();
    } catch (IOException ioe) {
      log.error("couldn't load resource", ioe);
      return;
    } finally {
      if (fis != null) {
        try {
          fis.close();
        } catch (Exception e) {
          log.error("couldn't close file input", e);
          return;
        }
      }
    }

    OutputStream response = xchg.getResponseBody();
    try {
      xchg.sendResponseHeaders(HttpURLConnection.HTTP_OK, data.length);

      response.write(data);
      response.flush();
    } catch (IOException ioe) {
      log.error("couldn't write data", ioe);
    } finally {
      try {
        response.close();
      } catch (Exception e) {
        log.error("failed to close responseBody", e);
      }
    }
  }
}
