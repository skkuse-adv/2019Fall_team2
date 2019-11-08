package kr.co.popone.fitts.model.order;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListDetailViewData {
    @Nullable
    private final List<Category> categories;
    private final int discountPercentage;
    @Nullable
    private final Long exchangeId;
    private final long orderLineItemVariantId;
    @NotNull
    private final OrderState orderState;
    private final int originalPrice;
    @Nullable
    private final Long postId;
    private final int productCount;
    @NotNull
    private final String productCoverImage;
    @NotNull
    private final String productLinkUrl;
    @NotNull
    private final String productName;
    @NotNull
    private final String productOption;
    private final int productPrice;
    @NotNull
    private final String productState;
    @Nullable
    private final Long refundId;
    @Nullable
    private final SpecialDiscount specialDiscountInfo;

    @NotNull
    public static /* synthetic */ OrderListDetailViewData copy$default(OrderListDetailViewData orderListDetailViewData, long j, String str, String str2, String str3, OrderState orderState2, int i, int i2, int i3, String str4, int i4, Long l, Long l2, Long l3, List list, String str5, SpecialDiscount specialDiscount, int i5, Object obj) {
        OrderListDetailViewData orderListDetailViewData2 = orderListDetailViewData;
        int i6 = i5;
        return orderListDetailViewData.copy((i6 & 1) != 0 ? orderListDetailViewData2.orderLineItemVariantId : j, (i6 & 2) != 0 ? orderListDetailViewData2.productCoverImage : str, (i6 & 4) != 0 ? orderListDetailViewData2.productLinkUrl : str2, (i6 & 8) != 0 ? orderListDetailViewData2.productName : str3, (i6 & 16) != 0 ? orderListDetailViewData2.orderState : orderState2, (i6 & 32) != 0 ? orderListDetailViewData2.originalPrice : i, (i6 & 64) != 0 ? orderListDetailViewData2.productPrice : i2, (i6 & 128) != 0 ? orderListDetailViewData2.discountPercentage : i3, (i6 & 256) != 0 ? orderListDetailViewData2.productOption : str4, (i6 & 512) != 0 ? orderListDetailViewData2.productCount : i4, (i6 & 1024) != 0 ? orderListDetailViewData2.exchangeId : l, (i6 & 2048) != 0 ? orderListDetailViewData2.refundId : l2, (i6 & 4096) != 0 ? orderListDetailViewData2.postId : l3, (i6 & 8192) != 0 ? orderListDetailViewData2.categories : list, (i6 & 16384) != 0 ? orderListDetailViewData2.productState : str5, (i6 & 32768) != 0 ? orderListDetailViewData2.specialDiscountInfo : specialDiscount);
    }

    public final long component1() {
        return this.orderLineItemVariantId;
    }

    public final int component10() {
        return this.productCount;
    }

    @Nullable
    public final Long component11() {
        return this.exchangeId;
    }

    @Nullable
    public final Long component12() {
        return this.refundId;
    }

    @Nullable
    public final Long component13() {
        return this.postId;
    }

    @Nullable
    public final List<Category> component14() {
        return this.categories;
    }

    @NotNull
    public final String component15() {
        return this.productState;
    }

    @Nullable
    public final SpecialDiscount component16() {
        return this.specialDiscountInfo;
    }

    @NotNull
    public final String component2() {
        return this.productCoverImage;
    }

    @NotNull
    public final String component3() {
        return this.productLinkUrl;
    }

    @NotNull
    public final String component4() {
        return this.productName;
    }

    @NotNull
    public final OrderState component5() {
        return this.orderState;
    }

    public final int component6() {
        return this.originalPrice;
    }

    public final int component7() {
        return this.productPrice;
    }

    public final int component8() {
        return this.discountPercentage;
    }

    @NotNull
    public final String component9() {
        return this.productOption;
    }

    @NotNull
    public final OrderListDetailViewData copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull OrderState orderState2, int i, int i2, int i3, @NotNull String str4, int i4, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable List<Category> list, @NotNull String str5, @Nullable SpecialDiscount specialDiscount) {
        long j2 = j;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        OrderState orderState3 = orderState2;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        String str9 = str4;
        int i8 = i4;
        Long l4 = l;
        Long l5 = l2;
        Long l6 = l3;
        List<Category> list2 = list;
        String str10 = str5;
        SpecialDiscount specialDiscount2 = specialDiscount;
        Intrinsics.checkParameterIsNotNull(str, "productCoverImage");
        Intrinsics.checkParameterIsNotNull(str2, "productLinkUrl");
        Intrinsics.checkParameterIsNotNull(str3, "productName");
        Intrinsics.checkParameterIsNotNull(orderState2, "orderState");
        Intrinsics.checkParameterIsNotNull(str4, "productOption");
        Intrinsics.checkParameterIsNotNull(str5, "productState");
        OrderListDetailViewData orderListDetailViewData = new OrderListDetailViewData(j, str6, str7, str8, orderState3, i5, i6, i7, str9, i8, l4, l5, l6, list2, str10, specialDiscount2);
        return orderListDetailViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderListDetailViewData) {
                OrderListDetailViewData orderListDetailViewData = (OrderListDetailViewData) obj;
                if ((this.orderLineItemVariantId == orderListDetailViewData.orderLineItemVariantId) && Intrinsics.areEqual((Object) this.productCoverImage, (Object) orderListDetailViewData.productCoverImage) && Intrinsics.areEqual((Object) this.productLinkUrl, (Object) orderListDetailViewData.productLinkUrl) && Intrinsics.areEqual((Object) this.productName, (Object) orderListDetailViewData.productName) && Intrinsics.areEqual((Object) this.orderState, (Object) orderListDetailViewData.orderState)) {
                    if (this.originalPrice == orderListDetailViewData.originalPrice) {
                        if (this.productPrice == orderListDetailViewData.productPrice) {
                            if ((this.discountPercentage == orderListDetailViewData.discountPercentage) && Intrinsics.areEqual((Object) this.productOption, (Object) orderListDetailViewData.productOption)) {
                                if (!(this.productCount == orderListDetailViewData.productCount) || !Intrinsics.areEqual((Object) this.exchangeId, (Object) orderListDetailViewData.exchangeId) || !Intrinsics.areEqual((Object) this.refundId, (Object) orderListDetailViewData.refundId) || !Intrinsics.areEqual((Object) this.postId, (Object) orderListDetailViewData.postId) || !Intrinsics.areEqual((Object) this.categories, (Object) orderListDetailViewData.categories) || !Intrinsics.areEqual((Object) this.productState, (Object) orderListDetailViewData.productState) || !Intrinsics.areEqual((Object) this.specialDiscountInfo, (Object) orderListDetailViewData.specialDiscountInfo)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.orderLineItemVariantId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.productCoverImage;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.productLinkUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.productName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        OrderState orderState2 = this.orderState;
        int hashCode4 = (((((((hashCode3 + (orderState2 != null ? orderState2.hashCode() : 0)) * 31) + this.originalPrice) * 31) + this.productPrice) * 31) + this.discountPercentage) * 31;
        String str4 = this.productOption;
        int hashCode5 = (((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.productCount) * 31;
        Long l = this.exchangeId;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.refundId;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.postId;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Category> list = this.categories;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.productState;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        SpecialDiscount specialDiscount = this.specialDiscountInfo;
        if (specialDiscount != null) {
            i2 = specialDiscount.hashCode();
        }
        return hashCode10 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderListDetailViewData(orderLineItemVariantId=");
        sb.append(this.orderLineItemVariantId);
        sb.append(", productCoverImage=");
        sb.append(this.productCoverImage);
        sb.append(", productLinkUrl=");
        sb.append(this.productLinkUrl);
        sb.append(", productName=");
        sb.append(this.productName);
        sb.append(", orderState=");
        sb.append(this.orderState);
        sb.append(", originalPrice=");
        sb.append(this.originalPrice);
        sb.append(", productPrice=");
        sb.append(this.productPrice);
        sb.append(", discountPercentage=");
        sb.append(this.discountPercentage);
        sb.append(", productOption=");
        sb.append(this.productOption);
        sb.append(", productCount=");
        sb.append(this.productCount);
        sb.append(", exchangeId=");
        sb.append(this.exchangeId);
        sb.append(", refundId=");
        sb.append(this.refundId);
        sb.append(", postId=");
        sb.append(this.postId);
        sb.append(", categories=");
        sb.append(this.categories);
        sb.append(", productState=");
        sb.append(this.productState);
        sb.append(", specialDiscountInfo=");
        sb.append(this.specialDiscountInfo);
        sb.append(")");
        return sb.toString();
    }

    public OrderListDetailViewData(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull OrderState orderState2, int i, int i2, int i3, @NotNull String str4, int i4, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable List<Category> list, @NotNull String str5, @Nullable SpecialDiscount specialDiscount) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        OrderState orderState3 = orderState2;
        String str9 = str4;
        String str10 = str5;
        Intrinsics.checkParameterIsNotNull(str, "productCoverImage");
        Intrinsics.checkParameterIsNotNull(str2, "productLinkUrl");
        Intrinsics.checkParameterIsNotNull(str3, "productName");
        Intrinsics.checkParameterIsNotNull(orderState2, "orderState");
        Intrinsics.checkParameterIsNotNull(str9, "productOption");
        Intrinsics.checkParameterIsNotNull(str10, "productState");
        this.orderLineItemVariantId = j;
        this.productCoverImage = str6;
        this.productLinkUrl = str7;
        this.productName = str8;
        this.orderState = orderState3;
        this.originalPrice = i;
        this.productPrice = i2;
        this.discountPercentage = i3;
        this.productOption = str9;
        this.productCount = i4;
        this.exchangeId = l;
        this.refundId = l2;
        this.postId = l3;
        this.categories = list;
        this.productState = str10;
        this.specialDiscountInfo = specialDiscount;
    }

    public final long getOrderLineItemVariantId() {
        return this.orderLineItemVariantId;
    }

    @NotNull
    public final String getProductCoverImage() {
        return this.productCoverImage;
    }

    @NotNull
    public final String getProductLinkUrl() {
        return this.productLinkUrl;
    }

    @NotNull
    public final String getProductName() {
        return this.productName;
    }

    @NotNull
    public final OrderState getOrderState() {
        return this.orderState;
    }

    public final int getOriginalPrice() {
        return this.originalPrice;
    }

    public final int getProductPrice() {
        return this.productPrice;
    }

    public final int getDiscountPercentage() {
        return this.discountPercentage;
    }

    @NotNull
    public final String getProductOption() {
        return this.productOption;
    }

    public final int getProductCount() {
        return this.productCount;
    }

    @Nullable
    public final Long getExchangeId() {
        return this.exchangeId;
    }

    @Nullable
    public final Long getRefundId() {
        return this.refundId;
    }

    @Nullable
    public final Long getPostId() {
        return this.postId;
    }

    @Nullable
    public final List<Category> getCategories() {
        return this.categories;
    }

    @NotNull
    public final String getProductState() {
        return this.productState;
    }

    @Nullable
    public final SpecialDiscount getSpecialDiscountInfo() {
        return this.specialDiscountInfo;
    }
}
