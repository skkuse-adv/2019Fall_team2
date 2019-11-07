package com.kakao.auth.authorization.accesstoken;

import android.os.Bundle;
import com.facebook.internal.ServerProtocol;
import com.kakao.auth.helper.Encryptor;
import com.kakao.util.helper.PersistentKVStore;
import java.util.Date;

class EncryptedAccessToken implements AccessToken {
    private static final String CACHE_KAKAO_SECURE_MODE = "com.kakao.token.KakaoSecureMode";
    private PersistentKVStore cache;
    private boolean currentSecureMode;
    private Encryptor encryptor;
    private AccessToken tokenInfo;

    /* access modifiers changed from: 0000 */
    public void setEncryptor(Encryptor encryptor2) {
        this.encryptor = encryptor2;
        initAccessToken();
    }

    EncryptedAccessToken(AccessToken accessToken, Encryptor encryptor2, boolean z, PersistentKVStore persistentKVStore) {
        this.tokenInfo = accessToken;
        this.encryptor = encryptor2;
        this.currentSecureMode = z;
        this.cache = persistentKVStore;
        if (encryptor2 != null) {
            initAccessToken();
        }
    }

    /* access modifiers changed from: 0000 */
    public void initAccessToken() {
        if (this.tokenInfo != null) {
            AccessToken accessToken = needsEncryption() ? processAccessToken(true, this.tokenInfo) : needsDecryption() ? processAccessToken(false, this.tokenInfo) : null;
            if (accessToken != null) {
                this.tokenInfo.updateAccessToken(accessToken);
            }
        }
        setLastSecureMode(this.currentSecureMode);
    }

    public String getAccessToken() {
        String accessToken = this.tokenInfo.getAccessToken();
        String str = null;
        if (accessToken == null) {
            return null;
        }
        try {
            if (this.currentSecureMode) {
                accessToken = decryptToken(accessToken);
            }
            str = accessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getRefreshToken() {
        String refreshToken = this.tokenInfo.getRefreshToken();
        String str = null;
        if (refreshToken == null) {
            return null;
        }
        try {
            if (this.currentSecureMode) {
                refreshToken = decryptToken(refreshToken);
            }
            str = refreshToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public Date accessTokenExpiresAt() {
        return this.tokenInfo.accessTokenExpiresAt();
    }

    public Date refreshTokenExpiresAt() {
        return this.tokenInfo.refreshTokenExpiresAt();
    }

    public void clearAccessToken() {
        this.tokenInfo.clearAccessToken();
    }

    public void clearRefreshToken() {
        this.tokenInfo.clearRefreshToken();
    }

    public boolean hasValidAccessToken() {
        return this.tokenInfo.hasValidAccessToken() && getAccessToken() != null;
    }

    public boolean hasRefreshToken() {
        return this.tokenInfo.hasRefreshToken() && getRefreshToken() != null;
    }

    public boolean hasValidRefreshToken() {
        return this.tokenInfo.hasValidRefreshToken() && getRefreshToken() != null;
    }

    public void updateAccessToken(AccessToken accessToken) {
        if (this.currentSecureMode) {
            accessToken = processAccessToken(true, accessToken);
        }
        AccessToken accessToken2 = this.tokenInfo;
        if (accessToken2 != null) {
            accessToken2.updateAccessToken(accessToken);
        }
        setLastSecureMode(this.currentSecureMode);
    }

    /* access modifiers changed from: private */
    public String encryptToken(String str) {
        try {
            return this.encryptor.encrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String decryptToken(String str) {
        try {
            return this.encryptor.decrypt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getRemainingExpireTime() {
        return this.tokenInfo.getRemainingExpireTime();
    }

    /* access modifiers changed from: 0000 */
    public boolean getLastSecureMode() {
        String string = this.cache.getString(CACHE_KAKAO_SECURE_MODE);
        return string != null && string.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    /* access modifiers changed from: 0000 */
    public void setLastSecureMode(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(CACHE_KAKAO_SECURE_MODE, String.valueOf(z));
        this.cache.save(bundle);
    }

    /* access modifiers changed from: 0000 */
    public boolean needsEncryption() {
        return !getLastSecureMode() && this.currentSecureMode;
    }

    /* access modifiers changed from: 0000 */
    public boolean needsDecryption() {
        return getLastSecureMode() && !this.currentSecureMode;
    }

    private AccessToken processAccessToken(final boolean z, final AccessToken accessToken) {
        return new AccessToken() {
            public void clearAccessToken() {
            }

            public void clearRefreshToken() {
            }

            public int getRemainingExpireTime() {
                return 0;
            }

            public boolean hasRefreshToken() {
                return false;
            }

            public boolean hasValidAccessToken() {
                return false;
            }

            public boolean hasValidRefreshToken() {
                return false;
            }

            public void updateAccessToken(AccessToken accessToken) {
            }

            public String getAccessToken() {
                if (z) {
                    return EncryptedAccessToken.this.encryptToken(accessToken.getAccessToken());
                }
                return EncryptedAccessToken.this.decryptToken(accessToken.getAccessToken());
            }

            public String getRefreshToken() {
                if (z) {
                    return EncryptedAccessToken.this.encryptToken(accessToken.getRefreshToken());
                }
                return EncryptedAccessToken.this.decryptToken(accessToken.getRefreshToken());
            }

            public Date accessTokenExpiresAt() {
                return accessToken.accessTokenExpiresAt();
            }

            public Date refreshTokenExpiresAt() {
                return accessToken.refreshTokenExpiresAt();
            }
        };
    }
}
