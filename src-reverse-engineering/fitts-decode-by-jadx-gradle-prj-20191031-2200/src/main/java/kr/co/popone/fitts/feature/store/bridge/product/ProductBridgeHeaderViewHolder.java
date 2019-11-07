package kr.co.popone.fitts.feature.store.bridge.product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.SessionProvider;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType;
import kr.co.popone.fitts.ui.ImageViewExtensionKt;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class ProductBridgeHeaderViewHolder extends ViewHolder {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public final int getId() {
            return C0013R$layout.item_product_bridge_header;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductBridgeHeaderViewHolder create(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C0013R$layout.item_product_bridge_header, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "view");
            return new ProductBridgeHeaderViewHolder(inflate);
        }
    }

    public interface Delegate extends SessionProvider {
        void productHeaderClicked(@NotNull String str);
    }

    public ProductBridgeHeaderViewHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        super(view);
    }

    public final void bind(@NotNull HeaderType headerType, boolean z, @NotNull Delegate delegate) {
        Intrinsics.checkParameterIsNotNull(headerType, "item");
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        View view = this.itemView;
        String str = "groupEmptyViews";
        String str2 = "groupNotEmptyViews";
        if (z) {
            ImageView imageView = (ImageView) view.findViewById(C0010R$id.imageProduct);
            Context context = imageView.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            ImageViewExtensionKt.loadImageAsBitmapCropTop(imageView, context, headerType.getHeaderImage(), null);
            imageView.setScaleType(ScaleType.MATRIX);
            Group group = (Group) view.findViewById(C0010R$id.groupNotEmptyViews);
            Intrinsics.checkExpressionValueIsNotNull(group, str2);
            group.setVisibility(0);
            Group group2 = (Group) view.findViewById(C0010R$id.groupEmptyViews);
            Intrinsics.checkExpressionValueIsNotNull(group2, str);
            group2.setVisibility(8);
            TextView textView = (TextView) view.findViewById(C0010R$id.textProductName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textProductName");
            textView.setText(headerType.getProductName());
            TextView textView2 = (TextView) view.findViewById(C0010R$id.textStoreName);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textStoreName");
            textView2.setText(headerType.getShopName());
            TextView textView3 = (TextView) view.findViewById(C0010R$id.textPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "textPrice");
            textView3.setText(headerType.getProductPrice());
        } else {
            ImageView imageView2 = (ImageView) view.findViewById(C0010R$id.imageProduct);
            ImageViewExtensionKt.loadImage(imageView2, (String) null, (int) C0008R$drawable.img_empty_product_info);
            imageView2.setScaleType(ScaleType.CENTER_CROP);
            Group group3 = (Group) view.findViewById(C0010R$id.groupNotEmptyViews);
            Intrinsics.checkExpressionValueIsNotNull(group3, str2);
            group3.setVisibility(8);
            Group group4 = (Group) view.findViewById(C0010R$id.groupEmptyViews);
            Intrinsics.checkExpressionValueIsNotNull(group4, str);
            group4.setVisibility(0);
            TextView textView4 = (TextView) view.findViewById(C0010R$id.textEmptyInfoStoreName);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "textEmptyInfoStoreName");
            textView4.setText(headerType.getShopName());
        }
        ProductBridgeHeaderViewHolder$bind$$inlined$with$lambda$1 productBridgeHeaderViewHolder$bind$$inlined$with$lambda$1 = new ProductBridgeHeaderViewHolder$bind$$inlined$with$lambda$1(headerType, view, headerType, z, delegate);
        view.setOnClickListener(productBridgeHeaderViewHolder$bind$$inlined$with$lambda$1);
        SessionManager sessionManager = delegate.getSessionManager();
        String str3 = "groupFittieInfo";
        if (sessionManager != null) {
            String fittsID = sessionManager.getFittsID();
            if (fittsID != null) {
                TextView textView5 = (TextView) view.findViewById(C0010R$id.textFittieId);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "textFittieId");
                textView5.setText(fittsID);
                Group group5 = (Group) view.findViewById(C0010R$id.groupFittieInfo);
                Intrinsics.checkExpressionValueIsNotNull(group5, str3);
                ViewExtensionsKt.visible(group5);
                return;
            }
        }
        Group group6 = (Group) view.findViewById(C0010R$id.groupFittieInfo);
        Intrinsics.checkExpressionValueIsNotNull(group6, str3);
        ViewExtensionsKt.gone(group6);
    }
}
