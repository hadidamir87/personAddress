package com.example.personaddress.aop.exceptionHandller;

import com.example.personaddress.aop.exceptionHandller.custom.DuplicatePerson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestException {

    @ExceptionHandler(DuplicatePerson.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDetailsForClient> getValidation(DuplicatePerson duplicatePerson) {

        ErrorDetailsForClient exceptionResponse = new ErrorDetailsForClient();
        exceptionResponse.setError(true);

//        exceptionResponse.setMessage(String.valueOf(duplicatePerson));
        exceptionResponse.setMessage("duplicate name is not allowed.");

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

}
