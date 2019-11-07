package com.kakao.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.auth.authorization.accesstoken.AccessTokenManager;
import com.kakao.auth.authorization.authcode.AuthCodeManager;
import com.kakao.auth.authorization.authcode.AuthCodeManager.Factory;
import com.kakao.auth.authorization.authcode.AuthorizationCode;
import com.kakao.auth.helper.StartActivityWrapper;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.common.KakaoContextService;
import com.kakao.network.ErrorResult;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.exception.KakaoException.ErrorType;
import com.kakao.util.helper.SharedPreferencesCache;
import com.kakao.util.helper.log.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class Session implements ISession {
    private static final int DEFAULT_TOKEN_REQUEST_TIME_MILLIS = 10800000;
    private static final int RETRY_TOKEN_REQUEST_TIME_MILLIS = 300000;
    @SuppressLint({"StaticFieldLeak"})
    private static Session currentSession;
    /* access modifiers changed from: private */
    public final Object INSTANCE_LOCK = new Object();
    private AccessToken accessToken;
    private AccessTokenCallback accessTokenCallback;
    /* access modifiers changed from: private */
    public AccessTokenManager accessTokenManager;
    private final PendingIntent alarmIntent;
    private final SharedPreferencesCache appCache;
    private AuthCodeCallback authCodeCallback;
    private AuthCodeManager authCodeManager;
    private AuthService authService;
    /* access modifiers changed from: private */
    public AuthorizationCode authorizationCode;
    private final List<ISessionCallback> callbacks;
    private final Context context;
    private final KakaoContextService contextService;
    /* access modifiers changed from: private */
    public volatile RequestType requestType;
    private final AlarmManager tokenAlarmManager;

    enum RequestType {
        GETTING_AUTHORIZATION_CODE,
        GETTING_ACCESS_TOKEN,
        REFRESHING_ACCESS_TOKEN
    }

    static synchronized void initialize(Application application, @NonNull ApprovalType approvalType) {
        synchronized (Session.class) {
            if (currentSession != null) {
                currentSession.clearCallbacks();
                currentSession.close();
            }
            KakaoContextService instance = KakaoContextService.getInstance();
            ISessionConfig sessionConfig = KakaoSDK.getAdapter().getSessionConfig();
            Session session = new Session(application.getApplicationContext(), instance, sessionConfig, Factory.initialize(application, sessionConfig), AccessTokenManager.Factory.initialize(application.getApplicationContext(), approvalType));
            currentSession = session;
            currentSession.setAuthService(AuthService.getInstance());
        }
    }

    public static synchronized Session getCurrentSession() {
        Session session;
        synchronized (Session.class) {
            if (currentSession != null) {
                session = currentSession;
            } else {
                throw new IllegalStateException("Session is not initialized. Call KakaoSDK#init first.");
            }
        }
        return session;
    }

    public synchronized AuthCodeManager getAuthCodeManager() {
        return this.authCodeManager;
    }

    public synchronized AccessTokenManager getAccessTokenManager() {
        return this.accessTokenManager;
    }

    Session(Context context2, KakaoContextService kakaoContextService, ISessionConfig iSessionConfig, AuthCodeManager authCodeManager2, AccessTokenManager accessTokenManager2) {
        if (context2 != null) {
            this.context = context2;
            this.contextService = kakaoContextService;
            this.appCache = new SharedPreferencesCache(context2, kakaoContextService.phaseInfo().appKey());
            synchronized (this.INSTANCE_LOCK) {
                this.authorizationCode = AuthorizationCode.createEmptyCode();
                this.accessToken = AccessToken.Factory.createFromCache(iSessionConfig, this.appCache);
            }
            this.authCodeManager = authCodeManager2;
            this.accessTokenManager = accessTokenManager2;
            this.callbacks = new ArrayList();
            this.tokenAlarmManager = (AlarmManager) context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
            this.alarmIntent = PendingIntent.getBroadcast(context2, 0, new Intent(context2, TokenAlarmReceiver.class), 134217728);
            return;
        }
        throw new KakaoException(ErrorType.ILLEGAL_ARGUMENT, "cannot create Session without Context.");
    }

    public void open(AuthType authType, Activity activity) {
        internalOpen(authType, new StartActivityWrapper(activity), null);
    }

    public void open(AuthType authType, Fragment fragment) {
        internalOpen(authType, new StartActivityWrapper(fragment), null);
    }

    public void open(AuthType authType, androidx.fragment.app.Fragment fragment) {
        internalOpen(authType, new StartActivityWrapper(fragment), null);
    }

    public void openWithAuthCode(String str) {
        onAuthCodeReceived(str);
    }

    public Future<AccessToken> refreshAccessToken(final AccessTokenCallback accessTokenCallback2) {
        if (getTokenInfo() == null || !getTokenInfo().hasValidRefreshToken()) {
            KakaoException kakaoException = new KakaoException(ErrorType.ILLEGAL_STATE, "Refresh token has already expired. Logging user out.");
            internalClose(kakaoException);
            if (accessTokenCallback2 != null) {
                accessTokenCallback2.onAccessTokenFailure(new ErrorResult((Exception) kakaoException));
            }
            return null;
        }
        synchronized (this.INSTANCE_LOCK) {
            this.requestType = RequestType.REFRESHING_ACCESS_TOKEN;
        }
        return this.accessTokenManager.refreshAccessToken(getTokenInfo().getRefreshToken(), new AccessTokenCallback() {
            public void onAccessTokenReceived(AccessToken accessToken) {
                Session.this.postProcessAccessToken(accessToken);
                AccessTokenCallback accessTokenCallback = accessTokenCallback2;
                if (accessTokenCallback != null) {
                    accessTokenCallback.onAccessTokenReceived(accessToken);
                }
            }

            public void onAccessTokenFailure(ErrorResult errorResult) {
                if (Session.this.shouldClearSessionState(errorResult)) {
                    synchronized (Session.this.INSTANCE_LOCK) {
                        Session.this.requestType = null;
                    }
                }
                AccessTokenCallback accessTokenCallback = accessTokenCallback2;
                if (accessTokenCallback != null) {
                    accessTokenCallback.onAccessTokenFailure(errorResult);
                }
            }
        });
    }

    public void updateScopes(Activity activity, List<String> list, AccessTokenCallback accessTokenCallback2) {
        updateScopes(new StartActivityWrapper(activity), list, accessTokenCallback2);
    }

    public void updateScopes(Fragment fragment, List<String> list, AccessTokenCallback accessTokenCallback2) {
        updateScopes(new StartActivityWrapper(fragment), list, accessTokenCallback2);
    }

    public void updateScopes(androidx.fragment.app.Fragment fragment, List<String> list, AccessTokenCallback accessTokenCallback2) {
        updateScopes(new StartActivityWrapper(fragment), list, accessTokenCallback2);
    }

    public void createAccountAndOpen(Activity activity) {
        this.authCodeManager.createAccountAndRequestAuthCode(new StartActivityWrapper(activity), getAuthCodeCallback());
    }

    public void createAccountAndOpen(androidx.fragment.app.Fragment fragment) {
        this.authCodeManager.createAccountAndRequestAuthCode(new StartActivityWrapper(fragment), getAuthCodeCallback());
    }

    private void updateScopes(StartActivityWrapper startActivityWrapper, List<String> list, final AccessTokenCallback accessTokenCallback2) {
        if (getTokenInfo() == null || !getTokenInfo().hasValidRefreshToken()) {
            KakaoException kakaoException = new KakaoException(ErrorType.ILLEGAL_STATE, "Refresh token has already expired. Logging user out.");
            internalClose(kakaoException);
            if (accessTokenCallback2 != null) {
                accessTokenCallback2.onAccessTokenFailure(new ErrorResult((Exception) kakaoException));
            }
            return;
        }
        synchronized (this.INSTANCE_LOCK) {
            this.requestType = RequestType.GETTING_AUTHORIZATION_CODE;
        }
        this.authCodeManager.requestAuthCodeWithScopes(AuthType.KAKAO_ACCOUNT, startActivityWrapper, list, new AuthCodeCallback() {
            public void onAuthCodeReceived(String str) {
                synchronized (Session.this.INSTANCE_LOCK) {
                    Session.this.authorizationCode = new AuthorizationCode(str);
                    Session.this.requestType = RequestType.GETTING_ACCESS_TOKEN;
                }
                Session.this.accessTokenManager.requestAccessTokenByAuthCode(str, new AccessTokenCallback() {
                    public void onAccessTokenReceived(AccessToken accessToken) {
                        Session.this.postProcessAccessToken(accessToken);
                        AccessTokenCallback accessTokenCallback = accessTokenCallback2;
                        if (accessTokenCallback != null) {
                            accessTokenCallback.onAccessTokenReceived(accessToken);
                        }
                    }

                    public void onAccessTokenFailure(ErrorResult errorResult) {
                        synchronized (Session.this.INSTANCE_LOCK) {
                            Session.this.authorizationCode = AuthorizationCode.createEmptyCode();
                            Session.this.requestType = null;
                        }
                        AccessTokenCallback accessTokenCallback = accessTokenCallback2;
                        if (accessTokenCallback != null) {
                            accessTokenCallback.onAccessTokenFailure(errorResult);
                        }
                    }
                });
            }

            public void onAuthCodeFailure(ErrorResult errorResult) {
                synchronized (Session.this.INSTANCE_LOCK) {
                    Session.this.authorizationCode = AuthorizationCode.createEmptyCode();
                    Session.this.requestType = null;
                }
                AccessTokenCallback accessTokenCallback = accessTokenCallback2;
                if (accessTokenCallback != null) {
                    accessTokenCallback.onAccessTokenFailure(errorResult);
                }
            }
        });
    }

    public boolean checkAndImplicitOpen() {
        return !isClosed() && implicitOpen();
    }

    /* access modifiers changed from: 0000 */
    public boolean implicitOpen() {
        if (!getTokenInfo().hasValidRefreshToken()) {
            return false;
        }
        internalOpen(null, null, null);
        return true;
    }

    public void close() {
        internalClose(null);
    }

    /* access modifiers changed from: 0000 */
    public void checkAccessTokenInfo() {
        if (isClosed()) {
            deregisterTokenManager();
        } else if (isOpenable()) {
            implicitOpen();
        } else {
            this.authService.requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
                public void onNotSignedUp() {
                }

                public void onSessionClosed(ErrorResult errorResult) {
                    Session.this.deregisterTokenManager();
                }

                public void onFailure(ErrorResult errorResult) {
                    Session.this.registerTokenManager(300000);
                }

                public void onSuccess(AccessTokenInfoResponse accessTokenInfoResponse) {
                    Session.this.registerTokenManager(Math.min(10800000, accessTokenInfoResponse.getExpiresInMillis()));
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    public Context getContext() {
        return this.context;
    }

    public final synchronized boolean isOpened() {
        return getTokenInfo() != null && getTokenInfo().hasValidAccessToken();
    }

    public synchronized boolean isOpenable() {
        return getTokenInfo() != null && !isOpened() && (this.authorizationCode.hasAuthorizationCode() || getTokenInfo().hasValidRefreshToken());
    }

    public final synchronized boolean isClosed() {
        return !isOpened() && !isOpenable();
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean isRefreshingAccessToken() {
        return this.requestType == RequestType.REFRESHING_ACCESS_TOKEN;
    }

    private boolean shouldCloseSession(ErrorResult errorResult) {
        return errorResult.getHttpStatus() == 401 || errorResult.getHttpStatus() == 400;
    }

    public RequestType getRequestType() {
        RequestType requestType2;
        synchronized (this.INSTANCE_LOCK) {
            requestType2 = this.requestType;
        }
        return requestType2;
    }

    public final AccessToken getTokenInfo() {
        AccessToken accessToken2;
        synchronized (this.INSTANCE_LOCK) {
            accessToken2 = this.accessToken;
        }
        return accessToken2;
    }

    public SharedPreferencesCache getAppCache() {
        return this.appCache;
    }

    private void updateAccessToken(AccessToken accessToken2) {
        synchronized (this.INSTANCE_LOCK) {
            getTokenInfo().updateAccessToken(accessToken2);
        }
    }

    private void internalOpen(AuthType authType, StartActivityWrapper startActivityWrapper, String str) {
        if (isOpened()) {
            for (ISessionCallback onSessionOpened : new ArrayList(this.callbacks)) {
                onSessionOpened.onSessionOpened();
            }
        } else if (getRequestType() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getRequestType());
            sb.append(" is still not finished. Just return.");
            Logger.w(sb.toString());
        } else {
            try {
                synchronized (this.INSTANCE_LOCK) {
                    if (isClosed()) {
                        this.requestType = RequestType.GETTING_AUTHORIZATION_CODE;
                        requestAuthCode(authType, startActivityWrapper);
                    } else if (!isOpenable()) {
                        throw new KakaoException(ErrorType.AUTHORIZATION_FAILED, "current session state is not possible to open.");
                    } else if (str != null) {
                        this.requestType = RequestType.GETTING_ACCESS_TOKEN;
                        this.accessTokenManager.requestAccessTokenByAuthCode(str, getAccessTokenCallback());
                    } else {
                        this.requestType = RequestType.REFRESHING_ACCESS_TOKEN;
                        this.accessTokenManager.refreshAccessToken(getTokenInfo().getRefreshToken(), getAccessTokenCallback());
                    }
                }
            } catch (KakaoException e) {
                internalClose(e);
            }
        }
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        AuthCodeManager authCodeManager2 = this.authCodeManager;
        return authCodeManager2 != null && authCodeManager2.handleActivityResult(i, i2, intent);
    }

    public void addCallback(ISessionCallback iSessionCallback) {
        synchronized (this.callbacks) {
            if (iSessionCallback != null) {
                if (!this.callbacks.contains(iSessionCallback)) {
                    this.callbacks.add(iSessionCallback);
                }
            }
        }
    }

    public void removeCallback(ISessionCallback iSessionCallback) {
        synchronized (this.callbacks) {
            if (iSessionCallback != null) {
                this.callbacks.remove(iSessionCallback);
            }
        }
    }

    public void clearCallbacks() {
        synchronized (this.callbacks) {
            this.callbacks.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    public List<ISessionCallback> getCallbacks() {
        return this.callbacks;
    }

    private void requestAuthCode(AuthType authType, StartActivityWrapper startActivityWrapper) {
        if (startActivityWrapper.getActivity() != null) {
            this.authCodeManager.requestAuthCode(authType, startActivityWrapper.getActivity(), getAuthCodeCallback());
        } else if (startActivityWrapper.getSupportFragment() != null) {
            this.authCodeManager.requestAuthCode(authType, startActivityWrapper.getSupportFragment(), getAuthCodeCallback());
        } else if (startActivityWrapper.getFragment() != null) {
            this.authCodeManager.requestAuthCode(authType, startActivityWrapper.getFragment(), getAuthCodeCallback());
        } else {
            throw new IllegalArgumentException("You should provide activity or fragment to get Authorization code.");
        }
    }

    public AuthCodeCallback getAuthCodeCallback() {
        if (this.authCodeCallback == null) {
            synchronized (Session.class) {
                if (this.authCodeCallback == null) {
                    this.authCodeCallback = new AuthCodeCallback() {
                        public void onAuthCodeReceived(String str) {
                            Session.this.onAuthCodeReceived(str);
                        }

                        public void onAuthCodeFailure(ErrorResult errorResult) {
                            Session.this.onAuthCodeFailure(errorResult);
                        }
                    };
                }
            }
        }
        return this.authCodeCallback;
    }

    public AccessTokenCallback getAccessTokenCallback() {
        if (this.accessTokenCallback == null) {
            synchronized (Session.class) {
                if (this.accessTokenCallback == null) {
                    this.accessTokenCallback = new AccessTokenCallback() {
                        public void onAccessTokenReceived(AccessToken accessToken) {
                            Session.this.onAccessTokenReceived(accessToken);
                        }

                        public void onAccessTokenFailure(ErrorResult errorResult) {
                            Session.this.onAccessTokenFailure(errorResult);
                        }
                    };
                }
            }
        }
        return this.accessTokenCallback;
    }

    /* access modifiers changed from: 0000 */
    public void internalClose(KakaoException kakaoException) {
        synchronized (this.INSTANCE_LOCK) {
            this.requestType = null;
            this.authorizationCode = AuthorizationCode.createEmptyCode();
            getTokenInfo().clearAccessToken();
            getTokenInfo().clearRefreshToken();
        }
        SharedPreferencesCache sharedPreferencesCache = this.appCache;
        if (sharedPreferencesCache != null) {
            sharedPreferencesCache.clearAll();
        }
        try {
            deregisterTokenManager();
        } catch (Throwable th) {
            Logger.e(th);
        }
        if (kakaoException != null) {
            for (ISessionCallback onSessionOpenFailed : new ArrayList(this.callbacks)) {
                onSessionOpenFailed.onSessionOpenFailed(kakaoException);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void setAuthService(AuthService authService2) {
        this.authService = authService2;
    }

    /* access modifiers changed from: private */
    public void registerTokenManager(long j) {
        this.tokenAlarmManager.cancel(this.alarmIntent);
        try {
            this.tokenAlarmManager.setInexactRepeating(3, SystemClock.elapsedRealtime() + j, j, this.alarmIntent);
        } catch (Exception e) {
            Logger.w("Failed to register automatic token refresh.", (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public void deregisterTokenManager() {
        this.tokenAlarmManager.cancel(this.alarmIntent);
    }

    /* access modifiers changed from: private */
    public void onAuthCodeReceived(String str) {
        if (str != null) {
            synchronized (this.INSTANCE_LOCK) {
                this.requestType = null;
                this.authorizationCode = new AuthorizationCode(str);
            }
            internalOpen(null, null, str);
        }
    }

    /* access modifiers changed from: private */
    public void onAuthCodeFailure(ErrorResult errorResult) {
        internalClose(wrapAsKakaoException(errorResult.getException()));
    }

    /* access modifiers changed from: private */
    public void onAccessTokenReceived(AccessToken accessToken2) {
        postProcessAccessToken(accessToken2);
        for (ISessionCallback onSessionOpened : new ArrayList(this.callbacks)) {
            onSessionOpened.onSessionOpened();
        }
    }

    /* access modifiers changed from: private */
    public void postProcessAccessToken(AccessToken accessToken2) {
        synchronized (this.INSTANCE_LOCK) {
            this.authorizationCode = AuthorizationCode.createEmptyCode();
            updateAccessToken(accessToken2);
            this.requestType = null;
        }
        registerTokenManager((long) Math.min(DEFAULT_TOKEN_REQUEST_TIME_MILLIS, getTokenInfo().getRemainingExpireTime()));
    }

    /* access modifiers changed from: private */
    public void onAccessTokenFailure(ErrorResult errorResult) {
        if (shouldClearSessionState(errorResult)) {
            synchronized (this.INSTANCE_LOCK) {
                this.requestType = null;
            }
            for (ISessionCallback onSessionOpenFailed : new ArrayList(this.callbacks)) {
                onSessionOpenFailed.onSessionOpenFailed(new KakaoException(ErrorType.AUTHORIZATION_FAILED, errorResult.getErrorMessage()));
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldClearSessionState(ErrorResult errorResult) {
        KakaoException kakaoException = new KakaoException(ErrorType.AUTHORIZATION_FAILED, errorResult.getErrorMessage());
        if (this.requestType != null && this.requestType == RequestType.GETTING_ACCESS_TOKEN) {
            internalClose(kakaoException);
        } else if (this.requestType != RequestType.REFRESHING_ACCESS_TOKEN || !shouldCloseSession(errorResult)) {
            return true;
        } else {
            internalClose(kakaoException);
        }
        return false;
    }

    private KakaoException wrapAsKakaoException(Exception exc) {
        if (exc == null) {
            return null;
        }
        if (exc instanceof KakaoException) {
            return (KakaoException) exc;
        }
        return new KakaoException((Throwable) exc);
    }

    @Deprecated
    public final String getAppKey() {
        return this.contextService.phaseInfo().appKey();
    }

    @Deprecated
    public final String getAccessToken() {
        String accessToken2;
        synchronized (this.INSTANCE_LOCK) {
            accessToken2 = this.accessToken == null ? null : this.accessToken.getAccessToken();
        }
        return accessToken2;
    }

    @Deprecated
    public final String getRefreshToken() {
        String refreshToken;
        synchronized (this.INSTANCE_LOCK) {
            refreshToken = this.accessToken == null ? null : this.accessToken.getRefreshToken();
        }
        return refreshToken;
    }

    @Deprecated
    public final boolean hasValidAccessToken() {
        boolean z;
        synchronized (this.INSTANCE_LOCK) {
            z = this.accessToken != null && this.accessToken.hasValidAccessToken();
        }
        return z;
    }

    @Deprecated
    public void removeAccessToken() {
        synchronized (this.INSTANCE_LOCK) {
            if (this.accessToken != null) {
                this.accessToken.clearAccessToken();
            }
        }
    }

    @Deprecated
    public void invalidateAccessToken() {
        synchronized (this.INSTANCE_LOCK) {
            this.accessToken.clearAccessToken();
            this.accessToken.clearRefreshToken();
        }
    }

    @Deprecated
    public void removeRefreshToken() {
        synchronized (this.INSTANCE_LOCK) {
            if (this.accessToken != null) {
                this.accessToken.clearRefreshToken();
            }
        }
    }

    @Deprecated
    public boolean isAvailableOpenByRefreshToken() {
        return isOpened() || getTokenInfo().hasValidRefreshToken();
    }
}
