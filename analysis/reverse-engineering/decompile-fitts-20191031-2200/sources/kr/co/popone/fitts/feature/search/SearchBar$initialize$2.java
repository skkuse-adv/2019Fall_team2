package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kr.co.popone.fitts.C0010R$id;

final class SearchBar$initialize$2 implements OnClickListener {
    final /* synthetic */ SearchBar this$0;

    SearchBar$initialize$2(SearchBar searchBar) {
        this.this$0 = searchBar;
    }

    public final void onClick(View view) {
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editSearchKeyword)).setText("");
    }
}
