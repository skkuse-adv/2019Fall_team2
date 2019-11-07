package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.BiConsumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;

final class StoreBrowserViewModel$getSigleItemVariantInfo$2<T1, T2> implements BiConsumer<OrderableOptionViewData, Throwable> {
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$getSigleItemVariantInfo$2(StoreBrowserViewModel storeBrowserViewModel) {
        this.this$0 = storeBrowserViewModel;
    }

    public final void accept(OrderableOptionViewData orderableOptionViewData, Throwable th) {
        if (orderableOptionViewData == null) {
            this.this$0.getErrorLiveData().setValue(th);
        } else if (Intrinsics.areEqual((Object) orderableOptionViewData.getProductState(), (Object) "sold_out")) {
            this.this$0.getSoldOutLiveData().setValue(Unit.INSTANCE);
        } else {
            this.this$0.getOrderableOptionLiveData().setValue(orderableOptionViewData);
        }
    }
}
