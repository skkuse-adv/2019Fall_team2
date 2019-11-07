package com.kakao.kakaolink.v2;

import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;

public abstract class KakaoLinkCallback extends ResponseCallback<KakaoLinkResponse> {
    public void onFailure(ErrorResult errorResult) {
    }

    public void onSuccess(KakaoLinkResponse kakaoLinkResponse) {
    }

    public void onHandledFailure(ErrorResult errorResult) {
        super.onHandledFailure(errorResult);
    }

    public final void onDidStart() {
        super.onDidStart();
    }

    public final void onDidEnd() {
        super.onDidEnd();
    }

    public void onFailureForUiThread(ErrorResult errorResult) {
        super.onFailureForUiThread(errorResult);
    }

    public void onSuccessForUiThread(KakaoLinkResponse kakaoLinkResponse) {
        super.onSuccessForUiThread(kakaoLinkResponse);
    }
}
