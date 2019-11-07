package com.kakao.usermgmt.response;

import com.kakao.network.response.JSONObjectResponse;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.network.response.ResponseStringConverter;
import com.kakao.usermgmt.StringSet;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.util.OptionalBoolean;
import java.util.Map;
import org.json.JSONObject;

public class MeV2Response extends JSONObjectResponse {
    public static final ResponseStringConverter<MeV2Response> CONVERTER = new ResponseStringConverter<MeV2Response>() {
        public MeV2Response convert(String str) throws ResponseBodyException {
            return new MeV2Response(str);
        }
    };
    public static final String KEY_NICKNAME = "nickname";
    public static final String KEY_PROFILE_IMAGE = "profile_image";
    public static final String KEY_THUMBNAIL_IMAGE = "thumbnail_image";
    private JSONObject forPartners;
    private OptionalBoolean hasSignedUp;
    private Long id;
    private UserAccount kakaoAccount;
    private String nickname;
    private String profileImagePath;
    private Map<String, String> properties;
    private String thumbnailImagePath;

    MeV2Response(String str) {
        super(str);
        String str2 = "id";
        if (getBody().has(str2)) {
            this.id = Long.valueOf(getBody().getLong(str2));
        }
        ResponseBody body = getBody();
        String str3 = StringSet.has_signed_up;
        this.hasSignedUp = body.has(str3) ? OptionalBoolean.getOptionalBoolean(Boolean.valueOf(getBody().getBoolean(str3))) : OptionalBoolean.NONE;
        ResponseBody body2 = getBody();
        String str4 = StringSet.properties;
        if (body2.has(str4)) {
            this.properties = ResponseBody.toMap(getBody().getBody(str4));
            String str5 = "nickname";
            if (this.properties.containsKey(str5)) {
                this.nickname = (String) this.properties.get(str5);
            }
            String str6 = "thumbnail_image";
            if (this.properties.containsKey(str6)) {
                this.thumbnailImagePath = (String) this.properties.get(str6);
            }
            String str7 = "profile_image";
            if (this.properties.containsKey(str7)) {
                this.profileImagePath = (String) this.properties.get(str7);
            }
        }
        ResponseBody body3 = getBody();
        String str8 = StringSet.kakao_account;
        if (body3.has(str8)) {
            this.kakaoAccount = new UserAccount(getBody().getBody(str8));
        }
        ResponseBody body4 = getBody();
        String str9 = StringSet.for_partner;
        if (body4.has(str9)) {
            this.forPartners = getBody().getBody(str9).getJson();
        }
    }

    public UserAccount getKakaoAccount() {
        return this.kakaoAccount;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public OptionalBoolean hasSignedUp() {
        return this.hasSignedUp;
    }

    public long getId() {
        return this.id.longValue();
    }

    public JSONObject forPartners() {
        return this.forPartners;
    }

    public String toString() {
        return getBody().toString();
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getThumbnailImagePath() {
        return this.thumbnailImagePath;
    }

    public String getProfileImagePath() {
        return this.profileImagePath;
    }
}
