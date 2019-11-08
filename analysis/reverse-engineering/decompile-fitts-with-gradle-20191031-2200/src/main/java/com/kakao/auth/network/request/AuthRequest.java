package com.kakao.auth.network.request;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public abstract class AuthRequest {
    protected static final String GET = "GET";
    protected static final String POST = "POST";
    private final String appKey;
    private final Bundle extraHeaders = new Bundle();
    private final Map<String, String> extraHeadersMap = new HashMap();
    private final Bundle extraParams = new Bundle();
    private final Map<String, String> extraParamsMap = new HashMap();
    private final String redirectURI;

    public AuthRequest(String str, String str2) {
        this.appKey = str;
        this.redirectURI = str2;
    }

    public void putExtraParam(String str, String str2) {
        this.extraParams.putString(str, str2);
        this.extraParamsMap.put(str, str2);
    }

    public void putExtraHeader(String str, String str2) {
        this.extraHeaders.putString(str, str2);
        this.extraHeadersMap.put(str, str2);
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getRedirectURI() {
        return this.redirectURI;
    }

    @Deprecated
    public Bundle getExtraParams() {
        return this.extraParams;
    }

    @Deprecated
    public Bundle getExtraHeaders() {
        return this.extraHeaders;
    }

    public Map<String, String> getExtraParamsMap() {
        return this.extraParamsMap;
    }

    public Map<String, String> getExtraHeadersMap() {
        return this.extraHeadersMap;
    }
}
