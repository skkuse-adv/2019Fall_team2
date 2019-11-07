package kr.co.popone.fitts.paging.store.bridge;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class StoreBridgeDataSource$loadAfter$2<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreBridgeDataSource this$0;

    StoreBridgeDataSource$loadAfter$2(StoreBridgeDataSource storeBridgeDataSource) {
        this.this$0 = storeBridgeDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
