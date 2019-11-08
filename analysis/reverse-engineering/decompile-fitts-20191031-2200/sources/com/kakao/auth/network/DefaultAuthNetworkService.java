package com.kakao.auth.network;

import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.auth.network.response.AuthorizedApiResponse.SessionClosedException;
import com.kakao.common.KakaoContextService;
import com.kakao.network.NetworkService;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ApiResponseStatusError;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.network.tasks.ITaskQueue;
import com.kakao.network.tasks.KakaoResultTask;
import java.util.List;
import java.util.concurrent.Future;

class DefaultAuthNetworkService implements AuthNetworkService {
    private KakaoContextService contextService;
    private ApiErrorHandlingService errorHandlingService;
    private final NetworkService networkService;
    private final ITaskQueue taskQueue;
    private AccessToken tokenInfo;

    public void setErrorHandlingService(ApiErrorHandlingService apiErrorHandlingService) {
        this.errorHandlingService = apiErrorHandlingService;
    }

    public void setTokenInfo(AccessToken accessToken) {
        this.tokenInfo = accessToken;
    }

    public void setConfService(KakaoContextService kakaoContextService) {
        this.contextService = kakaoContextService;
    }

    DefaultAuthNetworkService(NetworkService networkService2, ITaskQueue iTaskQueue) {
        this.networkService = networkService2;
        this.taskQueue = iTaskQueue;
    }

    public <T> Future<T> request(final AuthorizedRequest authorizedRequest, final ResponseStringConverter<T> responseStringConverter, ResponseCallback<T> responseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<T>(responseCallback) {
            public T call() throws Exception {
                return DefaultAuthNetworkService.this.request(authorizedRequest, responseStringConverter);
            }
        });
    }

    public <T> T request(AuthorizedRequest authorizedRequest, ResponseStringConverter<T> responseStringConverter) throws Exception {
        if (this.tokenInfo.hasValidAccessToken() || this.errorHandlingService.shouldRetryAfterTryingRefreshToken()) {
            authorizedRequest.setConfiguration(this.contextService.phaseInfo(), this.contextService.getAppConfiguration());
            authorizedRequest.setAccessToken(this.tokenInfo.getAccessToken());
            try {
                return this.networkService.request(authorizedRequest, responseStringConverter);
            } catch (ApiResponseStatusError e) {
                if (this.errorHandlingService.shouldRetryWithApiError(e)) {
                    return request(authorizedRequest, responseStringConverter);
                }
                throw e;
            }
        } else {
            throw new SessionClosedException("Could not refresh access token.");
        }
    }

    public <T> Future<List<T>> requestList(final AuthorizedRequest authorizedRequest, final ResponseStringConverter<T> responseStringConverter, ResponseCallback<List<T>> responseCallback) {
        return this.taskQueue.addTask(new KakaoResultTask<List<T>>(responseCallback) {
            public List<T> call() throws Exception {
                return DefaultAuthNetworkService.this.requestList(authorizedRequest, responseStringConverter);
            }
        });
    }

    public <T> List<T> requestList(AuthorizedRequest authorizedRequest, ResponseStringConverter<T> responseStringConverter) throws Exception {
        if (this.tokenInfo.hasValidAccessToken() || this.errorHandlingService.shouldRetryAfterTryingRefreshToken()) {
            authorizedRequest.setAccessToken(this.tokenInfo.getAccessToken());
            authorizedRequest.setConfiguration(this.contextService.phaseInfo(), this.contextService.getAppConfiguration());
            try {
                return this.networkService.requestList(authorizedRequest, responseStringConverter);
            } catch (ApiResponseStatusError e) {
                if (this.errorHandlingService.shouldRetryWithApiError(e)) {
                    return requestList(authorizedRequest, responseStringConverter);
                }
                throw e;
            }
        } else {
            throw new SessionClosedException("Could not refresh access token.");
        }
    }
}
