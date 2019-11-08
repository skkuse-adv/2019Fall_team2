package kr.co.popone.fitts.model.domain.exchange;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeRefundVariant {
    @NotNull
    private final String productInfoSummary;
    @NotNull
    private final String productOptionInfoSummary;
    private final int quantity;
    @Nullable
    private final RefundAccount refundAccount;

    @NotNull
    public static /* synthetic */ ExchangeRefundVariant copy$default(ExchangeRefundVariant exchangeRefundVariant, String str, String str2, RefundAccount refundAccount2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = exchangeRefundVariant.productInfoSummary;
        }
        if ((i2 & 2) != 0) {
            str2 = exchangeRefundVariant.productOptionInfoSummary;
        }
        if ((i2 & 4) != 0) {
            refundAccount2 = exchangeRefundVariant.refundAccount;
        }
        if ((i2 & 8) != 0) {
            i = exchangeRefundVariant.quantity;
        }
        return exchangeRefundVariant.copy(str, str2, refundAccount2, i);
    }

    @NotNull
    public final String component1() {
        return this.productInfoSummary;
    }

    @NotNull
    public final String component2() {
        return this.productOptionInfoSummary;
    }

    @Nullable
    public final RefundAccount component3() {
        return this.refundAccount;
    }

    public final int component4() {
        return this.quantity;
    }

    @NotNull
    public final ExchangeRefundVariant copy(@NotNull String str, @NotNull String str2, @Nullable RefundAccount refundAccount2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "productInfoSummary");
        Intrinsics.checkParameterIsNotNull(str2, "productOptionInfoSummary");
        return new ExchangeRefundVariant(str, str2, refundAccount2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ExchangeRefundVariant) {
                ExchangeRefundVariant exchangeRefundVariant = (ExchangeRefundVariant) obj;
                if (Intrinsics.areEqual((Object) this.productInfoSummary, (Object) exchangeRefundVariant.productInfoSummary) && Intrinsics.areEqual((Object) this.productOptionInfoSummary, (Object) exchangeRefundVariant.productOptionInfoSummary) && Intrinsics.areEqual((Object) this.refundAccount, (Object) exchangeRefundVariant.refundAccount)) {
                    if (this.quantity == exchangeRefundVariant.quantity) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.productInfoSummary;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.productOptionInfoSummary;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        RefundAccount refundAccount2 = this.refundAccount;
        if (refundAccount2 != null) {
            i = refundAccount2.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.quantity;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExchangeRefundVariant(productInfoSummary=");
        sb.append(this.productInfoSummary);
        sb.append(", productOptionInfoSummary=");
        sb.append(this.productOptionInfoSummary);
        sb.append(", refundAccount=");
        sb.append(this.refundAccount);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(")");
        return sb.toString();
    }

    public ExchangeRefundVariant(@NotNull String str, @NotNull String str2, @Nullable RefundAccount refundAccount2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "productInfoSummary");
        Intrinsics.checkParameterIsNotNull(str2, "productOptionInfoSummary");
        this.productInfoSummary = str;
        this.productOptionInfoSummary = str2;
        this.refundAccount = refundAccount2;
        this.quantity = i;
    }

    @NotNull
    public final String getProductInfoSummary() {
        return this.productInfoSummary;
    }

    @NotNull
    public final String getProductOptionInfoSummary() {
        return this.productOptionInfoSummary;
    }

    @Nullable
    public final RefundAccount getRefundAccount() {
        return this.refundAccount;
    }

    public final int getQuantity() {
        return this.quantity;
    }
}
