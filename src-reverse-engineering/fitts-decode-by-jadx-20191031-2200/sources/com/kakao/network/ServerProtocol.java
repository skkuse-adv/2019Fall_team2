package com.kakao.network;

import com.kakao.common.KakaoContextService;
import com.kakao.common.KakaoPhase;
import com.kakao.common.PhaseInfo;

public final class ServerProtocol {
    public static final String ACCESS_AGE_AUTH_PATH = "ageauths/main.html";
    public static final String ACCESS_TOKEN_PATH = "oauth/token";
    @Deprecated
    public static final String ACCOUNT_AUTHORITY = initAccountAuthority();
    public static final String ACCOUNT_CREATE_PATH = "sdks/signup";
    public static final String ACCOUNT_LOGIN_PATH = "kakao_accounts/view/login";
    @Deprecated
    public static final String AGE_AUTH_AUTHORITY = initAccountAuthority();
    @Deprecated
    public static final String API_AUTHORITY = initAPIAuthority();
    private static final String API_VERSION = "v1";
    public static final String AUTHORIZATION_BEARER = "Bearer";
    public static final String AUTHORIZATION_HEADER_DELIMITER = " ";
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    public static final String AUTHORIZE_CODE_PATH = "oauth/authorize";
    @Deprecated
    public static final String AUTH_AUTHORITY = initAuthAuthority();
    public static final String EVENTS_PUBLISH_ADID_PATH = "v1/s2/publish/adid";
    public static final String EVENTS_PUBLISH_PATH = "v1/s2/publish";
    public static final String GET_FRIENDS_OPERATION_PATH = "v1/friends/operation";
    public static final String GET_FRIENDS_PATH = "v1/friends";
    public static final String IS_STORY_USER_PATH = "v1/api/story/isstoryuser";
    public static final String KAKAO_AK_HEADER_KEY = "KakaoAK";
    public static final String LINK_IMAGE_DELETE_PATH = "v2/api/talk/message/image/delete";
    public static final String LINK_IMAGE_SCRAP_PATH = "v2/api/talk/message/image/scrap";
    public static final String LINK_IMAGE_UPLOAD_PATH = "v2/api/talk/message/image/upload";
    public static final String LINK_TEMPLATE_DEFAULT_PATH = "v2/api/kakaolink/talk/template/default";
    public static final String LINK_TEMPLATE_PATH = "/api/kakaolink/talk/template";
    public static final String LINK_TEMPLATE_SCRAP_PATH = "v2/api/kakaolink/talk/template/scrap";
    public static final String LINK_TEMPLATE_VALIDATE_PATH = "v2/api/kakaolink/talk/template/validate";
    @Deprecated
    public static final String NAVI_AUTHORITY = initNaviAuthority();
    public static final String PUSH_DEREGISTER_PATH = "v1/push/deregister";
    public static final String PUSH_REGISTER_PATH = "v1/push/register";
    public static final String PUSH_SEND_PATH = "v1/push/send";
    public static final String PUSH_TOKENS_PATH = "v1/push/tokens";
    public static final String SCHEME = "https";
    public static final String STORAGE_UPLOAD_IMAGE = "v1/storage/image/upload";
    public static final String STORY_ACTIVITIES_PATH = "v1/api/story/mystories";
    public static final String STORY_ACTIVITY_PATH = "v1/api/story/mystory";
    public static final String STORY_DELETE_ACTIVITY_PATH = "v1/api/story/delete/mystory";
    public static final String STORY_LINK_SCRAPPER_PATH = "v1/api/story/linkinfo";
    public static final String STORY_MULTI_UPLOAD_PATH = "v1/api/story/upload/multi";
    public static final String STORY_POST_LINK_PATH = "v1/api/story/post/link";
    public static final String STORY_POST_NOTE_PATH = "v1/api/story/post/note";
    public static final String STORY_POST_PHOTO_PATH = "v1/api/story/post/photo";
    public static final String STORY_PROFILE_PATH = "v1/api/story/profile";
    public static final String TALK_CHATROOM_LIST_PATH = "v1/api/talk/chat/list";
    @Deprecated
    public static final String TALK_CHAT_LIST_PATH = "v1/api/talk/chats";
    public static final String TALK_CHAT_MEMBERS_PATH = "v1/api/talk/members";
    public static final String TALK_MEMO_DEFAULT_V2_PATH = "v2/api/talk/memo/default/send";
    public static final String TALK_MEMO_SCRAP_V2_PATH = "v2/api/talk/memo/scrap/send";
    public static final String TALK_MEMO_SEND_V2_PATH = "v2/api/talk/memo/send";
    public static final String TALK_MESSAGE_DEFAULT_V2_PATH = "v2/api/talk/message/default/send";
    public static final String TALK_MESSAGE_IMAGE_PATH = "/api/talk/message/image";
    public static final String TALK_MESSAGE_SCRAP_V2_PATH = "v2/api/talk/message/scrap/send";
    public static final String TALK_MESSAGE_SEND_V2_PATH = "v2/api/talk/message/send";
    public static final String TALK_PLUS_FRIENDS_PATH = "v1/api/talk/plusfriends";
    public static final String TALK_PROFILE_PATH = "v1/api/talk/profile";
    public static final String USER_ACCESS_TOKEN_INFO_PATH = "v1/user/access_token_info";
    public static final String USER_AGE_AUTH = "v1/user/age_auth";
    public static final String USER_LOGOUT_PATH = "v1/user/logout";
    public static final String USER_ME_PATH = "v1/user/me";
    public static final String USER_ME_V2_PATH = "v2/user/me";
    public static final String USER_SERVICE_TERMS_PATH = "v1/user/service/terms";
    public static final String USER_SHIPPING_ADDRESS_PATH = "v1/user/shipping_address";
    public static final String USER_SIGNUP_PATH = "v1/user/signup";
    public static final String USER_UNLINK_PATH = "v1/user/unlink";
    public static final String USER_UPDATE_PROFILE_PATH = "v1/user/update_profile";
    private static final String V2_API_VERSION = "v2";

    /* renamed from: com.kakao.network.ServerProtocol$1 reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.kakao.network.ServerProtocol.AnonymousClass1.<clinit>():void");
        }
    }

    private static String initAPIAuthority() {
        return "kapi.kakao.com";
    }

    private static String initAccountAuthority() {
        return "auth.kakao.com";
    }

    private static String initAuthAuthority() {
        return "kauth.kakao.com";
    }

    private static String initNaviAuthority() {
        return "kakaonavi-wguide.kakao.com";
    }

    public static String apiAuthority() {
        PhaseInfo phaseInfo = KakaoContextService.getInstance() == null ? null : KakaoContextService.getInstance().phaseInfo();
        if (phaseInfo == null || phaseInfo.phase() == null) {
            return initAPIAuthority();
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$common$KakaoPhase[phaseInfo.phase().ordinal()];
        if (i == 1) {
            return "alpha-kapi.kakao.com";
        }
        if (i != 2) {
            return i != 3 ? "kapi.kakao.com" : "beta-kapi.kakao.com";
        }
        return "sandbox-kapi.kakao.com";
    }

    public static String authAuthority() {
        PhaseInfo phaseInfo = KakaoContextService.getInstance() == null ? null : KakaoContextService.getInstance().phaseInfo();
        if (phaseInfo == null || phaseInfo.phase() == null) {
            return initAuthAuthority();
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$common$KakaoPhase[phaseInfo.phase().ordinal()];
        if (i == 1) {
            return "alpha-kauth.kakao.com";
        }
        if (i != 2) {
            return i != 3 ? "kauth.kakao.com" : "beta-kauth.kakao.com";
        }
        return "sandbox-kauth.kakao.com";
    }

    public static String accountAuthority() {
        PhaseInfo phaseInfo = KakaoContextService.getInstance() == null ? null : KakaoContextService.getInstance().phaseInfo();
        if (phaseInfo == null || phaseInfo.phase() == null) {
            return initAccountAuthority();
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$common$KakaoPhase[phaseInfo.phase().ordinal()];
        if (i == 1) {
            return "alpha-auth.kakao.com";
        }
        if (i != 2) {
            return i != 3 ? "auth.kakao.com" : "beta-auth.kakao.com";
        }
        return "sandbox-auth.kakao.com";
    }
}
