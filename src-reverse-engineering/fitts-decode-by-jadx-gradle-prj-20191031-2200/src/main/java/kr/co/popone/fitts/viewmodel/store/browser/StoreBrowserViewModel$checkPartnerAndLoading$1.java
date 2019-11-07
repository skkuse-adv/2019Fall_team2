package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.store.StoreInfo;

final class StoreBrowserViewModel$checkPartnerAndLoading$1<T> implements Consumer<StoreInfo> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$checkPartnerAndLoading$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(StoreInfo storeInfo) {
        this.this$0.showStoreLoadingView(true, storeInfo.getStoreName());
    }
}
