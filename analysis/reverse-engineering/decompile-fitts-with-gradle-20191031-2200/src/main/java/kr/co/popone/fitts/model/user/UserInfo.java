package kr.co.popone.fitts.model.user;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UserInfo implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("contact")
    @NotNull
    private final String contact;
    @SerializedName("email")
    @Nullable
    private final String email;
    private final long id;
    @SerializedName("name")
    @NotNull
    private final String name;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            UserInfo userInfo = new UserInfo(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
            return userInfo;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new UserInfo[i];
        }
    }

    @NotNull
    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = userInfo.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = userInfo.name;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = userInfo.contact;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = userInfo.email;
        }
        return userInfo.copy(j2, str4, str5, str3);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.contact;
    }

    @Nullable
    public final String component4() {
        return this.email;
    }

    @NotNull
    public final UserInfo copy(long j, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "contact");
        UserInfo userInfo = new UserInfo(j, str, str2, str3);
        return userInfo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof UserInfo) {
                UserInfo userInfo = (UserInfo) obj;
                if (!(this.id == userInfo.id) || !Intrinsics.areEqual((Object) this.name, (Object) userInfo.name) || !Intrinsics.areEqual((Object) this.contact, (Object) userInfo.contact) || !Intrinsics.areEqual((Object) this.email, (Object) userInfo.email)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.contact;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.email;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfo(id=");
        sb.append(this.id);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", contact=");
        sb.append(this.contact);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.contact);
        parcel.writeString(this.email);
    }

    public UserInfo(long j, @NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "contact");
        this.id = j;
        this.name = str;
        this.contact = str2;
        this.email = str3;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getContact() {
        return this.contact;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }
}
