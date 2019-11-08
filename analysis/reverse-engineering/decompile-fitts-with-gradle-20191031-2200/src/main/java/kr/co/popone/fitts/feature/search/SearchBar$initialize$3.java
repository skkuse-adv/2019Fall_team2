package kr.co.popone.fitts.feature.search;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.SearchBar.State;

final class SearchBar$initialize$3 implements OnEditorActionListener {
    final /* synthetic */ SearchBar this$0;

    SearchBar$initialize$3(SearchBar searchBar) {
        this.this$0 = searchBar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkExpressionValueIsNotNull(textView, "v");
        CharSequence text = textView.getText();
        Intrinsics.checkExpressionValueIsNotNull(text, "v.text");
        if (!(!StringsKt__StringsJVMKt.isBlank(text)) || i != 3) {
            return false;
        }
        this.this$0.searchSubject.onNext(textView.getText().toString());
        this.this$0.changeSearchBarState(State.AFTER_INPUT);
        return true;
    }
}
