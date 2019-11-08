package com.kakao.auth.authorization.accesstoken;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kakao.auth.AccessTokenCallback;
import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.common.KakaoContextService;
import java.util.concurrent.Future;

public interface AccessTokenManager {

    public static class Factory {
        private static AccessTokenManager accessTokenManager;

        public static AccessTokenManager initialize(Context context, @NonNull ApprovalType approvalType) {
            if (accessTokenManager == null) {
                KakaoContextService.getInstance().initialize(context);
                accessTokenManager = new DefaultAccessTokenManager(KakaoContextService.getInstance(), com.kakao.network.NetworkService.Factory.getInstance(), approvalType);
            }
            return accessTokenManager;
        }

        public static AccessTokenManager getInstance() {
            return accessTokenManager;
        }
    }

    Future<AccessToken> refreshAccessToken(String str, AccessTokenCallback accessTokenCallback);

    Future<AccessToken> requestAccessTokenByAuthCode(String str, AccessTokenCallback accessTokenCallback);

    @Deprecated
    Future<AccessTokenInfoResponse> requestAccessTokenInfo(ApiResponseCallback<AccessTokenInfoResponse> apiResponseCallback);
}
