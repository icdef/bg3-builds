package org.freetime.me.bg3builds.exception;

public class BuildLootItemNotFoundException extends RuntimeException {
    public BuildLootItemNotFoundException(String message) {
        super(message);
    }

    public BuildLootItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
