package com.br.vitor.desafio2.exceptions;

public class InvalidFileException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidFileException(String message) {
        super("Arquivo inválido: " + message);
    }
}
