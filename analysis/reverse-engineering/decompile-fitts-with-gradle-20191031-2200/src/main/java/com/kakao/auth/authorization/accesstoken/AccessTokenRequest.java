package com.kakao.auth.authorization.accesstoken;

import android.net.Uri.Builder;
import com.kakao.auth.StringSet;
import com.kakao.auth.network.request.AuthRequest;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.IRequest;
import com.kakao.network.ServerProtocol;
import com.kakao.network.multipart.Part;
import com.kakao.util.helper.CommonProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessTokenRequest extends AuthRequest implements IRequest {
    private final String approvalType;
    private final String authCode;
    private final IConfiguration configuration;
    private final PhaseInfo phaseInfo;
    private final String refreshToken;

    public String getBodyEncoding() {
        return "UTF-8";
    }

    public String getMethod() {
        return HttpRequest.METHOD_POST;
    }

    public String getUrl() {
        return new Builder().scheme("https").authority(ServerProtocol.authAuthority()).path(ServerProtocol.ACCESS_TOKEN_PATH).build().toString();
    }

    public Map<String, String> getParams() {
        HashMap hashMap = new HashMap();
        boolean isAccessTokenRequestWithAuthCode = isAccessTokenRequestWithAuthCode();
        String str = StringSet.grant_type;
        if (isAccessTokenRequestWithAuthCode) {
            hashMap.put(str, StringSet.authorization_code);
            hashMap.put("code", getAuthCode());
        } else {
            String str2 = StringSet.refresh_token;
            hashMap.put(str, str2);
            hashMap.put(str2, getRefreshToken());
        }
        hashMap.put("client_id", getAppKey());
        if (this.phaseInfo.clientSecret() != null) {
            hashMap.put(StringSet.client_secret, this.phaseInfo.clientSecret());
        }
        hashMap.put("android_key_hash", this.configuration.getKeyHash());
        hashMap.put("redirect_uri", getRedirectURI());
        String str3 = this.approvalType;
        if (str3 != null && str3.length() > 0) {
            hashMap.put(StringSet.approval_type, this.approvalType);
        }
        Map extraParamsMap = getExtraParamsMap();
        if (extraParamsMap != null && !extraParamsMap.isEmpty()) {
            for (String str4 : extraParamsMap.keySet()) {
                String str5 = (String) extraParamsMap.get(str4);
                if (str5 != null) {
                    hashMap.put(str4, str5);
                }
            }
        }
        return hashMap;
    }

    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(CommonProtocol.KA_HEADER_KEY, this.configuration.getKAHeader());
        String str = HttpRequest.HEADER_CONTENT_TYPE;
        if (!hashMap.containsKey(str)) {
            hashMap.put(str, HttpRequest.CONTENT_TYPE_FORM);
        }
        String str2 = "Accept";
        if (!hashMap.containsKey(str2)) {
            hashMap.put(str2, "*/*");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("KakaoAK ");
        sb.append(getAppKey());
        hashMap.put("Authorization", sb.toString());
        Map extraHeadersMap = getExtraHeadersMap();
        if (extraHeadersMap != null && !extraHeadersMap.isEmpty()) {
            for (String str3 : extraHeadersMap.keySet()) {
                String str4 = (String) extraHeadersMap.get(str3);
                if (str4 != null) {
                    hashMap.put(str3, str4);
                }
            }
        }
        return hashMap;
    }

    public List<Part> getMultiPartList() {
        return Collections.emptyList();
    }

    public AccessTokenRequest(PhaseInfo phaseInfo2, IConfiguration iConfiguration, String str, String str2, String str3) {
        super(phaseInfo2.appKey(), String.format("%s%s%s", new Object[]{"kakao", phaseInfo2.appKey(), StringSet.REDIRECT_URL_POSTFIX}));
        this.phaseInfo = phaseInfo2;
        this.configuration = iConfiguration;
        this.authCode = str;
        this.refreshToken = str2;
        this.approvalType = str3;
    }

    public String getAuthCode() {
        return this.authCode;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    private boolean isAccessTokenRequestWithAuthCode() {
        return this.authCode != null;
    }
}
