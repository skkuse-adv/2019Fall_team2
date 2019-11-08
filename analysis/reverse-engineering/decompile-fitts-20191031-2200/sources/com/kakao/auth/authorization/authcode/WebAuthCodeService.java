package com.kakao.auth.authorization.authcode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.Window;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.R;
import com.kakao.auth.StringSet;
import com.kakao.auth.authorization.AuthorizationResult;
import com.kakao.auth.helper.StartActivityWrapper;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

class WebAuthCodeService implements AuthCodeService {
    private Context context;
    private Handler handler;
    private ISessionConfig sessionConfig;

    public boolean handleActivityResult(int i, int i2, Intent intent, AuthCodeListener authCodeListener) {
        return false;
    }

    public boolean isLoginAvailable() {
        return true;
    }

    WebAuthCodeService(Context context2, Handler handler2, ISessionConfig iSessionConfig) {
        this.context = context2;
        this.handler = handler2;
        this.sessionConfig = iSessionConfig;
    }

    /* access modifiers changed from: 0000 */
    public void onWebViewCompleted(int i, String str, KakaoException kakaoException, AuthCodeListener authCodeListener) {
        AuthorizationResult authorizationResult;
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (!TextUtils.isEmpty(parse.getQueryParameter("code"))) {
                authCodeListener.onAuthCodeReceived(i, AuthorizationResult.createSuccessAuthCodeResult(str));
                return;
            }
            String queryParameter = parse.getQueryParameter("error");
            String queryParameter2 = parse.getQueryParameter("error_description");
            if (queryParameter == null || !queryParameter.equalsIgnoreCase(StringSet.access_denied)) {
                authorizationResult = AuthorizationResult.createAuthCodeOAuthErrorResult(queryParameter2);
            } else {
                authorizationResult = AuthorizationResult.createAuthCodeCancelResult(this.context.getString(R.string.auth_code_cancel));
            }
        } else if (kakaoException == null) {
            authorizationResult = AuthorizationResult.createAuthCodeOAuthErrorResult("Failed to get Authorization Code.");
        } else if (kakaoException.isCancledOperation()) {
            authorizationResult = AuthorizationResult.createAuthCodeCancelResult(kakaoException.getMessage());
        } else {
            authorizationResult = AuthorizationResult.createAuthCodeOAuthErrorResult((Exception) kakaoException);
        }
        authCodeListener.onAuthCodeReceived(i, authorizationResult);
    }

    /* access modifiers changed from: 0000 */
    public void onReceivedResult(int i, int i2, Bundle bundle, AuthCodeListener authCodeListener) {
        KakaoException kakaoException;
        String str = null;
        if (i2 != 0) {
            kakaoException = i2 != 1 ? null : (KakaoException) bundle.getSerializable(KakaoWebViewActivity.KEY_EXCEPTION);
        } else {
            str = bundle.getString(KakaoWebViewActivity.KEY_REDIRECT_URL);
            kakaoException = null;
        }
        onWebViewCompleted(i, str, kakaoException, authCodeListener);
    }

    /* access modifiers changed from: 0000 */
    public ResultReceiver getResultReceiver(final AuthCodeRequest authCodeRequest, final AuthCodeListener authCodeListener) {
        return new ResultReceiver(this.handler) {
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i, Bundle bundle) {
                WebAuthCodeService.this.onReceivedResult(authCodeRequest.getRequestCode().intValue(), i, bundle, authCodeListener);
            }
        };
    }

    public boolean requestAuthCode(AuthCodeRequest authCodeRequest, StartActivityWrapper startActivityWrapper, AuthCodeListener authCodeListener) {
        try {
            startActivity(startActivityWrapper, createAuthorizeIntentWithUri(startActivityWrapper, authCodeRequest, authCodeListener));
            return true;
        } catch (Throwable th) {
            Logger.e("WebViewAuthHandler failed", th);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void startActivity(StartActivityWrapper startActivityWrapper, Intent intent) {
        startActivityWrapper.startActivity(intent);
    }

    /* access modifiers changed from: 0000 */
    public Intent createAuthorizeIntentWithUri(StartActivityWrapper startActivityWrapper, AuthCodeRequest authCodeRequest, AuthCodeListener authCodeListener) {
        Intent newIntent = KakaoWebViewActivity.newIntent(startActivityWrapper.getContext());
        if (authCodeRequest.getAccountUri() != null) {
            newIntent.putExtra(KakaoWebViewActivity.KEY_URL, authCodeRequest.getAccountUri().toString());
        }
        newIntent.putExtra(KakaoWebViewActivity.KEY_EXTRA_HEADERS, authCodeRequest.getExtraHeaders());
        newIntent.putExtra(KakaoWebViewActivity.KEY_USE_WEBVIEW_TIMERS, this.sessionConfig.isUsingWebviewTimer());
        newIntent.putExtra(KakaoWebViewActivity.KEY_RESULT_RECEIVER, getResultReceiver(authCodeRequest, authCodeListener));
        newIntent.putExtra(KakaoWebViewActivity.KEY_FULLSCREEN_OPTIONS, getFullScreenOptions(startActivityWrapper));
        return newIntent;
    }

    private Bundle getFullScreenOptions(StartActivityWrapper startActivityWrapper) {
        Activity activity = (Activity) startActivityWrapper.getContext();
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        int i = window.getAttributes().flags;
        int i2 = 0;
        if (VERSION.SDK_INT >= 28) {
            i2 = window.getAttributes().layoutInDisplayCutoutMode;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(KakaoWebViewActivity.KEY_SYSTEM_UI_VISIBILITY, systemUiVisibility);
        bundle.putInt(KakaoWebViewActivity.KEY_WINDOW_FLAGS, i);
        bundle.putInt(KakaoWebViewActivity.KEY_LAYOUT_IN_DISPLAY_CUTOUT_MODE, i2);
        return bundle;
    }
}
