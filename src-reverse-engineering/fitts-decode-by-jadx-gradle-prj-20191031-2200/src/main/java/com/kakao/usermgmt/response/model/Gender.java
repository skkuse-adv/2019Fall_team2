package com.kakao.usermgmt.response.model;

import com.facebook.internal.FacebookRequestErrorClassification;

public enum Gender {
    FEMALE("female"),
    MALE("male"),
    OTHER(FacebookRequestErrorClassification.KEY_OTHER),
    UNKNOWN("N/A");
    
    private String value;

    private Gender(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public static Gender getGender(String str) {
        Gender[] values;
        for (Gender gender : values()) {
            if (gender.value.equalsIgnoreCase(str)) {
                return gender;
            }
        }
        return UNKNOWN;
    }
}
