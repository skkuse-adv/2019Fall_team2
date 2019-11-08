package com.kakao.common;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kakao.util.helper.CommonProtocol;
import com.kakao.util.helper.Utility;

public class DefaultPhaseInfo implements PhaseInfo {
    private final String appKey;
    private final String clientSecret;
    private final KakaoPhase phase;

    DefaultPhaseInfo(Context context) {
        String metadata = Utility.getMetadata(context, CommonProtocol.PHASE);
        if (metadata != null) {
            this.phase = KakaoPhase.ofName(metadata);
        } else {
            this.phase = KakaoPhase.PRODUCTION;
        }
        this.appKey = Utility.getMetadata(context, CommonProtocol.APP_KEY_PROPERTY);
        this.clientSecret = Utility.getMetadata(context, CommonProtocol.CLIENT_SECRET_PROPERTY);
    }

    @NonNull
    public KakaoPhase phase() {
        return this.phase;
    }

    public String appKey() {
        return this.appKey;
    }

    public String clientSecret() {
        return this.clientSecret;
    }
}
