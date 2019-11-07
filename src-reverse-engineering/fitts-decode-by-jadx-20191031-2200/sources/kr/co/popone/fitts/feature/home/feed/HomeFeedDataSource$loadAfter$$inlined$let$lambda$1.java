package kr.co.popone.fitts.feature.home.feed;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class HomeFeedDataSource$loadAfter$$inlined$let$lambda$1<T> implements Consumer<Pair<? extends String, ? extends List<? extends Feed>>> {
    final /* synthetic */ LoadCallback $callback$inlined;
    final /* synthetic */ HomeFeedDataSource this$0;

    HomeFeedDataSource$loadAfter$$inlined$let$lambda$1(String str, HomeFeedDataSource homeFeedDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = homeFeedDataSource;
        this.$callback$inlined = loadCallback;
    }

    public final void accept(Pair<String, ? extends List<Feed>> pair) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback$inlined.onResult((List) pair.getSecond());
    }
}
