package com.example.personaddress.aop.exceptionHandller;

import lombok.Setter;

@Setter
public class CustomerException extends RuntimeException{

    private final String errorCode;

    public CustomerException(String errorCode) {
        this.errorCode = errorCode;
    }

    public CustomerException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomerException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public CustomerException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}
