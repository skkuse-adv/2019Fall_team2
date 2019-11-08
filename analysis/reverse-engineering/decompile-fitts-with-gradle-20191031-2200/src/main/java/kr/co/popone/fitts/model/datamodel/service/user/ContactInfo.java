package kr.co.popone.fitts.model.datamodel.service.user;

import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class ContactInfo {
    @SerializedName("contact")
    @Nullable
    private final String contact;
    @SerializedName("name")
    @Nullable
    private final String name;

    @NotNull
    public static /* synthetic */ ContactInfo copy$default(ContactInfo contactInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactInfo.name;
        }
        if ((i & 2) != 0) {
            str2 = contactInfo.contact;
        }
        return contactInfo.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final String component2() {
        return this.contact;
    }

    @NotNull
    public final ContactInfo copy(@Nullable String str, @Nullable String str2) {
        return new ContactInfo(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.contact, (java.lang.Object) r3.contact) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.user.ContactInfo
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.datamodel.service.user.ContactInfo r3 = (kr.co.popone.fitts.model.datamodel.service.user.ContactInfo) r3
            java.lang.String r0 = r2.name
            java.lang.String r1 = r3.name
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.contact
            java.lang.String r3 = r3.contact
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.user.ContactInfo.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contact;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContactInfo(name=");
        sb.append(this.name);
        sb.append(", contact=");
        sb.append(this.contact);
        sb.append(")");
        return sb.toString();
    }

    public ContactInfo(@Nullable String str, @Nullable String str2) {
        this.name = str;
        this.contact = str2;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getContact() {
        return this.contact;
    }
}
