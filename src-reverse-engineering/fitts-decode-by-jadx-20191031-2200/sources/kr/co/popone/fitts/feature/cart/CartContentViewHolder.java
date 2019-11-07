package kr.co.popone.fitts.feature.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import org.jetbrains.annotations.NotNull;

public final class CartContentViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CartContentViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_recycler_with_title, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new CartContentViewHolder(inflate);
        }
    }

    public interface Delegate {
        void onLineItemCleared(@NotNull CartLineItemViewData cartLineItemViewData);
    }

    public CartContentViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "cartItemViewData");
        View view = this.itemView;
        ((RecyclerView) view.findViewById(C0010R$id.cartContentRecyclerView)).setAdapter(new CartDetailAdatper());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.cartContentRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "cartContentRecyclerView");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((CartDetailAdatper) adapter).setCartLineItem(cartLineItemViewData);
            TextView textView = (TextView) view.findViewById(C0010R$id.textStoreTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textStoreTitle");
            textView.setText(cartLineItemViewData.getStoreTitle());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.cart.CartDetailAdatper");
    }

    public final void updateLineItem(@NotNull CartLineItemViewData cartLineItemViewData) {
        Intrinsics.checkParameterIsNotNull(cartLineItemViewData, "cartItemViewData");
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(C0010R$id.cartContentRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "cartContentRecyclerView");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((CartDetailAdatper) adapter).updateCartLineItem(cartLineItemViewData);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.cart.CartDetailAdatper");
    }
}
