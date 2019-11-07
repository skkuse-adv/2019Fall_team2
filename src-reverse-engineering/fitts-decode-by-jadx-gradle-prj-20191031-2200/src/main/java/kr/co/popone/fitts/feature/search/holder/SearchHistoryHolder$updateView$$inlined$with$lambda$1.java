package kr.co.popone.fitts.feature.search.holder;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.search.holder.SearchHistoryHolder.Delegate;

final class SearchHistoryHolder$updateView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ String $item$inlined;
    final /* synthetic */ SearchHistoryHolder this$0;

    SearchHistoryHolder$updateView$$inlined$with$lambda$1(SearchHistoryHolder searchHistoryHolder, String str) {
        this.this$0 = searchHistoryHolder;
        this.$item$inlined = str;
    }

    public final void onClick(View view) {
        Delegate delegate = this.this$0.getDelegate();
        if (delegate != null) {
            delegate.onHistoryClick(this.$item$inlined);
        }
    }
}
