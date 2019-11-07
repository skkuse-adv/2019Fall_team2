package kr.co.popone.fitts.feature.order.orderlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import kr.co.popone.fitts.ui.decorator.OrderDetailDecorator;
import org.jetbrains.annotations.NotNull;

public final class OrderTitleViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final OrderDetailAdapter orderDetailAdapter = new OrderDetailAdapter();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderTitleViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_title_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderTitleViewHolder(inflate);
        }
    }

    public OrderTitleViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull OrderListItemViewData orderListItemViewData) {
        Intrinsics.checkParameterIsNotNull(orderListItemViewData, "item");
        View view = this.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.recyclerOrderDetail);
        recyclerView.setAdapter(this.orderDetailAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            Context context = recyclerView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            recyclerView.addItemDecoration(new OrderDetailDecorator(context, C0008R$drawable.divider_line_gray));
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTitle");
        textView.setText(orderListItemViewData.getStoreName());
        this.orderDetailAdapter.setItems(orderListItemViewData.getOrderListDetails());
    }
}
