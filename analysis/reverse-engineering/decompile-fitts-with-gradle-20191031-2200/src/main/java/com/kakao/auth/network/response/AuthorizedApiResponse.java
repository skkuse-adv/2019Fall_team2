package com.kakao.auth.network.response;

import com.kakao.network.ApiErrorCode;
import com.kakao.network.response.ApiResponseStatusError;

public abstract class AuthorizedApiResponse {

    public static class SessionClosedException extends ApiResponseStatusError {
        public SessionClosedException(String str) {
            this(ApiErrorCode.INVALID_TOKEN_CODE, str, 401);
        }

        public SessionClosedException(int i, String str, int i2) {
            super(i, str, i2);
        }
    }
}
