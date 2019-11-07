package kr.co.popone.fitts.model.order;

import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentInfo;
import kr.co.popone.fitts.model.user.UserAPI.UserShippingInfo;
import kr.co.popone.fitts.model.user.UserInfoNotId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderDetailViewData {
    @Nullable
    private final String adjustType;
    @Nullable
    private final Integer adjustValue;
    @NotNull
    private final Date orderDate;
    @NotNull
    private final OrderDiscountType orderDiscountType;
    private final long orderId;
    @NotNull
    private final List<OrderListItemViewData> orderListItems;
    @NotNull
    private final String orderNumber;
    @NotNull
    private final OrderState orderState;
    @Nullable
    private final PaymentInfo paymentInfo;
    @Nullable
    private final String paymentMethod;
    private final int predictPoint;
    @NotNull
    private final UserShippingInfo shippingAddress;
    @Nullable
    private final Integer specialDiscountPrice;
    private final int totalCount;
    private final int totalOrderPrice;
    private final int totalProductPrice;
    private final int totalShippingPrice;
    @NotNull
    private final UserInfoNotId userInfo;

    @NotNull
    public static /* synthetic */ OrderDetailViewData copy$default(OrderDetailViewData orderDetailViewData, long j, OrderState orderState2, Date date, String str, List list, int i, Integer num, int i2, int i3, int i4, String str2, Integer num2, String str3, PaymentInfo paymentInfo2, UserInfoNotId userInfoNotId, UserShippingInfo userShippingInfo, int i5, OrderDiscountType orderDiscountType2, int i6, Object obj) {
        OrderDetailViewData orderDetailViewData2 = orderDetailViewData;
        int i7 = i6;
        return orderDetailViewData.copy((i7 & 1) != 0 ? orderDetailViewData2.orderId : j, (i7 & 2) != 0 ? orderDetailViewData2.orderState : orderState2, (i7 & 4) != 0 ? orderDetailViewData2.orderDate : date, (i7 & 8) != 0 ? orderDetailViewData2.orderNumber : str, (i7 & 16) != 0 ? orderDetailViewData2.orderListItems : list, (i7 & 32) != 0 ? orderDetailViewData2.totalCount : i, (i7 & 64) != 0 ? orderDetailViewData2.specialDiscountPrice : num, (i7 & 128) != 0 ? orderDetailViewData2.totalProductPrice : i2, (i7 & 256) != 0 ? orderDetailViewData2.totalShippingPrice : i3, (i7 & 512) != 0 ? orderDetailViewData2.totalOrderPrice : i4, (i7 & 1024) != 0 ? orderDetailViewData2.adjustType : str2, (i7 & 2048) != 0 ? orderDetailViewData2.adjustValue : num2, (i7 & 4096) != 0 ? orderDetailViewData2.paymentMethod : str3, (i7 & 8192) != 0 ? orderDetailViewData2.paymentInfo : paymentInfo2, (i7 & 16384) != 0 ? orderDetailViewData2.userInfo : userInfoNotId, (i7 & 32768) != 0 ? orderDetailViewData2.shippingAddress : userShippingInfo, (i7 & 65536) != 0 ? orderDetailViewData2.predictPoint : i5, (i7 & 131072) != 0 ? orderDetailViewData2.orderDiscountType : orderDiscountType2);
    }

    public final long component1() {
        return this.orderId;
    }

    public final int component10() {
        return this.totalOrderPrice;
    }

    @Nullable
    public final String component11() {
        return this.adjustType;
    }

    @Nullable
    public final Integer component12() {
        return this.adjustValue;
    }

    @Nullable
    public final String component13() {
        return this.paymentMethod;
    }

    @Nullable
    public final PaymentInfo component14() {
        return this.paymentInfo;
    }

    @NotNull
    public final UserInfoNotId component15() {
        return this.userInfo;
    }

    @NotNull
    public final UserShippingInfo component16() {
        return this.shippingAddress;
    }

    public final int component17() {
        return this.predictPoint;
    }

    @NotNull
    public final OrderDiscountType component18() {
        return this.orderDiscountType;
    }

    @NotNull
    public final OrderState component2() {
        return this.orderState;
    }

    @NotNull
    public final Date component3() {
        return this.orderDate;
    }

    @NotNull
    public final String component4() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListItemViewData> component5() {
        return this.orderListItems;
    }

    public final int component6() {
        return this.totalCount;
    }

    @Nullable
    public final Integer component7() {
        return this.specialDiscountPrice;
    }

    public final int component8() {
        return this.totalProductPrice;
    }

    public final int component9() {
        return this.totalShippingPrice;
    }

    @NotNull
    public final OrderDetailViewData copy(long j, @NotNull OrderState orderState2, @NotNull Date date, @NotNull String str, @NotNull List<OrderListItemViewData> list, int i, @Nullable Integer num, int i2, int i3, int i4, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable PaymentInfo paymentInfo2, @NotNull UserInfoNotId userInfoNotId, @NotNull UserShippingInfo userShippingInfo, int i5, @NotNull OrderDiscountType orderDiscountType2) {
        long j2 = j;
        OrderState orderState3 = orderState2;
        Date date2 = date;
        String str4 = str;
        List<OrderListItemViewData> list2 = list;
        int i6 = i;
        Integer num3 = num;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        String str5 = str2;
        Integer num4 = num2;
        String str6 = str3;
        PaymentInfo paymentInfo3 = paymentInfo2;
        UserInfoNotId userInfoNotId2 = userInfoNotId;
        UserShippingInfo userShippingInfo2 = userShippingInfo;
        int i10 = i5;
        OrderDiscountType orderDiscountType3 = orderDiscountType2;
        Intrinsics.checkParameterIsNotNull(orderState2, "orderState");
        Intrinsics.checkParameterIsNotNull(date, "orderDate");
        Intrinsics.checkParameterIsNotNull(str, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list, "orderListItems");
        Intrinsics.checkParameterIsNotNull(userInfoNotId, "userInfo");
        Intrinsics.checkParameterIsNotNull(userShippingInfo, "shippingAddress");
        Intrinsics.checkParameterIsNotNull(orderDiscountType2, "orderDiscountType");
        OrderDetailViewData orderDetailViewData = new OrderDetailViewData(j, orderState3, date2, str4, list2, i6, num3, i7, i8, i9, str5, num4, str6, paymentInfo3, userInfoNotId2, userShippingInfo2, i10, orderDiscountType3);
        return orderDetailViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderDetailViewData) {
                OrderDetailViewData orderDetailViewData = (OrderDetailViewData) obj;
                if ((this.orderId == orderDetailViewData.orderId) && Intrinsics.areEqual((Object) this.orderState, (Object) orderDetailViewData.orderState) && Intrinsics.areEqual((Object) this.orderDate, (Object) orderDetailViewData.orderDate) && Intrinsics.areEqual((Object) this.orderNumber, (Object) orderDetailViewData.orderNumber) && Intrinsics.areEqual((Object) this.orderListItems, (Object) orderDetailViewData.orderListItems)) {
                    if ((this.totalCount == orderDetailViewData.totalCount) && Intrinsics.areEqual((Object) this.specialDiscountPrice, (Object) orderDetailViewData.specialDiscountPrice)) {
                        if (this.totalProductPrice == orderDetailViewData.totalProductPrice) {
                            if (this.totalShippingPrice == orderDetailViewData.totalShippingPrice) {
                                if ((this.totalOrderPrice == orderDetailViewData.totalOrderPrice) && Intrinsics.areEqual((Object) this.adjustType, (Object) orderDetailViewData.adjustType) && Intrinsics.areEqual((Object) this.adjustValue, (Object) orderDetailViewData.adjustValue) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) orderDetailViewData.paymentMethod) && Intrinsics.areEqual((Object) this.paymentInfo, (Object) orderDetailViewData.paymentInfo) && Intrinsics.areEqual((Object) this.userInfo, (Object) orderDetailViewData.userInfo) && Intrinsics.areEqual((Object) this.shippingAddress, (Object) orderDetailViewData.shippingAddress)) {
                                    if (!(this.predictPoint == orderDetailViewData.predictPoint) || !Intrinsics.areEqual((Object) this.orderDiscountType, (Object) orderDetailViewData.orderDiscountType)) {
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
        long j = this.orderId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        OrderState orderState2 = this.orderState;
        int i2 = 0;
        int hashCode = (i + (orderState2 != null ? orderState2.hashCode() : 0)) * 31;
        Date date = this.orderDate;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        String str = this.orderNumber;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        List<OrderListItemViewData> list = this.orderListItems;
        int hashCode4 = (((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.totalCount) * 31;
        Integer num = this.specialDiscountPrice;
        int hashCode5 = (((((((hashCode4 + (num != null ? num.hashCode() : 0)) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31) + this.totalOrderPrice) * 31;
        String str2 = this.adjustType;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num2 = this.adjustValue;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str3 = this.paymentMethod;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        PaymentInfo paymentInfo2 = this.paymentInfo;
        int hashCode9 = (hashCode8 + (paymentInfo2 != null ? paymentInfo2.hashCode() : 0)) * 31;
        UserInfoNotId userInfoNotId = this.userInfo;
        int hashCode10 = (hashCode9 + (userInfoNotId != null ? userInfoNotId.hashCode() : 0)) * 31;
        UserShippingInfo userShippingInfo = this.shippingAddress;
        int hashCode11 = (((hashCode10 + (userShippingInfo != null ? userShippingInfo.hashCode() : 0)) * 31) + this.predictPoint) * 31;
        OrderDiscountType orderDiscountType2 = this.orderDiscountType;
        if (orderDiscountType2 != null) {
            i2 = orderDiscountType2.hashCode();
        }
        return hashCode11 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderDetailViewData(orderId=");
        sb.append(this.orderId);
        sb.append(", orderState=");
        sb.append(this.orderState);
        sb.append(", orderDate=");
        sb.append(this.orderDate);
        sb.append(", orderNumber=");
        sb.append(this.orderNumber);
        sb.append(", orderListItems=");
        sb.append(this.orderListItems);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", specialDiscountPrice=");
        sb.append(this.specialDiscountPrice);
        sb.append(", totalProductPrice=");
        sb.append(this.totalProductPrice);
        sb.append(", totalShippingPrice=");
        sb.append(this.totalShippingPrice);
        sb.append(", totalOrderPrice=");
        sb.append(this.totalOrderPrice);
        sb.append(", adjustType=");
        sb.append(this.adjustType);
        sb.append(", adjustValue=");
        sb.append(this.adjustValue);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", paymentInfo=");
        sb.append(this.paymentInfo);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", shippingAddress=");
        sb.append(this.shippingAddress);
        sb.append(", predictPoint=");
        sb.append(this.predictPoint);
        sb.append(", orderDiscountType=");
        sb.append(this.orderDiscountType);
        sb.append(")");
        return sb.toString();
    }

    public OrderDetailViewData(long j, @NotNull OrderState orderState2, @NotNull Date date, @NotNull String str, @NotNull List<OrderListItemViewData> list, int i, @Nullable Integer num, int i2, int i3, int i4, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable PaymentInfo paymentInfo2, @NotNull UserInfoNotId userInfoNotId, @NotNull UserShippingInfo userShippingInfo, int i5, @NotNull OrderDiscountType orderDiscountType2) {
        OrderState orderState3 = orderState2;
        Date date2 = date;
        String str4 = str;
        List<OrderListItemViewData> list2 = list;
        UserInfoNotId userInfoNotId2 = userInfoNotId;
        UserShippingInfo userShippingInfo2 = userShippingInfo;
        OrderDiscountType orderDiscountType3 = orderDiscountType2;
        Intrinsics.checkParameterIsNotNull(orderState2, "orderState");
        Intrinsics.checkParameterIsNotNull(date, "orderDate");
        Intrinsics.checkParameterIsNotNull(str, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list2, "orderListItems");
        Intrinsics.checkParameterIsNotNull(userInfoNotId2, "userInfo");
        Intrinsics.checkParameterIsNotNull(userShippingInfo2, "shippingAddress");
        Intrinsics.checkParameterIsNotNull(orderDiscountType3, "orderDiscountType");
        this.orderId = j;
        this.orderState = orderState3;
        this.orderDate = date2;
        this.orderNumber = str4;
        this.orderListItems = list2;
        this.totalCount = i;
        this.specialDiscountPrice = num;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.totalOrderPrice = i4;
        this.adjustType = str2;
        this.adjustValue = num2;
        this.paymentMethod = str3;
        this.paymentInfo = paymentInfo2;
        this.userInfo = userInfoNotId2;
        this.shippingAddress = userShippingInfo2;
        this.predictPoint = i5;
        this.orderDiscountType = orderDiscountType3;
    }

    public final long getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final OrderState getOrderState() {
        return this.orderState;
    }

    @NotNull
    public final Date getOrderDate() {
        return this.orderDate;
    }

    @NotNull
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListItemViewData> getOrderListItems() {
        return this.orderListItems;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    @Nullable
    public final Integer getSpecialDiscountPrice() {
        return this.specialDiscountPrice;
    }

    public final int getTotalProductPrice() {
        return this.totalProductPrice;
    }

    public final int getTotalShippingPrice() {
        return this.totalShippingPrice;
    }

    public final int getTotalOrderPrice() {
        return this.totalOrderPrice;
    }

    @Nullable
    public final String getAdjustType() {
        return this.adjustType;
    }

    @Nullable
    public final Integer getAdjustValue() {
        return this.adjustValue;
    }

    @Nullable
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @Nullable
    public final PaymentInfo getPaymentInfo() {
        return this.paymentInfo;
    }

    @NotNull
    public final UserInfoNotId getUserInfo() {
        return this.userInfo;
    }

    @NotNull
    public final UserShippingInfo getShippingAddress() {
        return this.shippingAddress;
    }

    public final int getPredictPoint() {
        return this.predictPoint;
    }

    @NotNull
    public final OrderDiscountType getOrderDiscountType() {
        return this.orderDiscountType;
    }

    public final int calcTotalProductPrice() {
        String str = this.adjustType;
        if (str == null || str.hashCode() != -1340241962 || !str.equals("membership")) {
            return this.totalProductPrice;
        }
        Integer num = this.adjustValue;
        if (num == null) {
            return this.totalProductPrice;
        }
        return num.intValue() + this.totalProductPrice;
    }
}
