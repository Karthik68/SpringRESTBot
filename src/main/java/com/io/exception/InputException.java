package com.io.exception;

/**
 * Exception representing error during input read. The whole app is
 * build around a input and there is no way for it to recover if it can't
 * rad it. Hence the exception is runtime.
 */
public class InputException extends RuntimeException {

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputException(Throwable cause) {
        super(cause);
    }
}
