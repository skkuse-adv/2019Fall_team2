package kr.co.popone.fitts.viewmodel.search.home;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.search.SearchRecommendViewData;

final class SearchViewModel$requestRecommendSearch$1<T1, T2> implements BiConsumer<SearchRecommendViewData, Throwable> {
    final /* synthetic */ SearchViewModel this$0;

    SearchViewModel$requestRecommendSearch$1(SearchViewModel searchViewModel) {
        this.this$0 = searchViewModel;
    }

    public final void accept(SearchRecommendViewData searchRecommendViewData, Throwable th) {
        if (searchRecommendViewData != null) {
            this.this$0.getNetworkState().setValue(NetworkState.Companion.getLOADED());
            this.this$0.getRecommendKeywords().setValue(searchRecommendViewData.getRecommendKeywords());
            this.this$0.getStyleKeywords().setValue(searchRecommendViewData.getRecommendStyles());
            return;
        }
        this.this$0.getNetworkState().setValue(NetworkState.Companion.error(th));
    }
}
