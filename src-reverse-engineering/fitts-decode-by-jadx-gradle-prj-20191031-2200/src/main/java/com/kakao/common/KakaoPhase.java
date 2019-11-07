package com.kakao.common;

public enum KakaoPhase {
    DEV("dev"),
    SANDBOX("sandbox"),
    CBT("cbt"),
    PRODUCTION("production");
    
    private final String phaseName;

    private KakaoPhase(String str) {
        this.phaseName = str;
    }

    public String phaseName() {
        return this.phaseName;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.kakao.common.KakaoPhase ofName(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case 98293: goto L_0x0028;
                case 99349: goto L_0x001e;
                case 1753018553: goto L_0x0014;
                case 1865400007: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0032
        L_0x000a:
            java.lang.String r0 = "sandbox"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 1
            goto L_0x0033
        L_0x0014:
            java.lang.String r0 = "production"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 3
            goto L_0x0033
        L_0x001e:
            java.lang.String r0 = "dev"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 0
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "cbt"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            r3 = 2
            goto L_0x0033
        L_0x0032:
            r3 = -1
        L_0x0033:
            if (r3 == 0) goto L_0x0042
            if (r3 == r2) goto L_0x003f
            if (r3 == r1) goto L_0x003c
            com.kakao.common.KakaoPhase r3 = PRODUCTION
            return r3
        L_0x003c:
            com.kakao.common.KakaoPhase r3 = CBT
            return r3
        L_0x003f:
            com.kakao.common.KakaoPhase r3 = SANDBOX
            return r3
        L_0x0042:
            com.kakao.common.KakaoPhase r3 = DEV
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.common.KakaoPhase.ofName(java.lang.String):com.kakao.common.KakaoPhase");
    }
}
