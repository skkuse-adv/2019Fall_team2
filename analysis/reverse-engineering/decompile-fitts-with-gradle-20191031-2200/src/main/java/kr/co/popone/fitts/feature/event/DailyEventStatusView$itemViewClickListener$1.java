package kr.co.popone.fitts.feature.event;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class DailyEventStatusView$itemViewClickListener$1 implements OnClickListener {
    final /* synthetic */ DailyEventStatusView this$0;

    DailyEventStatusView$itemViewClickListener$1(DailyEventStatusView dailyEventStatusView) {
        this.this$0 = dailyEventStatusView;
    }

    public final void onClick(View view) {
        Function1 itemClickListener = this.this$0.getItemClickListener();
        if (itemClickListener != null) {
            Intrinsics.checkExpressionValueIsNotNull(view, "it");
            Object tag = view.getTag();
            if (tag != null) {
                Unit unit = (Unit) itemClickListener.invoke((Integer) tag);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        }
    }
}
