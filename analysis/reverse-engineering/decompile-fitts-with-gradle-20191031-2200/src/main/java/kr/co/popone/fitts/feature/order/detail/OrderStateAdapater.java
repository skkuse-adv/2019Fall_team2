package kr.co.popone.fitts.feature.order.detail;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.order.detail.OrderStateHolder.OrderStateType;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import kr.co.popone.fitts.model.order.OrderState;
import org.jetbrains.annotations.NotNull;

public final class OrderStateAdapater extends Adapter<OrderStateHolder> {
    private final OrderListDetailViewData item;
    @NotNull
    private List<? extends OrderStateType> items = new ArrayList();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[OrderState.values().length];

        static {
            $EnumSwitchMapping$0[OrderState.PROCEEDING.ordinal()] = 1;
            $EnumSwitchMapping$0[OrderState.PROCEEDED.ordinal()] = 2;
            $EnumSwitchMapping$0[OrderState.DONE.ordinal()] = 3;
            $EnumSwitchMapping$0[OrderState.EXCHANGING.ordinal()] = 4;
            $EnumSwitchMapping$0[OrderState.EXCHANGED.ordinal()] = 5;
            $EnumSwitchMapping$0[OrderState.REFUNDED.ordinal()] = 6;
            $EnumSwitchMapping$0[OrderState.REFUNDING.ordinal()] = 7;
        }
    }

    public OrderStateAdapater(@NotNull OrderListDetailViewData orderListDetailViewData) {
        Intrinsics.checkParameterIsNotNull(orderListDetailViewData, "item");
        this.item = orderListDetailViewData;
    }

    @NotNull
    public final List<OrderStateType> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<? extends OrderStateType> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    public final void updateOrderState(@NotNull OrderState orderState) {
        List<? extends OrderStateType> list;
        List<? extends OrderStateType> list2;
        List<? extends OrderStateType> list3;
        List<? extends OrderStateType> list4;
        Intrinsics.checkParameterIsNotNull(orderState, "orderState");
        switch (WhenMappings.$EnumSwitchMapping$0[orderState.ordinal()]) {
            case 1:
                if (this.item.getPostId() == null) {
                    list = CollectionsKt__CollectionsKt.listOf(OrderStateType.CREATE_POST, OrderStateType.DELIVERY_INQUIRY, OrderStateType.RETURN, OrderStateType.EXCHANGE);
                } else {
                    list = CollectionsKt__CollectionsKt.listOf(OrderStateType.DELIVERY_INQUIRY, OrderStateType.RETURN, OrderStateType.EXCHANGE);
                }
                this.items = list;
                break;
            case 2:
                if (this.item.getPostId() == null) {
                    list2 = CollectionsKt__CollectionsKt.listOf(OrderStateType.CREATE_POST, OrderStateType.DELIVERY_INQUIRY, OrderStateType.RETURN, OrderStateType.EXCHANGE);
                } else {
                    list2 = CollectionsKt__CollectionsKt.listOf(OrderStateType.DELIVERY_INQUIRY, OrderStateType.RETURN, OrderStateType.EXCHANGE);
                }
                this.items = list2;
                break;
            case 3:
                if (this.item.getPostId() == null) {
                    list3 = CollectionsKt__CollectionsKt.listOf(OrderStateType.CREATE_POST, OrderStateType.DELIVERY_INQUIRY);
                } else {
                    list3 = CollectionsKt__CollectionsJVMKt.listOf(OrderStateType.DELIVERY_INQUIRY);
                }
                this.items = list3;
                break;
            case 4:
                this.items = CollectionsKt__CollectionsJVMKt.listOf(OrderStateType.EXCHANGE_DETAIL);
                break;
            case 5:
                if (this.item.getPostId() == null) {
                    list4 = CollectionsKt__CollectionsKt.listOf(OrderStateType.CREATE_POST, OrderStateType.EXCHANGE_DETAIL);
                } else {
                    list4 = CollectionsKt__CollectionsJVMKt.listOf(OrderStateType.EXCHANGE_DETAIL);
                }
                this.items = list4;
                break;
            case 6:
                this.items = CollectionsKt__CollectionsJVMKt.listOf(OrderStateType.REFUND_DETAIL);
                break;
            case 7:
                this.items = CollectionsKt__CollectionsJVMKt.listOf(OrderStateType.RETURN_DETAIL);
                break;
        }
        notifyDataSetChanged();
    }

    @NotNull
    public OrderStateHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return OrderStateHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull OrderStateHolder orderStateHolder, int i) {
        Intrinsics.checkParameterIsNotNull(orderStateHolder, "holder");
        orderStateHolder.bindTo(this.item, (OrderStateType) this.items.get(i));
    }
}
