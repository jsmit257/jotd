package com.jotd.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;

import com.jotd.data.Conn;
import com.sun.net.httpserver.HttpServer;

public class Server {

  private Logger log;

  private Server() {
  }

  public Server(String ctxRoot, int port, Conn conn, Logger log) throws IOException {
    this();
    this.log = log;
    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

    HttpServer srv = HttpServer.create(new InetSocketAddress("localhost", port), 0);
    srv.createContext("/" + ctxRoot, new JokeHandler(conn.getJokes(), this.log));
    srv.setExecutor(threadPoolExecutor);
    srv.start();

    log.info("Server started on port {}", port);
  }

}
