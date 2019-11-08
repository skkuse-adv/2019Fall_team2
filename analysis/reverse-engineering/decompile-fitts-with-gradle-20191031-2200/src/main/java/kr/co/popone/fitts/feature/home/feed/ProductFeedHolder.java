package kr.co.popone.fitts.feature.home.feed;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.RoundImageView;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public interface Delegate {
        void onProductClicked(@NotNull String str);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductFeedHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_feed_product, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductFeedHolder(inflate);
        }
    }

    public ProductFeedHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    @Nullable
    @SuppressLint({"SetTextI18n"})
    public final Unit bindTo(@Nullable ProductFeedViewData productFeedViewData, @NotNull Delegate delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        View view = this.itemView;
        if (productFeedViewData == null) {
            return null;
        }
        Integer discountRate = productFeedViewData.getDiscountRate();
        String str = "textDiscount";
        if (discountRate != null && discountRate.intValue() == 0) {
            TextView textView = (TextView) view.findViewById(C0010R$id.textDiscount);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            ViewExtensionsKt.gone(textView);
        } else {
            TextView textView2 = (TextView) view.findViewById(C0010R$id.textDiscount);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            ViewExtensionsKt.visible(textView2);
        }
        TextView textView3 = (TextView) view.findViewById(C0010R$id.textDiscount);
        Intrinsics.checkExpressionValueIsNotNull(textView3, str);
        StringBuilder sb = new StringBuilder();
        sb.append(productFeedViewData.getDiscountRate());
        sb.append('%');
        textView3.setText(sb.toString());
        RoundImageView roundImageView = (RoundImageView) view.findViewById(C0010R$id.imageProduct);
        Intrinsics.checkExpressionValueIsNotNull(roundImageView, "imageProduct");
        ImageViewExtensionKt.loadImageAsProduct(roundImageView, productFeedViewData.getStoreImageUrl());
        TextView textView4 = (TextView) view.findViewById(C0010R$id.textProductName);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "textProductName");
        textView4.setText(productFeedViewData.getStoreTitle());
        TextView textView5 = (TextView) view.findViewById(C0010R$id.textSalesPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "textSalesPrice");
        textView5.setText(IntExtensionsKt.commaString(productFeedViewData.getSalesPrice()));
        View view2 = this.itemView;
        ProductFeedHolder$bindTo$$inlined$with$lambda$1 productFeedHolder$bindTo$$inlined$with$lambda$1 = new ProductFeedHolder$bindTo$$inlined$with$lambda$1(productFeedViewData, view, this, productFeedViewData, delegate);
        view2.setOnClickListener(productFeedHolder$bindTo$$inlined$with$lambda$1);
        return Unit.INSTANCE;
    }
}
