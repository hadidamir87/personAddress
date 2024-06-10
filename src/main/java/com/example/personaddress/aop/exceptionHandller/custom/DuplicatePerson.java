package com.example.personaddress.aop.exceptionHandller.custom;

public class DuplicatePerson  extends RuntimeException{

    private final String errorCode;



    public DuplicatePerson(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
