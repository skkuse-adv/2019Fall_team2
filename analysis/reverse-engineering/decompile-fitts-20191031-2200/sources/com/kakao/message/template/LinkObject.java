package com.kakao.message.template;

import org.json.JSONException;
import org.json.JSONObject;

public class LinkObject {
    private final String androidExecutionParams;
    private final String iosExecutionParams;
    private final String mobileWebUrl;
    private final String webUrl;

    public static class Builder {
        /* access modifiers changed from: private */
        public String androidExecutionParams;
        /* access modifiers changed from: private */
        public String iosExecutionParams;
        /* access modifiers changed from: private */
        public String mobileWebUrl;
        /* access modifiers changed from: private */
        public String webUrl;

        public Builder setWebUrl(String str) {
            this.webUrl = str;
            return this;
        }

        public Builder setMobileWebUrl(String str) {
            this.mobileWebUrl = str;
            return this;
        }

        public Builder setAndroidExecutionParams(String str) {
            this.androidExecutionParams = str;
            return this;
        }

        public Builder setIosExecutionParams(String str) {
            this.iosExecutionParams = str;
            return this;
        }

        public LinkObject build() {
            return new LinkObject(this);
        }
    }

    LinkObject(Builder builder) {
        this.webUrl = builder.webUrl;
        this.mobileWebUrl = builder.mobileWebUrl;
        this.androidExecutionParams = builder.androidExecutionParams;
        this.iosExecutionParams = builder.iosExecutionParams;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("web_url", this.webUrl);
        jSONObject.put(MessageTemplateProtocol.MOBILE_WEB_URL, this.mobileWebUrl);
        jSONObject.put(MessageTemplateProtocol.ANDROID_PARAMS, this.androidExecutionParams);
        jSONObject.put(MessageTemplateProtocol.IOS_PARAMS, this.iosExecutionParams);
        return jSONObject;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public String getMobileWebUrl() {
        return this.mobileWebUrl;
    }

    public String getAndroidExecutionParams() {
        return this.androidExecutionParams;
    }

    public String getIosExecutionParams() {
        return this.iosExecutionParams;
    }
}
