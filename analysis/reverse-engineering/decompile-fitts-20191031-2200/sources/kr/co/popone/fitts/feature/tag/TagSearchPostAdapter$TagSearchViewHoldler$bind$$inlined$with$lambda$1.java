package kr.co.popone.fitts.feature.tag;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.tag.TagSearchPostAdapter.Delegate;
import kr.co.popone.fitts.feature.tag.TagSearchPostAdapter.TagSearchViewHoldler;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class TagSearchPostAdapter$TagSearchViewHoldler$bind$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $this_run;
    final /* synthetic */ TagSearchViewHoldler this$0;

    TagSearchPostAdapter$TagSearchViewHoldler$bind$$inlined$with$lambda$1(Post post, View view, TagSearchViewHoldler tagSearchViewHoldler, Post post2) {
        this.$this_run = post;
        this.this$0 = tagSearchViewHoldler;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.this$0.delegate;
        Post post = this.$this_run;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        access$getDelegate$p.onCoverImageClick(post, view);
    }
}
