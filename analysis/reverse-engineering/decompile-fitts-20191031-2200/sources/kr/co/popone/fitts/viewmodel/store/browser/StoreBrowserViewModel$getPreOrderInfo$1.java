package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.BiConsumer;
import kotlin.Pair;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.product.AffiliatesProduct;
import kr.co.popone.fitts.model.product.OrderableType;

final class StoreBrowserViewModel$getPreOrderInfo$1<T1, T2> implements BiConsumer<OrderInfoViewData, Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$getPreOrderInfo$1(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(OrderInfoViewData orderInfoViewData, Throwable th) {
        if (orderInfoViewData != null) {
            this.this$0.getOrderInfoLiveData().setValue(new Pair(orderInfoViewData, this.this$0.postId));
            return;
        }
        AffiliatesProduct affiliatesProduct = (AffiliatesProduct) this.this$0.getAffiliatesProductLiveData().getValue();
        if ((affiliatesProduct != null ? affiliatesProduct.getOrderableType() : null) == OrderableType.SPECIAL_DISCOUNT) {
            this.this$0.getErrorMessageLiveData().setValue(th);
        } else {
            this.this$0.getErrorLiveData().setValue(th);
        }
    }
}
