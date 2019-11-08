package kr.co.popone.fitts.feature.event;

import android.view.LayoutInflater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

final class CollaborativeEventStatusBoardView$updateView$$inlined$let$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ CollaborativeEventStatusBoardView this$0;

    CollaborativeEventStatusBoardView$updateView$$inlined$let$lambda$1(int i, LayoutInflater layoutInflater, CollaborativeEventStatusBoardView collaborativeEventStatusBoardView) {
        this.$index = i;
        this.this$0 = collaborativeEventStatusBoardView;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        Function2 itemClickListener = this.this$0.getItemClickListener();
        if (itemClickListener != null) {
            Unit unit = (Unit) itemClickListener.invoke(Integer.valueOf(this.$index), Integer.valueOf(i));
        }
    }
}
