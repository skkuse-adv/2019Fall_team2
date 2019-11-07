package kr.co.popone.fitts.feature.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DetailPriceSummarizeViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DetailPriceSummarizeViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_detail_summarize, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new DetailPriceSummarizeViewHolder(inflate);
        }
    }

    public DetailPriceSummarizeViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    public final Unit bindTo(@Nullable CartLineItemViewData cartLineItemViewData) {
        View view = this.itemView;
        if (cartLineItemViewData == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductPrice");
        textView.setText(IntExtensionsKt.commaString(cartLineItemViewData.getLineItemProductPrice()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textShippingPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textShippingPrice");
        textView2.setText(IntExtensionsKt.commaString(cartLineItemViewData.getLineItemShippingPrice()));
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textTotalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textTotalPrice");
        textView3.setText(IntExtensionsKt.commaString(cartLineItemViewData.getLineItemOrderPrice()));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Unit updateCartLineItem(@Nullable CartLineItemViewData cartLineItemViewData) {
        View view = this.itemView;
        if (cartLineItemViewData == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductPrice");
        textView.setText(IntExtensionsKt.commaString(cartLineItemViewData.getLineItemProductPrice()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textShippingPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textShippingPrice");
        textView2.setText(IntExtensionsKt.commaString(cartLineItemViewData.getLineItemShippingPrice()));
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textTotalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textTotalPrice");
        textView3.setText(IntExtensionsKt.commaString(cartLineItemViewData.getLineItemOrderPrice()));
        return Unit.INSTANCE;
    }
}
