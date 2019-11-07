package com.kakao.auth.authorization.authcode;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.helper.StartActivityWrapper;
import com.kakao.common.KakaoContextService;
import com.kakao.util.KakaoUtilService;

public interface AuthCodeService {

    public static class Factory {
        static AuthCodeService createTalkService(Context context, ISessionConfig iSessionConfig, KakaoUtilService kakaoUtilService) {
            return new TalkAuthCodeService(context, KakaoContextService.getInstance(), iSessionConfig, kakaoUtilService);
        }

        static AuthCodeService createStoryService(Context context, ISessionConfig iSessionConfig, KakaoUtilService kakaoUtilService) {
            return new StoryAuthCodeService(context, KakaoContextService.getInstance(), iSessionConfig, kakaoUtilService);
        }

        static AuthCodeService createWebService(Context context, Handler handler, ISessionConfig iSessionConfig) {
            return new WebAuthCodeService(context, handler, iSessionConfig);
        }
    }

    boolean handleActivityResult(int i, int i2, Intent intent, AuthCodeListener authCodeListener);

    boolean isLoginAvailable();

    boolean requestAuthCode(AuthCodeRequest authCodeRequest, StartActivityWrapper startActivityWrapper, AuthCodeListener authCodeListener);
}
