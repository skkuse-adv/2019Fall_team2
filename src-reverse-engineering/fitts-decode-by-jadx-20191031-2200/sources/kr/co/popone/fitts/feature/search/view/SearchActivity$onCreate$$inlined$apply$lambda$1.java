package kr.co.popone.fitts.feature.search.view;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;

final class SearchActivity$onCreate$$inlined$apply$lambda$1 implements OnEditorActionListener {
    final /* synthetic */ SearchActivity this$0;

    SearchActivity$onCreate$$inlined$apply$lambda$1(SearchActivity searchActivity) {
        this.this$0 = searchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean access$handleKeywordInput = this.this$0.handleKeywordInput(i);
        if (access$handleKeywordInput) {
            Intrinsics.checkExpressionValueIsNotNull(textView, "view");
            CharSequence text = textView.getText();
            String str = "view.text";
            Intrinsics.checkExpressionValueIsNotNull(text, str);
            if (text.length() > 0) {
                SearchViewModel viewModel = this.this$0.getViewModel();
                CharSequence text2 = textView.getText();
                Intrinsics.checkExpressionValueIsNotNull(text2, str);
                viewModel.searchButtonClick(text2, "direct");
            }
        }
        return access$handleKeywordInput;
    }
}
