package com.kakao.kakaolink.v2.network;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.kakao.common.KakaoContextService;
import com.kakao.message.template.TemplateParams;
import com.kakao.network.IRequest;
import com.kakao.util.exception.KakaoException;
import java.util.Map;
import org.json.JSONObject;

public interface KakaoLinkCore {

    public static class Factory {
        private static KakaoLinkCore service = new DefaultKakaoLinkCore(KakaoContextService.getInstance(), com.kakao.util.KakaoUtilService.Factory.getInstance());

        public static KakaoLinkCore getInstance() {
            return service;
        }
    }

    IRequest customTemplateRequest(Context context, String str, String str2, Map<String, String> map);

    IRequest defaultTemplateRequest(Context context, String str, TemplateParams templateParams);

    boolean isAvailable(Context context);

    Intent kakaoLinkIntent(Context context, String str, JSONObject jSONObject) throws KakaoException;

    Intent kakaoLinkIntent(Context context, String str, JSONObject jSONObject, Map<String, String> map) throws KakaoException;

    Intent kakaoTalkMarketIntent(Context context);

    IRequest scrapTemplateRequest(Context context, String str, String str2);

    IRequest scrapTemplateRequest(Context context, String str, String str2, String str3, Map<String, String> map);

    Uri sharerUri(Context context, TemplateParams templateParams, Map<String, String> map);

    Uri sharerUri(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2);

    Uri sharerUri(Context context, String str, Map<String, String> map);

    Uri sharerUri(Context context, String str, Map<String, String> map, Map<String, String> map2);
}
