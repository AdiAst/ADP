package com.lithan.exception;

public class StoreNotFoundException extends Exception {
  public StoreNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}