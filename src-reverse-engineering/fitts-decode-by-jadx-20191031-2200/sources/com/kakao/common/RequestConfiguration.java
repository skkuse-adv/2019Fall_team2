package com.kakao.common;

import com.kakao.util.exception.KakaoException;
import com.kakao.util.exception.KakaoException.ErrorType;
import org.json.JSONObject;

public class RequestConfiguration implements IConfiguration {
    private String appVer;
    private JSONObject extras;
    private String kaHeader;
    private String keyHash;
    private String packageName;

    public RequestConfiguration(String str, String str2, String str3, String str4, JSONObject jSONObject) throws KakaoException {
        if (str == null || str.length() == 0) {
            throw new KakaoException(ErrorType.MISS_CONFIGURATION, "Android key hash is null.");
        }
        this.keyHash = str;
        this.kaHeader = str2;
        this.appVer = str3;
        this.packageName = str4;
        this.extras = jSONObject;
    }

    public String getKeyHash() {
        return this.keyHash;
    }

    public String getKAHeader() {
        return this.kaHeader;
    }

    public String getAppVer() {
        return this.appVer;
    }

    public String getExtras() {
        JSONObject jSONObject = this.extras;
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public JSONObject getExtrasJson() {
        return this.extras;
    }

    public String getPackageName() {
        return this.packageName;
    }
}
