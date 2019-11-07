package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.BiConsumer;

final class StoreBrowserViewModel$startShowStoreInfoBubble$1<T1, T2> implements BiConsumer<Long, Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$startShowStoreInfoBubble$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(Long l, Throwable th) {
        this.this$0.isShowStoreStoreInfoBubble().setValue(Boolean.valueOf(false));
    }
}
