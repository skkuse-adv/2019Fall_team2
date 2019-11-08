package com.kakao.util.exception;

public class KakaoException extends RuntimeException {
    private static final long serialVersionUID = 3738785191273730776L;
    private ErrorType errorType;

    public enum ErrorType {
        ILLEGAL_ARGUMENT,
        ILLEGAL_STATE,
        MISS_CONFIGURATION,
        CANCELED_OPERATION,
        AUTHORIZATION_FAILED,
        UNSPECIFIED_ERROR,
        JSON_PARSING_ERROR,
        URI_LENGTH_EXCEEDED,
        KAKAOTALK_NOT_INSTALLED
    }

    public KakaoException(ErrorType errorType2) {
        this.errorType = errorType2;
    }

    public KakaoException(ErrorType errorType2, String str) {
        super(str);
        this.errorType = errorType2;
    }

    public boolean isCancledOperation() {
        return this.errorType == ErrorType.CANCELED_OPERATION;
    }

    public KakaoException(String str) {
        super(str);
    }

    public KakaoException(Throwable th) {
        super(th);
    }

    public KakaoException(String str, Throwable th) {
        super(str, th);
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String toString() {
        if (getErrorType() == null) {
            return super.getMessage();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getErrorType());
        sb.append(": ");
        sb.append(super.getMessage());
        return sb.toString();
    }
}
