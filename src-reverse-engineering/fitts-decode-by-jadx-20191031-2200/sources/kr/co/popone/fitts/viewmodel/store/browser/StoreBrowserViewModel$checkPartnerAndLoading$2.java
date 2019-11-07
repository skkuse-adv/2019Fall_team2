package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Consumer;

final class StoreBrowserViewModel$checkPartnerAndLoading$2<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$checkPartnerAndLoading$2(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.showStoreLoadingView(false, "핏츠 스토어");
    }
}
