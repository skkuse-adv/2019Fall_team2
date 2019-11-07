package kr.co.popone.fitts.model.user;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UserInfoNotId {
    @SerializedName("contact")
    @NotNull
    private final String contact;
    @SerializedName("email")
    @Nullable
    private final String email;
    @SerializedName("name")
    @NotNull
    private final String name;

    @NotNull
    public static /* synthetic */ UserInfoNotId copy$default(UserInfoNotId userInfoNotId, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoNotId.name;
        }
        if ((i & 2) != 0) {
            str2 = userInfoNotId.contact;
        }
        if ((i & 4) != 0) {
            str3 = userInfoNotId.email;
        }
        return userInfoNotId.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.contact;
    }

    @Nullable
    public final String component3() {
        return this.email;
    }

    @NotNull
    public final UserInfoNotId copy(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "contact");
        return new UserInfoNotId(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.email, (java.lang.Object) r3.email) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.user.UserInfoNotId
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.user.UserInfoNotId r3 = (kr.co.popone.fitts.model.user.UserInfoNotId) r3
            java.lang.String r0 = r2.name
            java.lang.String r1 = r3.name
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.contact
            java.lang.String r1 = r3.contact
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r2.email
            java.lang.String r3 = r3.email
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.user.UserInfoNotId.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contact;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.email;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfoNotId(name=");
        sb.append(this.name);
        sb.append(", contact=");
        sb.append(this.contact);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(")");
        return sb.toString();
    }

    public UserInfoNotId(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "contact");
        this.name = str;
        this.contact = str2;
        this.email = str3;
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
