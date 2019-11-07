package kr.co.popone.fitts.model.datamodel.social.feed;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CollectionFeedView {
    @NotNull
    private final ImageView imageView;
    @NotNull
    private final Group titleGroup;
    @NotNull
    private final TextView titleView;

    @NotNull
    public static /* synthetic */ CollectionFeedView copy$default(CollectionFeedView collectionFeedView, ImageView imageView2, TextView textView, Group group, int i, Object obj) {
        if ((i & 1) != 0) {
            imageView2 = collectionFeedView.imageView;
        }
        if ((i & 2) != 0) {
            textView = collectionFeedView.titleView;
        }
        if ((i & 4) != 0) {
            group = collectionFeedView.titleGroup;
        }
        return collectionFeedView.copy(imageView2, textView, group);
    }

    @NotNull
    public final ImageView component1() {
        return this.imageView;
    }

    @NotNull
    public final TextView component2() {
        return this.titleView;
    }

    @NotNull
    public final Group component3() {
        return this.titleGroup;
    }

    @NotNull
    public final CollectionFeedView copy(@NotNull ImageView imageView2, @NotNull TextView textView, @NotNull Group group) {
        Intrinsics.checkParameterIsNotNull(imageView2, "imageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleView");
        Intrinsics.checkParameterIsNotNull(group, "titleGroup");
        return new CollectionFeedView(imageView2, textView, group);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.titleGroup, (java.lang.Object) r3.titleGroup) != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x0029
            boolean r0 = r3 instanceof kr.co.popone.fitts.model.datamodel.social.feed.CollectionFeedView
            if (r0 == 0) goto L_0x0027
            kr.co.popone.fitts.model.datamodel.social.feed.CollectionFeedView r3 = (kr.co.popone.fitts.model.datamodel.social.feed.CollectionFeedView) r3
            android.widget.ImageView r0 = r2.imageView
            android.widget.ImageView r1 = r3.imageView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            android.widget.TextView r0 = r2.titleView
            android.widget.TextView r1 = r3.titleView
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0027
            androidx.constraintlayout.widget.Group r0 = r2.titleGroup
            androidx.constraintlayout.widget.Group r3 = r3.titleGroup
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r3 = 0
            return r3
        L_0x0029:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.social.feed.CollectionFeedView.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ImageView imageView2 = this.imageView;
        int i = 0;
        int hashCode = (imageView2 != null ? imageView2.hashCode() : 0) * 31;
        TextView textView = this.titleView;
        int hashCode2 = (hashCode + (textView != null ? textView.hashCode() : 0)) * 31;
        Group group = this.titleGroup;
        if (group != null) {
            i = group.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CollectionFeedView(imageView=");
        sb.append(this.imageView);
        sb.append(", titleView=");
        sb.append(this.titleView);
        sb.append(", titleGroup=");
        sb.append(this.titleGroup);
        sb.append(")");
        return sb.toString();
    }

    public CollectionFeedView(@NotNull ImageView imageView2, @NotNull TextView textView, @NotNull Group group) {
        Intrinsics.checkParameterIsNotNull(imageView2, "imageView");
        Intrinsics.checkParameterIsNotNull(textView, "titleView");
        Intrinsics.checkParameterIsNotNull(group, "titleGroup");
        this.imageView = imageView2;
        this.titleView = textView;
        this.titleGroup = group;
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
