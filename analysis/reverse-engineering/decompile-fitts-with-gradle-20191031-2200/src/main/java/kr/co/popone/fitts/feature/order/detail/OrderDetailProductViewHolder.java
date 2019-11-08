package kr.co.popone.fitts.feature.order.detail;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderListDetailViewData;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.ui.decorator.OrderStateDecorator;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class OrderDetailProductViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public OrderStateAdapater orderStateAdapter;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderDetailProductViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_order_detail_product, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new OrderDetailProductViewHolder(inflate);
        }
    }

    public OrderDetailProductViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @NotNull
    public final OrderStateAdapater getOrderStateAdapter() {
        OrderStateAdapater orderStateAdapater = this.orderStateAdapter;
        if (orderStateAdapater == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderStateAdapter");
        }
        return orderStateAdapater;
    }

    public final void setOrderStateAdapter(@NotNull OrderStateAdapater orderStateAdapater) {
        Intrinsics.checkParameterIsNotNull(orderStateAdapater, "<set-?>");
        this.orderStateAdapter = orderStateAdapater;
    }

    @SuppressLint({"SetTextI18n"})
    public final void bindTo(@NotNull OrderListDetailViewData orderListDetailViewData, int i) {
        Intrinsics.checkParameterIsNotNull(orderListDetailViewData, "item");
        View view = this.itemView;
        View findViewById = view.findViewById(C0010R$id.topDivider);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "topDivider");
        int i2 = 0;
        findViewById.setVisibility(i == 0 ? 0 : 8);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageCover);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageCover");
        ImageViewExtensionKt.loadImageAsProduct(roundImageView, orderListDetailViewData.getProductCoverImage());
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
        RoundImageView roundImageView2 = (RoundImageView) view.findViewById(C0010R$id.imageCover);
        OrderDetailProductViewHolder$bindTo$$inlined$with$lambda$1 orderDetailProductViewHolder$bindTo$$inlined$with$lambda$1 = new OrderDetailProductViewHolder$bindTo$$inlined$with$lambda$1(orderListDetailViewData, view, this, i, orderListDetailViewData);
        roundImageView2.setOnClickListener(orderDetailProductViewHolder$bindTo$$inlined$with$lambda$1);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C0010R$id.orderStateRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setLayoutDirection(1);
        this.orderStateAdapter = new OrderStateAdapater(orderListDetailViewData);
        OrderStateAdapater orderStateAdapater = this.orderStateAdapter;
        String str = "orderStateAdapter";
        if (orderStateAdapater == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        recyclerView.setAdapter(orderStateAdapater);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new OrderStateDecorator());
        }
        String str2 = "textPrice";
        String str3 = "textOriginalPrice";
        String str4 = "textPercent";
        if (orderListDetailViewData.getSpecialDiscountInfo() != null) {
            TextView textView5 = (TextView) view.findViewById(C0010R$id.textPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str2);
            textView5.setText(IntExtensionsKt.commaString(orderListDetailViewData.getSpecialDiscountInfo().getSpecialPrice() * ((long) orderListDetailViewData.getProductCount())));
            TextView textView6 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str3);
            textView6.setText(IntExtensionsKt.commaString(orderListDetailViewData.getOriginalPrice() * orderListDetailViewData.getProductCount()));
            double specialPrice = (double) orderListDetailViewData.getSpecialDiscountInfo().getSpecialPrice();
            double originalPrice = (double) orderListDetailViewData.getOriginalPrice();
            Double.isNaN(specialPrice);
            Double.isNaN(originalPrice);
            double d = specialPrice / originalPrice;
            double d2 = (double) 100;
            Double.isNaN(d2);
            int i3 = (int) (d * d2);
            TextView textView7 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView7, str4);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(100 - i3);
            sb2.append('%');
            textView7.setText(sb2.toString());
            TextView textView8 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView8, str4);
            ViewExtensionsKt.visible(textView8);
        } else {
            TextView textView9 = (TextView) view.findViewById(C0010R$id.textPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView9, str2);
            textView9.setText(IntExtensionsKt.commaString(orderListDetailViewData.getProductPrice() * orderListDetailViewData.getProductCount()));
            TextView textView10 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView10, str3);
            textView10.setText(IntExtensionsKt.commaString(orderListDetailViewData.getOriginalPrice() * orderListDetailViewData.getProductCount()));
            TextView textView11 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView11, str4);
            textView11.setVisibility(orderListDetailViewData.getDiscountPercentage() == 0 ? 8 : 0);
            TextView textView12 = (TextView) view.findViewById(C0010R$id.textOriginalPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView12, str3);
            if (orderListDetailViewData.getDiscountPercentage() == 0) {
                i2 = 8;
            }
            textView12.setVisibility(i2);
            TextView textView13 = (TextView) view.findViewById(C0010R$id.textPercent);
            Intrinsics.checkExpressionValueIsNotNull(textView13, str4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(orderListDetailViewData.getDiscountPercentage());
            sb3.append('%');
            textView13.setText(sb3.toString());
        }
        OrderStateAdapater orderStateAdapater2 = this.orderStateAdapter;
        if (orderStateAdapater2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderStateAdapater2.updateOrderState(orderListDetailViewData.getOrderState());
    }
}
