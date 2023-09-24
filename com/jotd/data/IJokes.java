package com.jotd.data;

import java.sql.Date;
import java.sql.SQLException;

import com.jotd.exceptions.DuplicateKeyException;
import com.jotd.exceptions.NotFoundException;
import com.jotd.types.Joke;

/**
 * useful for mocks farther up the stack
 */
public interface IJokes {

  Joke createJoke(Joke j) throws SQLException, DuplicateKeyException;

  Joke readJoke(Date d) throws SQLException, NotFoundException;

  Joke updateJoke(Date d, Joke j) throws SQLException, DuplicateKeyException, NotFoundException;

  Joke deleteJoke(Date d) throws SQLException, NotFoundException;

}