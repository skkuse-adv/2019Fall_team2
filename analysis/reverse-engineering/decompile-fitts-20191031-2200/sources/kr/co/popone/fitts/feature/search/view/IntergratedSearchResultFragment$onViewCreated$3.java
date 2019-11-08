package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;

final class IntergratedSearchResultFragment$onViewCreated$3<T> implements Observer<IntergratedSearchViewData> {
    final /* synthetic */ IntergratedSearchResultFragment this$0;

    IntergratedSearchResultFragment$onViewCreated$3(IntergratedSearchResultFragment intergratedSearchResultFragment) {
        this.this$0 = intergratedSearchResultFragment;
    }

    public final void onChanged(IntergratedSearchViewData intergratedSearchViewData) {
        IntergratedSearchResultFragment intergratedSearchResultFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(intergratedSearchViewData, "it");
        intergratedSearchResultFragment.updateSearchResult(intergratedSearchViewData);
    }
}
