package kr.co.popone.fitts.model.datamodel.social.feed;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ProductFeedView {
    @NotNull
    private final ImageView imageView;
    @NotNull
    private final View parentView;
    @NotNull
    private final Group titleGroup;
    @NotNull
    private final TextView titleView;

    @NotNull
    public static /* synthetic */ ProductFeedView copy$default(ProductFeedView productFeedView, View view, ImageView imageView2, TextView textView, Group group, int i, Object obj) {
        if ((i & 1) != 0) {
            view = productFeedView.parentView;
        }
        if ((i & 2) != 0) {
            imageView2 = productFeedView.imageView;
        }
        if ((i & 4) != 0) {
            textView = productFeedView.titleView;
        }
        if ((i & 8) != 0) {
            group = productFeedView.titleGroup;
        }
        return productFeedView.copy(view, imageView2, textView, group);
    }

    @NotNull
    public final View component1() {
        return this.parentView;
    }

    @NotNull
    public final ImageView component2() {
        return this.imageView;
    }

    @NotNull
    public final TextView component3() {
        return this.titleView;
    }

    @NotNull
    public final Group component4() {
        return this.titleGroup;
    }

    @NotNull
    public final ProductFeedView copy(@NotNull View view, @NotNull ImageView imageView2, @NotNull TextView textView, @NotNull Group group) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView2, "imageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleView");
        Intrinsics.checkParameterIsNotNull(group, "titleGroup");
        return new ProductFeedView(view, imageView2, textView, group);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.titleGroup, (java.lang.Object) r3.titleGroup) != false) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0033
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.feed.ProductFeedView
            if (r0 == 0) goto L_0x0031
            kr.co.popone.fitts.model.datamodel.social.feed.ProductFeedView r3 = (kr.co.popone.fitts.model.datamodel.social.feed.ProductFeedView) r3
            android.view.View r0 = r2.parentView
            android.view.View r1 = r3.parentView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            android.widget.ImageView r0 = r2.imageView
            android.widget.ImageView r1 = r3.imageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            android.widget.TextView r0 = r2.titleView
            android.widget.TextView r1 = r3.titleView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0031
            androidx.constraintlayout.widget.Group r0 = r2.titleGroup
            androidx.constraintlayout.widget.Group r3 = r3.titleGroup
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            return r3
        L_0x0033:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.ProductFeedView.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        View view = this.parentView;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        ImageView imageView2 = this.imageView;
        int hashCode2 = (hashCode + (imageView2 != null ? imageView2.hashCode() : 0)) * 31;
        TextView textView = this.titleView;
        int hashCode3 = (hashCode2 + (textView != null ? textView.hashCode() : 0)) * 31;
        Group group = this.titleGroup;
        if (group != null) {
            i = group.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductFeedView(parentView=");
        sb.append(this.parentView);
        sb.append(", imageView=");
        sb.append(this.imageView);
        sb.append(", titleView=");
        sb.append(this.titleView);
        sb.append(", titleGroup=");
        sb.append(this.titleGroup);
        sb.append(")");
        return sb.toString();
    }

    public ProductFeedView(@NotNull View view, @NotNull ImageView imageView2, @NotNull TextView textView, @NotNull Group group) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView2, "imageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleView");
        Intrinsics.checkParameterIsNotNull(group, "titleGroup");
        this.parentView = view;
        this.imageView = imageView2;
        this.titleView = textView;
        this.titleGroup = group;
    }

    @NotNull
    public final View getParentView() {
        return this.parentView;
    }

    @NotNull
    public final ImageView getImageView() {
        return this.imageView;
    }

    @NotNull
    public final TextView getTitleView() {
        return this.titleView;
    }

    @NotNull
    public final Group getTitleGroup() {
        return this.titleGroup;
    }
}
