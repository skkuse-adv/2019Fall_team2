package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel.SearchState;

final class SearchActivity$onCreate$5<T> implements Observer<SearchState> {
    final /* synthetic */ SearchActivity this$0;

    SearchActivity$onCreate$5(SearchActivity searchActivity) {
        this.this$0 = searchActivity;
    }

    public final void onChanged(SearchState searchState) {
        SearchActivity searchActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(searchState, "it");
        searchActivity.updateSearchView(searchState);
    }
}
