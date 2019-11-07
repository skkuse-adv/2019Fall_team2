package kr.co.popone.fitts.feature.order.detail;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderDetailAdapter extends Adapter<ViewHolder> {
    @NotNull
    private List<OrderListItemViewData> items = new ArrayList();

    @NotNull
    public final List<OrderListItemViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return OrderDetailViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof OrderDetailViewHolder) {
            ((OrderDetailViewHolder) viewHolder).bindTo((OrderListItemViewData) this.items.get(i));
        }
    }
}
