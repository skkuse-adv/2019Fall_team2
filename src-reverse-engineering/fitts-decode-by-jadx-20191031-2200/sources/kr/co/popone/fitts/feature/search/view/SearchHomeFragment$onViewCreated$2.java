package kr.co.popone.fitts.feature.search.view;

import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.view.SearchHomeFragment.Delegate;
import me.gujun.android.taggroup.TagGroup.OnTagClickListener;

final class SearchHomeFragment$onViewCreated$2 implements OnTagClickListener {
    final /* synthetic */ SearchHomeFragment this$0;

    SearchHomeFragment$onViewCreated$2(SearchHomeFragment searchHomeFragment) {
        this.this$0 = searchHomeFragment;
    }

    public final void onTagClick(String str) {
        Delegate access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            Intrinsics.checkExpressionValueIsNotNull(str, "it");
            access$getListener$p.onKeywordInput(str);
        }
    }
}
