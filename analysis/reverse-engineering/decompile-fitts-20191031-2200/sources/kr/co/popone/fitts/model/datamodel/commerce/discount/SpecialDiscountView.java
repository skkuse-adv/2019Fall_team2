package kr.co.popone.fitts.model.datamodel.commerce.discount;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;

public final class SpecialDiscountView {
    @NotNull
    private final ImageView coverImageView;
    @NotNull
    private final TextView discountTextView;
    @NotNull
    private final TextView originPriceTextView;
    @NotNull
    private final View parent;
    @NotNull
    private final TextView salesPriceTextView;
    @NotNull
    private final TextView titleTextView;

    @NotNull
    public static /* synthetic */ SpecialDiscountView copy$default(SpecialDiscountView specialDiscountView, View view, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i, Object obj) {
        if ((i & 1) != 0) {
            view = specialDiscountView.parent;
        }
        if ((i & 2) != 0) {
            imageView = specialDiscountView.coverImageView;
        }
        ImageView imageView2 = imageView;
        if ((i & 4) != 0) {
            textView = specialDiscountView.titleTextView;
        }
        TextView textView5 = textView;
        if ((i & 8) != 0) {
            textView2 = specialDiscountView.discountTextView;
        }
        TextView textView6 = textView2;
        if ((i & 16) != 0) {
            textView3 = specialDiscountView.salesPriceTextView;
        }
        TextView textView7 = textView3;
        if ((i & 32) != 0) {
            textView4 = specialDiscountView.originPriceTextView;
        }
        return specialDiscountView.copy(view, imageView2, textView5, textView6, textView7, textView4);
    }

    @NotNull
    public final View component1() {
        return this.parent;
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
        return this.discountTextView;
    }

    @NotNull
    public final TextView component5() {
        return this.salesPriceTextView;
    }

    @NotNull
    public final TextView component6() {
        return this.originPriceTextView;
    }

    @NotNull
    public final SpecialDiscountView copy(@NotNull View view, @NotNull ImageView imageView, @NotNull TextView textView, @NotNull TextView textView2, @NotNull TextView textView3, @NotNull TextView textView4) {
        Intrinsics.checkParameterIsNotNull(view, "parent");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "discountTextView");
        Intrinsics.checkParameterIsNotNull(textView3, "salesPriceTextView");
        Intrinsics.checkParameterIsNotNull(textView4, "originPriceTextView");
        SpecialDiscountView specialDiscountView = new SpecialDiscountView(view, imageView, textView, textView2, textView3, textView4);
        return specialDiscountView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.originPriceTextView, (java.lang.Object) r3.originPriceTextView) != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0047
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountView
            if (r0 == 0) goto L_0x0045
            kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountView r3 = (kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountView) r3
            android.view.View r0 = r2.parent
            android.view.View r1 = r3.parent
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.ImageView r0 = r2.coverImageView
            android.widget.ImageView r1 = r3.coverImageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.TextView r0 = r2.titleTextView
            android.widget.TextView r1 = r3.titleTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.TextView r0 = r2.discountTextView
            android.widget.TextView r1 = r3.discountTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.TextView r0 = r2.salesPriceTextView
            android.widget.TextView r1 = r3.salesPriceTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.TextView r0 = r2.originPriceTextView
            android.widget.TextView r3 = r3.originPriceTextView
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r3 = 0
            return r3
        L_0x0047:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountView.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        View view = this.parent;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        ImageView imageView = this.coverImageView;
        int hashCode2 = (hashCode + (imageView != null ? imageView.hashCode() : 0)) * 31;
        TextView textView = this.titleTextView;
        int hashCode3 = (hashCode2 + (textView != null ? textView.hashCode() : 0)) * 31;
        TextView textView2 = this.discountTextView;
        int hashCode4 = (hashCode3 + (textView2 != null ? textView2.hashCode() : 0)) * 31;
        TextView textView3 = this.salesPriceTextView;
        int hashCode5 = (hashCode4 + (textView3 != null ? textView3.hashCode() : 0)) * 31;
        TextView textView4 = this.originPriceTextView;
        if (textView4 != null) {
            i = textView4.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpecialDiscountView(parent=");
        sb.append(this.parent);
        sb.append(", coverImageView=");
        sb.append(this.coverImageView);
        sb.append(", titleTextView=");
        sb.append(this.titleTextView);
        sb.append(", discountTextView=");
        sb.append(this.discountTextView);
        sb.append(", salesPriceTextView=");
        sb.append(this.salesPriceTextView);
        sb.append(", originPriceTextView=");
        sb.append(this.originPriceTextView);
        sb.append(")");
        return sb.toString();
    }

    public SpecialDiscountView(@NotNull View view, @NotNull ImageView imageView, @NotNull TextView textView, @NotNull TextView textView2, @NotNull TextView textView3, @NotNull TextView textView4) {
        Intrinsics.checkParameterIsNotNull(view, "parent");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "discountTextView");
        Intrinsics.checkParameterIsNotNull(textView3, "salesPriceTextView");
        Intrinsics.checkParameterIsNotNull(textView4, "originPriceTextView");
        this.parent = view;
        this.coverImageView = imageView;
        this.titleTextView = textView;
        this.discountTextView = textView2;
        this.salesPriceTextView = textView3;
        this.originPriceTextView = textView4;
    }

    @NotNull
    public final View getParent() {
        return this.parent;
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
    public final TextView getDiscountTextView() {
        return this.discountTextView;
    }

    @NotNull
    public final TextView getSalesPriceTextView() {
        return this.salesPriceTextView;
    }

    @NotNull
    public final TextView getOriginPriceTextView() {
        return this.originPriceTextView;
    }

    public final void visible() {
        ViewExtensionsKt.visible(this.parent);
    }

    public final void invisible() {
        ViewExtensionsKt.invisible(this.parent);
    }
}
