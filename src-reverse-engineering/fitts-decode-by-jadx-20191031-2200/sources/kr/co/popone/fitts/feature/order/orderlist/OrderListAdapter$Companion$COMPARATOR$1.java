package kr.co.popone.fitts.feature.order.orderlist;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderListAdapter$Companion$COMPARATOR$1 extends ItemCallback<OrderListViewData> {
    OrderListAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull OrderListViewData orderListViewData, @NotNull OrderListViewData orderListViewData2) {
        Intrinsics.checkParameterIsNotNull(orderListViewData, "oldItem");
        Intrinsics.checkParameterIsNotNull(orderListViewData2, "newItem");
        return orderListViewData.getOrderId() == orderListViewData2.getOrderId();
    }

    public boolean areContentsTheSame(@NotNull OrderListViewData orderListViewData, @NotNull OrderListViewData orderListViewData2) {
        Intrinsics.checkParameterIsNotNull(orderListViewData, "oldItem");
        Intrinsics.checkParameterIsNotNull(orderListViewData2, "newItem");
        return orderListViewData.getOrderId() == orderListViewData2.getOrderId();
    }
}
