package com.example.crypto.exceptions.note;

import com.example.crypto.exceptions.CryptoException;

public class NoteNotFoundException extends CryptoException {

    NoteNotFoundException(){}

    public NoteNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatusCode() {
        return 404;
    }
}
