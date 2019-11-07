package com.kakao.auth.authorization.authcode;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.AuthCodeCallback;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.Session;
import com.kakao.auth.StringSet;
import com.kakao.auth.authorization.AuthorizationResult;
import com.kakao.auth.helper.StartActivityWrapper;
import com.kakao.common.KakaoContextService;
import com.kakao.network.ServerProtocol;
import com.kakao.util.helper.Utility;
import com.kakao.util.helper.log.Logger;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class KakaoAuthCodeManager implements AuthCodeManager, AuthCodeListener {
    private final Queue<AuthCodeService> authCodeManagers = new LinkedList();
    private KakaoContextService contextService;
    private AuthCodeRequest currentRequest;
    private AuthCodeService kakaoManager;
    private final int requestCode = 1001;
    private final ISessionConfig sessionConfig;
    private StartActivityWrapper startActivityWrapper;
    private AuthCodeService storyManager;
    private AuthCodeService webManager;

    /* renamed from: com.kakao.auth.authorization.authcode.KakaoAuthCodeManager$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kakao$auth$AuthType = new int[AuthType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.kakao.auth.AuthType[] r0 = com.kakao.auth.AuthType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kakao$auth$AuthType = r0
                int[] r0 = $SwitchMap$com$kakao$auth$AuthType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.kakao.auth.AuthType r1 = com.kakao.auth.AuthType.KAKAO_TALK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$kakao$auth$AuthType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.kakao.auth.AuthType r1 = com.kakao.auth.AuthType.KAKAO_TALK_EXCLUDE_NATIVE_LOGIN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$kakao$auth$AuthType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.kakao.auth.AuthType r1 = com.kakao.auth.AuthType.KAKAO_TALK_ONLY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$kakao$auth$AuthType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.kakao.auth.AuthType r1 = com.kakao.auth.AuthType.KAKAO_STORY     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$com$kakao$auth$AuthType     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.kakao.auth.AuthType r1 = com.kakao.auth.AuthType.KAKAO_LOGIN_ALL     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakao.auth.authorization.authcode.KakaoAuthCodeManager.AnonymousClass1.<clinit>():void");
        }
    }

    public void requestAuthCode(AuthType authType, Activity activity, AuthCodeCallback authCodeCallback) {
        requestAuthCode(authType, new StartActivityWrapper(activity), authCodeCallback);
    }

    public void requestAuthCode(AuthType authType, Fragment fragment, AuthCodeCallback authCodeCallback) {
        requestAuthCode(authType, new StartActivityWrapper(fragment), authCodeCallback);
    }

    public void requestAuthCode(AuthType authType, androidx.fragment.app.Fragment fragment, AuthCodeCallback authCodeCallback) {
        requestAuthCode(authType, new StartActivityWrapper(fragment), authCodeCallback);
    }

    public void requestAuthCode(AuthType authType, StartActivityWrapper startActivityWrapper2, AuthCodeCallback authCodeCallback) {
        AuthCodeRequest createAuthCodeRequest = createAuthCodeRequest(this.contextService.phaseInfo().appKey(), authCodeCallback);
        createAuthCodeRequest.setAccountUri(createAccountLoginUri(createAuthCodeRequest));
        startTryingAuthCodeServices(authType, createAuthCodeRequest, startActivityWrapper2);
    }

    public void requestAuthCodeWithScopes(AuthType authType, StartActivityWrapper startActivityWrapper2, List<String> list, AuthCodeCallback authCodeCallback) {
        AuthCodeRequest createAuthCodeRequest = createAuthCodeRequest(this.contextService.phaseInfo().appKey(), getRefreshToken(), list, authCodeCallback);
        createAuthCodeRequest.setAccountUri(createScopeUpdateUri(createAuthCodeRequest));
        startTryingAuthCodeServices(authType, createAuthCodeRequest, startActivityWrapper2);
    }

    public void createAccountAndRequestAuthCode(StartActivityWrapper startActivityWrapper2, AuthCodeCallback authCodeCallback) {
        AuthCodeRequest createAuthCodeRequest = createAuthCodeRequest(this.contextService.phaseInfo().appKey(), authCodeCallback);
        createAuthCodeRequest.setAccountUri(createAccountCreateUri(createAuthCodeRequest));
        startTryingAuthCodeServices(AuthType.KAKAO_ACCOUNT, createAuthCodeRequest, startActivityWrapper2);
    }

    /* access modifiers changed from: 0000 */
    public void startTryingAuthCodeServices(AuthType authType, AuthCodeRequest authCodeRequest, StartActivityWrapper startActivityWrapper2) {
        addToAuthCodeServicesQueue(authType);
        this.currentRequest = authCodeRequest;
        this.startActivityWrapper = startActivityWrapper2;
        tryNextAuthCodeService(authCodeRequest);
    }

    /* access modifiers changed from: 0000 */
    public void tryNextAuthCodeService(AuthCodeRequest authCodeRequest) {
        AuthCodeCallback callback = authCodeRequest.getCallback();
        while (true) {
            AuthCodeService authCodeService = (AuthCodeService) this.authCodeManagers.peek();
            if (authCodeService != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("trying ");
                sb.append(authCodeService.getClass().getSimpleName());
                Logger.d(sb.toString());
                if (!authCodeService.requestAuthCode(authCodeRequest, this.startActivityWrapper, this)) {
                    this.authCodeManagers.poll();
                } else {
                    return;
                }
            } else {
                if (callback != null) {
                    onAuthCodeReceived(authCodeRequest.getRequestCode().intValue(), AuthorizationResult.createAuthCodeOAuthErrorResult("Failed to get Authorization Code."));
                }
                return;
            }
        }
    }

    KakaoAuthCodeManager(KakaoContextService kakaoContextService, ISessionConfig iSessionConfig, AuthCodeService authCodeService, AuthCodeService authCodeService2, AuthCodeService authCodeService3) {
        this.contextService = kakaoContextService;
        this.sessionConfig = iSessionConfig;
        this.kakaoManager = authCodeService;
        this.storyManager = authCodeService2;
        this.webManager = authCodeService3;
    }

    private void addToAuthCodeServicesQueue(AuthType authType) {
        if (authType == null) {
            authType = AuthType.KAKAO_TALK;
        }
        int i = AnonymousClass1.$SwitchMap$com$kakao$auth$AuthType[authType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.authCodeManagers.add(this.kakaoManager);
        } else if (i == 4) {
            this.authCodeManagers.add(this.storyManager);
        } else if (i == 5) {
            this.authCodeManagers.add(this.kakaoManager);
            this.authCodeManagers.add(this.storyManager);
        }
        if (authType != AuthType.KAKAO_TALK_ONLY) {
            this.authCodeManagers.add(this.webManager);
        }
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        if (this.currentRequest == null) {
            Logger.w("Auth code was not requested or the request has already been processed.");
            return false;
        }
        AuthCodeService authCodeService = (AuthCodeService) this.authCodeManagers.poll();
        if (authCodeService == null || !authCodeService.handleActivityResult(i, i2, intent, this)) {
            tryNextAuthCodeService(this.currentRequest);
        }
        return true;
    }

    public boolean isTalkLoginAvailable() {
        return this.kakaoManager.isLoginAvailable();
    }

    public boolean isStoryLoginAvailable() {
        return this.storyManager.isLoginAvailable();
    }

    /* access modifiers changed from: 0000 */
    public String getScopesString(List<String> list) {
        String str = null;
        if (list == null) {
            return null;
        }
        StringBuilder sb = null;
        for (String str2 : list) {
            if (sb != null) {
                sb.append(",");
            } else {
                sb = new StringBuilder();
            }
            sb.append(str2);
        }
        if (sb != null) {
            str = sb.toString();
        }
        return str;
    }

    /* access modifiers changed from: 0000 */
    public AuthCodeRequest createAuthCodeRequest(String str, AuthCodeCallback authCodeCallback) {
        AuthCodeRequest authCodeRequest = new AuthCodeRequest(str, getRedirectUri(str), Integer.valueOf(1001), authCodeCallback);
        authCodeRequest.putExtraParam(StringSet.approval_type, (this.sessionConfig.getApprovalType() == null ? ApprovalType.INDIVIDUAL : this.sessionConfig.getApprovalType()).toString());
        return authCodeRequest;
    }

    private String getRedirectUri(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("kakao");
        sb.append(str);
        sb.append(StringSet.REDIRECT_URL_POSTFIX);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public AuthCodeRequest createAuthCodeRequest(String str, String str2, List<String> list, AuthCodeCallback authCodeCallback) {
        AuthCodeRequest authCodeRequest = new AuthCodeRequest(str, getRedirectUri(str), Integer.valueOf(1001), authCodeCallback);
        authCodeRequest.putExtraHeader(StringSet.RT, str2);
        authCodeRequest.putExtraParam("scope", getScopesString(list));
        authCodeRequest.putExtraParam(StringSet.approval_type, (this.sessionConfig.getApprovalType() == null ? ApprovalType.INDIVIDUAL : this.sessionConfig.getApprovalType()).toString());
        return authCodeRequest;
    }

    /* access modifiers changed from: 0000 */
    public String getRefreshToken() {
        try {
            return Session.getCurrentSession().getTokenInfo().getRefreshToken();
        } catch (IllegalStateException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAuthCodeReceived(int r6, com.kakao.auth.authorization.AuthorizationResult r7) {
        /*
            r5 = this;
            com.kakao.auth.authorization.authcode.AuthCodeRequest r6 = r5.currentRequest
            if (r6 != 0) goto L_0x000a
            java.lang.String r6 = "Current auth code request has already finished."
            com.kakao.util.helper.log.Logger.w(r6)
            return
        L_0x000a:
            com.kakao.auth.AuthCodeCallback r6 = r6.getCallback()
            if (r6 != 0) goto L_0x0016
            java.lang.String r6 = "Callback has not been set for this auth code request. Just return."
            com.kakao.util.helper.log.Logger.w(r6)
            return
        L_0x0016:
            r0 = 0
            if (r7 != 0) goto L_0x0026
            com.kakao.util.exception.KakaoException r7 = new com.kakao.util.exception.KakaoException
            com.kakao.util.exception.KakaoException$ErrorType r1 = com.kakao.util.exception.KakaoException.ErrorType.AUTHORIZATION_FAILED
            java.lang.String r2 = "the result of authorization code request is null."
            r7.<init>(r1, r2)
        L_0x0022:
            r1 = r7
        L_0x0023:
            r7 = r0
            goto L_0x009d
        L_0x0026:
            boolean r1 = r7.isCanceled()
            if (r1 == 0) goto L_0x0038
            com.kakao.util.exception.KakaoException r1 = new com.kakao.util.exception.KakaoException
            com.kakao.util.exception.KakaoException$ErrorType r2 = com.kakao.util.exception.KakaoException.ErrorType.CANCELED_OPERATION
            java.lang.String r7 = r7.getResultMessage()
            r1.<init>(r2, r7)
            goto L_0x0023
        L_0x0038:
            boolean r1 = r7.isAuthError()
            if (r1 != 0) goto L_0x0091
            boolean r1 = r7.isError()
            if (r1 == 0) goto L_0x0045
            goto L_0x0091
        L_0x0045:
            java.lang.String r1 = r7.getRedirectURL()
            if (r1 == 0) goto L_0x0071
            com.kakao.auth.authorization.authcode.AuthCodeRequest r2 = r5.currentRequest
            java.lang.String r2 = r2.getRedirectURI()
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x0071
            android.net.Uri r7 = r7.getRedirectUri()
            com.kakao.auth.authorization.authcode.AuthorizationCode r7 = com.kakao.auth.authorization.authcode.AuthorizationCode.createFromRedirectedUri(r7)
            boolean r1 = r7.hasAuthorizationCode()
            if (r1 != 0) goto L_0x006f
            com.kakao.util.exception.KakaoException r7 = new com.kakao.util.exception.KakaoException
            com.kakao.util.exception.KakaoException$ErrorType r1 = com.kakao.util.exception.KakaoException.ErrorType.AUTHORIZATION_FAILED
            java.lang.String r2 = "the result of authorization code request does not have authorization code."
            r7.<init>(r1, r2)
            goto L_0x0022
        L_0x006f:
            r1 = r0
            goto L_0x009d
        L_0x0071:
            com.kakao.util.helper.log.Logger.e(r1)
            com.kakao.util.exception.KakaoException r1 = new com.kakao.util.exception.KakaoException
            com.kakao.util.exception.KakaoException$ErrorType r2 = com.kakao.util.exception.KakaoException.ErrorType.AUTHORIZATION_FAILED
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "the result of authorization code request mismatched the registered redirect uri. msg = "
            r3.append(r4)
            java.lang.String r7 = r7.getResultMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r1.<init>(r2, r7)
            goto L_0x0023
        L_0x0091:
            com.kakao.util.exception.KakaoException r1 = new com.kakao.util.exception.KakaoException
            com.kakao.util.exception.KakaoException$ErrorType r2 = com.kakao.util.exception.KakaoException.ErrorType.AUTHORIZATION_FAILED
            java.lang.String r7 = r7.getResultMessage()
            r1.<init>(r2, r7)
            goto L_0x0023
        L_0x009d:
            r5.currentRequest = r0
            java.util.Queue<com.kakao.auth.authorization.authcode.AuthCodeService> r0 = r5.authCodeManagers
            r0.clear()
            if (r1 == 0) goto L_0x00af
            com.kakao.network.ErrorResult r7 = new com.kakao.network.ErrorResult
            r7.<init>(r1)
            r6.onAuthCodeFailure(r7)
            return
        L_0x00af:
            java.lang.String r7 = r7.getAuthorizationCode()
            r6.onAuthCodeReceived(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.auth.authorization.authcode.KakaoAuthCodeManager.onAuthCodeReceived(int, com.kakao.auth.authorization.AuthorizationResult):void");
    }

    /* access modifiers changed from: 0000 */
    public Uri createAccountLoginUri(AuthCodeRequest authCodeRequest) {
        Uri createScopeUpdateUri = createScopeUpdateUri(authCodeRequest);
        return new Builder().scheme("https").authority(ServerProtocol.accountAuthority()).path(ServerProtocol.ACCOUNT_LOGIN_PATH).appendQueryParameter(StringSet.CONTINUE, createScopeUpdateUri.toString()).build();
    }

    /* access modifiers changed from: 0000 */
    public Uri createAccountCreateUri(AuthCodeRequest authCodeRequest) {
        Uri createScopeUpdateUri = createScopeUpdateUri(authCodeRequest);
        return new Builder().scheme("https").authority(ServerProtocol.accountAuthority()).path(ServerProtocol.ACCOUNT_CREATE_PATH).appendQueryParameter(StringSet.CONTINUE, createScopeUpdateUri.toString()).build();
    }

    /* access modifiers changed from: 0000 */
    public Uri createScopeUpdateUri(AuthCodeRequest authCodeRequest) {
        Bundle bundle = new Bundle();
        bundle.putString("client_id", authCodeRequest.getAppKey());
        bundle.putString("redirect_uri", authCodeRequest.getRedirectURI());
        bundle.putString("response_type", "code");
        Bundle extraParams = authCodeRequest.getExtraParams();
        if (extraParams != null && !extraParams.isEmpty()) {
            for (String str : extraParams.keySet()) {
                String string = extraParams.getString(str);
                if (string != null) {
                    bundle.putString(str, string);
                }
            }
        }
        return Utility.buildUri(ServerProtocol.authAuthority(), ServerProtocol.AUTHORIZE_CODE_PATH, bundle);
    }
}
