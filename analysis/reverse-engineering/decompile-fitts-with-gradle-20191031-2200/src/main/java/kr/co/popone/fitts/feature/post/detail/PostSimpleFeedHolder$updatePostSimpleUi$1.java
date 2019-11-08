package kr.co.popone.fitts.feature.post.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PostSimpleFeedHolder$updatePostSimpleUi$1 implements OnClickListener {
    final /* synthetic */ Post $item;
    final /* synthetic */ PostSimpleFeedHolder this$0;

    PostSimpleFeedHolder$updatePostSimpleUi$1(PostSimpleFeedHolder postSimpleFeedHolder, Post post) {
        this.this$0 = postSimpleFeedHolder;
        this.$item = post;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSimplePostClick(this.$item.getId());
    }
}
