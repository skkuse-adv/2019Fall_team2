package com.kakao.network;

import com.kakao.network.exception.ResponseStatusError;

public class ErrorResult {
    private final int CLIENT_ERROR_CODE;
    private final int errorCode;
    protected final String errorMessage;
    protected final Exception exception;
    private final int httpStatus;

    public ErrorResult(Exception exc) {
        this.CLIENT_ERROR_CODE = -777;
        this.errorCode = -777;
        this.errorMessage = exc.getMessage();
        this.httpStatus = 500;
        this.exception = exc;
    }

    public ErrorResult(ResponseStatusError responseStatusError) {
        this.CLIENT_ERROR_CODE = -777;
        this.errorCode = responseStatusError.getErrorCode();
        this.errorMessage = responseStatusError.getErrorMsg();
        this.httpStatus = responseStatusError.getHttpStatusCode();
        this.exception = responseStatusError;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getHttpStatus() {
        return this.httpStatus;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        if (getErrorCode() == errorResult.getErrorCode() && getHttpStatus() == errorResult.getHttpStatus()) {
            return getErrorMessage().equals(errorResult.getErrorMessage());
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ErrorResult{errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage='");
        sb.append(this.errorMessage);
        sb.append('\'');
        sb.append(", exception='");
        Exception exc = this.exception;
        sb.append(exc != null ? exc.toString() : null);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
