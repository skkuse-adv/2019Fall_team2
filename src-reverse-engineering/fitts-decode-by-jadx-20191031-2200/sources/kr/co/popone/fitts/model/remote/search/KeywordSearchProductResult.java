package kr.co.popone.fitts.model.remote.search;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KeywordSearchProductResult {
    @SerializedName("total_count")
    private final int count;
    @SerializedName("results")
    @NotNull
    private final List<Product> products;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.product.Product>, for r1v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult copy$default(kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult r0, java.util.List<kr.co.popone.fitts.model.product.Product> r1, int r2, int r3, java.lang.Object r4) {
        /*
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.product.Product> r1 = r0.products
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x000c
            int r2 = r0.count
        L_0x000c:
            kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult r0 = r0.copy(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult.copy$default(kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult, java.util.List, int, int, java.lang.Object):kr.co.popone.fitts.model.remote.search.KeywordSearchProductResult");
    }

    @NotNull
    public final List<Product> component1() {
        return this.products;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final KeywordSearchProductResult copy(@NotNull List<Product> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "products");
        return new KeywordSearchProductResult(list, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof KeywordSearchProductResult) {
                KeywordSearchProductResult keywordSearchProductResult = (KeywordSearchProductResult) obj;
                if (Intrinsics.areEqual((Object) this.products, (Object) keywordSearchProductResult.products)) {
                    if (this.count == keywordSearchProductResult.count) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<Product> list = this.products;
        return ((list != null ? list.hashCode() : 0) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeywordSearchProductResult(products=");
        sb.append(this.products);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(")");
        return sb.toString();
    }

    public KeywordSearchProductResult(@NotNull List<Product> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "products");
        this.products = list;
        this.count = i;
    }

    @NotNull
    public final List<Product> getProducts() {
        return this.products;
    }

    public final int getCount() {
        return this.count;
    }
}
