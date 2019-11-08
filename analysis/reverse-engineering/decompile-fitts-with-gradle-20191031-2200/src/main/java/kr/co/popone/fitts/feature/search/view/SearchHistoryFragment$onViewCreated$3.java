package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.adapter.SearchHistoryAdapter;

final class SearchHistoryFragment$onViewCreated$3<T> implements Observer<List<? extends String>> {
    final /* synthetic */ SearchHistoryAdapter $searchHistoryAdapter;

    SearchHistoryFragment$onViewCreated$3(SearchHistoryAdapter searchHistoryAdapter) {
        this.$searchHistoryAdapter = searchHistoryAdapter;
    }

    public final void onChanged(List<String> list) {
        SearchHistoryAdapter searchHistoryAdapter = this.$searchHistoryAdapter;
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        searchHistoryAdapter.submitList(list);
    }
}
