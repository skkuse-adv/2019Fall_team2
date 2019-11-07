package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.search.SearchHistoryView.Delegate;

final class SearchHistoryView$initialize$2 implements OnClickListener {
    final /* synthetic */ SearchHistoryView this$0;

    SearchHistoryView$initialize$2(SearchHistoryView searchHistoryView) {
        this.this$0 = searchHistoryView;
    }

    public final void onClick(View view) {
        Delegate delegate = this.this$0.getDelegate();
        if (delegate != null) {
            delegate.onDeleteClicked();
        }
    }
}
