package kr.co.popone.fitts.feature.order.orderlist;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderDetailAdapter extends Adapter<OrderNumberViewHolder> {
    @NotNull
    private List<OrderListDetailViewData> items = new ArrayList();

    @NotNull
    public final List<OrderListDetailViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<OrderListDetailViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public OrderNumberViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return OrderNumberViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull OrderNumberViewHolder orderNumberViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(orderNumberViewHolder, "holder");
        orderNumberViewHolder.bindTo((OrderListDetailViewData) this.items.get(i));
    }
}
