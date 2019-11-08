package com.kakao.kakaolink.internal;

import com.kakao.common.KakaoContextService;
import com.kakao.common.KakaoPhase;
import com.kakao.common.PhaseInfo;
import java.nio.charset.Charset;

public final class KakaoTalkLinkProtocol {
    public static final String API_VER = "apiver";
    public static final String APP_KEY = "appkey";
    public static final String APP_KEY_HASH = "keyHash";
    public static final String APP_PACKAGE = "appPkg";
    public static final String APP_VER = "appver";
    public static final String ARGUMENT_MSG = "argument_msg";
    public static final String C = "C";
    public static final String ENCODING = Charset.forName("UTF-8").name();
    public static final String EXTRAS = "extras";
    public static final String FORWARDABLE = "forwardable";
    public static final String LCBA = "lcba";
    public static final String LINKVER = "linkver";
    public static final String LINK_40 = "4.0";
    public static final String LINK_AUTHORITY = "send";
    public static final String LINK_SCHEME = "kakaolink";
    public static final int LINK_URI_MAX_SIZE = 10240;
    public static final String LINK_VER = "link_ver";
    public static final String LINK_VERSION_40 = "4.0";
    public static final String OBJS = "objs";
    public static final String P = "P";
    public static final String REQUEST_URL = "request_url";
    public static final String SHARER_APP_KEY = "app_key";
    public static final String SHARER_KA = "ka";
    @Deprecated
    public static final String SHARE_AUTHORITY = initShareAuthority();
    public static final String SHARE_URI = "talk/friends/picker/easylink";
    public static final String TALK_MARKET_URL_PREFIX = "market://details?id=com.kakao.talk&referrer=";
    public static final String TALK_MARKET_URL_PREFIX_2 = "https://play.google.com/store/apps/details?id=com.kakao.talk&referrer=";
    public static final int TALK_MIN_VERSION_SUPPORT_LINK_V2 = 1400255;
    public static final String TARGET_APP_KEY = "target_app_key";
    public static final String TEMPLATE_ARGS = "template_args";
    public static final String TEMPLATE_ID = "template_id";
    public static final String TEMPLATE_JSON = "template_json";
    public static final String TEMPLATE_MSG = "template_msg";
    public static final String TEMPLATE_OBJECT = "template_object";
    public static final String VALIDATION_ACTION = "validation_action";
    public static final String VALIDATION_CUSTOM = "custom";
    public static final String VALIDATION_DEFAULT = "default";
    public static final String VALIDATION_PARAMS = "validation_params";
    public static final String VALIDATION_SCRAP = "scrap";
    public static final String WARNING_MSG = "warning_msg";
    public static final String ak = "ak";
    public static final String av = "av";
    public static final String lv = "lv";

    /* renamed from: com.kakao.kakaolink.internal.KakaoTalkLinkProtocol$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kakao$common$KakaoPhase = new int[KakaoPhase.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.kakao.common.KakaoPhase[] r0 = com.kakao.common.KakaoPhase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kakao$common$KakaoPhase = r0
                int[] r0 = $SwitchMap$com$kakao$common$KakaoPhase     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.DEV     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$kakao$common$KakaoPhase     // Catch:{ NoSuchFieldError -> 0x001f }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.SANDBOX     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$kakao$common$KakaoPhase     // Catch:{ NoSuchFieldError -> 0x002a }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.CBT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$kakao$common$KakaoPhase     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.kakao.common.KakaoPhase r1 = com.kakao.common.KakaoPhase.PRODUCTION     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakao.kakaolink.internal.KakaoTalkLinkProtocol.AnonymousClass1.<clinit>():void");
        }
    }

    private static String initShareAuthority() {
        return "sharer.kakao.com";
    }

    public static String sharerAuthority() {
        PhaseInfo phaseInfo = KakaoContextService.getInstance() == null ? null : KakaoContextService.getInstance().phaseInfo();
        if (phaseInfo == null) {
            return initShareAuthority();
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$common$KakaoPhase[phaseInfo.phase().ordinal()];
        if (i == 1) {
            return "alpha-sharer.devel.kakao.com";
        }
        if (i != 2) {
            return i != 3 ? "sharer.kakao.com" : "beta-sharer.kakao.com";
        }
        return "sandbox-sharer.devel.kakao.com";
    }
}
