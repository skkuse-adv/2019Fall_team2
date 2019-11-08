package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

final class IntergratedSearchResultProductViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ IntergratedSearchResultProductViewHolder this$0;

    IntergratedSearchResultProductViewHolder$bindTo$$inlined$with$lambda$1(IntergratedSearchResultProductViewHolder intergratedSearchResultProductViewHolder, List list, Boolean bool) {
        this.this$0 = intergratedSearchResultProductViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().switchProductTab();
    }
}
