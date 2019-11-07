package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;

public class TemplateValidateRequest extends KakaoLinkTemplateRequest {
    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    TemplateValidateRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, Map<String, String> map) {
        super(phaseInfo, iConfiguration, null, str, map);
    }

    TemplateValidateRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, String str2, Map<String, String> map) {
        super(phaseInfo, iConfiguration, str, str2, map);
    }

    public Builder getUriBuilder() {
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.path(ServerProtocol.LINK_TEMPLATE_VALIDATE_PATH);
        return uriBuilder;
    }
}
