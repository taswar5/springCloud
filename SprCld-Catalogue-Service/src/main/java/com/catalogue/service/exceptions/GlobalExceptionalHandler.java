package com.catalogue.service.exceptions;

import com.catalogue.service.model.TransactionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<TransactionResponse> gotException() {
        TransactionResponse tr = new TransactionResponse();
        tr.setInstanceId("Error:: NullPointer Exception");
        return new ResponseEntity<>(tr, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<String> missingHeaderException() {
        return new ResponseEntity<>(":::::Request Not routed from gateway-service:::Required Authorization", HttpStatus.UNAUTHORIZED);
    }


}
