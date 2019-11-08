package kr.co.popone.fitts.model.order;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartVariants;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;
import kr.co.popone.fitts.model.post.PostAPI.Category;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListLineItemVariant {
    @SerializedName("additional_price")
    private final int additionalPrice;
    @SerializedName("categories")
    @Nullable
    private final List<Category> categories;
    @SerializedName("discount_percentage")
    private final double discountPercentage;
    @SerializedName("exchange_id")
    @Nullable
    private final Long exchangeId;
    private final long id;
    @SerializedName("origin_price")
    private final int originPrice;
    @SerializedName("post_id")
    @Nullable
    private final Long postId;
    @SerializedName("price")
    private final int price;
    @SerializedName("quantity")
    private final int quantity;
    @SerializedName("refund_id")
    @Nullable
    private final Long refundId;
    @SerializedName("sales_price")
    private final int salesPrice;
    @SerializedName("special_discount_info")
    @Nullable
    private final SpecialDiscount specialDiscountInfo;
    @SerializedName("state")
    @NotNull
    private final String state;
    @SerializedName("variant")
    @NotNull
    private final CartVariants variant;

    @NotNull
    public static /* synthetic */ OrderListLineItemVariant copy$default(OrderListLineItemVariant orderListLineItemVariant, long j, CartVariants cartVariants, SpecialDiscount specialDiscount, List list, Long l, Long l2, Long l3, int i, int i2, double d, int i3, int i4, int i5, String str, int i6, Object obj) {
        OrderListLineItemVariant orderListLineItemVariant2 = orderListLineItemVariant;
        int i7 = i6;
        return orderListLineItemVariant.copy((i7 & 1) != 0 ? orderListLineItemVariant2.id : j, (i7 & 2) != 0 ? orderListLineItemVariant2.variant : cartVariants, (i7 & 4) != 0 ? orderListLineItemVariant2.specialDiscountInfo : specialDiscount, (i7 & 8) != 0 ? orderListLineItemVariant2.categories : list, (i7 & 16) != 0 ? orderListLineItemVariant2.refundId : l, (i7 & 32) != 0 ? orderListLineItemVariant2.exchangeId : l2, (i7 & 64) != 0 ? orderListLineItemVariant2.postId : l3, (i7 & 128) != 0 ? orderListLineItemVariant2.originPrice : i, (i7 & 256) != 0 ? orderListLineItemVariant2.salesPrice : i2, (i7 & 512) != 0 ? orderListLineItemVariant2.discountPercentage : d, (i7 & 1024) != 0 ? orderListLineItemVariant2.additionalPrice : i3, (i7 & 2048) != 0 ? orderListLineItemVariant2.quantity : i4, (i7 & 4096) != 0 ? orderListLineItemVariant2.price : i5, (i7 & 8192) != 0 ? orderListLineItemVariant2.state : str);
    }

    public final long component1() {
        return this.id;
    }

    public final double component10() {
        return this.discountPercentage;
    }

    public final int component11() {
        return this.additionalPrice;
    }

    public final int component12() {
        return this.quantity;
    }

    public final int component13() {
        return this.price;
    }

    @NotNull
    public final String component14() {
        return this.state;
    }

    @NotNull
    public final CartVariants component2() {
        return this.variant;
    }

    @Nullable
    public final SpecialDiscount component3() {
        return this.specialDiscountInfo;
    }

    @Nullable
    public final List<Category> component4() {
        return this.categories;
    }

    @Nullable
    public final Long component5() {
        return this.refundId;
    }

    @Nullable
    public final Long component6() {
        return this.exchangeId;
    }

    @Nullable
    public final Long component7() {
        return this.postId;
    }

    public final int component8() {
        return this.originPrice;
    }

    public final int component9() {
        return this.salesPrice;
    }

    @NotNull
    public final OrderListLineItemVariant copy(long j, @NotNull CartVariants cartVariants, @Nullable SpecialDiscount specialDiscount, @Nullable List<Category> list, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, int i, int i2, double d, int i3, int i4, int i5, @NotNull String str) {
        long j2 = j;
        CartVariants cartVariants2 = cartVariants;
        SpecialDiscount specialDiscount2 = specialDiscount;
        List<Category> list2 = list;
        Long l4 = l;
        Long l5 = l2;
        Long l6 = l3;
        int i6 = i;
        int i7 = i2;
        double d2 = d;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(cartVariants, "variant");
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        OrderListLineItemVariant orderListLineItemVariant = new OrderListLineItemVariant(j, cartVariants2, specialDiscount2, list2, l4, l5, l6, i6, i7, d2, i8, i9, i10, str2);
        return orderListLineItemVariant;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderListLineItemVariant) {
                OrderListLineItemVariant orderListLineItemVariant = (OrderListLineItemVariant) obj;
                if ((this.id == orderListLineItemVariant.id) && Intrinsics.areEqual((Object) this.variant, (Object) orderListLineItemVariant.variant) && Intrinsics.areEqual((Object) this.specialDiscountInfo, (Object) orderListLineItemVariant.specialDiscountInfo) && Intrinsics.areEqual((Object) this.categories, (Object) orderListLineItemVariant.categories) && Intrinsics.areEqual((Object) this.refundId, (Object) orderListLineItemVariant.refundId) && Intrinsics.areEqual((Object) this.exchangeId, (Object) orderListLineItemVariant.exchangeId) && Intrinsics.areEqual((Object) this.postId, (Object) orderListLineItemVariant.postId)) {
                    if (this.originPrice == orderListLineItemVariant.originPrice) {
                        if ((this.salesPrice == orderListLineItemVariant.salesPrice) && Double.compare(this.discountPercentage, orderListLineItemVariant.discountPercentage) == 0) {
                            if (this.additionalPrice == orderListLineItemVariant.additionalPrice) {
                                if (this.quantity == orderListLineItemVariant.quantity) {
                                    if (!(this.price == orderListLineItemVariant.price) || !Intrinsics.areEqual((Object) this.state, (Object) orderListLineItemVariant.state)) {
                                        return false;
                                    }
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
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        CartVariants cartVariants = this.variant;
        int i2 = 0;
        int hashCode = (i + (cartVariants != null ? cartVariants.hashCode() : 0)) * 31;
        SpecialDiscount specialDiscount = this.specialDiscountInfo;
        int hashCode2 = (hashCode + (specialDiscount != null ? specialDiscount.hashCode() : 0)) * 31;
        List<Category> list = this.categories;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Long l = this.refundId;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.exchangeId;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.postId;
        int hashCode6 = (((((hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31) + this.originPrice) * 31) + this.salesPrice) * 31;
        long doubleToLongBits = Double.doubleToLongBits(this.discountPercentage);
        int i3 = (((((((hashCode6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.additionalPrice) * 31) + this.quantity) * 31) + this.price) * 31;
        String str = this.state;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderListLineItemVariant(id=");
        sb.append(this.id);
        sb.append(", variant=");
        sb.append(this.variant);
        sb.append(", specialDiscountInfo=");
        sb.append(this.specialDiscountInfo);
        sb.append(", categories=");
        sb.append(this.categories);
        sb.append(", refundId=");
        sb.append(this.refundId);
        sb.append(", exchangeId=");
        sb.append(this.exchangeId);
        sb.append(", postId=");
        sb.append(this.postId);
        sb.append(", originPrice=");
        sb.append(this.originPrice);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", discountPercentage=");
        sb.append(this.discountPercentage);
        sb.append(", additionalPrice=");
        sb.append(this.additionalPrice);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(")");
        return sb.toString();
    }

    public OrderListLineItemVariant(long j, @NotNull CartVariants cartVariants, @Nullable SpecialDiscount specialDiscount, @Nullable List<Category> list, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, int i, int i2, double d, int i3, int i4, int i5, @NotNull String str) {
        CartVariants cartVariants2 = cartVariants;
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(cartVariants, "variant");
        Intrinsics.checkParameterIsNotNull(str2, ServerProtocol.DIALOG_PARAM_STATE);
        this.id = j;
        this.variant = cartVariants2;
        this.specialDiscountInfo = specialDiscount;
        this.categories = list;
        this.refundId = l;
        this.exchangeId = l2;
        this.postId = l3;
        this.originPrice = i;
        this.salesPrice = i2;
        this.discountPercentage = d;
        this.additionalPrice = i3;
        this.quantity = i4;
        this.price = i5;
        this.state = str2;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final CartVariants getVariant() {
        return this.variant;
    }

    @Nullable
    public final SpecialDiscount getSpecialDiscountInfo() {
        return this.specialDiscountInfo;
    }

    @Nullable
    public final List<Category> getCategories() {
        return this.categories;
    }

    @Nullable
    public final Long getRefundId() {
        return this.refundId;
    }

    @Nullable
    public final Long getExchangeId() {
        return this.exchangeId;
    }

    @Nullable
    public final Long getPostId() {
        return this.postId;
    }

    public final int getOriginPrice() {
        return this.originPrice;
    }

    public final int getSalesPrice() {
        return this.salesPrice;
    }

    public final double getDiscountPercentage() {
        return this.discountPercentage;
    }

    public final int getAdditionalPrice() {
        return this.additionalPrice;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final int getPrice() {
        return this.price;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }
}
