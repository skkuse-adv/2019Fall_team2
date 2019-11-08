package kr.co.popone.fitts.model.remote.refund;

import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundApplyResponse {
    @SerializedName("adjustment_type")
    @Nullable
    private final String adjustmentType;
    @SerializedName("adjustment_price")
    private final int adjustmentValue;
    @SerializedName("applied_at")
    @NotNull
    private final Date appliedAt;
    @SerializedName("detail_reason")
    @NotNull
    private final String detailReason;
    @SerializedName("order_line_item_variant")
    @NotNull
    private final OrderListLineItemVariant orderLineItemVariant;
    @SerializedName("quantity")
    private final int quantity;
    @SerializedName("user_refund_account")
    @Nullable
    private final RefundAccount refundAccount;
    @SerializedName("reason")
    @NotNull
    private final String refundReason;
    @SerializedName("refund_value")
    private final int refundValue;
    @SerializedName("state")
    @NotNull
    private final String state;
    @SerializedName("shop")
    @NotNull
    private final StoreInfo storeInfo;

    @NotNull
    public static /* synthetic */ RefundApplyResponse copy$default(RefundApplyResponse refundApplyResponse, OrderListLineItemVariant orderListLineItemVariant, int i, String str, String str2, String str3, int i2, int i3, String str4, Date date, StoreInfo storeInfo2, RefundAccount refundAccount2, int i4, Object obj) {
        RefundApplyResponse refundApplyResponse2 = refundApplyResponse;
        int i5 = i4;
        return refundApplyResponse.copy((i5 & 1) != 0 ? refundApplyResponse2.orderLineItemVariant : orderListLineItemVariant, (i5 & 2) != 0 ? refundApplyResponse2.quantity : i, (i5 & 4) != 0 ? refundApplyResponse2.refundReason : str, (i5 & 8) != 0 ? refundApplyResponse2.detailReason : str2, (i5 & 16) != 0 ? refundApplyResponse2.adjustmentType : str3, (i5 & 32) != 0 ? refundApplyResponse2.adjustmentValue : i2, (i5 & 64) != 0 ? refundApplyResponse2.refundValue : i3, (i5 & 128) != 0 ? refundApplyResponse2.state : str4, (i5 & 256) != 0 ? refundApplyResponse2.appliedAt : date, (i5 & 512) != 0 ? refundApplyResponse2.storeInfo : storeInfo2, (i5 & 1024) != 0 ? refundApplyResponse2.refundAccount : refundAccount2);
    }

    @NotNull
    public final OrderListLineItemVariant component1() {
        return this.orderLineItemVariant;
    }

    @NotNull
    public final StoreInfo component10() {
        return this.storeInfo;
    }

    @Nullable
    public final RefundAccount component11() {
        return this.refundAccount;
    }

    public final int component2() {
        return this.quantity;
    }

    @NotNull
    public final String component3() {
        return this.refundReason;
    }

    @NotNull
    public final String component4() {
        return this.detailReason;
    }

    @Nullable
    public final String component5() {
        return this.adjustmentType;
    }

    public final int component6() {
        return this.adjustmentValue;
    }

    public final int component7() {
        return this.refundValue;
    }

    @NotNull
    public final String component8() {
        return this.state;
    }

    @NotNull
    public final Date component9() {
        return this.appliedAt;
    }

    @NotNull
    public final RefundApplyResponse copy(@NotNull OrderListLineItemVariant orderListLineItemVariant, int i, @NotNull String str, @NotNull String str2, @Nullable String str3, int i2, int i3, @NotNull String str4, @NotNull Date date, @NotNull StoreInfo storeInfo2, @Nullable RefundAccount refundAccount2) {
        OrderListLineItemVariant orderListLineItemVariant2 = orderListLineItemVariant;
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "orderLineItemVariant");
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str5, "refundReason");
        String str6 = str2;
        Intrinsics.checkParameterIsNotNull(str6, "detailReason");
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, ServerProtocol.DIALOG_PARAM_STATE);
        Date date2 = date;
        Intrinsics.checkParameterIsNotNull(date2, "appliedAt");
        StoreInfo storeInfo3 = storeInfo2;
        Intrinsics.checkParameterIsNotNull(storeInfo3, "storeInfo");
        RefundApplyResponse refundApplyResponse = new RefundApplyResponse(orderListLineItemVariant2, i, str5, str6, str3, i2, i3, str7, date2, storeInfo3, refundAccount2);
        return refundApplyResponse;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RefundApplyResponse) {
                RefundApplyResponse refundApplyResponse = (RefundApplyResponse) obj;
                if (Intrinsics.areEqual((Object) this.orderLineItemVariant, (Object) refundApplyResponse.orderLineItemVariant)) {
                    if ((this.quantity == refundApplyResponse.quantity) && Intrinsics.areEqual((Object) this.refundReason, (Object) refundApplyResponse.refundReason) && Intrinsics.areEqual((Object) this.detailReason, (Object) refundApplyResponse.detailReason) && Intrinsics.areEqual((Object) this.adjustmentType, (Object) refundApplyResponse.adjustmentType)) {
                        if (this.adjustmentValue == refundApplyResponse.adjustmentValue) {
                            if (!(this.refundValue == refundApplyResponse.refundValue) || !Intrinsics.areEqual((Object) this.state, (Object) refundApplyResponse.state) || !Intrinsics.areEqual((Object) this.appliedAt, (Object) refundApplyResponse.appliedAt) || !Intrinsics.areEqual((Object) this.storeInfo, (Object) refundApplyResponse.storeInfo) || !Intrinsics.areEqual((Object) this.refundAccount, (Object) refundApplyResponse.refundAccount)) {
                                return false;
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
        OrderListLineItemVariant orderListLineItemVariant = this.orderLineItemVariant;
        int i = 0;
        int hashCode = (((orderListLineItemVariant != null ? orderListLineItemVariant.hashCode() : 0) * 31) + this.quantity) * 31;
        String str = this.refundReason;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.detailReason;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.adjustmentType;
        int hashCode4 = (((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.adjustmentValue) * 31) + this.refundValue) * 31;
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
        sb.append("RefundApplyResponse(orderLineItemVariant=");
        sb.append(this.orderLineItemVariant);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", refundReason=");
        sb.append(this.refundReason);
        sb.append(", detailReason=");
        sb.append(this.detailReason);
        sb.append(", adjustmentType=");
        sb.append(this.adjustmentType);
        sb.append(", adjustmentValue=");
        sb.append(this.adjustmentValue);
        sb.append(", refundValue=");
        sb.append(this.refundValue);
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

    public RefundApplyResponse(@NotNull OrderListLineItemVariant orderListLineItemVariant, int i, @NotNull String str, @NotNull String str2, @Nullable String str3, int i2, int i3, @NotNull String str4, @NotNull Date date, @NotNull StoreInfo storeInfo2, @Nullable RefundAccount refundAccount2) {
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "orderLineItemVariant");
        Intrinsics.checkParameterIsNotNull(str, "refundReason");
        Intrinsics.checkParameterIsNotNull(str2, "detailReason");
        Intrinsics.checkParameterIsNotNull(str4, ServerProtocol.DIALOG_PARAM_STATE);
        Intrinsics.checkParameterIsNotNull(date, "appliedAt");
        Intrinsics.checkParameterIsNotNull(storeInfo2, "storeInfo");
        this.orderLineItemVariant = orderListLineItemVariant;
        this.quantity = i;
        this.refundReason = str;
        this.detailReason = str2;
        this.adjustmentType = str3;
        this.adjustmentValue = i2;
        this.refundValue = i3;
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
    public final String getRefundReason() {
        return this.refundReason;
    }

    @NotNull
    public final String getDetailReason() {
        return this.detailReason;
    }

    @Nullable
    public final String getAdjustmentType() {
        return this.adjustmentType;
    }

    public final int getAdjustmentValue() {
        return this.adjustmentValue;
    }

    public final int getRefundValue() {
        return this.refundValue;
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
