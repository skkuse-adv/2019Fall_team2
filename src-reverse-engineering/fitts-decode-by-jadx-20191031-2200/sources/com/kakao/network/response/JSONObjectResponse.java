package com.kakao.network.response;

import com.kakao.network.response.ResponseBody.ResponseBodyException;

public class JSONObjectResponse {
    private ResponseBody body;

    /* access modifiers changed from: protected */
    public ResponseBody getBody() {
        return this.body;
    }

    protected JSONObjectResponse() {
    }

    protected JSONObjectResponse(String str) {
        this.body = new ResponseBody(str);
    }

    protected JSONObjectResponse(ResponseBody responseBody) throws ResponseBodyException {
        this.body = responseBody;
    }

    @Deprecated
    protected JSONObjectResponse(ResponseData responseData) throws ResponseBodyException {
        this(new String(responseData.getData()));
    }
}
