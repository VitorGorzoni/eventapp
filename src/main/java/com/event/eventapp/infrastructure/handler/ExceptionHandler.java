package com.event.eventapp.infrastructure.handler;

import com.event.eventapp.infrastructure.exceptions.ErrorMessage;
import com.event.eventapp.infrastructure.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleNoSuchElementFoundException(
            NotFoundException exception,
            WebRequest request
    ) {
        var error = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(exception.getMessage())
                .description(request.getDescription(false))
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
