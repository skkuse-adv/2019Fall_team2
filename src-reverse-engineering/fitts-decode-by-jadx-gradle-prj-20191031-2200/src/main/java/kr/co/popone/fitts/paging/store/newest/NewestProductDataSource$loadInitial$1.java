package kr.co.popone.fitts.paging.store.newest;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Triple;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;

final class NewestProductDataSource$loadInitial$1<T> implements Consumer<Triple<? extends String, ? extends SpecialDiscountInfo, ? extends List<? extends FeedItem>>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ NewestProductDataSource this$0;

    NewestProductDataSource$loadInitial$1(NewestProductDataSource newestProductDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = newestProductDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(Triple<String, SpecialDiscountInfo, ? extends List<? extends FeedItem>> triple) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0._version = (String) triple.getFirst();
        this.this$0.getSpecialDiscount().postValue(triple.getSecond());
        this.$callback.onResult((List) triple.getThird());
    }
}
