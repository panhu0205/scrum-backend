package com.exceptions;

/**
 * This exception will be thrown when user try to register a unappropriate ID
 */
public class IDNotAcceptedException extends RuntimeException {
   public IDNotAcceptedException(String message) {
      super(message);
   }
}
