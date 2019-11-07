package com.kakao.auth.ageauth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.kakao.auth.AuthService.AgeAuthStatus;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.authorization.authcode.KakaoWebViewActivity;
import com.kakao.network.ServerProtocol;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.Utility;
import com.kakao.util.helper.log.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultAgeAuthService implements AgeAuthService {
    private static DefaultAgeAuthService instance;
    /* access modifiers changed from: private */
    public Handler sHandler;

    static class AgeAuthResult {
        private KakaoException exception;
        private AtomicInteger result = new AtomicInteger();

        public AtomicInteger getResult() {
            return this.result;
        }

        public void setResult(AtomicInteger atomicInteger) {
            this.result = atomicInteger;
        }

        public KakaoException getException() {
            return this.exception;
        }

        public void setException(KakaoException kakaoException) {
            this.exception = kakaoException;
        }
    }

    public static DefaultAgeAuthService getInstance() {
        if (instance == null) {
            instance = new DefaultAgeAuthService(new Handler(Looper.getMainLooper()));
        }
        return instance;
    }

    DefaultAgeAuthService(Handler handler) {
        this.sHandler = handler;
    }

    /* access modifiers changed from: private */
    public boolean requestWebviewAuth(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        boolean isUsingWebviewTimer = KakaoSDK.getAdapter().getSessionConfig().isUsingWebviewTimer();
        Uri buildUri = Utility.buildUri(ServerProtocol.accountAuthority(), ServerProtocol.ACCESS_AGE_AUTH_PATH, bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("AgeAuth request Url : ");
        sb.append(buildUri);
        Logger.d(sb.toString());
        Intent newIntent = KakaoWebViewActivity.newIntent(context);
        newIntent.putExtra(KakaoWebViewActivity.KEY_URL, buildUri.toString());
        newIntent.putExtra(KakaoWebViewActivity.KEY_USE_WEBVIEW_TIMERS, isUsingWebviewTimer);
        newIntent.putExtra(KakaoWebViewActivity.KEY_RESULT_RECEIVER, resultReceiver);
        context.startActivity(newIntent);
        return true;
    }

    public int requestAgeAuth(Bundle bundle, Context context) {
        AgeAuthResult ageAuthResult = new AgeAuthResult();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Handler handler = this.sHandler;
        final AgeAuthResult ageAuthResult2 = ageAuthResult;
        final CountDownLatch countDownLatch2 = countDownLatch;
        final Context context2 = context;
        final Bundle bundle2 = bundle;
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                try {
                    DefaultAgeAuthService.this.requestWebviewAuth(context2, bundle2, new ResultReceiver(DefaultAgeAuthService.this.sHandler) {
                        /* access modifiers changed from: protected */
                        public void onReceiveResult(int i, Bundle bundle) {
                            int value = AgeAuthStatus.CLIENT_ERROR.getValue();
                            if (i == 0) {
                                String string = bundle.getString(KakaoWebViewActivity.KEY_REDIRECT_URL);
                                if (string != null) {
                                    String str = "status";
                                    if (Uri.parse(string).getQueryParameter(str) != null) {
                                        value = Integer.valueOf(Uri.parse(string).getQueryParameter(str)).intValue();
                                    }
                                }
                            } else if (i == 1) {
                                ageAuthResult2.setException((KakaoException) bundle.getSerializable(KakaoWebViewActivity.KEY_EXCEPTION));
                            }
                            ageAuthResult2.getResult().set(value);
                            countDownLatch2.countDown();
                        }
                    });
                } catch (Exception e) {
                    ageAuthResult2.getResult().set(AgeAuthStatus.CLIENT_ERROR.getValue());
                    ageAuthResult2.setException(new KakaoException((Throwable) e));
                    countDownLatch2.countDown();
                }
            }
        };
        handler.post(r0);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Logger.e(e.toString());
        }
        if (ageAuthResult.getException() == null) {
            return ageAuthResult.getResult().get();
        }
        throw ageAuthResult.getException();
    }
}
