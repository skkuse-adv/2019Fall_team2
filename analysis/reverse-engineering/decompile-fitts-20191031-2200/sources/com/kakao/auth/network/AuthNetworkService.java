package com.kakao.auth.network;

import com.kakao.common.KakaoContextService;
import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.network.tasks.KakaoTaskQueue;
import java.util.List;
import java.util.concurrent.Future;

public interface AuthNetworkService {

    public static class Factory {
        private static AuthNetworkService instance;

        static {
            DefaultAuthNetworkService defaultAuthNetworkService = new DefaultAuthNetworkService(com.kakao.network.NetworkService.Factory.getInstance(), KakaoTaskQueue.getInstance());
            defaultAuthNetworkService.setTokenInfo(com.kakao.auth.authorization.accesstoken.AccessToken.Factory.getInstance());
            defaultAuthNetworkService.setErrorHandlingService(com.kakao.auth.network.ApiErrorHandlingService.Factory.getInstance());
            defaultAuthNetworkService.setConfService(KakaoContextService.getInstance());
            instance = defaultAuthNetworkService;
        }

        public static AuthNetworkService getInstance() {
            return instance;
        }
    }

    <T> T request(AuthorizedRequest authorizedRequest, ResponseStringConverter<T> responseStringConverter) throws Exception;

    <T> Future<T> request(AuthorizedRequest authorizedRequest, ResponseStringConverter<T> responseStringConverter, ResponseCallback<T> responseCallback);

    <T> List<T> requestList(AuthorizedRequest authorizedRequest, ResponseStringConverter<T> responseStringConverter) throws Exception;

    <T> Future<List<T>> requestList(AuthorizedRequest authorizedRequest, ResponseStringConverter<T> responseStringConverter, ResponseCallback<List<T>> responseCallback);
}
