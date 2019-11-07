package kr.co.popone.fitts.ui.custom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import org.jetbrains.annotations.NotNull;

final class DiscountChoiceSelector$calculateUsablePoint$3<T> implements Predicate<Double> {
    final /* synthetic */ AdjustmentViewData $adjustmentViewData;

    DiscountChoiceSelector$calculateUsablePoint$3(AdjustmentViewData adjustmentViewData) {
        this.$adjustmentViewData = adjustmentViewData;
    }

    public final boolean test(@NotNull Double d) {
        Intrinsics.checkParameterIsNotNull(d, "it");
        double doubleValue = d.doubleValue();
        double usageValueUnit = (double) this.$adjustmentViewData.getUsageValueUnit();
        Double.isNaN(usageValueUnit);
        return doubleValue % usageValueUnit != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
