package com.kakao.auth.network.response;

import com.kakao.auth.ApiErrorCode;
import com.kakao.network.exception.ResponseStatusError;
import com.kakao.network.response.CustomErrorConverter;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;

public class AuthResponseError extends ResponseStatusError {
    public static final CustomErrorConverter<AuthResponseError> CONVERTER = new CustomErrorConverter<AuthResponseError>() {
        public AuthResponseError convert(int i, String str) {
            return new AuthResponseError(i, new ResponseBody(str));
        }
    };
    private static final long serialVersionUID = 3702596857996303483L;
    private final String error;
    private final String errorDescription;
    private final ResponseBody errorResponse;
    private final int httpStatusCode;

    public int getErrorCode() {
        return ApiErrorCode.AUTH_ERROR_CODE;
    }

    public AuthResponseError(int i, ResponseBody responseBody) throws ResponseBodyException {
        super(responseBody.toString());
        this.httpStatusCode = i;
        this.errorResponse = responseBody;
        this.error = responseBody.getString("error");
        this.errorDescription = responseBody.optString("error_description", "");
    }

    public String getError() {
        return this.error;
    }

    public String getErrorMsg() {
        return this.errorDescription;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public ResponseBody getErrorResponse() {
        return this.errorResponse;
    }
}
