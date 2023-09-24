package com.jotd.exceptions;

public class DuplicateKeyException extends Throwable {

  public DuplicateKeyException(String message) {
    super(message);
  }

  public DuplicateKeyException(String message, Throwable cause) {
    super(message, cause);
  }

}
