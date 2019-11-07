package kr.co.popone.fitts.model.store;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductOptionViewData {
    @Nullable
    private final Long optionId;
    @Nullable
    private final String optionState;
    @Nullable
    private final String optionValue;
    @Nullable
    private final List<ProductOptionViewData> subOptions;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData>, for r4v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.store.ProductOptionViewData copy$default(kr.co.popone.fitts.model.store.ProductOptionViewData r0, java.lang.Long r1, java.lang.String r2, java.lang.String r3, java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r4, int r5, java.lang.Object r6) {
        /*
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0006
            java.lang.Long r1 = r0.optionId
        L_0x0006:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x000c
            java.lang.String r2 = r0.optionState
        L_0x000c:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0012
            java.lang.String r3 = r0.optionValue
        L_0x0012:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0018
            java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r4 = r0.subOptions
        L_0x0018:
            kr.co.popone.fitts.model.store.ProductOptionViewData r0 = r0.copy(r1, r2, r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductOptionViewData.copy$default(kr.co.popone.fitts.model.store.ProductOptionViewData, java.lang.Long, java.lang.String, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.store.ProductOptionViewData");
    }

    @Nullable
    public final Long component1() {
        return this.optionId;
    }

    @Nullable
    public final String component2() {
        return this.optionState;
    }

    @Nullable
    public final String component3() {
        return this.optionValue;
    }

    @Nullable
    public final List<ProductOptionViewData> component4() {
        return this.subOptions;
    }

    @NotNull
    public final ProductOptionViewData copy(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable List<ProductOptionViewData> list) {
        return new ProductOptionViewData(l, str, str2, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.subOptions, (java.lang.Object) r3.subOptions) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.store.ProductOptionViewData
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.store.ProductOptionViewData r3 = (kr.co.popone.fitts.model.store.ProductOptionViewData) r3
            java.lang.Long r0 = r2.optionId
            java.lang.Long r1 = r3.optionId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.optionState
            java.lang.String r1 = r3.optionState
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.lang.String r0 = r2.optionValue
            java.lang.String r1 = r3.optionValue
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r0 = r2.subOptions
            java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r3 = r3.subOptions
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductOptionViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Long l = this.optionId;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.optionState;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.optionValue;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<ProductOptionViewData> list = this.subOptions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductOptionViewData(optionId=");
        sb.append(this.optionId);
        sb.append(", optionState=");
        sb.append(this.optionState);
        sb.append(", optionValue=");
        sb.append(this.optionValue);
        sb.append(", subOptions=");
        sb.append(this.subOptions);
        sb.append(")");
        return sb.toString();
    }

    public ProductOptionViewData(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable List<ProductOptionViewData> list) {
        this.optionId = l;
        this.optionState = str;
        this.optionValue = str2;
        this.subOptions = list;
    }

    @Nullable
    public final Long getOptionId() {
        return this.optionId;
    }

    @Nullable
    public final String getOptionState() {
        return this.optionState;
    }

    @Nullable
    public final String getOptionValue() {
        return this.optionValue;
    }

    @Nullable
    public final List<ProductOptionViewData> getSubOptions() {
        return this.subOptions;
    }
}
