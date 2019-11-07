package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Action;

final class StoreBrowserViewModel$registerVariantToCart$1 implements Action {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$registerVariantToCart$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void run() {
        this.this$0.getToastLiveData().setValue("장바구니에 추가되었습니다.");
    }
}
