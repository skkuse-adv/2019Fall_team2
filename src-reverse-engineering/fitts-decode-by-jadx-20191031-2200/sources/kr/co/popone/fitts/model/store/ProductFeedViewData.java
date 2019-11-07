package kr.co.popone.fitts.model.store;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.IntergratedSearchInterface;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedViewData implements IntergratedSearchInterface {
    @Nullable
    private final Integer discountRate;
    private final long id;
    private final long originPrice;
    private final long salesPrice;
    @Nullable
    private final String storeImageUrl;
    @Nullable
    private final String storeLinkUrl;
    @NotNull
    private final String storeTitle;

    @NotNull
    public static /* synthetic */ ProductFeedViewData copy$default(ProductFeedViewData productFeedViewData, long j, String str, String str2, String str3, long j2, long j3, Integer num, int i, Object obj) {
        ProductFeedViewData productFeedViewData2 = productFeedViewData;
        return productFeedViewData.copy((i & 1) != 0 ? productFeedViewData2.id : j, (i & 2) != 0 ? productFeedViewData2.storeTitle : str, (i & 4) != 0 ? productFeedViewData2.storeImageUrl : str2, (i & 8) != 0 ? productFeedViewData2.storeLinkUrl : str3, (i & 16) != 0 ? productFeedViewData2.originPrice : j2, (i & 32) != 0 ? productFeedViewData2.salesPrice : j3, (i & 64) != 0 ? productFeedViewData2.discountRate : num);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.storeTitle;
    }

    @Nullable
    public final String component3() {
        return this.storeImageUrl;
    }

    @Nullable
    public final String component4() {
        return this.storeLinkUrl;
    }

    public final long component5() {
        return this.originPrice;
    }

    public final long component6() {
        return this.salesPrice;
    }

    @Nullable
    public final Integer component7() {
        return this.discountRate;
    }

    @NotNull
    public final ProductFeedViewData copy(long j, @NotNull String str, @Nullable String str2, @Nullable String str3, long j2, long j3, @Nullable Integer num) {
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str, "storeTitle");
        ProductFeedViewData productFeedViewData = new ProductFeedViewData(j, str4, str2, str3, j2, j3, num);
        return productFeedViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ProductFeedViewData) {
                ProductFeedViewData productFeedViewData = (ProductFeedViewData) obj;
                if ((this.id == productFeedViewData.id) && Intrinsics.areEqual((Object) this.storeTitle, (Object) productFeedViewData.storeTitle) && Intrinsics.areEqual((Object) this.storeImageUrl, (Object) productFeedViewData.storeImageUrl) && Intrinsics.areEqual((Object) this.storeLinkUrl, (Object) productFeedViewData.storeLinkUrl)) {
                    if (this.originPrice == productFeedViewData.originPrice) {
                        if (!(this.salesPrice == productFeedViewData.salesPrice) || !Intrinsics.areEqual((Object) this.discountRate, (Object) productFeedViewData.discountRate)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.storeTitle;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.storeImageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.storeLinkUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j2 = this.originPrice;
        int i3 = (hashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.salesPrice;
        int i4 = (i3 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        Integer num = this.discountRate;
        if (num != null) {
            i2 = num.hashCode();
        }
        return i4 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductFeedViewData(id=");
        sb.append(this.id);
        sb.append(", storeTitle=");
        sb.append(this.storeTitle);
        sb.append(", storeImageUrl=");
        sb.append(this.storeImageUrl);
        sb.append(", storeLinkUrl=");
        sb.append(this.storeLinkUrl);
        sb.append(", originPrice=");
        sb.append(this.originPrice);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", discountRate=");
        sb.append(this.discountRate);
        sb.append(")");
        return sb.toString();
    }

    public ProductFeedViewData(long j, @NotNull String str, @Nullable String str2, @Nullable String str3, long j2, long j3, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "storeTitle");
        this.id = j;
        this.storeTitle = str;
        this.storeImageUrl = str2;
        this.storeLinkUrl = str3;
        this.originPrice = j2;
        this.salesPrice = j3;
        this.discountRate = num;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getStoreTitle() {
        return this.storeTitle;
    }

    @Nullable
    public final String getStoreImageUrl() {
        return this.storeImageUrl;
    }

    @Nullable
    public final String getStoreLinkUrl() {
        return this.storeLinkUrl;
    }

    public final long getOriginPrice() {
        return this.originPrice;
    }

    public final long getSalesPrice() {
        return this.salesPrice;
    }

    @Nullable
    public final Integer getDiscountRate() {
        return this.discountRate;
    }
}
