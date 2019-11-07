package kr.co.popone.fitts.feature.order.detail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import org.jetbrains.annotations.NotNull;

public final class OrderDetailViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    private OrderNumberDetailAdapter orderNumberDetailAdapter = new OrderNumberDetailAdapter();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderDetailViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_detail_recycler, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderDetailViewHolder(inflate);
        }
    }

    public OrderDetailViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @NotNull
    public final OrderNumberDetailAdapter getOrderNumberDetailAdapter() {
        return this.orderNumberDetailAdapter;
    }

    public final void setOrderNumberDetailAdapter(@NotNull OrderNumberDetailAdapter orderNumberDetailAdapter2) {
        Intrinsics.checkParameterIsNotNull(orderNumberDetailAdapter2, "<set-?>");
        this.orderNumberDetailAdapter = orderNumberDetailAdapter2;
    }

    public final void bindTo(@NotNull OrderListItemViewData orderListItemViewData) {
        Intrinsics.checkParameterIsNotNull(orderListItemViewData, "item");
        View view = this.itemView;
        ((RecyclerView) view.findViewById(C0010R$id.productRecyclerView)).setAdapter(this.orderNumberDetailAdapter);
        this.orderNumberDetailAdapter.updateItem(orderListItemViewData);
        TextView textView = (TextView) view.findViewById(C0010R$id.textTitleShop);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTitleShop");
        textView.setText(orderListItemViewData.getStoreName());
        ((LinearLayout) view.findViewById(C0010R$id.buttonContact)).setOnClickListener(new OrderDetailViewHolder$bindTo$$inlined$with$lambda$1(view, this, orderListItemViewData));
    }
}
