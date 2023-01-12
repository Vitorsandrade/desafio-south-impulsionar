package com.br.vitor.produtoApi.exceptions;

import java.io.IOException;

public class FileIsEmptyException extends IOException {

    private static final long serialVersionUID = 1L;

    public FileIsEmptyException(String message) {
        super(message);
    }
}
