package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

final class FittieSearchResultFragment$onViewCreated$6<T> implements Observer<Boolean> {
    final /* synthetic */ FittieSearchResultFragment this$0;

    FittieSearchResultFragment$onViewCreated$6(FittieSearchResultFragment fittieSearchResultFragment) {
        this.this$0 = fittieSearchResultFragment;
    }

    public final void onChanged(Boolean bool) {
        FittieSearchResultFragment fittieSearchResultFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        fittieSearchResultFragment.updateEmptyList(bool.booleanValue());
    }
}
