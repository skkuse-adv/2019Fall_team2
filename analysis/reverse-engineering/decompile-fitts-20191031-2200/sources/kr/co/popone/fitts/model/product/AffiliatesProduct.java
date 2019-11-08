package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AffiliatesProduct {
    @SerializedName("is_product")
    private final boolean isProduct;
    @SerializedName("orderable_type")
    @NotNull
    private final OrderableType orderableType;
    @SerializedName("product_id")
    @Nullable
    private final Long productId;
    @SerializedName("related_posts_count")
    private final int relatedPostsCount;
    @SerializedName("restrict_state")
    @NotNull
    private final AffiliatesProductRestrictState restrictType;

    @NotNull
    public static /* synthetic */ AffiliatesProduct copy$default(AffiliatesProduct affiliatesProduct, boolean z, Long l, OrderableType orderableType2, AffiliatesProductRestrictState affiliatesProductRestrictState, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = affiliatesProduct.isProduct;
        }
        if ((i2 & 2) != 0) {
            l = affiliatesProduct.productId;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            orderableType2 = affiliatesProduct.orderableType;
        }
        OrderableType orderableType3 = orderableType2;
        if ((i2 & 8) != 0) {
            affiliatesProductRestrictState = affiliatesProduct.restrictType;
        }
        AffiliatesProductRestrictState affiliatesProductRestrictState2 = affiliatesProductRestrictState;
        if ((i2 & 16) != 0) {
            i = affiliatesProduct.relatedPostsCount;
        }
        return affiliatesProduct.copy(z, l2, orderableType3, affiliatesProductRestrictState2, i);
    }

    public final boolean component1() {
        return this.isProduct;
    }

    @Nullable
    public final Long component2() {
        return this.productId;
    }

    @NotNull
    public final OrderableType component3() {
        return this.orderableType;
    }

    @NotNull
    public final AffiliatesProductRestrictState component4() {
        return this.restrictType;
    }

    public final int component5() {
        return this.relatedPostsCount;
    }

    @NotNull
    public final AffiliatesProduct copy(boolean z, @Nullable Long l, @NotNull OrderableType orderableType2, @NotNull AffiliatesProductRestrictState affiliatesProductRestrictState, int i) {
        Intrinsics.checkParameterIsNotNull(orderableType2, "orderableType");
        Intrinsics.checkParameterIsNotNull(affiliatesProductRestrictState, "restrictType");
        AffiliatesProduct affiliatesProduct = new AffiliatesProduct(z, l, orderableType2, affiliatesProductRestrictState, i);
        return affiliatesProduct;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AffiliatesProduct) {
                AffiliatesProduct affiliatesProduct = (AffiliatesProduct) obj;
                if ((this.isProduct == affiliatesProduct.isProduct) && Intrinsics.areEqual((Object) this.productId, (Object) affiliatesProduct.productId) && Intrinsics.areEqual((Object) this.orderableType, (Object) affiliatesProduct.orderableType) && Intrinsics.areEqual((Object) this.restrictType, (Object) affiliatesProduct.restrictType)) {
                    if (this.relatedPostsCount == affiliatesProduct.relatedPostsCount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isProduct;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        Long l = this.productId;
        int i2 = 0;
        int hashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        OrderableType orderableType2 = this.orderableType;
        int hashCode2 = (hashCode + (orderableType2 != null ? orderableType2.hashCode() : 0)) * 31;
        AffiliatesProductRestrictState affiliatesProductRestrictState = this.restrictType;
        if (affiliatesProductRestrictState != null) {
            i2 = affiliatesProductRestrictState.hashCode();
        }
        return ((hashCode2 + i2) * 31) + this.relatedPostsCount;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AffiliatesProduct(isProduct=");
        sb.append(this.isProduct);
        sb.append(", productId=");
        sb.append(this.productId);
        sb.append(", orderableType=");
        sb.append(this.orderableType);
        sb.append(", restrictType=");
        sb.append(this.restrictType);
        sb.append(", relatedPostsCount=");
        sb.append(this.relatedPostsCount);
        sb.append(")");
        return sb.toString();
    }

    public AffiliatesProduct(boolean z, @Nullable Long l, @NotNull OrderableType orderableType2, @NotNull AffiliatesProductRestrictState affiliatesProductRestrictState, int i) {
        Intrinsics.checkParameterIsNotNull(orderableType2, "orderableType");
        Intrinsics.checkParameterIsNotNull(affiliatesProductRestrictState, "restrictType");
        this.isProduct = z;
        this.productId = l;
        this.orderableType = orderableType2;
        this.restrictType = affiliatesProductRestrictState;
        this.relatedPostsCount = i;
    }

    public final boolean isProduct() {
        return this.isProduct;
    }

    @Nullable
    public final Long getProductId() {
        return this.productId;
    }

    @NotNull
    public final OrderableType getOrderableType() {
        return this.orderableType;
    }

    @NotNull
    public final AffiliatesProductRestrictState getRestrictType() {
        return this.restrictType;
    }

    public final int getRelatedPostsCount() {
        return this.relatedPostsCount;
    }
}
