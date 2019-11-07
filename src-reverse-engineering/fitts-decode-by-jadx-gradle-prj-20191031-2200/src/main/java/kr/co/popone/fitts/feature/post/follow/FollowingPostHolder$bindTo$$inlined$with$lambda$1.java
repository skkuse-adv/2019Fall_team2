package kr.co.popone.fitts.feature.post.follow;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class FollowingPostHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $this_run;
    final /* synthetic */ View $this_with$inlined;

    FollowingPostHolder$bindTo$$inlined$with$lambda$1(Post post, View view, FollowingPostHolder followingPostHolder, Post post2, long j) {
        this.$this_run = post;
        this.$this_with$inlined = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0024, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            android.view.View r5 = r4.$this_with$inlined
            android.content.Context r5 = r5.getContext()
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            android.content.Intent r0 = new android.content.Intent
            android.view.View r1 = r4.$this_with$inlined
            android.content.Context r1 = r1.getContext()
            java.lang.Class<kr.co.popone.fitts.feature.post.detail.PostActivity> r2 = kr.co.popone.fitts.feature.post.detail.PostActivity.class
            r0.<init>(r1, r2)
            kr.co.popone.fitts.model.post.PostAPI$Post r1 = r4.$this_run
            kr.co.popone.fitts.model.datamodel.service.post.Image r1 = r1.getCoverImage()
            if (r1 == 0) goto L_0x0027
            java.lang.String r1 = r1.getUrl()
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            java.lang.String r1 = ""
        L_0x0029:
            java.lang.String r2 = "post_cover"
            r0.putExtra(r2, r1)
            kr.co.popone.fitts.model.post.PostAPI$Post r1 = r4.$this_run
            long r1 = r1.getId()
            java.lang.String r3 = "post_id"
            r0.putExtra(r3, r1)
            kr.co.popone.fitts.utils.ActivityAnimationType r1 = kr.co.popone.fitts.utils.ActivityAnimationType.SLIDE_RTOL
            kr.co.popone.fitts.base.extension.ContextExtensionKt.activityStart(r5, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.post.follow.FollowingPostHolder$bindTo$$inlined$with$lambda$1.onClick(android.view.View):void");
    }
}
