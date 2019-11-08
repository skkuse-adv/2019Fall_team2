package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.feeds.PostFeedHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PostFeedHolder$updatePostFeedHolderUi$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $this_run;
    final /* synthetic */ PostFeedHolder this$0;

    PostFeedHolder$updatePostFeedHolderUi$$inlined$run$lambda$1(Post post, PostFeedHolder postFeedHolder) {
        this.$this_run = post;
        this.this$0 = postFeedHolder;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        long id = this.$this_run.getId();
        Image coverImage = this.$this_run.getCoverImage();
        access$getDelegate$p.onPostFeedClick(id, coverImage != null ? coverImage.getUrl() : null);
    }
}
