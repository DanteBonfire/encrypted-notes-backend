package com.example.crypto.exceptions.user;

import com.example.crypto.exceptions.CryptoException;

public class UserNotFoundException extends CryptoException {

    UserNotFoundException(){}

    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatusCode() {
        return 404;
    }
}
