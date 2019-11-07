package kr.co.popone.fitts.feature.order.orderlist;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class OrderNumberViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderNumberViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_list, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderNumberViewHolder(inflate);
        }
    }

    public OrderNumberViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @SuppressLint({"SetTextI18n"})
    public final void bindTo(@NotNull OrderListDetailViewData orderListDetailViewData) {
        Intrinsics.checkParameterIsNotNull(orderListDetailViewData, "item");
        View view = this.itemView;
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageCover");
        ImageViewExtensionKt.loadImage$default(roundImageView, orderListDetailViewData.getProductCoverImage(), null, 2, null);
        TextView textView = (TextView) view.findViewById(C0010R$id.textProductName);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductName");
        textView.setText(orderListDetailViewData.getProductName());
        TextView textView2 = (TextView) view.findViewById(C0010R$id.textOptions);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textOptions");
        textView2.setText(orderListDetailViewData.getProductOption());
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textCount);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textCount");
        StringBuilder sb = new StringBuilder();
        sb.append(orderListDetailViewData.getProductCount());
        sb.append(" 개");
        textView3.setText(sb.toString());
        TextView textView4 = (TextView) view.findViewById(C0010R$id.textProductState);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "textProductState");
        textView4.setText(orderListDetailViewData.getOrderState().getState());
        ((RoundImageView) view.findViewById(C0010R$id.imageCover)).setOnClickListener(new OrderNumberViewHolder$$special$$inlined$run$lambda$1(orderListDetailViewData, view));
        String str = "textPrice";
        String str2 = "textOriginalPrice";
        String str3 = "textPercent";
        if (orderListDetailViewData.getSpecialDiscountInfo() != null) {
            TextView textView5 = (TextView) view.findViewById(C0010R$id.textPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str);
            textView5.setText(IntExtensionsKt.commaString(orderListDetailViewData.getSpecialDiscountInfo().getSpecialPrice() * ((long) orderListDetailViewData.getProductCount())));
            TextView textView6 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str2);
            textView6.setText(IntExtensionsKt.commaString(orderListDetailViewData.getOriginalPrice() * orderListDetailViewData.getProductCount()));
            double specialPrice = (double) orderListDetailViewData.getSpecialDiscountInfo().getSpecialPrice();
            double originalPrice = (double) orderListDetailViewData.getOriginalPrice();
            Double.isNaN(specialPrice);
            Double.isNaN(originalPrice);
            double d = specialPrice / originalPrice;
            double d2 = (double) 100;
            Double.isNaN(d2);
            int i = (int) (d * d2);
            TextView textView7 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView7, str3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(100 - i);
            sb2.append('%');
            textView7.setText(sb2.toString());
            TextView textView8 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView8, str3);
            ViewExtensionsKt.visible(textView8);
            return;
        }
        TextView textView9 = (TextView) view.findViewById(C0010R$id.textPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView9, str);
        textView9.setText(IntExtensionsKt.commaString(orderListDetailViewData.getProductPrice() * orderListDetailViewData.getProductCount()));
        TextView textView10 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView10, str2);
        textView10.setText(IntExtensionsKt.commaString(orderListDetailViewData.getOriginalPrice() * orderListDetailViewData.getProductCount()));
        TextView textView11 = (TextView) view.findViewById(C0010R$id.textPercent);
        Intrinsics.checkExpressionValueIsNotNull(textView11, str3);
        int i2 = 8;
        textView11.setVisibility(orderListDetailViewData.getDiscountPercentage() == 0 ? 8 : 0);
        TextView textView12 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView12, str2);
        if (orderListDetailViewData.getDiscountPercentage() != 0) {
            i2 = 0;
        }
        textView12.setVisibility(i2);
        TextView textView13 = (TextView) view.findViewById(C0010R$id.textPercent);
        Intrinsics.checkExpressionValueIsNotNull(textView13, str3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(orderListDetailViewData.getDiscountPercentage());
        sb3.append('%');
        textView13.setText(sb3.toString());
    }
}
