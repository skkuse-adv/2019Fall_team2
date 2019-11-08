package kr.co.popone.fitts.feature.ncommerce;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import org.jetbrains.annotations.NotNull;

public final class PointUsageHistoryAdapter$Companion$COMPARATOR$1 extends ItemCallback<PaymentUsage> {
    PointUsageHistoryAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull PaymentUsage paymentUsage, @NotNull PaymentUsage paymentUsage2) {
        Intrinsics.checkParameterIsNotNull(paymentUsage, "oldItem");
        Intrinsics.checkParameterIsNotNull(paymentUsage2, "newItem");
        return paymentUsage.getId() == paymentUsage2.getId();
    }

    public boolean areContentsTheSame(@NotNull PaymentUsage paymentUsage, @NotNull PaymentUsage paymentUsage2) {
        Intrinsics.checkParameterIsNotNull(paymentUsage, "oldItem");
        Intrinsics.checkParameterIsNotNull(paymentUsage2, "newItem");
        return paymentUsage.getId() == paymentUsage.getId();
    }
}
