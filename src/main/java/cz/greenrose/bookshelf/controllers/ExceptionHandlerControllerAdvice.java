package cz.greenrose.bookshelf.controllers;

import cz.greenrose.bookshelf.DTO.ErrorResponse;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> NoIDFoundException(NoIDFoundException exception) {
        return new ResponseEntity<>(new ErrorResponse("error", exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> DuplicateEntryException(DuplicateEntryException exception) {
        return new ResponseEntity<>(new ErrorResponse("error", exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
