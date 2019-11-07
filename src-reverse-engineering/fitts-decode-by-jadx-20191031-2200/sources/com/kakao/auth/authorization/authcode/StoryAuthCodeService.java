package com.kakao.auth.authorization.authcode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.ISessionConfig;
import com.kakao.common.KakaoContextService;
import com.kakao.util.KakaoUtilService;

class StoryAuthCodeService extends TalkAuthCodeService {
    private static final String INTENT_ACTION_STORY_LOGGED_IN_ACTIVITY = "com.kakao.story.intent.action.CAPRI_LOGGED_IN_ACTIVITY";
    private static final int STORY_MIN_VERSION_SUPPORT_CAPRI = 80;
    private static final int STORY_MIN_VERSION_SUPPORT_PROJEC_LOGIN = 99;

    StoryAuthCodeService(Context context, KakaoContextService kakaoContextService, ISessionConfig iSessionConfig, KakaoUtilService kakaoUtilService) {
        super(context, kakaoContextService, iSessionConfig, kakaoUtilService);
    }

    public boolean handleActivityResult(int i, int i2, Intent intent, AuthCodeListener authCodeListener) {
        return super.handleActivityResult(i, i2, intent, authCodeListener);
    }

    public boolean isLoginAvailable() {
        return createLoggedInActivityIntent(null) != null;
    }

    /* access modifiers changed from: protected */
    public Intent createLoggedInActivityIntent(Bundle bundle) {
        return this.protocolService.resolveIntent(this.context, createIntent(INTENT_ACTION_STORY_LOGGED_IN_ACTIVITY, this.contextService.phaseInfo().appKey(), redirectUriString(), bundle), this.sessionConfig.getApprovalType() == ApprovalType.PROJECT ? 99 : 80);
    }
}
