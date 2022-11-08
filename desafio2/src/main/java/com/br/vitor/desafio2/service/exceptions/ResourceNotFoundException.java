package com.br.vitor.desafio2.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static  final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Recurso não encontrado. Id " + id);
    }

}
