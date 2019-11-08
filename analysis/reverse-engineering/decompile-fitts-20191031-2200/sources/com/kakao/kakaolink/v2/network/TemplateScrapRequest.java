package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;

class TemplateScrapRequest extends KakaoLinkTemplateRequest {
    private final String url;

    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    TemplateScrapRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, String str2, Map<String, String> map) {
        super(phaseInfo, iConfiguration, null, str2, map);
        this.url = str;
    }

    public Builder getUriBuilder() {
        return super.getUriBuilder().path(ServerProtocol.LINK_TEMPLATE_SCRAP_PATH).appendQueryParameter(KakaoTalkLinkProtocol.REQUEST_URL, this.url);
    }

    TemplateScrapRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, String str2, String str3, Map<String, String> map) {
        super(phaseInfo, iConfiguration, str, str3, map);
        this.url = str2;
    }
}
