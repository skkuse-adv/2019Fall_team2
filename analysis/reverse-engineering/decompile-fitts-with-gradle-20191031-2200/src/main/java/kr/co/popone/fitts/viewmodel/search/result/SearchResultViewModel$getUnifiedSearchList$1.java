package kr.co.popone.fitts.viewmodel.search.result;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.search.IntergratedSearchViewData;

final class SearchResultViewModel$getUnifiedSearchList$1<T> implements Consumer<IntergratedSearchViewData> {
    final /* synthetic */ SearchResultViewModel this$0;

    SearchResultViewModel$getUnifiedSearchList$1(SearchResultViewModel searchResultViewModel) {
        this.this$0 = searchResultViewModel;
    }

    public final void accept(IntergratedSearchViewData intergratedSearchViewData) {
        this.this$0.unifiedResultLiveData.setValue(intergratedSearchViewData);
        this.this$0.unifiedNetworkState.setValue(NetworkState.Companion.getINIT_LOADED());
    }
}
