package org.freetime.me.bg3builds.exception;

public class BuildLootItemUniqueConstraintException extends RuntimeException {
    public BuildLootItemUniqueConstraintException(String message) {
        super(message);
    }

    public BuildLootItemUniqueConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}
