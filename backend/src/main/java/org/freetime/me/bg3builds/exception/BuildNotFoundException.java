package org.freetime.me.bg3builds.exception;

public class BuildNotFoundException extends RuntimeException {

    public BuildNotFoundException(String message) {
        super(message);
    }

    public BuildNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
