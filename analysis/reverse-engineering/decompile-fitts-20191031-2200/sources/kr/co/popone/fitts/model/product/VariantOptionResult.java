package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class VariantOptionResult {
    @SerializedName("options")
    @NotNull
    private final List<Option> options;
    @SerializedName("option_types")
    @NotNull
    private final List<String> types;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.String>, for r1v0, types: [java.util.List] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.product.Option>, for r2v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.product.VariantOptionResult copy$default(kr.co.popone.fitts.model.product.VariantOptionResult r0, java.util.List<java.lang.String> r1, java.util.List<kr.co.popone.fitts.model.product.Option> r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.util.List<java.lang.String> r1 = r0.types
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.product.Option> r2 = r0.options
        L_0x000c:
            kr.co.popone.fitts.model.product.VariantOptionResult r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.VariantOptionResult.copy$default(kr.co.popone.fitts.model.product.VariantOptionResult, java.util.List, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.product.VariantOptionResult");
    }

    @NotNull
    public final List<String> component1() {
        return this.types;
    }

    @NotNull
    public final List<Option> component2() {
        return this.options;
    }

    @NotNull
    public final VariantOptionResult copy(@NotNull List<String> list, @NotNull List<Option> list2) {
        Intrinsics.checkParameterIsNotNull(list, "types");
        Intrinsics.checkParameterIsNotNull(list2, "options");
        return new VariantOptionResult(list, list2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.options, (java.lang.Object) r3.options) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.product.VariantOptionResult
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.product.VariantOptionResult r3 = (kr.co.popone.fitts.model.product.VariantOptionResult) r3
            java.util.List<java.lang.String> r0 = r2.types
            java.util.List<java.lang.String> r1 = r3.types
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.util.List<kr.co.popone.fitts.model.product.Option> r0 = r2.options
            java.util.List<kr.co.popone.fitts.model.product.Option> r3 = r3.options
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.VariantOptionResult.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        List<String> list = this.types;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Option> list2 = this.options;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariantOptionResult(types=");
        sb.append(this.types);
        sb.append(", options=");
        sb.append(this.options);
        sb.append(")");
        return sb.toString();
    }

    public VariantOptionResult(@NotNull List<String> list, @NotNull List<Option> list2) {
        Intrinsics.checkParameterIsNotNull(list, "types");
        Intrinsics.checkParameterIsNotNull(list2, "options");
        this.types = list;
        this.options = list2;
    }

    @NotNull
    public final List<String> getTypes() {
        return this.types;
    }

    @NotNull
    public final List<Option> getOptions() {
        return this.options;
    }
}
