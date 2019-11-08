package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Option {
    @SerializedName("variant_id")
    @Nullable
    private final Long id;
    @SerializedName("state")
    @Nullable
    private final String state;
    @SerializedName("sub_options")
    @Nullable
    private final List<Option> subOption;
    @SerializedName("value")
    @Nullable
    private final String value;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.product.Option>, for r4v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.product.Option copy$default(kr.co.popone.fitts.model.product.Option r0, java.lang.Long r1, java.lang.String r2, java.lang.String r3, java.util.List<kr.co.popone.fitts.model.product.Option> r4, int r5, java.lang.Object r6) {
        /*
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0006
            java.lang.Long r1 = r0.id
        L_0x0006:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x000c
            java.lang.String r2 = r0.state
        L_0x000c:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0012
            java.lang.String r3 = r0.value
        L_0x0012:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0018
            java.util.List<kr.co.popone.fitts.model.product.Option> r4 = r0.subOption
        L_0x0018:
            kr.co.popone.fitts.model.product.Option r0 = r0.copy(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.Option.copy$default(kr.co.popone.fitts.model.product.Option, java.lang.Long, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.product.Option");
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.state;
    }

    @Nullable
    public final String component3() {
        return this.value;
    }

    @Nullable
    public final List<Option> component4() {
        return this.subOption;
    }

    @NotNull
    public final Option copy(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable List<Option> list) {
        return new Option(l, str, str2, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.subOption, (java.lang.Object) r3.subOption) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.product.Option
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.product.Option r3 = (kr.co.popone.fitts.model.product.Option) r3
            java.lang.Long r0 = r2.id
            java.lang.Long r1 = r3.id
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.state
            java.lang.String r1 = r3.state
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.value
            java.lang.String r1 = r3.value
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.util.List<kr.co.popone.fitts.model.product.Option> r0 = r2.subOption
            java.util.List<kr.co.popone.fitts.model.product.Option> r3 = r3.subOption
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.Option.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.state;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Option> list = this.subOption;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option(id=");
        sb.append(this.id);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", subOption=");
        sb.append(this.subOption);
        sb.append(")");
        return sb.toString();
    }

    public Option(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable List<Option> list) {
        this.id = l;
        this.state = str;
        this.value = str2;
        this.subOption = list;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    @Nullable
    public final List<Option> getSubOption() {
        return this.subOption;
    }
}
