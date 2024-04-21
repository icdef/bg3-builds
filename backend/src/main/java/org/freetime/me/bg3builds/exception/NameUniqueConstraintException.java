package org.freetime.me.bg3builds.exception;

public class NameUniqueConstraintException extends RuntimeException {

    public NameUniqueConstraintException(String message) {
        super(message);
    }

    public NameUniqueConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
