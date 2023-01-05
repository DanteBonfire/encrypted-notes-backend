package com.example.crypto.exceptions.userNote;

import com.example.crypto.exceptions.CryptoException;

public class UserNoteNotFoundException extends CryptoException {

    UserNoteNotFoundException(){}

    public UserNoteNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatusCode() {
        return 404;
    }
}
