package kr.co.popone.fitts.model.store;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductVariantViewData {
    @Nullable
    private List<ProductOptionViewData> options;
    @NotNull
    private final String optionsGroupName;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData>, for r2v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.store.ProductVariantViewData copy$default(kr.co.popone.fitts.model.store.ProductVariantViewData r0, java.lang.String r1, java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.lang.String r1 = r0.optionsGroupName
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r2 = r0.options
        L_0x000c:
            kr.co.popone.fitts.model.store.ProductVariantViewData r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductVariantViewData.copy$default(kr.co.popone.fitts.model.store.ProductVariantViewData, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.store.ProductVariantViewData");
    }

    @NotNull
    public final String component1() {
        return this.optionsGroupName;
    }

    @Nullable
    public final List<ProductOptionViewData> component2() {
        return this.options;
    }

    @NotNull
    public final ProductVariantViewData copy(@NotNull String str, @Nullable List<ProductOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(str, "optionsGroupName");
        return new ProductVariantViewData(str, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.options, (java.lang.Object) r3.options) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.store.ProductVariantViewData
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.store.ProductVariantViewData r3 = (kr.co.popone.fitts.model.store.ProductVariantViewData) r3
            java.lang.String r0 = r2.optionsGroupName
            java.lang.String r1 = r3.optionsGroupName
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r0 = r2.options
            java.util.List<kr.co.popone.fitts.model.store.ProductOptionViewData> r3 = r3.options
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.store.ProductVariantViewData.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.optionsGroupName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<ProductOptionViewData> list = this.options;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductVariantViewData(optionsGroupName=");
        sb.append(this.optionsGroupName);
        sb.append(", options=");
        sb.append(this.options);
        sb.append(")");
        return sb.toString();
    }

    public ProductVariantViewData(@NotNull String str, @Nullable List<ProductOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(str, "optionsGroupName");
        this.optionsGroupName = str;
        this.options = list;
    }

    @NotNull
    public final String getOptionsGroupName() {
        return this.optionsGroupName;
    }

    @Nullable
    public final List<ProductOptionViewData> getOptions() {
        return this.options;
    }

    public final void setOptions(@Nullable List<ProductOptionViewData> list) {
        this.options = list;
    }
}
