package kr.co.popone.fitts.feature.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartSummarizeViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CartSummarizeViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_cart_summarize, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new CartSummarizeViewHolder(inflate);
        }
    }

    public CartSummarizeViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(@Nullable CartLineItemsDomain cartLineItemsDomain) {
        View view = this.itemView;
        if (cartLineItemsDomain == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textCountView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textCountView");
        textView.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalProductCount()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textTotalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textTotalPrice");
        textView2.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalProductPrice()));
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textShippingPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textShippingPrice");
        textView3.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalShippingPrice()));
        TextView textView4 = (TextView) view.findViewById(C0010R$id.textPaymentPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "textPaymentPrice");
        textView4.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalOrderPrice()));
        ((Button) view.findViewById(C0010R$id.buttonBuy)).setOnClickListener(CartSummarizeViewHolder$bindTo$1$1$1.INSTANCE);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Unit updateCartLineItemsDomain(@Nullable CartLineItemsDomain cartLineItemsDomain) {
        View view = this.itemView;
        if (cartLineItemsDomain == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textCountView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textCountView");
        textView.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalProductCount()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textTotalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textTotalPrice");
        textView2.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalProductPrice()));
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textShippingPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textShippingPrice");
        textView3.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalShippingPrice()));
        TextView textView4 = (TextView) view.findViewById(C0010R$id.textPaymentPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "textPaymentPrice");
        textView4.setText(IntExtensionsKt.commaString(cartLineItemsDomain.getTotalOrderPrice()));
        return Unit.INSTANCE;
    }
}
