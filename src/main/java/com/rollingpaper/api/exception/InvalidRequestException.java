package com.rollingpaper.api.exception;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
