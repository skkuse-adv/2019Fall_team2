package kr.co.popone.fitts.ui.custom;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import org.jetbrains.annotations.NotNull;

final class DiscountChoiceSelector$calculateUsablePoint$4<T, R> implements Function<T, R> {
    final /* synthetic */ AdjustmentViewData $adjustmentViewData;

    DiscountChoiceSelector$calculateUsablePoint$4(AdjustmentViewData adjustmentViewData) {
        this.$adjustmentViewData = adjustmentViewData;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Double.valueOf(apply((Double) obj));
    }

    public final double apply(@NotNull Double d) {
        Intrinsics.checkParameterIsNotNull(d, "it");
        double doubleValue = d.doubleValue();
        double usageValueUnit = (double) this.$adjustmentViewData.getUsageValueUnit();
        Double.isNaN(usageValueUnit);
        double floor = Math.floor(doubleValue / usageValueUnit);
        double usageValueUnit2 = (double) this.$adjustmentViewData.getUsageValueUnit();
        Double.isNaN(usageValueUnit2);
        return floor * usageValueUnit2;
    }
}
