package kr.co.popone.fitts.viewmodel.recommend.fittie;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class FittieRecommendViewModel$fittsStartButtonClick$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FittieRecommendViewModel this$0;

    FittieRecommendViewModel$fittsStartButtonClick$1(FittieRecommendViewModel fittieRecommendViewModel) {
        this.this$0 = fittieRecommendViewModel;
        super(0);
    }

    public final void invoke() {
        this.this$0._startFittsLiveData.setValue(Unit.INSTANCE);
    }
}
