package kr.co.popone.fitts.feature.search.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kr.co.popone.fitts.C0010R$id;

final class SearchActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ SearchActivity this$0;

    SearchActivity$onCreate$1(SearchActivity searchActivity) {
        this.this$0 = searchActivity;
    }

    public final void onClick(View view) {
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editSearchKeyword)).setText("");
    }
}
