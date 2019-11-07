package kr.co.popone.fitts.model.product;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CategoryProductListResponse {
    @SerializedName("items")
    @NotNull
    private final List<CategoryProductItem> items;
    @SerializedName("version")
    @NotNull
    private final String version;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.product.CategoryProductItem>, for r2v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.product.CategoryProductListResponse copy$default(kr.co.popone.fitts.model.product.CategoryProductListResponse r0, java.lang.String r1, java.util.List<kr.co.popone.fitts.model.product.CategoryProductItem> r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.lang.String r1 = r0.version
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.product.CategoryProductItem> r2 = r0.items
        L_0x000c:
            kr.co.popone.fitts.model.product.CategoryProductListResponse r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.CategoryProductListResponse.copy$default(kr.co.popone.fitts.model.product.CategoryProductListResponse, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.product.CategoryProductListResponse");
    }

    @NotNull
    public final String component1() {
        return this.version;
    }

    @NotNull
    public final List<CategoryProductItem> component2() {
        return this.items;
    }

    @NotNull
    public final CategoryProductListResponse copy(@NotNull String str, @NotNull List<CategoryProductItem> list) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        Intrinsics.checkParameterIsNotNull(list, "items");
        return new CategoryProductListResponse(str, list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.items, (java.lang.Object) r3.items) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.product.CategoryProductListResponse
            if (r0 == 0) goto L_0x001d
            kr.co.popone.fitts.model.product.CategoryProductListResponse r3 = (kr.co.popone.fitts.model.product.CategoryProductListResponse) r3
            java.lang.String r0 = r2.version
            java.lang.String r1 = r3.version
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.util.List<kr.co.popone.fitts.model.product.CategoryProductItem> r0 = r2.items
            java.util.List<kr.co.popone.fitts.model.product.CategoryProductItem> r3 = r3.items
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.product.CategoryProductListResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str = this.version;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<CategoryProductItem> list = this.items;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryProductListResponse(version=");
        sb.append(this.version);
        sb.append(", items=");
        sb.append(this.items);
        sb.append(")");
        return sb.toString();
    }

    public CategoryProductListResponse(@NotNull String str, @NotNull List<CategoryProductItem> list) {
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        Intrinsics.checkParameterIsNotNull(list, "items");
        this.version = str;
        this.items = list;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @NotNull
    public final List<CategoryProductItem> getItems() {
        return this.items;
    }
}
