package com.kakao.common;

public final class ServerProtocol {
    public static final String NAVI_GUIDE_PATH = "navigate";
    public static final String NAVI_SHARE_PATH = "sharePoi";
    public static final String PF_ADD_PATH = "friend";
    public static final String PF_CHAT_PATH = "chat";
    @Deprecated
    public static final String PLUS_FRIEND_AUTHORITY = initPlusFriendAuthority();
    public static final String SCHEME = "https";

    /* renamed from: com.kakao.common.ServerProtocol$1 reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.kakao.common.ServerProtocol.AnonymousClass1.<clinit>():void");
        }
    }

    private static String initPlusFriendAuthority() {
        return "pf.kakao.com";
    }

    public static String plusFriendAuthority() {
        PhaseInfo phaseInfo = KakaoContextService.getInstance().phaseInfo();
        if (phaseInfo == null) {
            return initPlusFriendAuthority();
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$common$KakaoPhase[phaseInfo.phase().ordinal()];
        if (i == 1 || i == 2) {
            return "sandbox-pf.kakao.com";
        }
        return i != 3 ? "pf.kakao.com" : "beta-pf.kakao.com";
    }

    public static String naviAuthority() {
        PhaseInfo phaseInfo = KakaoContextService.getInstance().phaseInfo();
        String str = "kakaonavi-wguide.kakao.com";
        if (phaseInfo == null) {
            return str;
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$common$KakaoPhase[phaseInfo.phase().ordinal()];
        return (i == 1 || i == 2) ? "sandbox-kakaonavi-wguide.kakao.com" : str;
    }
}
