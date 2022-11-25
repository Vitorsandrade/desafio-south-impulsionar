package com.br.vitor.desafio2.exceptions;

import java.io.IOException;

public class FileIsEmptyException extends IOException {

    private static final long serialVersionUID = 1L;
    public FileIsEmptyException(String message) {
        super(message);
    }
}
