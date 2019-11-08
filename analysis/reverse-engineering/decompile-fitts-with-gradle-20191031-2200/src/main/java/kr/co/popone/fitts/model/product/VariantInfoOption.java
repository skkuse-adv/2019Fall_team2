package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class VariantInfoOption {
    @SerializedName("type")
    @NotNull
    private final String optionType;
    @SerializedName("value")
    @NotNull
    private final String optionValue;

    @NotNull
    public static /* synthetic */ VariantInfoOption copy$default(VariantInfoOption variantInfoOption, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = variantInfoOption.optionType;
        }
        if ((i & 2) != 0) {
            str2 = variantInfoOption.optionValue;
        }
        return variantInfoOption.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.optionType;
    }

    @NotNull
    public final String component2() {
        return this.optionValue;
    }

    @NotNull
    public final VariantInfoOption copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "optionType");
        Intrinsics.checkParameterIsNotNull(str2, "optionValue");
        return new VariantInfoOption(str, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.optionValue, (java.lang.Object) r3.optionValue) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.product.VariantInfoOption
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.product.VariantInfoOption r3 = (kr.co.popone.fitts.model.product.VariantInfoOption) r3
            java.lang.String r0 = r2.optionType
            java.lang.String r1 = r3.optionType
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r2.optionValue
            java.lang.String r3 = r3.optionValue
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.VariantInfoOption.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.optionType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.optionValue;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariantInfoOption(optionType=");
        sb.append(this.optionType);
        sb.append(", optionValue=");
        sb.append(this.optionValue);
        sb.append(")");
        return sb.toString();
    }

    public VariantInfoOption(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "optionType");
        Intrinsics.checkParameterIsNotNull(str2, "optionValue");
        this.optionType = str;
        this.optionValue = str2;
    }

    @NotNull
    public final String getOptionType() {
        return this.optionType;
    }

    @NotNull
    public final String getOptionValue() {
        return this.optionValue;
    }
}
