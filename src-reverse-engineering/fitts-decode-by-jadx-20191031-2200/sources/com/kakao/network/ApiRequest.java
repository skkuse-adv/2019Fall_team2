package com.kakao.network;

import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.multipart.Part;
import com.kakao.util.helper.CommonProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApiRequest implements IRequest {
    protected static final String DELETE = "DELETE";
    protected static final String GET = "GET";
    protected static final String POST = "POST";
    private String appKey;
    private String appVer;
    private String extras;
    private String kaHeader;

    public String getBodyEncoding() {
        return "UTF-8";
    }

    public abstract String getMethod();

    protected ApiRequest() {
    }

    protected ApiRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration) {
        this.appKey = phaseInfo.appKey();
        this.kaHeader = iConfiguration.getKAHeader();
        this.extras = iConfiguration.getExtrasJson().toString();
        this.appVer = iConfiguration.getAppVer();
    }

    public String getUrl() {
        Builder uriBuilder = getUriBuilder();
        return uriBuilder != null ? uriBuilder.build().toString() : "";
    }

    public Builder getUriBuilder() {
        return new Builder().scheme("https");
    }

    public Map<String, String> getParams() {
        return new HashMap();
    }

    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(CommonProtocol.KA_HEADER_KEY, this.kaHeader);
        String str = HttpRequest.HEADER_CONTENT_TYPE;
        if (!hashMap.containsKey(str)) {
            hashMap.put(str, HttpRequest.CONTENT_TYPE_FORM);
        }
        String str2 = "Accept";
        if (!hashMap.containsKey(str2)) {
            hashMap.put(str2, "*/*");
        }
        String str3 = "User-Agent";
        if (!hashMap.containsKey(str3)) {
            hashMap.put(str3, getHttpUserAgentString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("KakaoAK ");
        sb.append(getAppKey());
        hashMap.put("Authorization", sb.toString());
        return hashMap;
    }

    public List<Part> getMultiPartList() {
        return new ArrayList();
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppVer() {
        return this.appVer;
    }

    public String getExtras() {
        return this.extras;
    }

    public String getHttpUserAgentString() {
        StringBuilder sb = new StringBuilder();
        sb.append("os/android-");
        sb.append(VERSION.SDK_INT);
        return sb.toString();
    }

    public void setConfiguration(PhaseInfo phaseInfo, IConfiguration iConfiguration) {
        setAppKey(phaseInfo.appKey());
        setKaHeader(iConfiguration.getKAHeader());
        setAppVer(iConfiguration.getAppVer());
        setExtras(iConfiguration.getExtrasJson().toString());
    }

    public void setKaHeader(String str) {
        this.kaHeader = str;
    }

    public void setExtras(String str) {
        this.extras = str;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setAppVer(String str) {
        this.appVer = str;
    }
}
