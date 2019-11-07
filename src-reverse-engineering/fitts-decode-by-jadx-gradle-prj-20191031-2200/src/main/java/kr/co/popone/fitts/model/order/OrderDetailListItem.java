package kr.co.popone.fitts.model.order;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentInfo;
import kr.co.popone.fitts.model.user.UserAPI.UserShippingInfo;
import kr.co.popone.fitts.model.user.UserInfoNotId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderDetailListItem {
    @SerializedName("adjustment_type")
    @Nullable
    private final String adjustType;
    @SerializedName("adjustment_price")
    @Nullable
    private final Integer adjustValue;
    private final long id;
    @SerializedName("line_items")
    @NotNull
    private final List<OrderListLineItem> lineItems;
    @SerializedName("order_created_at")
    @NotNull
    private final Date orderCreatedDate;
    @SerializedName("order_discount_type")
    @NotNull
    private final OrderDiscountType orderDiscountType;
    @SerializedName("order_number")
    @NotNull
    private final String orderNumber;
    @SerializedName("payment_direct_deposit_info")
    @Nullable
    private final PaymentInfo paymentInfo;
    @SerializedName("payment_method")
    @Nullable
    private final String paymentMethod;
    @SerializedName("predict_point")
    private final int predictPoint;
    @SerializedName("shipping_address")
    @NotNull
    private final UserShippingInfo shippingAddress;
    @SerializedName("special_discount_price")
    @Nullable
    private final Integer specialDiscountPrice;
    @SerializedName("state")
    @NotNull
    private final String state;
    @SerializedName("total_quantity_of_variants")
    private final int totalCount;
    @SerializedName("total_payment_price")
    private final int totalPaymentPrice;
    @SerializedName("total_product_price")
    private final int totalProductPrice;
    @SerializedName("total_shipping_price")
    private final int totalShippingPrice;
    @SerializedName("user_info")
    @NotNull
    private final UserInfoNotId userInfo;

    @NotNull
    public static /* synthetic */ OrderDetailListItem copy$default(OrderDetailListItem orderDetailListItem, long j, String str, Date date, String str2, List list, int i, Integer num, int i2, int i3, int i4, String str3, Integer num2, OrderDiscountType orderDiscountType2, int i5, String str4, PaymentInfo paymentInfo2, UserInfoNotId userInfoNotId, UserShippingInfo userShippingInfo, int i6, Object obj) {
        OrderDetailListItem orderDetailListItem2 = orderDetailListItem;
        int i7 = i6;
        return orderDetailListItem.copy((i7 & 1) != 0 ? orderDetailListItem2.id : j, (i7 & 2) != 0 ? orderDetailListItem2.state : str, (i7 & 4) != 0 ? orderDetailListItem2.orderCreatedDate : date, (i7 & 8) != 0 ? orderDetailListItem2.orderNumber : str2, (i7 & 16) != 0 ? orderDetailListItem2.lineItems : list, (i7 & 32) != 0 ? orderDetailListItem2.totalCount : i, (i7 & 64) != 0 ? orderDetailListItem2.specialDiscountPrice : num, (i7 & 128) != 0 ? orderDetailListItem2.totalProductPrice : i2, (i7 & 256) != 0 ? orderDetailListItem2.totalShippingPrice : i3, (i7 & 512) != 0 ? orderDetailListItem2.totalPaymentPrice : i4, (i7 & 1024) != 0 ? orderDetailListItem2.adjustType : str3, (i7 & 2048) != 0 ? orderDetailListItem2.adjustValue : num2, (i7 & 4096) != 0 ? orderDetailListItem2.orderDiscountType : orderDiscountType2, (i7 & 8192) != 0 ? orderDetailListItem2.predictPoint : i5, (i7 & 16384) != 0 ? orderDetailListItem2.paymentMethod : str4, (i7 & 32768) != 0 ? orderDetailListItem2.paymentInfo : paymentInfo2, (i7 & 65536) != 0 ? orderDetailListItem2.userInfo : userInfoNotId, (i7 & 131072) != 0 ? orderDetailListItem2.shippingAddress : userShippingInfo);
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.totalPaymentPrice;
    }

    @Nullable
    public final String component11() {
        return this.adjustType;
    }

    @Nullable
    public final Integer component12() {
        return this.adjustValue;
    }

    @NotNull
    public final OrderDiscountType component13() {
        return this.orderDiscountType;
    }

    public final int component14() {
        return this.predictPoint;
    }

    @Nullable
    public final String component15() {
        return this.paymentMethod;
    }

    @Nullable
    public final PaymentInfo component16() {
        return this.paymentInfo;
    }

    @NotNull
    public final UserInfoNotId component17() {
        return this.userInfo;
    }

    @NotNull
    public final UserShippingInfo component18() {
        return this.shippingAddress;
    }

    @NotNull
    public final String component2() {
        return this.state;
    }

    @NotNull
    public final Date component3() {
        return this.orderCreatedDate;
    }

    @NotNull
    public final String component4() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListLineItem> component5() {
        return this.lineItems;
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
    public final OrderDetailListItem copy(long j, @NotNull String str, @NotNull Date date, @NotNull String str2, @NotNull List<OrderListLineItem> list, int i, @Nullable Integer num, int i2, int i3, int i4, @Nullable String str3, @Nullable Integer num2, @NotNull OrderDiscountType orderDiscountType2, int i5, @Nullable String str4, @Nullable PaymentInfo paymentInfo2, @NotNull UserInfoNotId userInfoNotId, @NotNull UserShippingInfo userShippingInfo) {
        long j2 = j;
        String str5 = str;
        Date date2 = date;
        String str6 = str2;
        List<OrderListLineItem> list2 = list;
        int i6 = i;
        Integer num3 = num;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        String str7 = str3;
        Integer num4 = num2;
        OrderDiscountType orderDiscountType3 = orderDiscountType2;
        int i10 = i5;
        String str8 = str4;
        PaymentInfo paymentInfo3 = paymentInfo2;
        UserInfoNotId userInfoNotId2 = userInfoNotId;
        UserShippingInfo userShippingInfo2 = userShippingInfo;
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(date, "orderCreatedDate");
        Intrinsics.checkParameterIsNotNull(str2, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        Intrinsics.checkParameterIsNotNull(orderDiscountType2, "orderDiscountType");
        Intrinsics.checkParameterIsNotNull(userInfoNotId, "userInfo");
        Intrinsics.checkParameterIsNotNull(userShippingInfo, "shippingAddress");
        OrderDetailListItem orderDetailListItem = new OrderDetailListItem(j, str5, date2, str6, list2, i6, num3, i7, i8, i9, str7, num4, orderDiscountType3, i10, str8, paymentInfo3, userInfoNotId2, userShippingInfo2);
        return orderDetailListItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderDetailListItem) {
                OrderDetailListItem orderDetailListItem = (OrderDetailListItem) obj;
                if ((this.id == orderDetailListItem.id) && Intrinsics.areEqual((Object) this.state, (Object) orderDetailListItem.state) && Intrinsics.areEqual((Object) this.orderCreatedDate, (Object) orderDetailListItem.orderCreatedDate) && Intrinsics.areEqual((Object) this.orderNumber, (Object) orderDetailListItem.orderNumber) && Intrinsics.areEqual((Object) this.lineItems, (Object) orderDetailListItem.lineItems)) {
                    if ((this.totalCount == orderDetailListItem.totalCount) && Intrinsics.areEqual((Object) this.specialDiscountPrice, (Object) orderDetailListItem.specialDiscountPrice)) {
                        if (this.totalProductPrice == orderDetailListItem.totalProductPrice) {
                            if (this.totalShippingPrice == orderDetailListItem.totalShippingPrice) {
                                if ((this.totalPaymentPrice == orderDetailListItem.totalPaymentPrice) && Intrinsics.areEqual((Object) this.adjustType, (Object) orderDetailListItem.adjustType) && Intrinsics.areEqual((Object) this.adjustValue, (Object) orderDetailListItem.adjustValue) && Intrinsics.areEqual((Object) this.orderDiscountType, (Object) orderDetailListItem.orderDiscountType)) {
                                    if (!(this.predictPoint == orderDetailListItem.predictPoint) || !Intrinsics.areEqual((Object) this.paymentMethod, (Object) orderDetailListItem.paymentMethod) || !Intrinsics.areEqual((Object) this.paymentInfo, (Object) orderDetailListItem.paymentInfo) || !Intrinsics.areEqual((Object) this.userInfo, (Object) orderDetailListItem.userInfo) || !Intrinsics.areEqual((Object) this.shippingAddress, (Object) orderDetailListItem.shippingAddress)) {
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
        String str = this.state;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Date date = this.orderCreatedDate;
        int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
        String str2 = this.orderNumber;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<OrderListLineItem> list = this.lineItems;
        int hashCode4 = (((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.totalCount) * 31;
        Integer num = this.specialDiscountPrice;
        int hashCode5 = (((((((hashCode4 + (num != null ? num.hashCode() : 0)) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31) + this.totalPaymentPrice) * 31;
        String str3 = this.adjustType;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num2 = this.adjustValue;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        OrderDiscountType orderDiscountType2 = this.orderDiscountType;
        int hashCode8 = (((hashCode7 + (orderDiscountType2 != null ? orderDiscountType2.hashCode() : 0)) * 31) + this.predictPoint) * 31;
        String str4 = this.paymentMethod;
        int hashCode9 = (hashCode8 + (str4 != null ? str4.hashCode() : 0)) * 31;
        PaymentInfo paymentInfo2 = this.paymentInfo;
        int hashCode10 = (hashCode9 + (paymentInfo2 != null ? paymentInfo2.hashCode() : 0)) * 31;
        UserInfoNotId userInfoNotId = this.userInfo;
        int hashCode11 = (hashCode10 + (userInfoNotId != null ? userInfoNotId.hashCode() : 0)) * 31;
        UserShippingInfo userShippingInfo = this.shippingAddress;
        if (userShippingInfo != null) {
            i2 = userShippingInfo.hashCode();
        }
        return hashCode11 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderDetailListItem(id=");
        sb.append(this.id);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", orderCreatedDate=");
        sb.append(this.orderCreatedDate);
        sb.append(", orderNumber=");
        sb.append(this.orderNumber);
        sb.append(", lineItems=");
        sb.append(this.lineItems);
        sb.append(", totalCount=");
        sb.append(this.totalCount);
        sb.append(", specialDiscountPrice=");
        sb.append(this.specialDiscountPrice);
        sb.append(", totalProductPrice=");
        sb.append(this.totalProductPrice);
        sb.append(", totalShippingPrice=");
        sb.append(this.totalShippingPrice);
        sb.append(", totalPaymentPrice=");
        sb.append(this.totalPaymentPrice);
        sb.append(", adjustType=");
        sb.append(this.adjustType);
        sb.append(", adjustValue=");
        sb.append(this.adjustValue);
        sb.append(", orderDiscountType=");
        sb.append(this.orderDiscountType);
        sb.append(", predictPoint=");
        sb.append(this.predictPoint);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", paymentInfo=");
        sb.append(this.paymentInfo);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", shippingAddress=");
        sb.append(this.shippingAddress);
        sb.append(")");
        return sb.toString();
    }

    public OrderDetailListItem(long j, @NotNull String str, @NotNull Date date, @NotNull String str2, @NotNull List<OrderListLineItem> list, int i, @Nullable Integer num, int i2, int i3, int i4, @Nullable String str3, @Nullable Integer num2, @NotNull OrderDiscountType orderDiscountType2, int i5, @Nullable String str4, @Nullable PaymentInfo paymentInfo2, @NotNull UserInfoNotId userInfoNotId, @NotNull UserShippingInfo userShippingInfo) {
        String str5 = str;
        Date date2 = date;
        String str6 = str2;
        List<OrderListLineItem> list2 = list;
        OrderDiscountType orderDiscountType3 = orderDiscountType2;
        UserInfoNotId userInfoNotId2 = userInfoNotId;
        UserShippingInfo userShippingInfo2 = userShippingInfo;
        Intrinsics.checkParameterIsNotNull(str, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(date, "orderCreatedDate");
        Intrinsics.checkParameterIsNotNull(str2, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list2, "lineItems");
        Intrinsics.checkParameterIsNotNull(orderDiscountType3, "orderDiscountType");
        Intrinsics.checkParameterIsNotNull(userInfoNotId2, "userInfo");
        Intrinsics.checkParameterIsNotNull(userShippingInfo2, "shippingAddress");
        this.id = j;
        this.state = str5;
        this.orderCreatedDate = date2;
        this.orderNumber = str6;
        this.lineItems = list2;
        this.totalCount = i;
        this.specialDiscountPrice = num;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.totalPaymentPrice = i4;
        this.adjustType = str3;
        this.adjustValue = num2;
        this.orderDiscountType = orderDiscountType3;
        this.predictPoint = i5;
        this.paymentMethod = str4;
        this.paymentInfo = paymentInfo2;
        this.userInfo = userInfoNotId2;
        this.shippingAddress = userShippingInfo2;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @NotNull
    public final Date getOrderCreatedDate() {
        return this.orderCreatedDate;
    }

    @NotNull
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListLineItem> getLineItems() {
        return this.lineItems;
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

    public final int getTotalPaymentPrice() {
        return this.totalPaymentPrice;
    }

    @Nullable
    public final String getAdjustType() {
        return this.adjustType;
    }

    @Nullable
    public final Integer getAdjustValue() {
        return this.adjustValue;
    }

    @NotNull
    public final OrderDiscountType getOrderDiscountType() {
        return this.orderDiscountType;
    }

    public final int getPredictPoint() {
        return this.predictPoint;
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
}
