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

  /**
   * @param j
   * @return
   * @throws SQLException
   * @throws DuplicateKeyException
   */
  Joke createJoke(Joke j) throws SQLException, DuplicateKeyException;

  /**
   * @param d
   * @return
   * @throws SQLException
   * @throws NotFoundException
   */
  Joke readJoke(Date d) throws SQLException, NotFoundException;

  /**
   * @param d
   * @param j
   * @return
   * @throws SQLException
   * @throws DuplicateKeyException
   * @throws NotFoundException
   */
  Joke updateJoke(Date d, Joke j) throws SQLException, DuplicateKeyException, NotFoundException;

  /**
   * @param d
   * @return
   * @throws SQLException
   * @throws NotFoundException
   */
  Joke deleteJoke(Date d) throws SQLException, NotFoundException;

}