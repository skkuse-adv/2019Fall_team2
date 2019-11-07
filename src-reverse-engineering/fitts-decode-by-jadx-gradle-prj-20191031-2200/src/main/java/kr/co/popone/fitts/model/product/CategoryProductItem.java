package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategoryProductItem {
    @SerializedName("id")
    private final long feedId;
    @SerializedName("item")
    @NotNull
    private final Product item;
    @SerializedName("type")
    @NotNull
    private final String type;

    @NotNull
    public static /* synthetic */ CategoryProductItem copy$default(CategoryProductItem categoryProductItem, long j, String str, Product product, int i, Object obj) {
        if ((i & 1) != 0) {
            j = categoryProductItem.feedId;
        }
        if ((i & 2) != 0) {
            str = categoryProductItem.type;
        }
        if ((i & 4) != 0) {
            product = categoryProductItem.item;
        }
        return categoryProductItem.copy(j, str, product);
    }

    public final long component1() {
        return this.feedId;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final Product component3() {
        return this.item;
    }

    @NotNull
    public final CategoryProductItem copy(long j, @NotNull String str, @NotNull Product product) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(product, "item");
        return new CategoryProductItem(j, str, product);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CategoryProductItem) {
                CategoryProductItem categoryProductItem = (CategoryProductItem) obj;
                if (!(this.feedId == categoryProductItem.feedId) || !Intrinsics.areEqual((Object) this.type, (Object) categoryProductItem.type) || !Intrinsics.areEqual((Object) this.item, (Object) categoryProductItem.item)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.feedId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.type;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Product product = this.item;
        if (product != null) {
            i2 = product.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CategoryProductItem(feedId=");
        sb.append(this.feedId);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", item=");
        sb.append(this.item);
        sb.append(")");
        return sb.toString();
    }

    public CategoryProductItem(long j, @NotNull String str, @NotNull Product product) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(product, "item");
        this.feedId = j;
        this.type = str;
        this.item = product;
    }

    public final long getFeedId() {
        return this.feedId;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final Product getItem() {
        return this.item;
    }
}
