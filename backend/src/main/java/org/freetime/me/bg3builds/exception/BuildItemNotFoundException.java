package org.freetime.me.bg3builds.exception;

public class BuildItemNotFoundException extends RuntimeException {

    public BuildItemNotFoundException(String message) {
        super(message);
    }

    public BuildItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
