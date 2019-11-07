package kr.co.popone.fitts.model.datamodel.commerce.discount;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderPrice {
    public static final Companion Companion = new Companion(null);
    private final int couponValue;
    private final int discountPrice;
    private final int finalOrderPrice;
    private final int membershipValue;
    private final int pointValue;
    private final int shippingPrice;
    private final int specialDiscountValue;
    private final int totalPrice;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: new reason: not valid java name */
        public final OrderPrice m149new(@NotNull OrderInfoViewData orderInfoViewData, @Nullable Integer num) {
            Intrinsics.checkParameterIsNotNull(orderInfoViewData, "orderInfo");
            OrderPrice orderPrice = new OrderPrice(orderInfoViewData.getTotalProductPrice(), orderInfoViewData.getTotalShippingPrice(), num != null ? num.intValue() : 0, num != null ? num.intValue() : 0, 0, 0, 0, num == null ? orderInfoViewData.getTotalProductPrice() + orderInfoViewData.getTotalShippingPrice() : (orderInfoViewData.getTotalProductPrice() + orderInfoViewData.getTotalShippingPrice()) - num.intValue());
            return orderPrice;
        }

        @NotNull
        /* renamed from: new reason: not valid java name */
        public final OrderPrice m150new(@NotNull OrderInfoViewData orderInfoViewData, @Nullable CouponInfo couponInfo) {
            Intrinsics.checkParameterIsNotNull(orderInfoViewData, "orderInfo");
            OrderPrice orderPrice = new OrderPrice(orderInfoViewData.getTotalProductPrice(), orderInfoViewData.getTotalShippingPrice(), couponInfo != null ? couponInfo.getValue() : 0, 0, couponInfo != null ? couponInfo.getValue() : 0, 0, 0, couponInfo == null ? orderInfoViewData.getTotalProductPrice() + orderInfoViewData.getTotalShippingPrice() : (orderInfoViewData.getTotalProductPrice() + orderInfoViewData.getTotalShippingPrice()) - couponInfo.getValue());
            return orderPrice;
        }

        @NotNull
        /* renamed from: new reason: not valid java name */
        public final OrderPrice m147new(@NotNull ProductLineItem productLineItem) {
            Intrinsics.checkParameterIsNotNull(productLineItem, "lineItem");
            OrderPrice orderPrice = new OrderPrice(productLineItem.getVariantsTotalPrice(), productLineItem.getVariantsShippingPrice(), productLineItem.getMembershipDiscountPrice(), 0, 0, productLineItem.getMembershipDiscountPrice(), 0, productLineItem.getVariantsOrderPrice());
            return orderPrice;
        }

        @NotNull
        /* renamed from: new reason: not valid java name */
        public final OrderPrice m148new(@NotNull OrderInfoViewData orderInfoViewData) {
            Intrinsics.checkParameterIsNotNull(orderInfoViewData, "orderInfo");
            int totalProductPrice = orderInfoViewData.getTotalProductPrice();
            int totalShippingPrice = orderInfoViewData.getTotalShippingPrice();
            Integer specialDiscountPrice = orderInfoViewData.getSpecialDiscountPrice();
            int intValue = specialDiscountPrice != null ? specialDiscountPrice.intValue() : 0;
            Integer specialDiscountPrice2 = orderInfoViewData.getSpecialDiscountPrice();
            OrderPrice orderPrice = new OrderPrice(totalProductPrice, totalShippingPrice, intValue, 0, 0, 0, specialDiscountPrice2 != null ? specialDiscountPrice2.intValue() : 0, orderInfoViewData.getSpecialDiscountPrice() == null ? orderInfoViewData.getTotalProductPrice() + orderInfoViewData.getTotalShippingPrice() : (orderInfoViewData.getTotalProductPrice() + orderInfoViewData.getTotalShippingPrice()) - orderInfoViewData.getSpecialDiscountPrice().intValue());
            return orderPrice;
        }
    }

    @NotNull
    public static /* synthetic */ OrderPrice copy$default(OrderPrice orderPrice, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
        OrderPrice orderPrice2 = orderPrice;
        int i10 = i9;
        return orderPrice.copy((i10 & 1) != 0 ? orderPrice2.totalPrice : i, (i10 & 2) != 0 ? orderPrice2.shippingPrice : i2, (i10 & 4) != 0 ? orderPrice2.discountPrice : i3, (i10 & 8) != 0 ? orderPrice2.pointValue : i4, (i10 & 16) != 0 ? orderPrice2.couponValue : i5, (i10 & 32) != 0 ? orderPrice2.membershipValue : i6, (i10 & 64) != 0 ? orderPrice2.specialDiscountValue : i7, (i10 & 128) != 0 ? orderPrice2.finalOrderPrice : i8);
    }

    public final int component1() {
        return this.totalPrice;
    }

    public final int component2() {
        return this.shippingPrice;
    }

    public final int component3() {
        return this.discountPrice;
    }

    public final int component4() {
        return this.pointValue;
    }

    public final int component5() {
        return this.couponValue;
    }

    public final int component6() {
        return this.membershipValue;
    }

    public final int component7() {
        return this.specialDiscountValue;
    }

    public final int component8() {
        return this.finalOrderPrice;
    }

    @NotNull
    public final OrderPrice copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        OrderPrice orderPrice = new OrderPrice(i, i2, i3, i4, i5, i6, i7, i8);
        return orderPrice;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderPrice) {
                OrderPrice orderPrice = (OrderPrice) obj;
                if (this.totalPrice == orderPrice.totalPrice) {
                    if (this.shippingPrice == orderPrice.shippingPrice) {
                        if (this.discountPrice == orderPrice.discountPrice) {
                            if (this.pointValue == orderPrice.pointValue) {
                                if (this.couponValue == orderPrice.couponValue) {
                                    if (this.membershipValue == orderPrice.membershipValue) {
                                        if (this.specialDiscountValue == orderPrice.specialDiscountValue) {
                                            if (this.finalOrderPrice == orderPrice.finalOrderPrice) {
                                                return true;
                                            }
                                        }
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
        return (((((((((((((this.totalPrice * 31) + this.shippingPrice) * 31) + this.discountPrice) * 31) + this.pointValue) * 31) + this.couponValue) * 31) + this.membershipValue) * 31) + this.specialDiscountValue) * 31) + this.finalOrderPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderPrice(totalPrice=");
        sb.append(this.totalPrice);
        sb.append(", shippingPrice=");
        sb.append(this.shippingPrice);
        sb.append(", discountPrice=");
        sb.append(this.discountPrice);
        sb.append(", pointValue=");
        sb.append(this.pointValue);
        sb.append(", couponValue=");
        sb.append(this.couponValue);
        sb.append(", membershipValue=");
        sb.append(this.membershipValue);
        sb.append(", specialDiscountValue=");
        sb.append(this.specialDiscountValue);
        sb.append(", finalOrderPrice=");
        sb.append(this.finalOrderPrice);
        sb.append(")");
        return sb.toString();
    }

    public OrderPrice(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.totalPrice = i;
        this.shippingPrice = i2;
        this.discountPrice = i3;
        this.pointValue = i4;
        this.couponValue = i5;
        this.membershipValue = i6;
        this.specialDiscountValue = i7;
        this.finalOrderPrice = i8;
    }

    public final int getTotalPrice() {
        return this.totalPrice;
    }

    public final int getShippingPrice() {
        return this.shippingPrice;
    }

    public final int getDiscountPrice() {
        return this.discountPrice;
    }

    public final int getPointValue() {
        return this.pointValue;
    }

    public final int getCouponValue() {
        return this.couponValue;
    }

    public final int getMembershipValue() {
        return this.membershipValue;
    }

    public final int getSpecialDiscountValue() {
        return this.specialDiscountValue;
    }

    public final int getFinalOrderPrice() {
        return this.finalOrderPrice;
    }

    public final boolean haveToPay() {
        return this.finalOrderPrice > 0;
    }
}
