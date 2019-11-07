package kr.co.popone.fitts.viewmodel.order;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
import kr.co.popone.fitts.model.order.OrderExtensionKt;

final class OrderViewModel$makeOrder$$inlined$with$lambda$3<T> implements Consumer<OrderDetailListItem> {
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$makeOrder$$inlined$with$lambda$3(OrderViewModel orderViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.this$0 = orderViewModel;
    }

    public final void accept(OrderDetailListItem orderDetailListItem) {
        MutableLiveData orderCompleteLiveData = this.this$0.getOrderCompleteLiveData();
        Intrinsics.checkExpressionValueIsNotNull(orderDetailListItem, "it");
        orderCompleteLiveData.setValue(OrderExtensionKt.mapToOrderCompleteViewData(orderDetailListItem));
        this.this$0.purchaseLog(orderDetailListItem.getLineItems());
    }
}
