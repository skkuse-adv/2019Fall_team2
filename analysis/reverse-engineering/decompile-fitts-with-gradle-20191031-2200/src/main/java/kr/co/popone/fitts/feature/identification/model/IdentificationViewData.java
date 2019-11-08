package kr.co.popone.fitts.feature.identification.model;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class IdentificationViewData {
    @NotNull
    private final String contact;
    @NotNull
    private final String name;
    @NotNull
    private final String ssnFirst;
    @NotNull
    private String ssnSecond;

    @NotNull
    public static /* synthetic */ IdentificationViewData copy$default(IdentificationViewData identificationViewData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = identificationViewData.name;
        }
        if ((i & 2) != 0) {
            str2 = identificationViewData.contact;
        }
        if ((i & 4) != 0) {
            str3 = identificationViewData.ssnFirst;
        }
        if ((i & 8) != 0) {
            str4 = identificationViewData.ssnSecond;
        }
        return identificationViewData.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.contact;
    }

    @NotNull
    public final String component3() {
        return this.ssnFirst;
    }

    @NotNull
    public final String component4() {
        return this.ssnSecond;
    }

    @NotNull
    public final IdentificationViewData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "contact");
        Intrinsics.checkParameterIsNotNull(str3, "ssnFirst");
        Intrinsics.checkParameterIsNotNull(str4, "ssnSecond");
        return new IdentificationViewData(str, str2, str3, str4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.ssnSecond, (java.lang.Object) r3.ssnSecond) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof kr.co.popone.fitts.feature.identification.model.IdentificationViewData
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.feature.identification.model.IdentificationViewData r3 = (kr.co.popone.fitts.feature.identification.model.IdentificationViewData) r3
            java.lang.String r0 = r2.name
            java.lang.String r1 = r3.name
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.contact
            java.lang.String r1 = r3.contact
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.ssnFirst
            java.lang.String r1 = r3.ssnFirst
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.ssnSecond
            java.lang.String r3 = r3.ssnSecond
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.identification.model.IdentificationViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.contact;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ssnFirst;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ssnSecond;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IdentificationViewData(name=");
        sb.append(this.name);
        sb.append(", contact=");
        sb.append(this.contact);
        sb.append(", ssnFirst=");
        sb.append(this.ssnFirst);
        sb.append(", ssnSecond=");
        sb.append(this.ssnSecond);
        sb.append(")");
        return sb.toString();
    }

    public IdentificationViewData(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(str2, "contact");
        Intrinsics.checkParameterIsNotNull(str3, "ssnFirst");
        Intrinsics.checkParameterIsNotNull(str4, "ssnSecond");
        this.name = str;
        this.contact = str2;
        this.ssnFirst = str3;
        this.ssnSecond = str4;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getContact() {
        return this.contact;
    }

    @NotNull
    public final String getSsnFirst() {
        return this.ssnFirst;
    }

    @NotNull
    public final String getSsnSecond() {
        return this.ssnSecond;
    }

    public final void setSsnSecond(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.ssnSecond = str;
    }
}
