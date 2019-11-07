package com.kakao.auth.authorization;

import android.net.Uri;
import com.kakao.auth.authorization.accesstoken.AccessToken;

public class AuthorizationResult {
    private AccessToken accessToken;
    private Exception exception;
    private String redirectURL;
    private final RESULT_CODE resultCode;
    private String resultMessage;

    public enum RESULT_CODE {
        SUCCESS,
        CANCEL,
        PASS,
        OAUTH_ERROR,
        ERROR
    }

    public static AuthorizationResult createSuccessAuthCodeResult(String str) {
        return new AuthorizationResult(RESULT_CODE.SUCCESS).setRedirectURL(str);
    }

    public static AuthorizationResult createAuthCodeCancelResult(String str) {
        return new AuthorizationResult(RESULT_CODE.CANCEL).setResultMessage(str);
    }

    public static AuthorizationResult createAuthCodeOAuthErrorResult(String str) {
        return new AuthorizationResult(RESULT_CODE.OAUTH_ERROR).setResultMessage(str);
    }

    public static AuthorizationResult createAuthCodeOAuthErrorResult(Exception exc) {
        return new AuthorizationResult(RESULT_CODE.OAUTH_ERROR, exc).setResultMessage(exc.getMessage());
    }

    public static AuthorizationResult createAuthCodePassResult() {
        return new AuthorizationResult(RESULT_CODE.PASS);
    }

    public boolean isSuccess() {
        return this.resultCode == RESULT_CODE.SUCCESS;
    }

    public boolean isCanceled() {
        return this.resultCode == RESULT_CODE.CANCEL;
    }

    public boolean isPass() {
        return this.resultCode == RESULT_CODE.PASS;
    }

    public boolean isAuthError() {
        return this.resultCode == RESULT_CODE.OAUTH_ERROR;
    }

    public boolean isError() {
        return this.resultCode == RESULT_CODE.ERROR;
    }

    public String getRedirectURL() {
        return this.redirectURL;
    }

    public Uri getRedirectUri() {
        String str = this.redirectURL;
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    public String getResultMessage() {
        return this.resultMessage;
    }

    public Exception getException() {
        return this.exception;
    }

    private AuthorizationResult(RESULT_CODE result_code) {
        this.resultCode = result_code;
    }

    private AuthorizationResult(RESULT_CODE result_code, Exception exc) {
        this.resultCode = result_code;
        this.exception = exc;
    }

    private AuthorizationResult setRedirectURL(String str) {
        this.redirectURL = str;
        return this;
    }

    private AuthorizationResult setAccessToken(AccessToken accessToken2) {
        this.accessToken = accessToken2;
        return this;
    }

    private AuthorizationResult setResultMessage(String str) {
        this.resultMessage = str;
        return this;
    }
}
