package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.product.AffiliatesProduct;

final class StoreBrowserViewModel$checkProductLink$4<T> implements Consumer<AffiliatesProduct> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$checkProductLink$4(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(AffiliatesProduct affiliatesProduct) {
        this.this$0.isProductSubject.onNext(affiliatesProduct);
        this.this$0.isPartnerSubject.onNext(Boolean.valueOf(affiliatesProduct.isProduct()));
    }
}
