package com.kakao.auth;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.kakao.auth.AuthService.AgeAuthStatus;
import com.kakao.auth.ageauth.DefaultAgeAuthService;
import com.kakao.auth.authorization.accesstoken.AccessToken;
import com.kakao.auth.authorization.accesstoken.AccessTokenManager.Factory;
import com.kakao.auth.authorization.authcode.AuthCodeManager;
import com.kakao.auth.helper.StartActivityWrapper;
import com.kakao.auth.network.response.InsufficientScopeException;
import com.kakao.network.ApiErrorCode;
import com.kakao.network.ErrorResult;
import com.kakao.network.INetwork;
import com.kakao.network.IRequest;
import com.kakao.network.KakaoNetworkImpl;
import com.kakao.network.NetworkTask;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseData;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.util.helper.log.Logger;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
public class SingleNetworkTask extends NetworkTask {
    @Deprecated
    public SingleNetworkTask() {
        super(new KakaoNetworkImpl());
    }

    @Deprecated
    public SingleNetworkTask(INetwork iNetwork) {
        super(iNetwork);
    }

    private static boolean checkApiSession() {
        Session currentSession = Session.getCurrentSession();
        if (currentSession.isOpened()) {
            return true;
        }
        Logger.i("access token expired... trying to refresh access token...", new Object[0]);
        if (currentSession.getTokenInfo().hasRefreshToken()) {
            try {
                Factory.getInstance().refreshAccessToken(currentSession.getTokenInfo().getRefreshToken(), currentSession.getAccessTokenCallback()).get();
                return true;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("exception: ");
                sb.append(e.toString());
                Logger.e(sb.toString());
            }
        }
        return false;
    }

    private AccessToken requestScopesUpdateBlocking(AuthType authType, Activity activity, ResponseBody responseBody) throws Exception {
        List list;
        String str = StringSet.required_scopes;
        if (responseBody.has(str)) {
            try {
                list = ResponseStringConverter.IDENTITY_CONVERTER.convertList(responseBody.getBody().optJSONArray(str));
            } catch (ResponseBodyException unused) {
                throw new InsufficientScopeException(responseBody);
            }
        } else {
            list = null;
        }
        return requestScopesUpdate(authType, activity, list);
    }

    private AccessToken requestScopesUpdate(AuthType authType, Activity activity, List<String> list) throws Exception {
        final AuthCodeManager instance = AuthCodeManager.Factory.getInstance();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AnonymousClass1 r7 = new AuthCodeCallback() {
            public void onAuthCodeReceived(String str) {
                atomicReference.set(str);
                countDownLatch.countDown();
            }

            public void onAuthCodeFailure(ErrorResult errorResult) {
                atomicReference2.set(errorResult.getException());
                countDownLatch.countDown();
            }
        };
        Handler handler = new Handler(Looper.getMainLooper());
        final AuthType authType2 = authType;
        final Activity activity2 = activity;
        final List<String> list2 = list;
        final AtomicReference atomicReference3 = atomicReference2;
        final CountDownLatch countDownLatch2 = countDownLatch;
        AnonymousClass2 r1 = new Runnable() {
            public void run() {
                try {
                    instance.requestAuthCodeWithScopes(authType2, new StartActivityWrapper(activity2), list2, r7);
                } catch (Exception e) {
                    atomicReference3.set(e);
                    countDownLatch2.countDown();
                }
            }
        };
        handler.post(r1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            atomicReference2.set(e);
        }
        if (atomicReference2.get() == null) {
            String str = (String) atomicReference.get();
            if (str != null) {
                try {
                    return (AccessToken) Factory.getInstance().requestAccessTokenByAuthCode(str, Session.getCurrentSession().getAccessTokenCallback()).get();
                } catch (Exception e2) {
                    Logger.e((Throwable) e2);
                    throw new InsufficientScopeException(e2.toString());
                }
            } else {
                throw new InsufficientScopeException("Failed to get authorization code while requesting dynamic scope update.");
            }
        } else {
            throw new InsufficientScopeException(atomicReference2.toString());
        }
    }

    private static int getErrorCode(ResponseBody responseBody) {
        String str = "code";
        try {
            if (responseBody.has(str)) {
                return responseBody.getInt(str);
            }
        } catch (ResponseBodyException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception while getting error code: ");
            sb.append(e.toString());
            Logger.e(sb.toString());
        }
        return ApiErrorCode.UNDEFINED_ERROR_CODE;
    }

    /* access modifiers changed from: 0000 */
    public Activity getTopActivity() {
        Activity currentActivity = KakaoSDK.getCurrentActivity();
        if (currentActivity == null) {
            int i = 0;
            while (currentActivity == null && i < 3) {
                i++;
                try {
                    Thread.sleep(500);
                    currentActivity = KakaoSDK.getCurrentActivity();
                } catch (InterruptedException unused) {
                }
            }
        }
        return currentActivity;
    }

    /* access modifiers changed from: 0000 */
    public AuthType getAuthType() {
        return AuthType.KAKAO_ACCOUNT;
    }

    private boolean handleApiError(ResponseData responseData) throws Exception {
        ResponseBody responseBody = new ResponseBody(responseData.getHttpStatusCode(), responseData.getData());
        boolean z = false;
        if (getErrorCode(responseBody) == -401) {
            Session currentSession = Session.getCurrentSession();
            currentSession.getTokenInfo().clearAccessToken();
            if (currentSession.getTokenInfo().hasRefreshToken()) {
                AccessToken accessToken = (AccessToken) Factory.getInstance().refreshAccessToken(currentSession.getTokenInfo().getRefreshToken(), currentSession.getAccessTokenCallback()).get();
                if (accessToken != null) {
                    return accessToken.hasValidAccessToken();
                }
            }
        } else if (getErrorCode(responseBody) == -402) {
            z = requestScopesUpdateBlocking(getAuthType(), getTopActivity(), responseBody).hasValidAccessToken();
        } else if (getErrorCode(responseBody) == -405) {
            int requestAgeAuth = DefaultAgeAuthService.getInstance().requestAgeAuth(null, getTopActivity());
            if (requestAgeAuth == AgeAuthStatus.SUCCESS.getValue() || requestAgeAuth == AgeAuthStatus.ALREADY_AGE_AUTHORIZED.getValue()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        return r0;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.kakao.network.response.ResponseData requestApi(com.kakao.network.IRequest r6) throws java.lang.Exception {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = checkApiSession()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x003b
            com.kakao.network.response.ResponseData r0 = r5.request(r6)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = "++ [%s]response : %s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0043 }
            r3 = 0
            int r4 = r0.getHttpStatusCode()     // Catch:{ all -> 0x0043 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0043 }
            r2[r3] = r4     // Catch:{ all -> 0x0043 }
            r3 = 1
            java.lang.String r4 = r0.getStringData()     // Catch:{ all -> 0x0043 }
            r2[r3] = r4     // Catch:{ all -> 0x0043 }
            com.kakao.util.helper.log.Logger.d(r1, r2)     // Catch:{ all -> 0x0043 }
            int r1 = r0.getHttpStatusCode()     // Catch:{ all -> 0x0043 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 == r2) goto L_0x0039
            boolean r1 = r5.handleApiError(r0)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0039
            com.kakao.network.response.ResponseData r6 = r5.requestApi(r6)     // Catch:{ all -> 0x0043 }
            monitor-exit(r5)
            return r6
        L_0x0039:
            monitor-exit(r5)
            return r0
        L_0x003b:
            com.kakao.auth.network.response.AuthorizedApiResponse$SessionClosedException r6 = new com.kakao.auth.network.response.AuthorizedApiResponse$SessionClosedException     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = "Application Session is Closed."
            r6.<init>(r0)     // Catch:{ all -> 0x0043 }
            throw r6     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.auth.SingleNetworkTask.requestApi(com.kakao.network.IRequest):com.kakao.network.response.ResponseData");
    }

    @Deprecated
    public synchronized ResponseBody requestAuth(IRequest iRequest) throws Exception {
        ResponseData request;
        request = request(iRequest);
        Logger.d("++ [%s]response : %s", Integer.valueOf(request.getHttpStatusCode()), request.getStringData());
        return new ResponseBody(request.getHttpStatusCode(), request.getData());
    }
}
