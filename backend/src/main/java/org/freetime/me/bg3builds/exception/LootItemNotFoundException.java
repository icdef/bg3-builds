package org.freetime.me.bg3builds.exception;

public class LootItemNotFoundException extends RuntimeException {

    public LootItemNotFoundException(String message) {
        super(message);
    }

    public LootItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
