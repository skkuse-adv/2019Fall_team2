package kr.co.popone.fitts.model.datamodel.service.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductDoubleFeedView {
    @NotNull
    private final ImageView coverImageView;
    @NotNull
    private final TextView discountPercetageTextView;
    @NotNull
    private final TextView originPriceTextView;
    @NotNull
    private final View parentView;
    @NotNull
    private final TextView salePriceTextView;
    @NotNull
    private final TextView titleTextView;
    @NotNull
    private final ImageView wishItemImageView;

    @NotNull
    public static /* synthetic */ ProductDoubleFeedView copy$default(ProductDoubleFeedView productDoubleFeedView, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, int i, Object obj) {
        if ((i & 1) != 0) {
            view = productDoubleFeedView.parentView;
        }
        if ((i & 2) != 0) {
            imageView = productDoubleFeedView.coverImageView;
        }
        ImageView imageView3 = imageView;
        if ((i & 4) != 0) {
            textView = productDoubleFeedView.titleTextView;
        }
        TextView textView5 = textView;
        if ((i & 8) != 0) {
            textView2 = productDoubleFeedView.discountPercetageTextView;
        }
        TextView textView6 = textView2;
        if ((i & 16) != 0) {
            textView3 = productDoubleFeedView.salePriceTextView;
        }
        TextView textView7 = textView3;
        if ((i & 32) != 0) {
            textView4 = productDoubleFeedView.originPriceTextView;
        }
        TextView textView8 = textView4;
        if ((i & 64) != 0) {
            imageView2 = productDoubleFeedView.wishItemImageView;
        }
        return productDoubleFeedView.copy(view, imageView3, textView5, textView6, textView7, textView8, imageView2);
    }

    @NotNull
    public final View component1() {
        return this.parentView;
    }

    @NotNull
    public final ImageView component2() {
        return this.coverImageView;
    }

    @NotNull
    public final TextView component3() {
        return this.titleTextView;
    }

    @NotNull
    public final TextView component4() {
        return this.discountPercetageTextView;
    }

    @NotNull
    public final TextView component5() {
        return this.salePriceTextView;
    }

    @NotNull
    public final TextView component6() {
        return this.originPriceTextView;
    }

    @NotNull
    public final ImageView component7() {
        return this.wishItemImageView;
    }

    @NotNull
    public final ProductDoubleFeedView copy(@NotNull View view, @NotNull ImageView imageView, @NotNull TextView textView, @NotNull TextView textView2, @NotNull TextView textView3, @NotNull TextView textView4, @NotNull ImageView imageView2) {
        View view2 = view;
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        ImageView imageView3 = imageView;
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        TextView textView5 = textView;
        Intrinsics.checkParameterIsNotNull(textView, "titleTextView");
        TextView textView6 = textView2;
        Intrinsics.checkParameterIsNotNull(textView2, "discountPercetageTextView");
        TextView textView7 = textView3;
        Intrinsics.checkParameterIsNotNull(textView3, "salePriceTextView");
        TextView textView8 = textView4;
        Intrinsics.checkParameterIsNotNull(textView4, "originPriceTextView");
        ImageView imageView4 = imageView2;
        Intrinsics.checkParameterIsNotNull(imageView4, "wishItemImageView");
        ProductDoubleFeedView productDoubleFeedView = new ProductDoubleFeedView(view2, imageView3, textView5, textView6, textView7, textView8, imageView4);
        return productDoubleFeedView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.wishItemImageView, (java.lang.Object) r3.wishItemImageView) != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0051
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView
            if (r0 == 0) goto L_0x004f
            kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView r3 = (kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView) r3
            android.view.View r0 = r2.parentView
            android.view.View r1 = r3.parentView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            android.widget.ImageView r0 = r2.coverImageView
            android.widget.ImageView r1 = r3.coverImageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            android.widget.TextView r0 = r2.titleTextView
            android.widget.TextView r1 = r3.titleTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            android.widget.TextView r0 = r2.discountPercetageTextView
            android.widget.TextView r1 = r3.discountPercetageTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            android.widget.TextView r0 = r2.salePriceTextView
            android.widget.TextView r1 = r3.salePriceTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            android.widget.TextView r0 = r2.originPriceTextView
            android.widget.TextView r1 = r3.originPriceTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004f
            android.widget.ImageView r0 = r2.wishItemImageView
            android.widget.ImageView r3 = r3.wishItemImageView
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r3 = 0
            return r3
        L_0x0051:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        View view = this.parentView;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        ImageView imageView = this.coverImageView;
        int hashCode2 = (hashCode + (imageView != null ? imageView.hashCode() : 0)) * 31;
        TextView textView = this.titleTextView;
        int hashCode3 = (hashCode2 + (textView != null ? textView.hashCode() : 0)) * 31;
        TextView textView2 = this.discountPercetageTextView;
        int hashCode4 = (hashCode3 + (textView2 != null ? textView2.hashCode() : 0)) * 31;
        TextView textView3 = this.salePriceTextView;
        int hashCode5 = (hashCode4 + (textView3 != null ? textView3.hashCode() : 0)) * 31;
        TextView textView4 = this.originPriceTextView;
        int hashCode6 = (hashCode5 + (textView4 != null ? textView4.hashCode() : 0)) * 31;
        ImageView imageView2 = this.wishItemImageView;
        if (imageView2 != null) {
            i = imageView2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductDoubleFeedView(parentView=");
        sb.append(this.parentView);
        sb.append(", coverImageView=");
        sb.append(this.coverImageView);
        sb.append(", titleTextView=");
        sb.append(this.titleTextView);
        sb.append(", discountPercetageTextView=");
        sb.append(this.discountPercetageTextView);
        sb.append(", salePriceTextView=");
        sb.append(this.salePriceTextView);
        sb.append(", originPriceTextView=");
        sb.append(this.originPriceTextView);
        sb.append(", wishItemImageView=");
        sb.append(this.wishItemImageView);
        sb.append(")");
        return sb.toString();
    }

    public ProductDoubleFeedView(@NotNull View view, @NotNull ImageView imageView, @NotNull TextView textView, @NotNull TextView textView2, @NotNull TextView textView3, @NotNull TextView textView4, @NotNull ImageView imageView2) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "discountPercetageTextView");
        Intrinsics.checkParameterIsNotNull(textView3, "salePriceTextView");
        Intrinsics.checkParameterIsNotNull(textView4, "originPriceTextView");
        Intrinsics.checkParameterIsNotNull(imageView2, "wishItemImageView");
        this.parentView = view;
        this.coverImageView = imageView;
        this.titleTextView = textView;
        this.discountPercetageTextView = textView2;
        this.salePriceTextView = textView3;
        this.originPriceTextView = textView4;
        this.wishItemImageView = imageView2;
    }

    @NotNull
    public final View getParentView() {
        return this.parentView;
    }

    @NotNull
    public final ImageView getCoverImageView() {
        return this.coverImageView;
    }

    @NotNull
    public final TextView getTitleTextView() {
        return this.titleTextView;
    }

    @NotNull
    public final TextView getDiscountPercetageTextView() {
        return this.discountPercetageTextView;
    }

    @NotNull
    public final TextView getSalePriceTextView() {
        return this.salePriceTextView;
    }

    @NotNull
    public final TextView getOriginPriceTextView() {
        return this.originPriceTextView;
    }

    @NotNull
    public final ImageView getWishItemImageView() {
        return this.wishItemImageView;
    }

    public final void invisible() {
        View view = this.parentView;
        if (view.getVisibility() != 4) {
            view.setVisibility(4);
        }
    }

    public final void visible() {
        View view = this.parentView;
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    public final void updateLikeIcon(@Nullable Boolean bool) {
        this.wishItemImageView.setImageResource(Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(true)) ? C0008R$drawable.img_icon_heart_point : C0008R$drawable.img_icon_heart);
    }

    public final void setOnClickListener(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        this.parentView.setOnClickListener(new ProductDoubleFeedView$sam$android_view_View_OnClickListener$0(function1));
    }
}
