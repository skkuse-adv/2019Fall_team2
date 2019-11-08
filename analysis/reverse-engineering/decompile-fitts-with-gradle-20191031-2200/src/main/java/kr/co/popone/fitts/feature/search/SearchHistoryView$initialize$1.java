package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import kr.co.popone.fitts.feature.search.SearchHistoryView.Delegate;

final class SearchHistoryView$initialize$1 implements OnItemClickListener {
    final /* synthetic */ SearchHistoryView this$0;

    SearchHistoryView$initialize$1(SearchHistoryView searchHistoryView) {
        this.this$0 = searchHistoryView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Delegate delegate = this.this$0.getDelegate();
        if (delegate != null) {
            delegate.onItemSelected(i);
        }
    }
}
