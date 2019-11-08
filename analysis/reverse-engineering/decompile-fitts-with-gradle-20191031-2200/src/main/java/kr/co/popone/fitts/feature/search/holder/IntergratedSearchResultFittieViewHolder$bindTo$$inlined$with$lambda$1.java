package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

final class IntergratedSearchResultFittieViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ IntergratedSearchResultFittieViewHolder this$0;

    IntergratedSearchResultFittieViewHolder$bindTo$$inlined$with$lambda$1(IntergratedSearchResultFittieViewHolder intergratedSearchResultFittieViewHolder, Boolean bool, List list) {
        this.this$0 = intergratedSearchResultFittieViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().switchFittieTab();
    }
}
