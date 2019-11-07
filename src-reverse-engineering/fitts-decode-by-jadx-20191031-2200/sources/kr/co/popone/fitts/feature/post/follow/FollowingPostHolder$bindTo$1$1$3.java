package kr.co.popone.fitts.feature.post.follow;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.FeedEvent$LikePostClicked;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class FollowingPostHolder$bindTo$1$1$3 implements OnClickListener {
    final /* synthetic */ Post $this_run;

    FollowingPostHolder$bindTo$1$1$3(Post post) {
        this.$this_run = post;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new FeedEvent$LikePostClicked(this.$this_run.getId(), this.$this_run.isLiked()));
    }
}
