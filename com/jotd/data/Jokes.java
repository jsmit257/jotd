package com.jotd.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;

import com.jotd.exceptions.DuplicateKeyException;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;

class Jokes implements IJokes {

  private Connection connection;
  private Logger log;

  private Jokes() {
  }

  public Jokes(Connection connection, Logger log) {
    this();
    this.connection = connection;
    this.log = log;
    log.info("successfully initialized jokes");
  }

  @Override
  public Joke createJoke(Joke j) throws SQLException, DuplicateKeyException {
    try {
      if (readJoke(j.getDay()) != null) {
        throw new DuplicateKeyException(String.format("a joke exists for day: '%s'", j.getDay()));
      }
    } catch (NotFoundException e) {
      log.debug("no joke for day '{}'", j.getDay());
    }

    PreparedStatement ps = connection.prepareStatement("insert into jokes (day, text, description) values (?, ?, ?)");
    ps.setDate(1, j.getDay());
    ps.setString(2, j.getText());
    if (j.getDesc() == null || j.getDesc().isBlank()) {
      ps.setNull(3, Types.VARCHAR);
    } else {
      ps.setString(3, j.getDesc());
    }

    if (ps.executeUpdate() != 1) {
      throw new RuntimeException("couldn't create joke");
    }
    return j;
  }

  @Override
  public Joke readJoke(Date d) throws SQLException, NotFoundException {
    Joke result;

    PreparedStatement ps = connection.prepareStatement("select id, text, description from jokes where day = ?");
    ps.setDate(1, d);

    ResultSet rs = ps.executeQuery();
    try {
      if (!rs.next()) {
        throw new NotFoundException(String.format("not found for day: '%s'", d));
      }

      result = new Joke(
          rs.getInt("id"),
          d,
          rs.getString("text"),
          rs.getString("description"));
    } finally {
      try {
        rs.close();
      } catch (Exception e) {
        log.error("failed to close result set", e);
      }
    }

    return result;
  }

  @Override
  public Joke updateJoke(Date d, Joke j) throws SQLException, DuplicateKeyException, NotFoundException {
    if (!d.equals(j.getDay())) {
      try {
        if (readJoke(j.getDay()) != null) {
          throw new DuplicateKeyException("there's already a joke for that day");
        }
      } catch (NotFoundException e) {
        log.debug("no joke for day '{}'", j.getDay());
      }
    }
    Joke oldJoke = readJoke(d);
    PreparedStatement ps = connection
        .prepareStatement("update jokes set day = ?, text = ?, description = ? where id = ?");
    ps.setDate(1, j.getDay());
    ps.setString(2, j.getText());
    if (j.getDesc() == null || j.getDesc().isBlank()) {
      ps.setNull(3, Types.VARCHAR);
    } else {
      ps.setString(3, j.getDesc());
    }
    ps.setLong(4, oldJoke.getId());

    if (ps.executeUpdate() != 1) {
      throw new RuntimeException("couldn't update joke");
    }

    return oldJoke;
  }

  @Override
  public Joke deleteJoke(Date d) throws SQLException, NotFoundException {
    Joke oldJoke = readJoke(d);
    PreparedStatement ps = connection.prepareStatement("delete from jokes where id = ?");
    ps.setLong(1, oldJoke.getId());
    if (ps.executeUpdate() != 1) {
      throw new RuntimeException(String.format("row could not be deleted: '%s'", oldJoke));
    }
    return oldJoke;
  }
}
