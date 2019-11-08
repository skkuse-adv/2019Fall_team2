package kr.co.popone.fitts.paging.search;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.remote.search.KeywordSearchFittieResult;
import kr.co.popone.fitts.model.search.SearchResult.FittieSearchResult;
import kr.co.popone.fitts.model.search.SearchResult.SearchResultCount;

final class FittieResultDataSource$loadInitial$1<T> implements Consumer<KeywordSearchFittieResult> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ FittieResultDataSource this$0;

    FittieResultDataSource$loadInitial$1(FittieResultDataSource fittieResultDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = fittieResultDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(KeywordSearchFittieResult keywordSearchFittieResult) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.isEmptyFitties().postValue(Boolean.valueOf(keywordSearchFittieResult.getCount() < 1));
        List[] listArr = new List[2];
        listArr[0] = CollectionsKt__CollectionsJVMKt.listOf(new SearchResultCount(keywordSearchFittieResult.getCount(), "명의 핏티"));
        List<User> fitties = keywordSearchFittieResult.getFitties();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fitties, 10));
        for (User fittieSearchResult : fitties) {
            arrayList.add(new FittieSearchResult(fittieSearchResult));
        }
        listArr[1] = arrayList;
        this.$callback.onResult(CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(listArr)));
    }
}
