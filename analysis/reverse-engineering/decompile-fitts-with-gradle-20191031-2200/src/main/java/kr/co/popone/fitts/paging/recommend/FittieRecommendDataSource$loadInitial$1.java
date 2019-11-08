package kr.co.popone.fitts.paging.recommend;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.FittieRecommendHeader;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;

final class FittieRecommendDataSource$loadInitial$1<T> implements Consumer<List<? extends RecommendFittie>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ FittieRecommendDataSource this$0;

    FittieRecommendDataSource$loadInitial$1(FittieRecommendDataSource fittieRecommendDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = fittieRecommendDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<RecommendFittie> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.$callback.onResult(CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(CollectionsKt__CollectionsJVMKt.listOf(FittieRecommendHeader.INSTANCE), list)));
    }
}
