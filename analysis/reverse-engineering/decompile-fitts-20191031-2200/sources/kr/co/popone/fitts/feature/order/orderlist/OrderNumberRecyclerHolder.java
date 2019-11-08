package kr.co.popone.fitts.feature.order.orderlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.text.SimpleDateFormat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderListViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderNumberRecyclerHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final OrderNumberDetailWithButtonAdapter orderNumberDetailWithButtonAdapter = new OrderNumberDetailWithButtonAdapter();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderNumberRecyclerHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_number_recycler, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderNumberRecyclerHolder(inflate);
        }
    }

    public OrderNumberRecyclerHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(@Nullable OrderListViewData orderListViewData) {
        View view = this.itemView;
        if (orderListViewData == null) {
            return null;
        }
        ((RecyclerView) view.findViewById(C0010R$id.recyclerView)).setAdapter(this.orderNumberDetailWithButtonAdapter);
        this.orderNumberDetailWithButtonAdapter.setItems(orderListViewData.getOrderListItems());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        TextView textView = (TextView) view.findViewById(C0010R$id.textOrderDate);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderDate");
        textView.setText(simpleDateFormat.format(orderListViewData.getOrderDate()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textOrderNumber);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textOrderNumber");
        textView2.setText(orderListViewData.getOrderNumber());
        view.findViewById(C0010R$id.viewOrderNumber).setOnClickListener(new OrderNumberRecyclerHolder$bindTo$$inlined$with$lambda$1(view, this, orderListViewData));
        return Unit.INSTANCE;
    }
}
