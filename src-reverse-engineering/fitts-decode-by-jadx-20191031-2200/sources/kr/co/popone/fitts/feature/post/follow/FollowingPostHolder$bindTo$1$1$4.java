package kr.co.popone.fitts.feature.post.follow;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.FeedEvent$FollowClicked;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class FollowingPostHolder$bindTo$1$1$4 implements OnClickListener {
    final /* synthetic */ Post $this_run;

    FollowingPostHolder$bindTo$1$1$4(Post post) {
        this.$this_run = post;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new FeedEvent$FollowClicked(this.$this_run.getUser().getId(), this.$this_run.getUser().isFollowing()));
    }
}
