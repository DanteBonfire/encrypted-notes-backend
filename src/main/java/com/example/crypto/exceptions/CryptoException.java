package com.example.crypto.exceptions;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public abstract class CryptoException extends Exception {

    private final UUID uuid = UUID.randomUUID();

    public CryptoException() {
    }

    public CryptoException(String message) {
        super(message);
    }

    public CryptoException(
        String message,
        Throwable cause
    )
    {
        super(message, cause);
    }

    public CryptoException(Throwable cause) {
        super(cause);
    }

    public CryptoException(
        String message,
        Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace
    )
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Map getData() {
        return Collections.emptyMap();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    abstract public int getHttpStatusCode();
}

