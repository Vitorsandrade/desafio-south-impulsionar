package com.br.vitor.desafio2.exceptions;

public class InvalidCodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidCodeException(String message) {
        super("Invalid Code! : " + message);
    }
}
