package kr.co.popone.fitts.feature.recommend.fittie;

import androidx.lifecycle.Observer;
import kotlin.Unit;

final class FittieRecommendActivity$onCreate$6<T> implements Observer<Unit> {
    final /* synthetic */ FittieRecommendActivity this$0;

    FittieRecommendActivity$onCreate$6(FittieRecommendActivity fittieRecommendActivity) {
        this.this$0 = fittieRecommendActivity;
    }

    public final void onChanged(Unit unit) {
        this.this$0.startFitts();
    }
}
