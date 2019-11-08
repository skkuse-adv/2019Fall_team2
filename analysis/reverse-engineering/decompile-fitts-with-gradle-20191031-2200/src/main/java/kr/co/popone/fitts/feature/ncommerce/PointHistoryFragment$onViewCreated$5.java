package kr.co.popone.fitts.feature.ncommerce;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class PointHistoryFragment$onViewCreated$5<T> implements Observer<Boolean> {
    final /* synthetic */ PointHistoryFragment this$0;

    PointHistoryFragment$onViewCreated$5(PointHistoryFragment pointHistoryFragment) {
        this.this$0 = pointHistoryFragment;
    }

    public final void onChanged(Boolean bool) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.textEmptyView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "textEmptyView");
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        int i = 0;
        linearLayout.setVisibility(bool.booleanValue() ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerPointHistory);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerPointHistory");
        if (bool.booleanValue()) {
            i = 8;
        }
        recyclerView.setVisibility(i);
    }
}
