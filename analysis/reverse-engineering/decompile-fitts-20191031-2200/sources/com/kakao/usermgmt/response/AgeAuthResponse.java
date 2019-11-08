package com.kakao.usermgmt.response;

import com.kakao.auth.AuthService.AgeAuthLevel;
import com.kakao.network.response.ApiResponseStatusError;
import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.usermgmt.StringSet;
import com.kakao.util.OptionalBoolean;

public class AgeAuthResponse extends JSONObjectResponse {
    public static final ResponseStringConverter<AgeAuthResponse> CONVERTER = new ResponseStringConverter<AgeAuthResponse>() {
        public AgeAuthResponse convert(String str) throws ResponseBodyException, ApiResponseStatusError {
            return new AgeAuthResponse(str);
        }
    };
    private final AgeAuthLimitStatus ageAuthLimitStatus;
    private final AgeAuthLevel authLevel = AgeAuthLevel.convertByName(getBody().optString(StringSet.auth_level, ""));
    private final int authLevelCode = getBody().optInt(StringSet.auth_level_code, 0);
    private final String authenticatedAt = getBody().optString(StringSet.authenticated_at, null);
    private final String ci;
    private final OptionalBoolean ciNeedsAgreement;
    private final OptionalBoolean hasCi;
    private final long userId = getBody().getLong("id");

    public enum AgeAuthLimitStatus {
        DONT_KNOW,
        BYPASS_AGE_LIMIT,
        DONT_BYPASS_AGE_LIMIT
    }

    public AgeAuthResponse(String str) {
        super(str);
        ResponseBody body = getBody();
        String str2 = StringSet.has_ci;
        this.hasCi = body.has(str2) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(getBody().getBoolean(str2))) : OptionalBoolean.NONE;
        ResponseBody body2 = getBody();
        String str3 = StringSet.ci_needs_agreement;
        this.ciNeedsAgreement = body2.has(str3) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(getBody().getBoolean(str3))) : OptionalBoolean.NONE;
        this.ci = getBody().optString(StringSet.ci, null);
        ResponseBody body3 = getBody();
        String str4 = StringSet.bypass_age_limit;
        if (body3.has(str4)) {
            this.ageAuthLimitStatus = getBody().getBoolean(str4) ? AgeAuthLimitStatus.BYPASS_AGE_LIMIT : AgeAuthLimitStatus.DONT_BYPASS_AGE_LIMIT;
        } else {
            this.ageAuthLimitStatus = AgeAuthLimitStatus.DONT_KNOW;
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public String getAuthenticatedAt() {
        return this.authenticatedAt;
    }

    public OptionalBoolean hasCI() {
        return this.hasCi;
    }

    public OptionalBoolean ciNeedsAgreement() {
        return this.ciNeedsAgreement;
    }

    public String getCI() {
        return this.ci;
    }

    public AgeAuthLevel getAuthLevel() {
        return this.authLevel;
    }

    public int getAuthLevelCode() {
        return this.authLevelCode;
    }

    public AgeAuthLimitStatus getAgeAuthLimitStatus() {
        return this.ageAuthLimitStatus;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AgeAuthResponse{userId=");
        sb.append(this.userId);
        sb.append(", authenticatedAt='");
        sb.append(this.authenticatedAt);
        sb.append('\'');
        sb.append(", hasCi=");
        sb.append(this.hasCi);
        sb.append('\'');
        sb.append(", ci='");
        sb.append(this.ci);
        sb.append('\'');
        sb.append(", authLevel=");
        sb.append(this.authLevel);
        sb.append(", authLevelCode=");
        sb.append(this.authLevelCode);
        sb.append(", ageAuthLimitStatus=");
        sb.append(this.ageAuthLimitStatus);
        sb.append('}');
        return sb.toString();
    }
}
