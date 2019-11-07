package com.kakao.auth.authorization.accesstoken;

import androidx.annotation.NonNull;
import com.kakao.auth.AccessTokenCallback;
import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.authorization.accesstoken.AccessToken.Factory;
import com.kakao.auth.network.request.AccessTokenInfoRequest;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.auth.network.response.AuthResponseError;
import com.kakao.common.KakaoContextService;
import com.kakao.network.IRequest;
import com.kakao.network.NetworkService;
import com.kakao.network.callback.ResponseCallback;
import java.util.concurrent.Future;

class DefaultAccessTokenManager implements AccessTokenManager {
    private ApprovalType approvalType;
    private KakaoContextService contextService;
    private NetworkService networkService;

    DefaultAccessTokenManager(KakaoContextService kakaoContextService, NetworkService networkService2, @NonNull ApprovalType approvalType2) {
        this.contextService = kakaoContextService;
        this.networkService = networkService2;
        this.approvalType = approvalType2;
    }

    public Future<AccessToken> requestAccessTokenByAuthCode(String str, AccessTokenCallback accessTokenCallback) {
        AccessTokenRequest accessTokenRequest = new AccessTokenRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), str, null, this.approvalType.toString());
        return this.networkService.request(accessTokenRequest, Factory.CONVERTER, AuthResponseError.CONVERTER, accessTokenCallback);
    }

    public synchronized Future<AccessToken> refreshAccessToken(String str, AccessTokenCallback accessTokenCallback) {
        AccessTokenRequest accessTokenRequest;
        accessTokenRequest = new AccessTokenRequest(this.contextService.phaseInfo(), this.contextService.getAppConfiguration(), null, str, this.approvalType.toString());
        return this.networkService.request(accessTokenRequest, Factory.CONVERTER, AuthResponseError.CONVERTER, accessTokenCallback);
    }

    @Deprecated
    public Future<AccessTokenInfoResponse> requestAccessTokenInfo(ApiResponseCallback<AccessTokenInfoResponse> apiResponseCallback) {
        return this.networkService.request((IRequest) new AccessTokenInfoRequest(), AccessTokenInfoResponse.CONVERTER, (ResponseCallback<T>) apiResponseCallback);
    }
}
