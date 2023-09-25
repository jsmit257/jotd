package com.jotd.cmd;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jotd.data.Conn;
import com.jotd.http.Server;

public class JOTD {

  private static final String APP_LOCALE = "JOTD_CONFIG";
  private static final String SERVER_HOST = "SERVER_HOST";
  private static final String SERVER_PORT = "SERVER_PORT";

  public static void main(String[] args) {

    Logger log = LoggerFactory.getLogger(JOTD.class);

    String appLocale = System.getenv(JOTD.APP_LOCALE);
    String hostname = System.getenv(JOTD.SERVER_HOST);
    String port = System.getenv(JOTD.SERVER_PORT);
    if (appLocale == null) {
      appLocale = "";
    }

    ResourceBundle p = ResourceBundle.getBundle(
        "jotd",
        Locale.of(appLocale),
        JOTD.class.getClassLoader());

    log.info("successfully loaded resource bundle: '{}'", p.getLocale());

    Conn conn;
    try {
      conn = new Conn(p.getString("jdbc.url"), log);
    } catch (SQLException e) {
      log.error("couldn't connect to database", e);
      return;
    }

    log.info("successfully configured database conn: '{}'", conn);

    try {
      new Server(
          p.getString("app.name"),
          hostname,
          Integer.parseInt(port),
          conn,
          log);
    } catch (NumberFormatException | IOException e) {
      log.error("couldn't start server", e);
    }

    log.info("successfully exiting application");

  };

}
