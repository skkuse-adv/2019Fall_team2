package kr.co.popone.fitts.feature.ncommerce;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import org.jetbrains.annotations.NotNull;

public final class PointHistoryAdapter$Companion$COMPARATOR$1 extends ItemCallback<PaymentHistory> {
    PointHistoryAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull PaymentHistory paymentHistory, @NotNull PaymentHistory paymentHistory2) {
        Intrinsics.checkParameterIsNotNull(paymentHistory, "oldItem");
        Intrinsics.checkParameterIsNotNull(paymentHistory2, "newItem");
        return paymentHistory.getId() == paymentHistory2.getId();
    }

    public boolean areContentsTheSame(@NotNull PaymentHistory paymentHistory, @NotNull PaymentHistory paymentHistory2) {
        Intrinsics.checkParameterIsNotNull(paymentHistory, "oldItem");
        Intrinsics.checkParameterIsNotNull(paymentHistory2, "newItem");
        return paymentHistory.getId() == paymentHistory.getId();
    }
}
