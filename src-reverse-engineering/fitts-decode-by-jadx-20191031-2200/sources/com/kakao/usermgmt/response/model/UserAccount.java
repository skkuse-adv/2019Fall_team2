package com.kakao.usermgmt.response.model;

import androidx.annotation.Nullable;
import com.kakao.network.response.ResponseBody;
import com.kakao.usermgmt.StringSet;
import com.kakao.util.OptionalBoolean;
import org.json.JSONObject;

public class UserAccount {
    private AgeRange ageRange;
    private OptionalBoolean ageRangeNeedsAgreement;
    private String birthday;
    private OptionalBoolean birthdayNeedsAgreement;
    private String birthyear;
    private OptionalBoolean birthyearNeedsAgreement;
    private String ci;
    private String ciAuthenticatedAt;
    private OptionalBoolean ciNeedsAgreement;
    private String displayId;
    private String email;
    private OptionalBoolean emailNeedsAgreement;
    private Gender gender;
    private OptionalBoolean genderNeedsAgreement;
    private OptionalBoolean hasAgeRange;
    private OptionalBoolean hasBirthday;
    private OptionalBoolean hasBirthyear;
    private OptionalBoolean hasCi;
    private OptionalBoolean hasEmail;
    private OptionalBoolean hasGender;
    private OptionalBoolean hasPhoneNumber;
    private OptionalBoolean isEmailValid;
    private OptionalBoolean isEmailVerified;
    private OptionalBoolean isKakaoTalkUser;
    private String phoneNumber;
    private OptionalBoolean phoneNumberNeedsAgreement;
    private JSONObject response;

    public UserAccount(ResponseBody responseBody) {
        String str = StringSet.has_email;
        this.hasEmail = responseBody.has(str) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str))) : OptionalBoolean.NONE;
        String str2 = StringSet.email_needs_agreement;
        this.emailNeedsAgreement = responseBody.has(str2) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str2))) : OptionalBoolean.NONE;
        String str3 = StringSet.is_email_verified;
        this.isEmailVerified = responseBody.has(str3) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str3))) : OptionalBoolean.NONE;
        String str4 = StringSet.is_email_valid;
        this.isEmailValid = responseBody.has(str4) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str4))) : OptionalBoolean.NONE;
        String str5 = StringSet.has_phone_number;
        this.hasPhoneNumber = responseBody.has(str5) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str5))) : OptionalBoolean.NONE;
        String str6 = StringSet.phone_number_needs_agreement;
        this.phoneNumberNeedsAgreement = responseBody.has(str6) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str6))) : OptionalBoolean.NONE;
        String str7 = StringSet.has_age_range;
        this.hasAgeRange = responseBody.has(str7) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str7))) : OptionalBoolean.NONE;
        String str8 = StringSet.age_range_needs_agreement;
        this.ageRangeNeedsAgreement = responseBody.has(str8) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str8))) : OptionalBoolean.NONE;
        String str9 = StringSet.has_birthday;
        this.hasBirthday = responseBody.has(str9) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str9))) : OptionalBoolean.NONE;
        String str10 = StringSet.birthday_needs_agreement;
        this.birthdayNeedsAgreement = responseBody.has(str10) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str10))) : OptionalBoolean.NONE;
        String str11 = StringSet.has_birthyear;
        this.hasBirthyear = responseBody.has(str11) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str11))) : OptionalBoolean.NONE;
        String str12 = StringSet.birthyear_needs_agreement;
        this.birthyearNeedsAgreement = responseBody.has(str12) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str12))) : OptionalBoolean.NONE;
        String str13 = StringSet.has_gender;
        this.hasGender = responseBody.has(str13) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str13))) : OptionalBoolean.NONE;
        String str14 = StringSet.gender_needs_agreement;
        this.genderNeedsAgreement = responseBody.has(str14) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str14))) : OptionalBoolean.NONE;
        String str15 = StringSet.has_ci;
        this.hasCi = responseBody.has(str15) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(str15))) : OptionalBoolean.NONE;
        this.ciNeedsAgreement = responseBody.has(StringSet.ci_needs_agreement) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(StringSet.ci_needs_agreement))) : OptionalBoolean.NONE;
        this.isKakaoTalkUser = responseBody.has(StringSet.is_kakaotalk_user) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(responseBody.getBoolean(StringSet.is_kakaotalk_user))) : OptionalBoolean.NONE;
        if (responseBody.has("email")) {
            this.email = responseBody.getString("email");
        }
        if (responseBody.has(StringSet.phone_number)) {
            this.phoneNumber = responseBody.getString(StringSet.phone_number);
        }
        if (responseBody.has(StringSet.age_range)) {
            this.ageRange = AgeRange.getRange(responseBody.getString(StringSet.age_range));
        }
        if (responseBody.has(StringSet.birthday)) {
            this.birthday = responseBody.getString(StringSet.birthday);
        }
        if (responseBody.has(StringSet.birthyear)) {
            this.birthyear = responseBody.getString(StringSet.birthyear);
        }
        if (responseBody.has(StringSet.gender)) {
            this.gender = Gender.getGender(responseBody.getString(StringSet.gender));
        }
        if (responseBody.has(StringSet.ci)) {
            this.ci = responseBody.getString(StringSet.ci);
        }
        if (responseBody.has(StringSet.ci_authenticated_at)) {
            this.ciAuthenticatedAt = responseBody.getString(StringSet.ci_authenticated_at);
        }
        if (responseBody.has(StringSet.display_id)) {
            this.displayId = responseBody.getString(StringSet.display_id);
        }
        this.response = responseBody.getJson();
    }

    public OptionalBoolean emailNeedsAgreement() {
        return this.emailNeedsAgreement;
    }

    public OptionalBoolean isEmailVerified() {
        return this.isEmailVerified;
    }

    public OptionalBoolean isEmailValid() {
        return this.isEmailValid;
    }

    public String getEmail() {
        return this.email;
    }

    public OptionalBoolean phoneNumberNeedsAgreement() {
        return this.phoneNumberNeedsAgreement;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getDisplayId() {
        return this.displayId;
    }

    public OptionalBoolean ageRangeNeedsAgreement() {
        return this.ageRangeNeedsAgreement;
    }

    public AgeRange getAgeRange() {
        return this.ageRange;
    }

    public OptionalBoolean birthdayNeedsAgreement() {
        return this.birthdayNeedsAgreement;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public OptionalBoolean birthyearNeedsAgreement() {
        return this.birthyearNeedsAgreement;
    }

    public String getBirthyear() {
        return this.birthyear;
    }

    public OptionalBoolean genderNeedsAgreement() {
        return this.genderNeedsAgreement;
    }

    @Nullable
    public Gender getGender() {
        return this.gender;
    }

    public OptionalBoolean ciNeedsAgreement() {
        return this.ciNeedsAgreement;
    }

    public String getCI() {
        return this.ci;
    }

    public String ciAuthenticatedAt() {
        return this.ciAuthenticatedAt;
    }

    public boolean isKakaotalkUserNeedsAgreement() {
        return this.isKakaoTalkUser == OptionalBoolean.NONE;
    }

    public OptionalBoolean isKakaoTalkUser() {
        return this.isKakaoTalkUser;
    }

    public JSONObject getResponse() {
        return this.response;
    }

    @Deprecated
    public OptionalBoolean hasEmail() {
        return this.hasEmail;
    }

    @Deprecated
    public OptionalBoolean hasPhoneNumber() {
        return this.hasPhoneNumber;
    }

    @Deprecated
    public OptionalBoolean hasAgeRange() {
        return this.hasAgeRange;
    }

    @Deprecated
    public OptionalBoolean hasBirthday() {
        return this.hasBirthday;
    }

    @Deprecated
    public OptionalBoolean hasGender() {
        return this.hasGender;
    }

    @Deprecated
    public OptionalBoolean hasBirthyear() {
        return this.hasBirthyear;
    }

    @Deprecated
    public OptionalBoolean hasCI() {
        return this.hasCi;
    }

    @Deprecated
    public boolean needsScopeAccountEmail() {
        return this.hasEmail == OptionalBoolean.TRUE && this.email == null;
    }

    @Deprecated
    public boolean needsScopePhoneNumber() {
        return this.hasPhoneNumber == OptionalBoolean.TRUE && this.phoneNumber == null;
    }

    @Deprecated
    public boolean needsScopeAgeRange() {
        return this.hasAgeRange == OptionalBoolean.TRUE && this.ageRange == null;
    }

    @Deprecated
    public boolean needsScopeBirthday() {
        return this.hasBirthday == OptionalBoolean.TRUE && this.birthday == null;
    }

    @Deprecated
    public boolean needsScopeGender() {
        return this.hasGender == OptionalBoolean.TRUE && this.gender == null;
    }

    @Deprecated
    public boolean needsScopeIsKakaotalkUser() {
        return this.isKakaoTalkUser == OptionalBoolean.NONE;
    }
}
