package com.kakao.auth.authorization.accesstoken;

import android.os.Bundle;
import com.kakao.util.helper.PersistentKVStore;
import com.kakao.util.helper.Utility;
import java.util.ArrayList;
import java.util.Date;

class PersistentAccessToken implements AccessToken {
    private static final String CACHE_ACCESS_TOKEN = "com.kakao.token.AccessToken";
    private static final String CACHE_ACCESS_TOKEN_EXPIRES_AT = "com.kakao.token.AccessToken.ExpiresAt";
    private static final String CACHE_REFRESH_TOKEN = "com.kakao.token.RefreshToken";
    private static final String CACHE_REFRESH_TOKEN_EXPIRES_AT = "com.kakao.token.RefreshToken.ExpiresAt";
    private PersistentKVStore cache;
    private AccessToken tokenInfo;

    PersistentAccessToken(AccessToken accessToken, PersistentKVStore persistentKVStore) {
        this.tokenInfo = accessToken;
        this.cache = persistentKVStore;
    }

    public String getAccessToken() {
        return this.cache.getString(CACHE_ACCESS_TOKEN);
    }

    public String getRefreshToken() {
        return this.cache.getString(CACHE_REFRESH_TOKEN);
    }

    public Date accessTokenExpiresAt() {
        return this.cache.getDate(CACHE_ACCESS_TOKEN_EXPIRES_AT);
    }

    public Date refreshTokenExpiresAt() {
        return this.cache.getDate(CACHE_REFRESH_TOKEN_EXPIRES_AT);
    }

    public void clearAccessToken() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CACHE_ACCESS_TOKEN);
        arrayList.add(CACHE_ACCESS_TOKEN_EXPIRES_AT);
        this.cache.clear(arrayList);
    }

    public void clearRefreshToken() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CACHE_REFRESH_TOKEN);
        arrayList.add(CACHE_REFRESH_TOKEN_EXPIRES_AT);
        this.cache.clear(arrayList);
    }

    public boolean hasValidAccessToken() {
        return !Utility.isNullOrEmpty(getAccessToken()) && !new Date().after(accessTokenExpiresAt());
    }

    public boolean hasRefreshToken() {
        return !Utility.isNullOrEmpty(getRefreshToken());
    }

    public boolean hasValidRefreshToken() {
        return !Utility.isNullOrEmpty(getRefreshToken()) && !new Date().after(refreshTokenExpiresAt());
    }

    public void updateAccessToken(AccessToken accessToken) {
        AccessToken accessToken2 = this.tokenInfo;
        if (accessToken2 != null) {
            accessToken2.updateAccessToken(accessToken);
        }
        Bundle bundle = new Bundle();
        bundle.putString(CACHE_ACCESS_TOKEN, accessToken.getAccessToken());
        bundle.putString(CACHE_REFRESH_TOKEN, accessToken.getRefreshToken());
        if (accessToken.accessTokenExpiresAt() != null) {
            bundle.putLong(CACHE_ACCESS_TOKEN_EXPIRES_AT, accessToken.accessTokenExpiresAt().getTime());
        }
        if (accessToken.refreshTokenExpiresAt() != null) {
            bundle.putLong(CACHE_REFRESH_TOKEN_EXPIRES_AT, accessToken.refreshTokenExpiresAt().getTime());
        }
        this.cache.save(bundle);
    }

    public int getRemainingExpireTime() {
        if (accessTokenExpiresAt() == null || !hasValidAccessToken()) {
            return 0;
        }
        return (int) (accessTokenExpiresAt().getTime() - new Date().getTime());
    }
}
