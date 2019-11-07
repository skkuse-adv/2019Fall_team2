package kr.co.popone.fitts.model.remote.exchange;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListLineItemVariant;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;

public final class PreExchageResponse {
    @SerializedName("order_line_item_variant")
    @NotNull
    private final OrderListLineItemVariant orderLineItemVariant;
    @SerializedName("user_refund_account")
    @NotNull
    private final RefundAccount refundAccount;
    @SerializedName("shop")
    @NotNull
    private final StoreInfo storeInfo;

    @NotNull
    public static /* synthetic */ PreExchageResponse copy$default(PreExchageResponse preExchageResponse, OrderListLineItemVariant orderListLineItemVariant, StoreInfo storeInfo2, RefundAccount refundAccount2, int i, Object obj) {
        if ((i & 1) != 0) {
            orderListLineItemVariant = preExchageResponse.orderLineItemVariant;
        }
        if ((i & 2) != 0) {
            storeInfo2 = preExchageResponse.storeInfo;
        }
        if ((i & 4) != 0) {
            refundAccount2 = preExchageResponse.refundAccount;
        }
        return preExchageResponse.copy(orderListLineItemVariant, storeInfo2, refundAccount2);
    }

    @NotNull
    public final OrderListLineItemVariant component1() {
        return this.orderLineItemVariant;
    }

    @NotNull
    public final StoreInfo component2() {
        return this.storeInfo;
    }

    @NotNull
    public final RefundAccount component3() {
        return this.refundAccount;
    }

    @NotNull
    public final PreExchageResponse copy(@NotNull OrderListLineItemVariant orderListLineItemVariant, @NotNull StoreInfo storeInfo2, @NotNull RefundAccount refundAccount2) {
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "orderLineItemVariant");
        Intrinsics.checkParameterIsNotNull(storeInfo2, "storeInfo");
        Intrinsics.checkParameterIsNotNull(refundAccount2, "refundAccount");
        return new PreExchageResponse(orderListLineItemVariant, storeInfo2, refundAccount2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.refundAccount, (java.lang.Object) r3.refundAccount) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.remote.exchange.PreExchageResponse
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.remote.exchange.PreExchageResponse r3 = (kr.co.popone.fitts.model.remote.exchange.PreExchageResponse) r3
            kr.co.popone.fitts.model.order.OrderListLineItemVariant r0 = r2.orderLineItemVariant
            kr.co.popone.fitts.model.order.OrderListLineItemVariant r1 = r3.orderLineItemVariant
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.store.StoreInfo r0 = r2.storeInfo
            kr.co.popone.fitts.model.store.StoreInfo r1 = r3.storeInfo
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.remote.model.RefundAccount r0 = r2.refundAccount
            kr.co.popone.fitts.model.remote.model.RefundAccount r3 = r3.refundAccount
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.remote.exchange.PreExchageResponse.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        OrderListLineItemVariant orderListLineItemVariant = this.orderLineItemVariant;
        int i = 0;
        int hashCode = (orderListLineItemVariant != null ? orderListLineItemVariant.hashCode() : 0) * 31;
        StoreInfo storeInfo2 = this.storeInfo;
        int hashCode2 = (hashCode + (storeInfo2 != null ? storeInfo2.hashCode() : 0)) * 31;
        RefundAccount refundAccount2 = this.refundAccount;
        if (refundAccount2 != null) {
            i = refundAccount2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreExchageResponse(orderLineItemVariant=");
        sb.append(this.orderLineItemVariant);
        sb.append(", storeInfo=");
        sb.append(this.storeInfo);
        sb.append(", refundAccount=");
        sb.append(this.refundAccount);
        sb.append(")");
        return sb.toString();
    }

    public PreExchageResponse(@NotNull OrderListLineItemVariant orderListLineItemVariant, @NotNull StoreInfo storeInfo2, @NotNull RefundAccount refundAccount2) {
        Intrinsics.checkParameterIsNotNull(orderListLineItemVariant, "orderLineItemVariant");
        Intrinsics.checkParameterIsNotNull(storeInfo2, "storeInfo");
        Intrinsics.checkParameterIsNotNull(refundAccount2, "refundAccount");
        this.orderLineItemVariant = orderListLineItemVariant;
        this.storeInfo = storeInfo2;
        this.refundAccount = refundAccount2;
    }

    @NotNull
    public final OrderListLineItemVariant getOrderLineItemVariant() {
        return this.orderLineItemVariant;
    }

    @NotNull
    public final StoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    @NotNull
    public final RefundAccount getRefundAccount() {
        return this.refundAccount;
    }
}
