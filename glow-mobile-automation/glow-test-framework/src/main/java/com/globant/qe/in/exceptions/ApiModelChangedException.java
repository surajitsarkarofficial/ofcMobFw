package com.globant.qe.in.exceptions;

import static java.lang.String.format;

public class ApiModelChangedException extends RuntimeException {

  public ApiModelChangedException(Throwable ex) {
    super(format("API model has changed and no longer matches current implementation. Please update pojo ASAP!\n%s", ex.getLocalizedMessage()));
  }

}