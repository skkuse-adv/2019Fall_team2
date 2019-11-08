package com.kakao.util.exception;

public class ParameterMissingException extends RuntimeException {
    private static final long serialVersionUID = -3069940750063668160L;

    public ParameterMissingException(String str) {
        super(str);
    }

    public ParameterMissingException(Exception exc) {
        super(exc);
    }
}
