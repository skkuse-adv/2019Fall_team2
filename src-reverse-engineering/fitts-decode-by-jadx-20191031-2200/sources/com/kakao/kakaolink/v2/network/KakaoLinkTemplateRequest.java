package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import com.kakao.network.ApiRequest;
import com.kakao.network.ServerProtocol;
import java.util.Map;
import org.json.JSONObject;

public abstract class KakaoLinkTemplateRequest extends ApiRequest {
    private final String targetAppKey;
    private final Map<String, String> templateArgs;
    private final String templateId;

    KakaoLinkTemplateRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, String str2, Map<String, String> map) {
        super(phaseInfo, iConfiguration);
        this.targetAppKey = str;
        this.templateId = str2;
        this.templateArgs = map;
    }

    KakaoLinkTemplateRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str) {
        super(phaseInfo, iConfiguration);
        this.targetAppKey = str;
        this.templateId = null;
        this.templateArgs = null;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public Map getTemplateArgs() {
        return this.templateArgs;
    }

    public Builder getUriBuilder() {
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.authority(ServerProtocol.apiAuthority());
        uriBuilder.appendQueryParameter(KakaoTalkLinkProtocol.LINK_VER, "4.0");
        String str = this.templateId;
        if (str != null) {
            uriBuilder.appendQueryParameter(KakaoTalkLinkProtocol.TEMPLATE_ID, str);
        }
        Map<String, String> map = this.templateArgs;
        if (map != null && !map.isEmpty()) {
            uriBuilder.appendQueryParameter(KakaoTalkLinkProtocol.TEMPLATE_ARGS, getTemplateArgsString());
        }
        String str2 = this.targetAppKey;
        if (str2 != null) {
            uriBuilder.appendQueryParameter(KakaoTalkLinkProtocol.TARGET_APP_KEY, str2);
        }
        return uriBuilder;
    }

    public String getTemplateArgsString() {
        Map<String, String> map = this.templateArgs;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new JSONObject(this.templateArgs).toString();
    }
}
