package kr.co.popone.fitts.model.remote.exchange;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeApplyResponse {
    @SerializedName("applied_at")
    @NotNull
    private final Date appliedAt;
    @SerializedName("detail_reason")
    @NotNull
    private final String detailReason;
    @SerializedName("reason")
    @NotNull
    private final String exchangeReason;
    @SerializedName("exchange_wish_option")
    @NotNull
    private final String exchangeWishOption;
    @SerializedName("order_line_item_variant")
    @NotNull
    private final OrderListLineItemVariant orderLineItemVariant;
    @SerializedName("quantity")
    private final int quantity;
    @SerializedName("user_refund_account")
    @Nullable
    private final RefundAccount refundAccount;
    @SerializedName("state")
    @NotNull
    private final String state;
    @SerializedName("shop")
    @NotNull
    private final StoreInfo storeInfo;

    @NotNull
    public static /* synthetic */ ExchangeApplyResponse copy$default(ExchangeApplyResponse exchangeApplyResponse, OrderListLineItemVariant orderListLineItemVariant, int i, String str, String str2, String str3, String str4, Date date, StoreInfo storeInfo2, RefundAccount refundAccount2, int i2, Object obj) {
        ExchangeApplyResponse exchangeApplyResponse2 = exchangeApplyResponse;
        int i3 = i2;
        return exchangeApplyResponse.copy((i3 & 1) != 0 ? exchangeApplyResponse2.orderLineItemVariant : orderListLineItemVariant, (i3 & 2) != 0 ? exchangeApplyResponse2.quantity : i, (i3 & 4) != 0 ? exchangeApplyResponse2.exchangeWishOption : str, (i3 & 8) != 0 ? exchangeApplyResponse2.exchangeReason : str2, (i3 & 16) != 0 ? exchangeApplyResponse2.detailReason : str3, (i3 & 32) != 0 ? exchangeApplyResponse2.state : str4, (i3 & 64) != 0 ? exchangeApplyResponse2.appliedAt : date, (i3 & 128) != 0 ? exchangeApplyResponse2.storeInfo : storeInfo2, (i3 & 256) != 0 ? exchangeApplyResponse2.refundAccount : refundAccount2);
    }

    @NotNull
    public final OrderListLineItemVariant component1() {
        return this.orderLineItemVariant;
    }

    public final int component2() {
        return this.quantity;
    }

    @NotNull
    public final String component3() {
        return this.exchangeWishOption;
    }

    @NotNull
    public final String component4() {
        return this.exchangeReason;
    }

    @NotNull
    public final String component5() {
        return this.detailReason;
    }

    @NotNull
    public final String component6() {
        return this.state;
    }

    @NotNull
    public final Date component7() {
        return this.appliedAt;
    }

    @NotNull
    public final StoreInfo component8() {
        return this.storeInfo;
    }

    @Nullable
    public final RefundAccount component9() {
        return this.refundAccount;
    }

    @NotNull
    public final ExchangeApplyResponse copy(@NotNull OrderListLineItemVariant orderListLineItemVariant, int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Date date, @NotNull StoreInfo storeInfo2, @Nullable RefundAccount refundAccount2) {
        OrderListLineItemVariant orderListLineItemVariant2 = orderListLineItemVariant;
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "orderLineItemVariant");
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str, "exchangeWishOption");
        String str6 = str2;
        Intrinsics.checkParameterIsNotNull(str2, "exchangeReason");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, "detailReason");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, ServerProtocol.DIALOG_PARAM_STATE);
        Date date2 = date;
        Intrinsics.checkParameterIsNotNull(date2, "appliedAt");
        StoreInfo storeInfo3 = storeInfo2;
        Intrinsics.checkParameterIsNotNull(storeInfo3, "storeInfo");
        ExchangeApplyResponse exchangeApplyResponse = new ExchangeApplyResponse(orderListLineItemVariant2, i, str5, str6, str7, str8, date2, storeInfo3, refundAccount2);
        return exchangeApplyResponse;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ExchangeApplyResponse) {
                ExchangeApplyResponse exchangeApplyResponse = (ExchangeApplyResponse) obj;
                if (Intrinsics.areEqual((Object) this.orderLineItemVariant, (Object) exchangeApplyResponse.orderLineItemVariant)) {
                    if (!(this.quantity == exchangeApplyResponse.quantity) || !Intrinsics.areEqual((Object) this.exchangeWishOption, (Object) exchangeApplyResponse.exchangeWishOption) || !Intrinsics.areEqual((Object) this.exchangeReason, (Object) exchangeApplyResponse.exchangeReason) || !Intrinsics.areEqual((Object) this.detailReason, (Object) exchangeApplyResponse.detailReason) || !Intrinsics.areEqual((Object) this.state, (Object) exchangeApplyResponse.state) || !Intrinsics.areEqual((Object) this.appliedAt, (Object) exchangeApplyResponse.appliedAt) || !Intrinsics.areEqual((Object) this.storeInfo, (Object) exchangeApplyResponse.storeInfo) || !Intrinsics.areEqual((Object) this.refundAccount, (Object) exchangeApplyResponse.refundAccount)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        OrderListLineItemVariant orderListLineItemVariant = this.orderLineItemVariant;
        int i = 0;
        int hashCode = (((orderListLineItemVariant != null ? orderListLineItemVariant.hashCode() : 0) * 31) + this.quantity) * 31;
        String str = this.exchangeWishOption;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.exchangeReason;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.detailReason;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.state;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Date date = this.appliedAt;
        int hashCode6 = (hashCode5 + (date != null ? date.hashCode() : 0)) * 31;
        StoreInfo storeInfo2 = this.storeInfo;
        int hashCode7 = (hashCode6 + (storeInfo2 != null ? storeInfo2.hashCode() : 0)) * 31;
        RefundAccount refundAccount2 = this.refundAccount;
        if (refundAccount2 != null) {
            i = refundAccount2.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExchangeApplyResponse(orderLineItemVariant=");
        sb.append(this.orderLineItemVariant);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", exchangeWishOption=");
        sb.append(this.exchangeWishOption);
        sb.append(", exchangeReason=");
        sb.append(this.exchangeReason);
        sb.append(", detailReason=");
        sb.append(this.detailReason);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", appliedAt=");
        sb.append(this.appliedAt);
        sb.append(", storeInfo=");
        sb.append(this.storeInfo);
        sb.append(", refundAccount=");
        sb.append(this.refundAccount);
        sb.append(")");
        return sb.toString();
    }

    public ExchangeApplyResponse(@NotNull OrderListLineItemVariant orderListLineItemVariant, int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Date date, @NotNull StoreInfo storeInfo2, @Nullable RefundAccount refundAccount2) {
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "orderLineItemVariant");
        Intrinsics.checkParameterIsNotNull(str, "exchangeWishOption");
        Intrinsics.checkParameterIsNotNull(str2, "exchangeReason");
        Intrinsics.checkParameterIsNotNull(str3, "detailReason");
        Intrinsics.checkParameterIsNotNull(str4, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(date, "appliedAt");
        Intrinsics.checkParameterIsNotNull(storeInfo2, "storeInfo");
        this.orderLineItemVariant = orderListLineItemVariant;
        this.quantity = i;
        this.exchangeWishOption = str;
        this.exchangeReason = str2;
        this.detailReason = str3;
        this.state = str4;
        this.appliedAt = date;
        this.storeInfo = storeInfo2;
        this.refundAccount = refundAccount2;
    }

    @NotNull
    public final OrderListLineItemVariant getOrderLineItemVariant() {
        return this.orderLineItemVariant;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @NotNull
    public final String getExchangeWishOption() {
        return this.exchangeWishOption;
    }

    @NotNull
    public final String getExchangeReason() {
        return this.exchangeReason;
    }

    @NotNull
    public final String getDetailReason() {
        return this.detailReason;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @NotNull
    public final Date getAppliedAt() {
        return this.appliedAt;
    }

    @NotNull
    public final StoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    @Nullable
    public final RefundAccount getRefundAccount() {
        return this.refundAccount;
    }
}
