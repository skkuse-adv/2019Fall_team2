package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

final class PostSearchResultFragment$onViewCreated$6<T> implements Observer<Boolean> {
    final /* synthetic */ PostSearchResultFragment this$0;

    PostSearchResultFragment$onViewCreated$6(PostSearchResultFragment postSearchResultFragment) {
        this.this$0 = postSearchResultFragment;
    }

    public final void onChanged(Boolean bool) {
        PostSearchResultFragment postSearchResultFragment = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        postSearchResultFragment.updateEmptyList(bool.booleanValue());
    }
}
