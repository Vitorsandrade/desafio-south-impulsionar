package com.br.vitor.produtoApi.exceptions;

public class InvalidCodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCodeException(String message) {
        super("Invalid Code! : " + message);
    }
}
