package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Consumer;

final class StoreBrowserViewModel$startLoadingTimer$1<T> implements Consumer<Long> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$startLoadingTimer$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(Long l) {
        this.this$0.loadingTimerSubject.onNext(Boolean.valueOf(true));
    }
}
