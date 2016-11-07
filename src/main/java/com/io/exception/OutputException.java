package com.io.exception;

/**
 * Exception representing error during input read. If the app can't produce output,
 * there is no reason for it to continue. Hence the exception is runtime.
 */
public class OutputException extends RuntimeException{

    public OutputException(String message) {
        super(message);
    }

    public OutputException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutputException(Throwable cause) {
        super(cause);
    }
}
