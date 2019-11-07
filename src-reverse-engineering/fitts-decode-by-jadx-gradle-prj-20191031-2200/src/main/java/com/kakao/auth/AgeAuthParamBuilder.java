package com.kakao.auth;

import android.os.Bundle;
import android.text.TextUtils;
import com.kakao.auth.AuthService.AgeAuthLevel;
import com.kakao.auth.AuthService.AgeLimit;

public class AgeAuthParamBuilder {
    private Boolean adultsOnly;
    private AgeLimit ageLimit;
    private String authFrom;
    private AgeAuthLevel authLevel;
    private boolean isSkipTerms;
    private boolean isWesternAge;

    public AgeAuthParamBuilder setAuthLevel(AgeAuthLevel ageAuthLevel) {
        this.authLevel = ageAuthLevel;
        return this;
    }

    public AgeAuthParamBuilder setAgeLimit(AgeLimit ageLimit2) {
        this.ageLimit = ageLimit2;
        return this;
    }

    public AgeAuthParamBuilder setIsWesternAge(boolean z) {
        this.isWesternAge = z;
        return this;
    }

    public AgeAuthParamBuilder setSkipTerm(boolean z) {
        this.isSkipTerms = z;
        return this;
    }

    public AgeAuthParamBuilder setAuthFrom(String str) {
        this.authFrom = str;
        return this;
    }

    public AgeAuthParamBuilder setAdultsOnly(Boolean bool) {
        this.adultsOnly = bool;
        return this;
    }

    public Bundle build() {
        Bundle bundle = new Bundle();
        bundle.putString(StringSet.token_type, StringSet.api);
        bundle.putString("access_token", Session.getCurrentSession().getTokenInfo().getAccessToken());
        bundle.putString(StringSet.return_url, getAgeAuthRedirectUrl());
        AgeAuthLevel ageAuthLevel = this.authLevel;
        if (ageAuthLevel != null) {
            bundle.putString(StringSet.ageauth_level, ageAuthLevel.getValue());
        }
        AgeLimit ageLimit2 = this.ageLimit;
        if (ageLimit2 != null) {
            bundle.putString(StringSet.age_limit, ageLimit2.getValue());
        }
        boolean z = this.isWesternAge;
        if (z) {
            bundle.putString(StringSet.is_western_age, String.valueOf(z));
        }
        Boolean bool = this.adultsOnly;
        if (bool != null) {
            bundle.putString(StringSet.adults_only, String.valueOf(bool));
        }
        boolean z2 = this.isSkipTerms;
        if (z2) {
            bundle.putString(StringSet.skip_term, String.valueOf(z2));
        }
        if (!TextUtils.isEmpty(this.authFrom)) {
            bundle.putString(StringSet.auth_from, this.authFrom);
        }
        return bundle;
    }

    /* access modifiers changed from: 0000 */
    public String getAgeAuthRedirectUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("kakao");
        sb.append(Session.getCurrentSession().getAppKey());
        sb.append(StringSet.AGEAUTH_REDIRECT_URL_POSTFIX);
        return sb.toString();
    }
}
