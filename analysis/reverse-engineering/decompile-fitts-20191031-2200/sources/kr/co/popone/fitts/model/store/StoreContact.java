package kr.co.popone.fitts.model.store;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreContact {
    @SerializedName("cs_manager_contact")
    @Nullable
    private final String csContact;
    @SerializedName("kakao_plus_friend_url")
    @Nullable
    private final String kakaoFriendUrl;

    @NotNull
    public static /* synthetic */ StoreContact copy$default(StoreContact storeContact, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeContact.csContact;
        }
        if ((i & 2) != 0) {
            str2 = storeContact.kakaoFriendUrl;
        }
        return storeContact.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.csContact;
    }

    @Nullable
    public final String component2() {
        return this.kakaoFriendUrl;
    }

    @NotNull
    public final StoreContact copy(@Nullable String str, @Nullable String str2) {
        return new StoreContact(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.kakaoFriendUrl, (java.lang.Object) r3.kakaoFriendUrl) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.store.StoreContact
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.store.StoreContact r3 = (kr.co.popone.fitts.model.store.StoreContact) r3
            java.lang.String r0 = r2.csContact
            java.lang.String r1 = r3.csContact
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.kakaoFriendUrl
            java.lang.String r3 = r3.kakaoFriendUrl
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.StoreContact.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.csContact;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.kakaoFriendUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreContact(csContact=");
        sb.append(this.csContact);
        sb.append(", kakaoFriendUrl=");
        sb.append(this.kakaoFriendUrl);
        sb.append(")");
        return sb.toString();
    }

    public StoreContact(@Nullable String str, @Nullable String str2) {
        this.csContact = str;
        this.kakaoFriendUrl = str2;
    }

    @Nullable
    public final String getCsContact() {
        return this.csContact;
    }

    @Nullable
    public final String getKakaoFriendUrl() {
        return this.kakaoFriendUrl;
    }
}
