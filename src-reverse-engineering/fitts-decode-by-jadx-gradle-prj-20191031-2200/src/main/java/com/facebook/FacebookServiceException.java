package com.facebook;

public class FacebookServiceException extends FacebookException {
    private static final long serialVersionUID = 1;
    private final FacebookRequestError error;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.error = facebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.error;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookServiceException: ");
        sb.append("httpResponseCode: ");
        sb.append(this.error.getRequestStatusCode());
        sb.append(", facebookErrorCode: ");
        sb.append(this.error.getErrorCode());
        sb.append(", facebookErrorType: ");
        sb.append(this.error.getErrorType());
        sb.append(", message: ");
        sb.append(this.error.getErrorMessage());
        sb.append("}");
        return sb.toString();
    }
}
