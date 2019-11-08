package kr.co.popone.fitts.feature.reward;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.reward.UsedRewardHistoryAdapter.Delegate;

final class UsedRewardHistoryAdapter$onClickListener$1 implements OnClickListener {
    final /* synthetic */ UsedRewardHistoryAdapter this$0;

    UsedRewardHistoryAdapter$onClickListener$1(UsedRewardHistoryAdapter usedRewardHistoryAdapter) {
        this.this$0 = usedRewardHistoryAdapter;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        Intrinsics.checkExpressionValueIsNotNull(view, "v");
        Object tag = view.getTag();
        if (tag != null) {
            access$getDelegate$p.onItemClicked(((Integer) tag).intValue());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
}
