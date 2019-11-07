package kr.co.popone.fitts.viewmodel.store.home;

import io.reactivex.functions.Consumer;

final class StoreFeedViewModel$removeLikeProductClick$2<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreFeedViewModel this$0;

    StoreFeedViewModel$removeLikeProductClick$2(StoreFeedViewModel storeFeedViewModel) {
        this.this$0 = storeFeedViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
