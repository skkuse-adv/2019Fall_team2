package com.kakao.kakaolink.v2;

import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseStringConverter;
import org.json.JSONObject;

public class KakaoLinkResponse extends JSONObjectResponse {
    public static final ResponseStringConverter<KakaoLinkResponse> CONVERTER = new ResponseStringConverter<KakaoLinkResponse>() {
        public KakaoLinkResponse convert(String str) {
            return new KakaoLinkResponse(str);
        }
    };
    private final JSONObject argumentMsg;
    private JSONObject templateArgs;
    private final String templateId;
    private final JSONObject templateMsg;
    private final JSONObject warningMsg;

    public KakaoLinkResponse(String str) {
        super(str);
        this.templateId = getBody().optString(KakaoTalkLinkProtocol.TEMPLATE_ID, null);
        this.templateArgs = getBody().optJSONObject(KakaoTalkLinkProtocol.TEMPLATE_ARGS, null);
        this.templateMsg = getBody().optJSONObject(KakaoTalkLinkProtocol.TEMPLATE_MSG, null);
        this.warningMsg = getBody().optJSONObject(KakaoTalkLinkProtocol.WARNING_MSG, null);
        this.argumentMsg = getBody().optJSONObject(KakaoTalkLinkProtocol.ARGUMENT_MSG, null);
    }

    public KakaoLinkResponse(JSONObject jSONObject) {
        this(jSONObject.toString());
    }

    KakaoLinkResponse(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.templateId = str;
        this.templateArgs = jSONObject;
        this.templateMsg = jSONObject2;
        this.warningMsg = jSONObject3;
        this.argumentMsg = jSONObject4;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public JSONObject getTemplateArgs() {
        return this.templateArgs;
    }

    public JSONObject getTemplateMsg() {
        return this.templateMsg;
    }

    public JSONObject getWarningMsg() {
        return this.warningMsg;
    }

    public JSONObject getArgumentMsg() {
        return this.argumentMsg;
    }
}
