package com.jotd.exceptions;

public class InternalErrorException extends Throwable {

  public InternalErrorException(String message) {
    super(message);
  }

  public InternalErrorException(String message, Throwable cause) {
    super(message, cause);
  }

}
