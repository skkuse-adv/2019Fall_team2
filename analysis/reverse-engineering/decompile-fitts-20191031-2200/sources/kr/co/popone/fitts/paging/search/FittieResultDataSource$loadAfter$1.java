package kr.co.popone.fitts.paging.search;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult;
import kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult;

final class FittieResultDataSource$loadAfter$1<T> implements Consumer<KeywordSearchFittieResult> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ FittieResultDataSource this$0;

    FittieResultDataSource$loadAfter$1(FittieResultDataSource fittieResultDataSource, LoadCallback loadCallback) {
        this.this$0 = fittieResultDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(KeywordSearchFittieResult keywordSearchFittieResult) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        LoadCallback loadCallback = this.$callback;
        List<User> fitties = keywordSearchFittieResult.getFitties();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fitties, 10));
        for (User fittieSearchResult : fitties) {
            arrayList.add(new FittieSearchResult(fittieSearchResult));
        }
        loadCallback.onResult(arrayList);
    }
}
