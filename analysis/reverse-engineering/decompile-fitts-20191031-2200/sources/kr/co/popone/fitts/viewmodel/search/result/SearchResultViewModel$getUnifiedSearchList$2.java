package kr.co.popone.fitts.viewmodel.search.result;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class SearchResultViewModel$getUnifiedSearchList$2<T> implements Consumer<Throwable> {
    final /* synthetic */ SearchResultViewModel this$0;

    SearchResultViewModel$getUnifiedSearchList$2(SearchResultViewModel searchResultViewModel) {
        this.this$0 = searchResultViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.unifiedNetworkState.setValue(NetworkState.Companion.error(th));
        StringBuilder sb = new StringBuilder();
        sb.append("SearchResultViewModel::ERROR(");
        sb.append(th.getMessage());
        sb.append("))");
        Logger.d(sb.toString(), new Object[0]);
    }
}
