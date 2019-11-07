package com.kakao.kakaolink.v2.network;

import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.PhaseInfo;
import com.kakao.message.template.TemplateParams;
import com.kakao.network.ServerProtocol;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map;
import org.json.JSONObject;

class TemplateDefaultRequest extends KakaoLinkTemplateRequest {
    private JSONObject jsonObject;
    private final Map<String, Object> templateObject;

    public String getMethod() {
        return HttpRequest.METHOD_GET;
    }

    public TemplateDefaultRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, Map<String, Object> map) {
        super(phaseInfo, iConfiguration, null);
        this.templateObject = map;
        this.jsonObject = null;
    }

    public TemplateDefaultRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, Map<String, Object> map) {
        super(phaseInfo, iConfiguration, str);
        this.templateObject = map;
        this.jsonObject = null;
    }

    TemplateDefaultRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, TemplateParams templateParams) {
        super(phaseInfo, iConfiguration, null);
        this.templateObject = null;
        this.jsonObject = templateParams.toJSONObject();
    }

    TemplateDefaultRequest(PhaseInfo phaseInfo, IConfiguration iConfiguration, String str, TemplateParams templateParams) {
        super(phaseInfo, iConfiguration, str);
        this.templateObject = null;
        this.jsonObject = templateParams.toJSONObject();
    }

    public Builder getUriBuilder() {
        JSONObject jSONObject;
        Builder uriBuilder = super.getUriBuilder();
        uriBuilder.path(ServerProtocol.LINK_TEMPLATE_DEFAULT_PATH);
        Map<String, Object> map = this.templateObject;
        if (map != null) {
            jSONObject = new JSONObject(map);
        } else {
            jSONObject = this.jsonObject;
            if (jSONObject == null) {
                throw new IllegalArgumentException("Template object is null.");
            }
        }
        uriBuilder.appendQueryParameter("template_object", jSONObject.toString());
        return uriBuilder;
    }
}
