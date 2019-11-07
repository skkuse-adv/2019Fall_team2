package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

final class IntergratedSearchResultPostViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ IntergratedSearchResultPostViewHolder this$0;

    IntergratedSearchResultPostViewHolder$bindTo$$inlined$with$lambda$1(IntergratedSearchResultPostViewHolder intergratedSearchResultPostViewHolder, Boolean bool, List list) {
        this.this$0 = intergratedSearchResultPostViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().switchPostTab();
    }
}
