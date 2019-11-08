package com.kakao.network.response;

import com.kakao.network.response.ResponseBody.ResponseBodyException;

public final class BlankApiResponse {
    public static final ResponseStringConverter<Boolean> CONVERTER = new ResponseStringConverter<Boolean>() {
        public Boolean convert(String str) throws ResponseBodyException {
            return Boolean.valueOf(true);
        }
    };

    @Deprecated
    public BlankApiResponse(ResponseData responseData) {
    }
}
