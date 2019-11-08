package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.feature.search.SearchBar.State;

final class SearchBar$initialize$1 implements OnClickListener {
    final /* synthetic */ SearchBar this$0;

    SearchBar$initialize$1(SearchBar searchBar) {
        this.this$0 = searchBar;
    }

    public final void onClick(View view) {
        Function0 cancelListener = this.this$0.getCancelListener();
        if (cancelListener != null) {
            Unit unit = (Unit) cancelListener.invoke();
        }
        this.this$0.changeSearchBarState(State.BEFORE_INPUT);
    }
}
