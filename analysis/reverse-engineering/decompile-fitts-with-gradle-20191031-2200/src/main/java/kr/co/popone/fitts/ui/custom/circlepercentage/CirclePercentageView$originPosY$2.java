package kr.co.popone.fitts.ui.custom.circlepercentage;

import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;

final class CirclePercentageView$originPosY$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ CirclePercentageView this$0;

    CirclePercentageView$originPosY$2(CirclePercentageView circlePercentageView) {
        this.this$0 = circlePercentageView;
        super(0);
    }

    public final float invoke() {
        View _$_findCachedViewById = this.this$0._$_findCachedViewById(C0010R$id.graphView);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "graphView");
        return _$_findCachedViewById.getY();
    }
}
