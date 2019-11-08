package kr.co.popone.fitts.feature.order.complete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentTransactionExtensionKt;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderState;

final class OrderCompleteRenderActivity$onCreate$3<T> implements Observer<OrderDetailViewData> {
    final /* synthetic */ OrderCompleteRenderActivity this$0;

    OrderCompleteRenderActivity$onCreate$3(OrderCompleteRenderActivity orderCompleteRenderActivity) {
        this.this$0 = orderCompleteRenderActivity;
    }

    public final void onChanged(OrderDetailViewData orderDetailViewData) {
        OrderState orderState = null;
        String paymentMethod = orderDetailViewData != null ? orderDetailViewData.getPaymentMethod() : null;
        if (paymentMethod != null) {
            int hashCode = paymentMethod.hashCode();
            if (hashCode == -303793002 ? paymentMethod.equals("credit_card") : !(hashCode != 846974213 || !paymentMethod.equals("kakaopay"))) {
                FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this.this$0, 2131362058, (Fragment) OrderCompleteRenderPaymentFragment.Companion.newInstance());
                return;
            }
        }
        if (orderDetailViewData != null) {
            orderState = orderDetailViewData.getOrderState();
        }
        if (orderState == OrderState.DEPOSITED) {
            FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this.this$0, 2131362058, (Fragment) OrderCompleteRenderPaymentFragment.Companion.newInstance());
        } else {
            FragmentTransactionExtensionKt.beginTransaction((AppCompatActivity) this.this$0, 2131362058, (Fragment) OrderCompleteRenderReservationFragment.Companion.newInstance());
        }
    }
}
