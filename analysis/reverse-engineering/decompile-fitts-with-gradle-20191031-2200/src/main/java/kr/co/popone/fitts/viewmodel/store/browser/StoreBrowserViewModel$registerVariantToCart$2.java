package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Consumer;

final class StoreBrowserViewModel$registerVariantToCart$2<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$registerVariantToCart$2(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
