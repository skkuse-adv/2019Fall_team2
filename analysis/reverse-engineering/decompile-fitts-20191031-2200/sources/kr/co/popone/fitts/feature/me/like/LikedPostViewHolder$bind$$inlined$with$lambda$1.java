package kr.co.popone.fitts.feature.me.like;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.me.like.LikedPostViewHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.service.post.Image;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class LikedPostViewHolder$bind$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Delegate $delegate$inlined;
    final /* synthetic */ Post $this_run;

    LikedPostViewHolder$bind$$inlined$with$lambda$1(Post post, View view, Post post2, Delegate delegate) {
        this.$this_run = post;
        this.$delegate$inlined = delegate;
    }

    public final void onClick(View view) {
        Delegate delegate = this.$delegate$inlined;
        long id = this.$this_run.getId();
        Image coverImage = this.$this_run.getCoverImage();
        delegate.onPostClicked(id, coverImage != null ? coverImage.getUrl() : null);
    }
}
