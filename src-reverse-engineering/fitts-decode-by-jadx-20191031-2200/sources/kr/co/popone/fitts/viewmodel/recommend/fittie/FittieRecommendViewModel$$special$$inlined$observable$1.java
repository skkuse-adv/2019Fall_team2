package kr.co.popone.fitts.viewmodel.recommend.fittie;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendViewModel$$special$$inlined$observable$1 extends ObservableProperty<Integer> {
    final /* synthetic */ FittieRecommendViewModel this$0;

    public FittieRecommendViewModel$$special$$inlined$observable$1(Object obj, Object obj2, FittieRecommendViewModel fittieRecommendViewModel) {
        this.this$0 = fittieRecommendViewModel;
        super(obj2);
    }

    /* access modifiers changed from: protected */
    public void afterChange(@NotNull KProperty<?> kProperty, Integer num, Integer num2) {
        Intrinsics.checkParameterIsNotNull(kProperty, "property");
        int intValue = num2.intValue();
        num.intValue();
        this.this$0.handleFollowingCount(intValue);
    }
}
