package com.kakao.auth.authorization.accesstoken;

import com.kakao.auth.StringSet;
import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.util.helper.Utility;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

class AccessTokenImpl extends JSONObjectResponse implements AccessToken {
    private static final Date DEFAULT_EXPIRATION_TIME = MAX_DATE;
    private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
    private String accessToken;
    private Date accessTokenExpiresAt;
    private String refreshToken;
    private Date refreshTokenExpiresAt;
    private AccessToken tokenInfo;

    public AccessTokenImpl(ResponseBody responseBody) throws ResponseBodyException {
        this(responseBody.toString());
    }

    public AccessTokenImpl(String str) {
        super(str);
        String str2 = "access_token";
        if (getBody().has(str2)) {
            this.accessToken = getBody().getString(str2);
            this.accessTokenExpiresAt = new Date(new Date().getTime() + (getBody().getLong("expires_in") * 1000));
            ResponseBody body = getBody();
            String str3 = StringSet.refresh_token;
            if (body.has(str3)) {
                this.refreshToken = getBody().getString(str3);
            }
            ResponseBody body2 = getBody();
            String str4 = StringSet.refresh_token_expires_in;
            if (body2.has(str4)) {
                this.refreshTokenExpiresAt = new Date(new Date().getTime() + (getBody().getLong(str4) * 1000));
            } else {
                this.refreshTokenExpiresAt = MAX_DATE;
            }
        } else {
            throw new ResponseBodyException("No Search Element : access_token");
        }
    }

    public AccessTokenImpl(String str, String str2, Date date, Date date2) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.accessTokenExpiresAt = date;
        this.refreshTokenExpiresAt = date2;
    }

    public AccessTokenImpl(AccessToken accessToken2) {
        this(accessToken2.getAccessToken(), accessToken2.getRefreshToken(), accessToken2.accessTokenExpiresAt(), accessToken2.refreshTokenExpiresAt());
        this.tokenInfo = accessToken2;
    }

    public void clearAccessToken() {
        this.accessToken = null;
        this.accessTokenExpiresAt = DEFAULT_EXPIRATION_TIME;
        AccessToken accessToken2 = this.tokenInfo;
        if (accessToken2 != null) {
            accessToken2.clearAccessToken();
        }
    }

    public void clearRefreshToken() {
        this.refreshToken = null;
        this.refreshTokenExpiresAt = DEFAULT_EXPIRATION_TIME;
        AccessToken accessToken2 = this.tokenInfo;
        if (accessToken2 != null) {
            accessToken2.clearRefreshToken();
        }
    }

    public boolean hasValidAccessToken() {
        return !Utility.isNullOrEmpty(this.accessToken) && !new Date().after(this.accessTokenExpiresAt);
    }

    public int getRemainingExpireTime() {
        if (this.accessTokenExpiresAt == null || !hasValidAccessToken()) {
            return 0;
        }
        return (int) (this.accessTokenExpiresAt.getTime() - new Date().getTime());
    }

    public void updateAccessToken(AccessToken accessToken2) {
        String refreshToken2 = accessToken2.getRefreshToken();
        if (refreshToken2 == null || refreshToken2.length() == 0) {
            this.accessToken = accessToken2.getAccessToken();
            this.accessTokenExpiresAt = accessToken2.accessTokenExpiresAt();
        } else {
            this.accessToken = accessToken2.getAccessToken();
            this.refreshToken = accessToken2.getRefreshToken();
            this.accessTokenExpiresAt = accessToken2.accessTokenExpiresAt();
            this.refreshTokenExpiresAt = accessToken2.refreshTokenExpiresAt();
        }
        AccessToken accessToken3 = this.tokenInfo;
        if (accessToken3 != null) {
            accessToken3.updateAccessToken(this);
        }
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public Date accessTokenExpiresAt() {
        return this.accessTokenExpiresAt;
    }

    public Date refreshTokenExpiresAt() {
        return this.refreshTokenExpiresAt;
    }

    public boolean hasRefreshToken() {
        return !Utility.isNullOrEmpty(this.refreshToken);
    }

    public boolean hasValidRefreshToken() {
        return !Utility.isNullOrEmpty(this.refreshToken) && (this.refreshTokenExpiresAt == null || !new Date().after(this.refreshTokenExpiresAt));
    }

    @Deprecated
    public int getRemainedExpiresInAccessTokenTime() {
        if (this.accessTokenExpiresAt == null || !hasValidAccessToken()) {
            return 0;
        }
        return (int) (this.accessTokenExpiresAt.getTime() - new Date().getTime());
    }

    public String toString() {
        if (getBody() != null) {
            return getBody().toString();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access_token", this.accessToken).put(StringSet.refresh_token, null);
            if (this.accessTokenExpiresAt != null) {
                jSONObject.put("expires_in", (this.accessTokenExpiresAt.getTime() - new Date().getTime()) / 1000);
            }
            if (this.refreshTokenExpiresAt != null) {
                jSONObject.put(StringSet.refresh_token_expires_in, (this.refreshTokenExpiresAt.getTime() - new Date().getTime()) / 1000);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return jSONObject.toString();
        }
    }
}
