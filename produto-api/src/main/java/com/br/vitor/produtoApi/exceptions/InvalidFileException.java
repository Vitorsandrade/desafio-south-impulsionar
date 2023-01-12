package com.br.vitor.produtoApi.exceptions;

public class InvalidFileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidFileException(String message) {
        super("Invalid File! : " + message);
    }
}
