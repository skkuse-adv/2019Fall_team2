package com.kakao.auth;

import android.content.Context;
import android.os.Bundle;
import com.kakao.auth.ageauth.DefaultAgeAuthService;
import com.kakao.auth.api.AuthApi;
import com.kakao.auth.callback.AccountResponseCallback;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.network.ApiErrorCode;
import com.kakao.network.tasks.ITaskQueue;
import com.kakao.network.tasks.KakaoResultTask;
import com.kakao.network.tasks.KakaoTaskQueue;
import java.util.concurrent.Future;

public class AuthService {
    private static AuthService instance = new AuthService(AuthApi.getInstance(), KakaoTaskQueue.getInstance());
    /* access modifiers changed from: private */
    public AuthApi api;
    private ITaskQueue taskQueue;

    public enum AgeAuthLevel {
        LEVEL_1("10", "AUTH_LEVEL1"),
        LEVEL_2("20", "AUTH_LEVEL2");
        
        private final String name;
        private final String value;

        private AgeAuthLevel(String str, String str2) {
            this.value = str;
            this.name = str2;
        }

        public static AgeAuthLevel convertByName(String str) {
            AgeAuthLevel[] values;
            for (AgeAuthLevel ageAuthLevel : values()) {
                if (ageAuthLevel.getName().equals(str)) {
                    return ageAuthLevel;
                }
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum AgeAuthStatus {
        SUCCESS(0),
        CLIENT_ERROR(-777),
        CANCELED_OPERATION(OAuthErrorCode.INVALID_REQUEST),
        UNAUTHORIZED(ApiErrorCode.INVALID_TOKEN_CODE),
        BAD_PARAMETERS(-440),
        NOT_AUTHORIZED_AGE(-450),
        LOWER_AGE_LIMIT(-451),
        ALREADY_AGE_AUTHORIZED(-452),
        EXCEED_AGE_CHECK_LIMIT(-453),
        AGE_AUTH_RESULT_MISMATCH(-480),
        CI_RESULT_MISMATCH(-481),
        ERROR(-500),
        UNKOWN(-999);
        
        private final int value;

        private AgeAuthStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static AgeAuthStatus valueOf(int i) {
            AgeAuthStatus[] values;
            for (AgeAuthStatus ageAuthStatus : values()) {
                if (ageAuthStatus.getValue() == i) {
                    return ageAuthStatus;
                }
            }
            return UNKOWN;
        }
    }

    public enum AgeLimit {
        LIMIT_12("12"),
        LIMIT_15("15"),
        LIMIT_18("18"),
        LIMIT_19("19");
        
        private final String value;

        private AgeLimit(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public static AuthService getInstance() {
        return instance;
    }

    AuthService(AuthApi authApi, ITaskQueue iTaskQueue) {
        this.api = authApi;
        this.taskQueue = iTaskQueue;
    }

    public Future<Integer> requestShowAgeAuthDialog(AccountResponseCallback accountResponseCallback, final Bundle bundle, final Context context) {
        return KakaoTaskQueue.getInstance().addTask(new KakaoResultTask<Integer>(accountResponseCallback) {
            public Integer call() {
                return Integer.valueOf(DefaultAgeAuthService.getInstance().requestAgeAuth(bundle, context));
            }
        });
    }

    public void requestAccessTokenInfo(ApiResponseCallback<AccessTokenInfoResponse> apiResponseCallback) {
        this.taskQueue.addTask(new KakaoResultTask<AccessTokenInfoResponse>(apiResponseCallback) {
            public AccessTokenInfoResponse call() throws Exception {
                return AuthService.this.api.requestAccessTokenInfo();
            }
        });
    }
}
