package kr.co.popone.fitts.feature.order.orderlist;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderNumberDetailWithButtonAdapter extends Adapter<OrderTitleViewHolder> {
    @NotNull
    private List<OrderListItemViewData> items = new ArrayList();

    @NotNull
    public final List<OrderListItemViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public OrderTitleViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return OrderTitleViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull OrderTitleViewHolder orderTitleViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(orderTitleViewHolder, "holder");
        orderTitleViewHolder.bindTo((OrderListItemViewData) this.items.get(i));
    }
}
