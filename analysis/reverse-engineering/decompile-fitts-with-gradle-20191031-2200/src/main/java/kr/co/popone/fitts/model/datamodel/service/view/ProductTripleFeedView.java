package kr.co.popone.fitts.model.datamodel.service.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ProductTripleFeedView {
    @NotNull
    private final ImageView coverImageView;
    @NotNull
    private final TextView discountPercetageTextView;
    @NotNull
    private final View parentView;
    @NotNull
    private final TextView priceTextView;
    @NotNull
    private final TextView titleTextView;

    @NotNull
    public static /* synthetic */ ProductTripleFeedView copy$default(ProductTripleFeedView productTripleFeedView, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3, int i, Object obj) {
        if ((i & 1) != 0) {
            view = productTripleFeedView.parentView;
        }
        if ((i & 2) != 0) {
            imageView = productTripleFeedView.coverImageView;
        }
        ImageView imageView2 = imageView;
        if ((i & 4) != 0) {
            textView = productTripleFeedView.titleTextView;
        }
        TextView textView4 = textView;
        if ((i & 8) != 0) {
            textView2 = productTripleFeedView.discountPercetageTextView;
        }
        TextView textView5 = textView2;
        if ((i & 16) != 0) {
            textView3 = productTripleFeedView.priceTextView;
        }
        return productTripleFeedView.copy(view, imageView2, textView4, textView5, textView3);
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
        return this.priceTextView;
    }

    @NotNull
    public final ProductTripleFeedView copy(@NotNull View view, @NotNull ImageView imageView, @NotNull TextView textView, @NotNull TextView textView2, @NotNull TextView textView3) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "discountPercetageTextView");
        Intrinsics.checkParameterIsNotNull(textView3, "priceTextView");
        ProductTripleFeedView productTripleFeedView = new ProductTripleFeedView(view, imageView, textView, textView2, textView3);
        return productTripleFeedView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.priceTextView, (java.lang.Object) r3.priceTextView) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x003d
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.service.view.ProductTripleFeedView
            if (r0 == 0) goto L_0x003b
            kr.co.popone.fitts.model.datamodel.service.view.ProductTripleFeedView r3 = (kr.co.popone.fitts.model.datamodel.service.view.ProductTripleFeedView) r3
            android.view.View r0 = r2.parentView
            android.view.View r1 = r3.parentView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            android.widget.ImageView r0 = r2.coverImageView
            android.widget.ImageView r1 = r3.coverImageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            android.widget.TextView r0 = r2.titleTextView
            android.widget.TextView r1 = r3.titleTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            android.widget.TextView r0 = r2.discountPercetageTextView
            android.widget.TextView r1 = r3.discountPercetageTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x003b
            android.widget.TextView r0 = r2.priceTextView
            android.widget.TextView r3 = r3.priceTextView
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r3 = 0
            return r3
        L_0x003d:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.service.view.ProductTripleFeedView.equals(java.lang.Object):boolean");
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
        TextView textView3 = this.priceTextView;
        if (textView3 != null) {
            i = textView3.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductTripleFeedView(parentView=");
        sb.append(this.parentView);
        sb.append(", coverImageView=");
        sb.append(this.coverImageView);
        sb.append(", titleTextView=");
        sb.append(this.titleTextView);
        sb.append(", discountPercetageTextView=");
        sb.append(this.discountPercetageTextView);
        sb.append(", priceTextView=");
        sb.append(this.priceTextView);
        sb.append(")");
        return sb.toString();
    }

    public ProductTripleFeedView(@NotNull View view, @NotNull ImageView imageView, @NotNull TextView textView, @NotNull TextView textView2, @NotNull TextView textView3) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "discountPercetageTextView");
        Intrinsics.checkParameterIsNotNull(textView3, "priceTextView");
        this.parentView = view;
        this.coverImageView = imageView;
        this.titleTextView = textView;
        this.discountPercetageTextView = textView2;
        this.priceTextView = textView3;
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
    public final TextView getPriceTextView() {
        return this.priceTextView;
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

    public final void setOnClickListener(@NotNull Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "body");
        this.parentView.setOnClickListener(new ProductTripleFeedView$sam$android_view_View_OnClickListener$0(function1));
    }
}
