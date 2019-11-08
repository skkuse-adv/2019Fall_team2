package kr.co.popone.fitts.model.datamodel.social.feed;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PostFeedView {
    @NotNull
    private final ImageView coverImageView;
    @NotNull
    private final TextView fittieIdTextView;
    @NotNull
    private final View fittieSuitView;
    @NotNull
    private final View parentView;
    @NotNull
    private final TextView postTitleTextView;
    @NotNull
    private final ImageView profileImageView;

    @NotNull
    public static /* synthetic */ PostFeedView copy$default(PostFeedView postFeedView, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, View view2, int i, Object obj) {
        if ((i & 1) != 0) {
            view = postFeedView.parentView;
        }
        if ((i & 2) != 0) {
            imageView = postFeedView.coverImageView;
        }
        ImageView imageView3 = imageView;
        if ((i & 4) != 0) {
            imageView2 = postFeedView.profileImageView;
        }
        ImageView imageView4 = imageView2;
        if ((i & 8) != 0) {
            textView = postFeedView.postTitleTextView;
        }
        TextView textView3 = textView;
        if ((i & 16) != 0) {
            textView2 = postFeedView.fittieIdTextView;
        }
        TextView textView4 = textView2;
        if ((i & 32) != 0) {
            view2 = postFeedView.fittieSuitView;
        }
        return postFeedView.copy(view, imageView3, imageView4, textView3, textView4, view2);
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
    public final ImageView component3() {
        return this.profileImageView;
    }

    @NotNull
    public final TextView component4() {
        return this.postTitleTextView;
    }

    @NotNull
    public final TextView component5() {
        return this.fittieIdTextView;
    }

    @NotNull
    public final View component6() {
        return this.fittieSuitView;
    }

    @NotNull
    public final PostFeedView copy(@NotNull View view, @NotNull ImageView imageView, @NotNull ImageView imageView2, @NotNull TextView textView, @NotNull TextView textView2, @NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(imageView2, "profileImageView");
        Intrinsics.checkParameterIsNotNull(textView, "postTitleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "fittieIdTextView");
        Intrinsics.checkParameterIsNotNull(view2, "fittieSuitView");
        PostFeedView postFeedView = new PostFeedView(view, imageView, imageView2, textView, textView2, view2);
        return postFeedView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.fittieSuitView, (java.lang.Object) r3.fittieSuitView) != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0047
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.feed.PostFeedView
            if (r0 == 0) goto L_0x0045
            kr.co.popone.fitts.model.datamodel.social.feed.PostFeedView r3 = (kr.co.popone.fitts.model.datamodel.social.feed.PostFeedView) r3
            android.view.View r0 = r2.parentView
            android.view.View r1 = r3.parentView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.ImageView r0 = r2.coverImageView
            android.widget.ImageView r1 = r3.coverImageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.ImageView r0 = r2.profileImageView
            android.widget.ImageView r1 = r3.profileImageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.TextView r0 = r2.postTitleTextView
            android.widget.TextView r1 = r3.postTitleTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.widget.TextView r0 = r2.fittieIdTextView
            android.widget.TextView r1 = r3.fittieIdTextView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0045
            android.view.View r0 = r2.fittieSuitView
            android.view.View r3 = r3.fittieSuitView
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
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.PostFeedView.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        View view = this.parentView;
        int i = 0;
        int hashCode = (view != null ? view.hashCode() : 0) * 31;
        ImageView imageView = this.coverImageView;
        int hashCode2 = (hashCode + (imageView != null ? imageView.hashCode() : 0)) * 31;
        ImageView imageView2 = this.profileImageView;
        int hashCode3 = (hashCode2 + (imageView2 != null ? imageView2.hashCode() : 0)) * 31;
        TextView textView = this.postTitleTextView;
        int hashCode4 = (hashCode3 + (textView != null ? textView.hashCode() : 0)) * 31;
        TextView textView2 = this.fittieIdTextView;
        int hashCode5 = (hashCode4 + (textView2 != null ? textView2.hashCode() : 0)) * 31;
        View view2 = this.fittieSuitView;
        if (view2 != null) {
            i = view2.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostFeedView(parentView=");
        sb.append(this.parentView);
        sb.append(", coverImageView=");
        sb.append(this.coverImageView);
        sb.append(", profileImageView=");
        sb.append(this.profileImageView);
        sb.append(", postTitleTextView=");
        sb.append(this.postTitleTextView);
        sb.append(", fittieIdTextView=");
        sb.append(this.fittieIdTextView);
        sb.append(", fittieSuitView=");
        sb.append(this.fittieSuitView);
        sb.append(")");
        return sb.toString();
    }

    public PostFeedView(@NotNull View view, @NotNull ImageView imageView, @NotNull ImageView imageView2, @NotNull TextView textView, @NotNull TextView textView2, @NotNull View view2) {
        Intrinsics.checkParameterIsNotNull(view, "parentView");
        Intrinsics.checkParameterIsNotNull(imageView, "coverImageView");
        Intrinsics.checkParameterIsNotNull(imageView2, "profileImageView");
        Intrinsics.checkParameterIsNotNull(textView, "postTitleTextView");
        Intrinsics.checkParameterIsNotNull(textView2, "fittieIdTextView");
        Intrinsics.checkParameterIsNotNull(view2, "fittieSuitView");
        this.parentView = view;
        this.coverImageView = imageView;
        this.profileImageView = imageView2;
        this.postTitleTextView = textView;
        this.fittieIdTextView = textView2;
        this.fittieSuitView = view2;
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
    public final ImageView getProfileImageView() {
        return this.profileImageView;
    }

    @NotNull
    public final TextView getPostTitleTextView() {
        return this.postTitleTextView;
    }

    @NotNull
    public final TextView getFittieIdTextView() {
        return this.fittieIdTextView;
    }

    @NotNull
    public final View getFittieSuitView() {
        return this.fittieSuitView;
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
        this.parentView.setOnClickListener(new PostFeedView$sam$android_view_View_OnClickListener$0(function1));
    }
}
