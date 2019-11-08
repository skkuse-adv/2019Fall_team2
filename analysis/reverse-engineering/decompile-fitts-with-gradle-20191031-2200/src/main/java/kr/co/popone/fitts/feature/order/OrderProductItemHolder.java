package kr.co.popone.fitts.feature.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import kr.co.popone.fitts.ui.decorator.ProductDetailListDecorator;
import org.jetbrains.annotations.NotNull;

public final class OrderProductItemHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    private final OrderProductDetailAdapter orderProductDetailAdapter = new OrderProductDetailAdapter();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderProductItemHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recycler_with_title, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderProductItemHolder(inflate);
        }
    }

    public OrderProductItemHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "item");
        View view = this.itemView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.cartContentRecyclerView);
        recyclerView.setAdapter(this.orderProductDetailAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new ProductDetailListDecorator());
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textStoreTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textStoreTitle");
        textView.setText(cartLineItemViewData.getStoreTitle());
        this.orderProductDetailAdapter.setCartLineItem(cartLineItemViewData);
    }
}
