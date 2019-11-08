package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.BiConsumer;

final class StoreBrowserViewModel$getTotalVariantOptions$1<T1, T2> implements BiConsumer<Integer, Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$getTotalVariantOptions$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(Integer num, Throwable th) {
        if (num != null) {
            this.this$0.getTotalPriceLiveData().setValue(num);
        } else {
            this.this$0.getTotalPriceErrorLiveData().setValue(th);
        }
    }
}
