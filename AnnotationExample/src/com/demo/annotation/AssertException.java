package com.demo.annotation;

public class AssertException extends RuntimeException {

    private static final long serialVersionUID = 3793171626258679203L;

    
    public AssertException() {
        super();
    }

    public AssertException(String message) {
        super(message);
    }

    public AssertException(String message, Throwable cause) {
        super(message, cause);
    }

}