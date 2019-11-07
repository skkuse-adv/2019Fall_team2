package com.kakao.usermgmt.response.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.kakao.auth.Session;
import com.kakao.network.response.ResponseBody;
import com.kakao.network.response.ResponseBody.ResponseBodyException;
import com.kakao.usermgmt.StringSet;
import com.kakao.util.helper.SharedPreferencesCache;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class UserProfile implements User, Parcelable {
    private static final String CACHE_EMAIL_VERIFIED = "com.kakao.user.email_verified";
    private static final String CACHE_FRIEND_UUID = "com.kakao.user.uuid";
    private static final String CACHE_NICKNAME = "com.kakao.user.nickname";
    private static final String CACHE_PROFILE_PATH = "com.kakao.user.profilepath";
    private static final String CACHE_REMAINING_GRUOP_MSG_COUNT = "com.kakao.user.remaininggroupmsgcount";
    private static final String CACHE_REMAINING_INVITE_COUNT = "com.kakao.user.remaininginvitecount";
    private static final String CACHE_SERVICE_USER_ID = "com.kakao.user.serviceuserid";
    private static final String CACHE_THUMBNAIL_PATH = "com.kakao.user.thumbbnailpath";
    private static final String CACHE_USER_EMAIL = "com.kakao.user.email";
    private static final String CACHE_USER_ID = "com.kakao.user.userId";
    private static final String CACHE_USER_PREFIX = "com.kakao.user.properties.";
    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        public UserProfile createFromParcel(Parcel parcel) {
            return new UserProfile(parcel);
        }

        public UserProfile[] newArray(int i) {
            return new UserProfile[i];
        }
    };
    private String email;
    private boolean emailVerified;
    private final long id;
    private String nickname;
    private String profileImagePath;
    private Map<String, String> properties = new HashMap();
    private final int remainingGroupMsgCount;
    private final int remainingInviteCount;
    private final long serviceUserId;
    private String thumbnailImagePath;
    private final String uuid;

    public int describeContents() {
        return 0;
    }

    public UserProfile(ResponseBody responseBody) throws ResponseBodyException {
        this.id = responseBody.getLong("id");
        if (this.id > 0) {
            this.email = responseBody.optString(StringSet.kaccount_email, null);
            this.emailVerified = responseBody.optBoolean(StringSet.email_verified, false);
            this.uuid = responseBody.optString(StringSet.uuid, null);
            this.serviceUserId = responseBody.optLong(StringSet.service_user_id, 0);
            this.remainingInviteCount = responseBody.optInt(StringSet.remaining_invite_count, 0);
            this.remainingGroupMsgCount = responseBody.optInt(StringSet.remaining_group_msg_count, 0);
            String str = StringSet.properties;
            if (responseBody.has(str)) {
                this.properties = ResponseBody.toMap(responseBody.getBody(str));
                this.nickname = (String) this.properties.remove("nickname");
                this.thumbnailImagePath = (String) this.properties.remove("thumbnail_image");
                this.profileImagePath = (String) this.properties.remove("profile_image");
                return;
            }
            this.nickname = null;
            this.thumbnailImagePath = null;
            this.profileImagePath = null;
            return;
        }
        throw new ResponseBodyException("User is called but the result user is null.");
    }

    public UserProfile(SharedPreferencesCache sharedPreferencesCache) {
        this.id = sharedPreferencesCache.getLong(CACHE_USER_ID).longValue();
        this.email = sharedPreferencesCache.getString(CACHE_USER_EMAIL);
        this.emailVerified = sharedPreferencesCache.getBoolean(CACHE_EMAIL_VERIFIED).booleanValue();
        this.nickname = sharedPreferencesCache.getString(CACHE_NICKNAME);
        this.thumbnailImagePath = sharedPreferencesCache.getString(CACHE_THUMBNAIL_PATH);
        this.profileImagePath = sharedPreferencesCache.getString(CACHE_PROFILE_PATH);
        this.properties = sharedPreferencesCache.getStringMap(CACHE_USER_PREFIX);
        this.uuid = sharedPreferencesCache.getString(CACHE_FRIEND_UUID);
        this.serviceUserId = sharedPreferencesCache.getLong(CACHE_SERVICE_USER_ID).longValue();
        this.remainingInviteCount = sharedPreferencesCache.getInt(CACHE_REMAINING_INVITE_COUNT);
        this.remainingGroupMsgCount = sharedPreferencesCache.getInt(CACHE_REMAINING_GRUOP_MSG_COUNT);
    }

    public UserProfile(Parcel parcel) {
        this.id = parcel.readLong();
        this.email = parcel.readString();
        this.emailVerified = parcel.readInt() != 0;
        this.nickname = parcel.readString();
        this.thumbnailImagePath = parcel.readString();
        this.profileImagePath = parcel.readString();
        this.uuid = parcel.readString();
        this.serviceUserId = parcel.readLong();
        this.remainingInviteCount = parcel.readInt();
        this.remainingGroupMsgCount = parcel.readInt();
        parcel.readMap(this.properties, UserProfile.class.getClassLoader());
    }

    public int getRemainingInviteCount() {
        return this.remainingInviteCount;
    }

    public int getRemainingGroupMsgCount() {
        return this.remainingGroupMsgCount;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public String getProperty(String str) {
        Map<String, String> map = this.properties;
        if (map != null) {
            return (String) map.get(str);
        }
        return null;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean getEmailVerified() {
        return this.emailVerified;
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

    public long getId() {
        return this.id;
    }

    public String getUUID() {
        return this.uuid;
    }

    public long getServiceUserId() {
        return this.serviceUserId;
    }

    public static UserProfile loadFromCache() {
        SharedPreferencesCache appCache = Session.getCurrentSession().getAppCache();
        if (appCache == null) {
            return null;
        }
        return new UserProfile(appCache);
    }

    public void saveUserToCache() {
        SharedPreferencesCache appCache = Session.getCurrentSession().getAppCache();
        if (appCache != null) {
            Bundle bundle = new Bundle();
            bundle.putLong(CACHE_USER_ID, this.id);
            bundle.putString(CACHE_USER_EMAIL, this.email);
            bundle.putBoolean(CACHE_EMAIL_VERIFIED, this.emailVerified);
            bundle.putString(CACHE_NICKNAME, this.nickname);
            bundle.putString(CACHE_THUMBNAIL_PATH, this.thumbnailImagePath);
            bundle.putString(CACHE_PROFILE_PATH, this.profileImagePath);
            bundle.putString(CACHE_FRIEND_UUID, this.uuid);
            bundle.putLong(CACHE_SERVICE_USER_ID, this.serviceUserId);
            bundle.putInt(CACHE_REMAINING_INVITE_COUNT, this.remainingInviteCount);
            bundle.putInt(CACHE_REMAINING_GRUOP_MSG_COUNT, this.remainingGroupMsgCount);
            if (!this.properties.isEmpty()) {
                for (String str : this.properties.keySet()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CACHE_USER_PREFIX);
                    sb.append(str);
                    bundle.putString(sb.toString(), (String) this.properties.get(str));
                }
            }
            appCache.save(bundle);
        }
    }

    public UserProfile updateUserProfile(Map<String, String> map) {
        if (map != null) {
            String str = (String) map.remove("nickname");
            if (str != null) {
                this.nickname = str;
            }
            String str2 = (String) map.remove("thumbnail_image");
            if (str2 != null) {
                this.thumbnailImagePath = str2;
            }
            String str3 = (String) map.remove("profile_image");
            if (str3 != null) {
                this.profileImagePath = str3;
            }
            if (!map.isEmpty()) {
                this.properties.putAll(map);
            }
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserProfile{nickname='");
        sb.append(this.nickname);
        sb.append('\'');
        sb.append(", email='");
        sb.append(this.email);
        sb.append('\'');
        sb.append(", email_verified='");
        sb.append(this.emailVerified);
        sb.append('\'');
        sb.append(", thumbnailImagePath='");
        sb.append(this.thumbnailImagePath);
        sb.append('\'');
        sb.append(", profileImagePath='");
        sb.append(this.profileImagePath);
        sb.append('\'');
        sb.append(", code='");
        sb.append(this.uuid);
        sb.append('\'');
        sb.append(", serviceUserId='");
        sb.append(this.serviceUserId);
        sb.append('\'');
        sb.append(", remainingInviteCount='");
        sb.append(this.remainingInviteCount);
        sb.append('\'');
        sb.append(", remainingGroupMsgCount='");
        sb.append(this.remainingGroupMsgCount);
        sb.append('\'');
        sb.append(", properties=");
        sb.append(this.properties);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.email);
        parcel.writeInt(this.emailVerified ? 1 : 0);
        parcel.writeString(this.nickname);
        parcel.writeString(this.thumbnailImagePath);
        parcel.writeString(this.profileImagePath);
        parcel.writeString(this.uuid);
        parcel.writeLong(this.serviceUserId);
        parcel.writeInt(this.remainingInviteCount);
        parcel.writeInt(this.remainingGroupMsgCount);
        parcel.writeMap(this.properties);
    }
}
