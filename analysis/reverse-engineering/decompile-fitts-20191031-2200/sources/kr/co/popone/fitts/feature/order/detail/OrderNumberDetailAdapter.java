package kr.co.popone.fitts.feature.order.detail;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderNumberDetailAdapter extends Adapter<ViewHolder> {
    private List<OrderListDetailViewData> items = new ArrayList();
    private OrderListItemViewData orderListItemViewData;

    public final void updateItem(@NotNull OrderListItemViewData orderListItemViewData2) {
        Intrinsics.checkParameterIsNotNull(orderListItemViewData2, "orderListItemViewData");
        this.orderListItemViewData = orderListItemViewData2;
        this.items = orderListItemViewData2.getOrderListDetails();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558635) {
            return OrderPriceSummarizeViewHolder.Companion.create(viewGroup);
        }
        if (i == 2131558667) {
            return OrderDetailProductViewHolder.Companion.create(viewGroup);
        }
        throw new IllegalArgumentException("unknown view type");
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof OrderPriceSummarizeViewHolder) {
            ((OrderPriceSummarizeViewHolder) viewHolder).bindTo(this.orderListItemViewData);
        } else if (viewHolder instanceof OrderDetailProductViewHolder) {
            ((OrderDetailProductViewHolder) viewHolder).bindTo((OrderListDetailViewData) this.items.get(i), i);
        }
    }

    public int getItemViewType(int i) {
        return i == this.items.size() ? C0013R$layout.item_detail_summarize : C0013R$layout.item_order_detail_product;
    }
}
