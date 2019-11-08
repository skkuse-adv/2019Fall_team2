package com.kakao.auth.network.response;

import com.kakao.auth.ApiErrorCode;
import com.kakao.network.response.ApiResponseStatusError;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;

public class InsufficientScopeException extends ApiResponseStatusError {
    public InsufficientScopeException(ResponseBody responseBody) throws ResponseBodyException {
        this(responseBody.getInt("code"), responseBody.optString("msg", ""), 403, responseBody);
    }

    public InsufficientScopeException(String str) {
        super(ApiErrorCode.INVALID_SCOPE_CODE, str, 403);
    }

    public InsufficientScopeException(int i, String str, int i2, ResponseBody responseBody) {
        super(i, str, i2, responseBody);
    }
}
