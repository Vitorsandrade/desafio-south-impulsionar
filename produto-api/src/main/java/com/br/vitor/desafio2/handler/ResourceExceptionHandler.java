package com.br.vitor.desafio2.handler;

import com.br.vitor.desafio2.exceptions.FileIsEmptyException;
import com.br.vitor.desafio2.exceptions.InvalidCodeException;
import com.br.vitor.desafio2.exceptions.InvalidFileException;
import com.br.vitor.desafio2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> handlerResourceNotFound(ResourceNotFoundException e,
                                                                 HttpServletRequest request) {

        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(), status.value(), error,
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidFileException.class)
    public ResponseEntity<StandardError> handlerInvalidFile(InvalidFileException e,
                                                            HttpServletRequest request) {


        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(), status.value(), error,
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(FileIsEmptyException.class)
    public ResponseEntity<StandardError> handlerFileIsEmpty(FileIsEmptyException e,
                                                            HttpServletRequest request) {

        String error = "Invalid File!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(), status.value(), error,
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handlerMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                       HttpServletRequest request) {

        String error = "Fields: name, category, price and tax cannot be null or empty!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(), status.value(), error,
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(InvalidCodeException.class)
    public ResponseEntity<StandardError> handlerInvalidCode(InvalidCodeException e,
                                                                       HttpServletRequest request) {

        String error = "Invalid Code!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(LocalDateTime.now(), status.value(), error,
                e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }

}
