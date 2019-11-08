package kr.co.popone.fitts.paging.recommend;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;

final class FittieRecommendDataSource$loadAfter$1<T> implements Consumer<List<? extends RecommendFittie>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ FittieRecommendDataSource this$0;

    FittieRecommendDataSource$loadAfter$1(FittieRecommendDataSource fittieRecommendDataSource, LoadCallback loadCallback) {
        this.this$0 = fittieRecommendDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<RecommendFittie> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(list);
    }
}
