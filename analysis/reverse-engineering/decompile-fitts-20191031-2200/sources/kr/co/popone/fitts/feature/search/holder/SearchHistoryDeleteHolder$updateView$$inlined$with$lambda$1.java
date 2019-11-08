package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.search.holder.SearchHistoryDeleteHolder.Delegate;

final class SearchHistoryDeleteHolder$updateView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ SearchHistoryDeleteHolder this$0;

    SearchHistoryDeleteHolder$updateView$$inlined$with$lambda$1(SearchHistoryDeleteHolder searchHistoryDeleteHolder) {
        this.this$0 = searchHistoryDeleteHolder;
    }

    public final void onClick(View view) {
        Delegate delegate = this.this$0.getDelegate();
        if (delegate != null) {
            delegate.onHistoryDelete();
        }
    }
}
