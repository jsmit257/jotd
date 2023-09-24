package com.jotd.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;

public class Conn {

  private Logger log;
  private IJokes jokes;

  private Conn() {
  }

  public Conn(String url, Logger log) throws SQLException {
    this();
    this.log = log;
    Connection connection = DriverManager.getConnection(url);
    jokes = new Jokes(connection, this.log);
    log.info("successfully initialized connection");
  }

  public IJokes getJokes() {
    return jokes;
  }
}
