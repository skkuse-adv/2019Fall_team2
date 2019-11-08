package kr.co.popone.fitts.feature.order;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderProductAdapter extends Adapter<OrderProductItemHolder> {
    @NotNull
    private List<CartLineItemViewData> items = new ArrayList();

    @NotNull
    public final List<CartLineItemViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public final String getOrderProductAsJson() {
        return CartEntityExtensionKt.mapToLineItemsJson(this.items);
    }

    @NotNull
    public OrderProductItemHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return OrderProductItemHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull OrderProductItemHolder orderProductItemHolder, int i) {
        Intrinsics.checkParameterIsNotNull(orderProductItemHolder, "holder");
        orderProductItemHolder.bindTo((CartLineItemViewData) this.items.get(i));
    }
}
