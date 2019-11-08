package com.kakao.auth.authorization.authcode;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.kakao.auth.ApprovalType;
import com.kakao.auth.ISessionConfig;
import com.kakao.auth.R;
import com.kakao.auth.StringSet;
import com.kakao.auth.authorization.AuthorizationResult;
import com.kakao.auth.helper.StartActivityWrapper;
import com.kakao.common.KakaoContextService;
import com.kakao.util.KakaoUtilService;
import com.kakao.util.helper.log.Logger;

class TalkAuthCodeService implements AuthCodeService {
    static final String APPLICATION_ERROR = "ApplicationError";
    static final String AUTH_CODE_ERROR = "AuthCodeError";
    static final String CLIENT_INFO_ERROR = "ClientInfoError";
    static final String EXTRA_APPLICATION_KEY = "com.kakao.sdk.talk.appKey";
    static final String EXTRA_ERROR_DESCRIPTION = "com.kakao.sdk.talk.error.description";
    static final String EXTRA_ERROR_TYPE = "com.kakao.sdk.talk.error.type";
    static final String EXTRA_EXTRAPARAMS = "com.kakao.sdk.talk.extraparams";
    static final String EXTRA_KA_HEADER = "com.kakao.sdk.talk.kaHeader";
    static final String EXTRA_PROTOCOL_VERSION = "com.kakao.sdk.talk.protocol.version";
    static final String EXTRA_REDIRECT_URI = "com.kakao.sdk.talk.redirectUri";
    static final String EXTRA_REDIRECT_URL = "com.kakao.sdk.talk.redirectUrl";
    static final String INTENT_ACTION_LOGGED_IN_ACTIVITY = "com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY";
    static final String NOT_SUPPORT_ERROR = "NotSupportError";
    static final String PROTOCOL_ERROR = "ProtocolError";
    static final int PROTOCOL_VERSION = 1;
    private static final int TALK_MIN_VERSION_SUPPORT_CAPRI = 139;
    private static final int TALK_MIN_VERSION_SUPPORT_PROJEC_LOGIN = 178;
    static final String UNKNOWN_ERROR = "UnknownError";
    protected Context context;
    protected KakaoContextService contextService;
    protected KakaoUtilService protocolService;
    protected ISessionConfig sessionConfig;

    public boolean requestAuthCode(AuthCodeRequest authCodeRequest, StartActivityWrapper startActivityWrapper, AuthCodeListener authCodeListener) {
        Intent createLoggedInActivityIntent = createLoggedInActivityIntent(authCodeRequest.getExtraParams());
        if (createLoggedInActivityIntent == null) {
            return false;
        }
        startActivityForResult(startActivityWrapper, createLoggedInActivityIntent, authCodeRequest.getRequestCode().intValue());
        return true;
    }

    public boolean handleActivityResult(int i, int i2, Intent intent, AuthCodeListener authCodeListener) {
        AuthorizationResult parseAuthCodeIntent = parseAuthCodeIntent(i, i2, intent);
        if (parseAuthCodeIntent.isPass()) {
            return false;
        }
        authCodeListener.onAuthCodeReceived(i, parseAuthCodeIntent);
        return true;
    }

    public boolean isLoginAvailable() {
        return createLoggedInActivityIntent(null) != null;
    }

    TalkAuthCodeService(Context context2, KakaoContextService kakaoContextService, ISessionConfig iSessionConfig, KakaoUtilService kakaoUtilService) {
        this.context = context2;
        this.contextService = kakaoContextService;
        this.sessionConfig = iSessionConfig;
        this.protocolService = kakaoUtilService;
    }

    /* access modifiers changed from: 0000 */
    public void startActivityForResult(StartActivityWrapper startActivityWrapper, Intent intent, int i) {
        if (startActivityWrapper != null) {
            startActivityWrapper.startActivityForResult(intent, i);
        }
    }

    /* access modifiers changed from: 0000 */
    public AuthorizationResult parseAuthCodeIntent(int i, int i2, Intent intent) {
        AuthorizationResult authorizationResult;
        String str;
        String str2;
        if (intent == null || i2 == 0) {
            authorizationResult = AuthorizationResult.createAuthCodeCancelResult(this.context.getString(R.string.auth_code_cancel));
        } else if (isCapriProtocolMatched(intent)) {
            authorizationResult = AuthorizationResult.createAuthCodeOAuthErrorResult("TalkProtocol is mismatched during requesting auth code through KakaoTalk.");
        } else if (i2 != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("got unexpected resultCode during requesting auth code. code=");
            sb.append(i);
            authorizationResult = AuthorizationResult.createAuthCodeOAuthErrorResult(sb.toString());
        } else {
            Bundle extras = intent.getExtras();
            String str3 = null;
            if (extras == null) {
                str = null;
            } else {
                str = extras.getString(EXTRA_ERROR_TYPE);
            }
            if (extras != null) {
                str3 = extras.getString(EXTRA_REDIRECT_URL);
            }
            if (str != null || str3 == null || !str3.startsWith(redirectUriString())) {
                if (extras == null) {
                    str2 = "No result was passed from KakaoTalk.";
                } else {
                    str2 = extras.getString(EXTRA_ERROR_DESCRIPTION);
                }
                if (str == null || !str.equals(NOT_SUPPORT_ERROR)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("redirectURL=");
                    sb2.append(str3);
                    sb2.append(", ");
                    sb2.append(str);
                    sb2.append(" : ");
                    sb2.append(str2);
                    return AuthorizationResult.createAuthCodeOAuthErrorResult(sb2.toString());
                }
                if (str2 != null) {
                    Logger.i(str2, new Object[0]);
                }
                return AuthorizationResult.createAuthCodePassResult();
            }
            Uri parse = Uri.parse(str3);
            if (!TextUtils.isEmpty(parse.getQueryParameter("code"))) {
                return AuthorizationResult.createSuccessAuthCodeResult(str3);
            }
            String queryParameter = parse.getQueryParameter("error");
            String queryParameter2 = parse.getQueryParameter("error_description");
            if (queryParameter == null || !queryParameter.equalsIgnoreCase(StringSet.access_denied)) {
                return AuthorizationResult.createAuthCodeOAuthErrorResult(queryParameter2);
            }
            return AuthorizationResult.createAuthCodeCancelResult(this.context.getString(R.string.auth_code_cancel));
        }
        return authorizationResult;
    }

    /* access modifiers changed from: protected */
    public Intent createLoggedInActivityIntent(Bundle bundle) {
        ApprovalType approvalType = this.sessionConfig.getApprovalType();
        return this.protocolService.resolveIntent(this.context, createIntent(INTENT_ACTION_LOGGED_IN_ACTIVITY, this.contextService.phaseInfo().appKey(), redirectUriString(), bundle), approvalType == ApprovalType.PROJECT ? TALK_MIN_VERSION_SUPPORT_PROJEC_LOGIN : TALK_MIN_VERSION_SUPPORT_CAPRI);
    }

    /* access modifiers changed from: protected */
    public String redirectUriString() {
        StringBuilder sb = new StringBuilder();
        sb.append("kakao");
        sb.append(this.contextService.phaseInfo().appKey());
        sb.append(StringSet.REDIRECT_URL_POSTFIX);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Intent createIntent(String str, String str2, String str3, Bundle bundle) {
        Intent putExtra = new Intent().setAction(str).addCategory("android.intent.category.DEFAULT").putExtra(EXTRA_PROTOCOL_VERSION, 1).putExtra(EXTRA_APPLICATION_KEY, str2).putExtra(EXTRA_REDIRECT_URI, str3).putExtra(EXTRA_KA_HEADER, this.contextService.getAppConfiguration().getKAHeader());
        if (bundle != null && !bundle.isEmpty()) {
            putExtra.putExtra(EXTRA_EXTRAPARAMS, bundle);
        }
        putExtra.addFlags(65536);
        return putExtra;
    }

    /* access modifiers changed from: protected */
    public boolean isCapriProtocolMatched(Intent intent) {
        return 1 == intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
    }
}
