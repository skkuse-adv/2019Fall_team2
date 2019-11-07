package kr.co.popone.fitts.feature.cart;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.cart.CartVariantsItem;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;

public final class CartDetailViewHolder extends ViewHolder implements LifecycleObserver {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CartDetailViewHolder create(@NotNull ViewGroup viewGroup, @NotNull Delegate delegate) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_cart_details, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new CartDetailViewHolder(inflate, delegate);
        }
    }

    public interface Delegate {
        void onCheckStateChanged(boolean z, int i);
    }

    public CartDetailViewHolder(@NotNull View view, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(view);
        this.delegate = delegate2;
    }

    @SuppressLint({"SetTextI18n"})
    public final void bindTo(@NotNull CartVariantsItem cartVariantsItem, int i) {
        CartVariantsItem cartVariantsItem2 = cartVariantsItem;
        Intrinsics.checkParameterIsNotNull(cartVariantsItem2, "cartVariantsItem");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductName);
        String str = "textProductName";
        Intrinsics.checkExpressionValueIsNotNull(textView, str);
        textView.setText(cartVariantsItem.getProductName());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textPrice);
        String str2 = "textPrice";
        Intrinsics.checkExpressionValueIsNotNull(textView2, str2);
        textView2.setText(IntExtensionsKt.commaString(cartVariantsItem.getSalesPrice() * cartVariantsItem.getProductCount()));
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        String str3 = "textOriginalPrice";
        Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
        textView3.setText(IntExtensionsKt.commaString(cartVariantsItem.getOriginPrice() * cartVariantsItem.getProductCount()));
        TextView textView4 = (TextView) view.findViewById(C0010R$id.textOptions);
        String str4 = "textOptions";
        Intrinsics.checkExpressionValueIsNotNull(textView4, str4);
        textView4.setText(cartVariantsItem.getProductOption());
        TextView textView5 = (TextView) view.findViewById(C0010R$id.textPercent);
        String str5 = "textPercent";
        Intrinsics.checkExpressionValueIsNotNull(textView5, str5);
        StringBuilder sb = new StringBuilder();
        sb.append(cartVariantsItem.getSaleRate());
        sb.append('%');
        textView5.setText(sb.toString());
        TextView textView6 = (TextView) view.findViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "textProductCount");
        textView6.setText(String.valueOf(cartVariantsItem.getProductCount()));
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageCover");
        ImageViewExtensionKt.loadImage$default(roundImageView, cartVariantsItem.getCoverImageUrl(), null, 2, null);
        ((TextView) view.findViewById(C0010R$id.buttonMinusCount)).setOnClickListener(new CartDetailViewHolder$bindTo$1$1$1(cartVariantsItem2));
        RoundImageView roundImageView2 = (RoundImageView) view.findViewById(C0010R$id.imageCover);
        CartVariantsItem cartVariantsItem3 = cartVariantsItem;
        View view2 = view;
        CartVariantsItem cartVariantsItem4 = cartVariantsItem;
        int i2 = i;
        CartDetailViewHolder$bindTo$$inlined$with$lambda$1 cartDetailViewHolder$bindTo$$inlined$with$lambda$1 = new CartDetailViewHolder$bindTo$$inlined$with$lambda$1(cartVariantsItem3, view2, this, cartVariantsItem4, i2);
        roundImageView2.setOnClickListener(cartDetailViewHolder$bindTo$$inlined$with$lambda$1);
        CheckBox checkBox = (CheckBox) view.findViewById(C0010R$id.checkOrder);
        CartDetailViewHolder$bindTo$$inlined$with$lambda$2 cartDetailViewHolder$bindTo$$inlined$with$lambda$2 = new CartDetailViewHolder$bindTo$$inlined$with$lambda$2(cartVariantsItem3, view2, this, cartVariantsItem4, i2);
        checkBox.setOnCheckedChangeListener(cartDetailViewHolder$bindTo$$inlined$with$lambda$2);
        ((TextView) view.findViewById(C0010R$id.buttonPlusCount)).setOnClickListener(new CartDetailViewHolder$bindTo$1$1$4(cartVariantsItem2));
        ((ImageView) view.findViewById(C0010R$id.imageDelete)).setOnClickListener(new CartDetailViewHolder$bindTo$1$1$5(cartVariantsItem2));
        TextView textView7 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView7, str3);
        Integer saleRate = cartVariantsItem.getSaleRate();
        int i3 = 8;
        int i4 = 0;
        textView7.setVisibility((saleRate != null && saleRate.intValue() == 0) ? 8 : 0);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C0010R$id.productCountLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "productCountLayout");
        linearLayout.setVisibility(cartVariantsItem.isSoldOut() ? 8 : 0);
        TextView textView8 = (TextView) view.findViewById(C0010R$id.textPercent);
        Intrinsics.checkExpressionValueIsNotNull(textView8, str5);
        Integer saleRate2 = cartVariantsItem.getSaleRate();
        textView8.setVisibility((saleRate2 != null && saleRate2.intValue() == 0) ? 8 : 0);
        TextView textView9 = (TextView) view.findViewById(C0010R$id.iconSoldOut);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "iconSoldOut");
        if (cartVariantsItem.isSoldOut()) {
            i3 = 0;
        }
        textView9.setVisibility(i3);
        CheckBox checkBox2 = (CheckBox) view.findViewById(C0010R$id.checkOrder);
        String str6 = "checkOrder";
        Intrinsics.checkExpressionValueIsNotNull(checkBox2, str6);
        checkBox2.setChecked(cartVariantsItem.isSoldOut() ? false : cartVariantsItem.isCheckedOption());
        CheckBox checkBox3 = (CheckBox) view.findViewById(C0010R$id.checkOrder);
        Intrinsics.checkExpressionValueIsNotNull(checkBox3, str6);
        if (cartVariantsItem.isSoldOut()) {
            i4 = 4;
        }
        checkBox3.setVisibility(i4);
        int color = cartVariantsItem.isSoldOut() ? ContextCompat.getColor(view.getContext(), C0006R$color.gray3) : ContextCompat.getColor(view.getContext(), C0006R$color.gray6);
        int color2 = cartVariantsItem.isSoldOut() ? ContextCompat.getColor(view.getContext(), C0006R$color.gray3) : ContextCompat.getColor(view.getContext(), C0006R$color.gray4);
        TextView textView10 = (TextView) view.findViewById(C0010R$id.textProductName);
        Intrinsics.checkExpressionValueIsNotNull(textView10, str);
        Sdk27PropertiesKt.setTextColor(textView10, color);
        TextView textView11 = (TextView) view.findViewById(C0010R$id.textPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView11, str2);
        Sdk27PropertiesKt.setTextColor(textView11, color);
        TextView textView12 = (TextView) view.findViewById(C0010R$id.textWon);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "textWon");
        Sdk27PropertiesKt.setTextColor(textView12, color);
        TextView textView13 = (TextView) view.findViewById(C0010R$id.textOptions);
        Intrinsics.checkExpressionValueIsNotNull(textView13, str4);
        Sdk27PropertiesKt.setTextColor(textView13, color2);
        CheckBox checkBox4 = (CheckBox) view.findViewById(C0010R$id.checkOrder);
        Intrinsics.checkExpressionValueIsNotNull(checkBox4, str6);
        checkBox4.setChecked(cartVariantsItem.isCheckedOption());
    }

    public final void updateCartVariantsItem(@NotNull CartVariantsItem cartVariantsItem) {
        Intrinsics.checkParameterIsNotNull(cartVariantsItem, "cartVariantsItem");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        textView.setText(IntExtensionsKt.commaString(cartVariantsItem.getProductCount()));
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textPrice");
        textView2.setText(IntExtensionsKt.commaString(cartVariantsItem.getSalesPrice() * cartVariantsItem.getProductCount()));
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textOriginalPrice");
        textView3.setText(IntExtensionsKt.commaString(cartVariantsItem.getOriginPrice() * cartVariantsItem.getProductCount()));
    }
}
