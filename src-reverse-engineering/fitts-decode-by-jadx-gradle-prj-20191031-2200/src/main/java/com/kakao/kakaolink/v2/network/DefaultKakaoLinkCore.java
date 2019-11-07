package com.kakao.kakaolink.v2.network;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.kakao.common.IConfiguration;
import com.kakao.common.KakaoContextService;
import com.kakao.common.PhaseInfo;
import com.kakao.kakaolink.R;
import com.kakao.kakaolink.internal.KakaoTalkLinkProtocol;
import com.kakao.message.template.TemplateParams;
import com.kakao.network.IRequest;
import com.kakao.util.KakaoUtilService;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.exception.KakaoException.ErrorType;
import com.kakao.util.helper.CommonProtocol;
import com.kakao.util.helper.log.Logger;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultKakaoLinkCore implements KakaoLinkCore {
    private static final int TALK_MIN_VERSION_SUPPORT_LINK_40 = 1400255;
    private KakaoContextService contextService;
    private KakaoUtilService utilService;

    DefaultKakaoLinkCore(KakaoContextService kakaoContextService, KakaoUtilService kakaoUtilService) {
        this.contextService = kakaoContextService;
        this.utilService = kakaoUtilService;
    }

    public IRequest defaultTemplateRequest(Context context, String str, TemplateParams templateParams) {
        this.contextService.initialize(context);
        return new TemplateDefaultRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), str, templateParams);
    }

    public IRequest customTemplateRequest(Context context, String str, String str2, Map<String, String> map) {
        this.contextService.initialize(context);
        TemplateValidateRequest templateValidateRequest = new TemplateValidateRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), str, str2, map);
        return templateValidateRequest;
    }

    public IRequest scrapTemplateRequest(Context context, String str, String str2) {
        return scrapTemplateRequest(context, str, str2, null, null);
    }

    public IRequest scrapTemplateRequest(Context context, String str, String str2, String str3, Map<String, String> map) {
        this.contextService.initialize(context);
        TemplateScrapRequest templateScrapRequest = new TemplateScrapRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), str, str2, str3, map);
        return templateScrapRequest;
    }

    public boolean isAvailable(Context context) {
        return this.utilService.resolveIntent(context, new Intent("android.intent.action.VIEW", new Builder().scheme(KakaoTalkLinkProtocol.LINK_SCHEME).authority(KakaoTalkLinkProtocol.LINK_AUTHORITY).build()), 1400255) != null;
    }

    public Intent kakaoLinkIntent(Context context, String str, JSONObject jSONObject) throws KakaoException {
        return kakaoLinkIntent(context, str, jSONObject, null);
    }

    public Intent kakaoLinkIntent(Context context, String str, JSONObject jSONObject, Map<String, String> map) throws KakaoException {
        this.contextService.initialize(context);
        PhaseInfo phaseInfo = this.contextService.phaseInfo();
        IConfiguration appConfiguration = this.contextService.getAppConfiguration();
        try {
            int attachmentSize = getAttachmentSize(phaseInfo, appConfiguration, jSONObject);
            Logger.i("KakaoLink intent size is %d bytes.", Integer.valueOf(attachmentSize));
            if (attachmentSize <= 10240) {
                String str2 = KakaoTalkLinkProtocol.TEMPLATE_ID;
                String optString = jSONObject.optString(str2, null);
                String str3 = KakaoTalkLinkProtocol.TEMPLATE_ARGS;
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                JSONObject optJSONObject2 = jSONObject.optJSONObject(KakaoTalkLinkProtocol.TEMPLATE_MSG);
                Builder builder = new Builder();
                builder.scheme(KakaoTalkLinkProtocol.LINK_SCHEME).authority(KakaoTalkLinkProtocol.LINK_AUTHORITY);
                builder.appendQueryParameter(KakaoTalkLinkProtocol.LINKVER, "4.0");
                if (str == null) {
                    str = phaseInfo.appKey();
                }
                builder.appendQueryParameter(KakaoTalkLinkProtocol.APP_KEY, str);
                builder.appendQueryParameter(KakaoTalkLinkProtocol.APP_VER, appConfiguration.getAppVer());
                if (optString != null) {
                    builder.appendQueryParameter(str2, optString);
                }
                if (optJSONObject != null) {
                    builder.appendQueryParameter(str3, optJSONObject.toString());
                }
                if (optJSONObject2 != null) {
                    builder.appendQueryParameter(KakaoTalkLinkProtocol.TEMPLATE_JSON, optJSONObject2.toString());
                }
                if (appConfiguration.getExtrasJson() != null) {
                    builder.appendQueryParameter(KakaoTalkLinkProtocol.EXTRAS, mergeExtrasAndServerCallbackArgs(appConfiguration.getExtrasJson(), map).toString());
                }
                Intent intent = new Intent("android.intent.action.SEND", builder.build());
                intent.addFlags(335544320);
                return this.utilService.resolveIntent(context, intent, 1400255);
            }
            throw new KakaoException(ErrorType.URI_LENGTH_EXCEEDED, context.getString(R.string.com_kakao_alert_uri_too_long));
        } catch (JSONException e) {
            throw new KakaoException(ErrorType.JSON_PARSING_ERROR, e.toString());
        }
    }

    public Intent kakaoTalkMarketIntent(Context context) {
        this.contextService.initialize(context);
        PhaseInfo phaseInfo = this.contextService.phaseInfo();
        IConfiguration appConfiguration = this.contextService.getAppConfiguration();
        StringBuilder sb = new StringBuilder();
        sb.append(KakaoTalkLinkProtocol.TALK_MARKET_URL_PREFIX);
        sb.append(getReferrer(phaseInfo, appConfiguration));
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        intent.addFlags(268435456);
        return intent;
    }

    public Uri sharerUri(Context context, TemplateParams templateParams, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("template_object", templateParams.toJSONObject());
            return shareUri(context, KakaoTalkLinkProtocol.VALIDATION_DEFAULT, jSONObject, map);
        } catch (JSONException unused) {
            return null;
        }
    }

    public Uri sharerUri(Context context, String str, Map<String, String> map, Map<String, String> map2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KakaoTalkLinkProtocol.TEMPLATE_ID, Integer.parseInt(str));
            if (map != null) {
                jSONObject.put(KakaoTalkLinkProtocol.TEMPLATE_ARGS, new JSONObject(map));
            }
            return shareUri(context, KakaoTalkLinkProtocol.VALIDATION_CUSTOM, jSONObject, map2);
        } catch (JSONException unused) {
            return null;
        }
    }

    public Uri sharerUri(Context context, String str, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KakaoTalkLinkProtocol.REQUEST_URL, str);
            return shareUri(context, KakaoTalkLinkProtocol.VALIDATION_SCRAP, jSONObject, map);
        } catch (JSONException unused) {
            return null;
        }
    }

    public Uri sharerUri(Context context, String str, String str2, Map<String, String> map, Map<String, String> map2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KakaoTalkLinkProtocol.REQUEST_URL, str);
            if (str2 != null) {
                jSONObject.put(KakaoTalkLinkProtocol.TEMPLATE_ID, Integer.parseInt(str2));
            }
            if (map != null) {
                jSONObject.put(KakaoTalkLinkProtocol.TEMPLATE_ARGS, new JSONObject(map));
            }
            return shareUri(context, KakaoTalkLinkProtocol.VALIDATION_SCRAP, jSONObject, map2);
        } catch (JSONException unused) {
            return null;
        }
    }

    private Uri shareUri(Context context, String str, JSONObject jSONObject, Map<String, String> map) {
        this.contextService.initialize(context);
        IConfiguration appConfiguration = this.contextService.getAppConfiguration();
        PhaseInfo phaseInfo = this.contextService.phaseInfo();
        JSONObject jSONObject2 = null;
        try {
            jSONObject.put(KakaoTalkLinkProtocol.LINK_VER, "4.0");
            try {
                jSONObject2 = new JSONObject(map);
            } catch (NullPointerException unused) {
            }
            Builder appendQueryParameter = new Builder().authority(KakaoTalkLinkProtocol.sharerAuthority()).scheme("https").path(KakaoTalkLinkProtocol.SHARE_URI).appendQueryParameter(KakaoTalkLinkProtocol.SHARER_APP_KEY, phaseInfo.appKey()).appendQueryParameter(KakaoTalkLinkProtocol.VALIDATION_ACTION, str).appendQueryParameter(KakaoTalkLinkProtocol.VALIDATION_PARAMS, jSONObject.toString()).appendQueryParameter(KakaoTalkLinkProtocol.SHARER_KA, appConfiguration.getKAHeader());
            if (jSONObject2 != null) {
                appendQueryParameter.appendQueryParameter(KakaoTalkLinkProtocol.LCBA, jSONObject2.toString());
            }
            return appendQueryParameter.build();
        } catch (JSONException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public String getReferrer(PhaseInfo phaseInfo, IConfiguration iConfiguration) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonProtocol.KA_HEADER_KEY, iConfiguration.getKAHeader());
            jSONObject.put(KakaoTalkLinkProtocol.APP_KEY, phaseInfo.appKey());
            jSONObject.put(KakaoTalkLinkProtocol.APP_VER, iConfiguration.getAppVer());
            jSONObject.put("appPkg", iConfiguration.getPackageName());
            return jSONObject.toString();
        } catch (JSONException e) {
            Logger.w((Throwable) e);
            return "";
        }
    }

    /* access modifiers changed from: 0000 */
    public int getAttachmentSize(PhaseInfo phaseInfo, IConfiguration iConfiguration, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        String str = "4.0";
        jSONObject2.put(KakaoTalkLinkProtocol.lv, str);
        jSONObject2.put(KakaoTalkLinkProtocol.av, str);
        jSONObject2.put(KakaoTalkLinkProtocol.ak, phaseInfo.appKey());
        JSONObject optJSONObject = jSONObject.optJSONObject(KakaoTalkLinkProtocol.TEMPLATE_MSG);
        String str2 = KakaoTalkLinkProtocol.P;
        jSONObject2.put(str2, optJSONObject.get(str2));
        String str3 = KakaoTalkLinkProtocol.C;
        jSONObject2.put(str3, optJSONObject.get(str3));
        String str4 = KakaoTalkLinkProtocol.TEMPLATE_ID;
        jSONObject2.put(str4, jSONObject.optString(str4, null));
        String str5 = KakaoTalkLinkProtocol.TEMPLATE_ARGS;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(str5);
        if (optJSONObject2 != null) {
            jSONObject2.put(str5, optJSONObject2);
        }
        if (iConfiguration.getExtrasJson() != null) {
            jSONObject2.put(KakaoTalkLinkProtocol.EXTRAS, iConfiguration.getExtrasJson().toString());
        }
        return jSONObject2.toString().getBytes().length;
    }

    /* access modifiers changed from: 0000 */
    public JSONObject mergeExtrasAndServerCallbackArgs(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject == null) {
            return null;
        }
        if (map == null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject(map);
        try {
            jSONObject.put(KakaoTalkLinkProtocol.LCBA, jSONObject2.toString());
        } catch (JSONException unused) {
            Logger.w(String.format("failed to put Kakaolink callback parameters %s to extras.", new Object[]{map.toString()}));
        }
        return jSONObject;
    }
}
