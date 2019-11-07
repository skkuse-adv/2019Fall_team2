package kr.co.popone.fitts.feature.order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.cart.CartVariantsItem;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class OrderProductDetailItemHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderProductDetailItemHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_product_details, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderProductDetailItemHolder(inflate);
        }
    }

    public OrderProductDetailItemHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bindTo(@NotNull CartVariantsItem cartVariantsItem) {
        Intrinsics.checkParameterIsNotNull(cartVariantsItem, "cartVariantsItem");
        View view = this.itemView;
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageCover");
        ImageViewExtensionKt.loadImage$default(roundImageView, cartVariantsItem.getCoverImageUrl(), null, 2, null);
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductName");
        textView.setText(cartVariantsItem.getProductName());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textOptions);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textOptions");
        textView2.setText(cartVariantsItem.getProductOption());
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textCount);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textCount");
        StringBuilder sb = new StringBuilder();
        sb.append(cartVariantsItem.getProductCount());
        sb.append(44060);
        textView3.setText(sb.toString());
        String str = "textPrice";
        String str2 = "textOriginalPrice";
        String str3 = "textPercent";
        if (cartVariantsItem.getSpecialDiscountInfo() != null) {
            TextView textView4 = (TextView) view.findViewById(C0010R$id.textPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str);
            textView4.setText(IntExtensionsKt.commaString(cartVariantsItem.getSpecialDiscountInfo().getSpecialPrice() * ((long) cartVariantsItem.getProductCount())));
            TextView textView5 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str2);
            textView5.setText(IntExtensionsKt.commaString(cartVariantsItem.getOriginPrice() * cartVariantsItem.getProductCount()));
            double specialPrice = (double) cartVariantsItem.getSpecialDiscountInfo().getSpecialPrice();
            double originPrice = (double) cartVariantsItem.getOriginPrice();
            Double.isNaN(specialPrice);
            Double.isNaN(originPrice);
            double d = specialPrice / originPrice;
            double d2 = (double) 100;
            Double.isNaN(d2);
            int i = (int) (d * d2);
            TextView textView6 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(100 - i);
            sb2.append('%');
            textView6.setText(sb2.toString());
            TextView textView7 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView7, str3);
            ViewExtensionsKt.visible(textView7);
            return;
        }
        TextView textView8 = (TextView) view.findViewById(C0010R$id.textPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView8, str);
        textView8.setText(IntExtensionsKt.commaString(cartVariantsItem.getSalesPrice() * cartVariantsItem.getProductCount()));
        TextView textView9 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView9, str2);
        textView9.setText(IntExtensionsKt.commaString(cartVariantsItem.getOriginPrice() * cartVariantsItem.getProductCount()));
        TextView textView10 = (TextView) view.findViewById(C0010R$id.textPercent);
        Intrinsics.checkExpressionValueIsNotNull(textView10, str3);
        Integer saleRate = cartVariantsItem.getSaleRate();
        int i2 = 8;
        textView10.setVisibility((saleRate != null && saleRate.intValue() == 0) ? 8 : 0);
        TextView textView11 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView11, str2);
        Integer saleRate2 = cartVariantsItem.getSaleRate();
        if (saleRate2 == null || saleRate2.intValue() != 0) {
            i2 = 0;
        }
        textView11.setVisibility(i2);
        TextView textView12 = (TextView) view.findViewById(C0010R$id.textPercent);
        Intrinsics.checkExpressionValueIsNotNull(textView12, str3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cartVariantsItem.getSaleRate());
        sb3.append('%');
        textView12.setText(sb3.toString());
    }
}
