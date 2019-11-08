package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Consumer;

final class StoreBrowserViewModel$checkProductLink$5<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$checkProductLink$5(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
        this.this$0.getCheckOrderableExceptionLiveData().setValue(th);
        this.this$0.isPartnerSubject.onNext(Boolean.valueOf(false));
    }
}
