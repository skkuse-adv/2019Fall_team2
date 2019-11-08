package kr.co.popone.fitts.feature.post.follow;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.FeedEvent$FollowClicked;
import kr.co.popone.fitts.event.FeedEvent$LikePostClicked;

final class FollowingPostActivity$onCreate$4<T> implements Consumer<Object> {
    final /* synthetic */ FollowingPostActivity this$0;

    FollowingPostActivity$onCreate$4(FollowingPostActivity followingPostActivity) {
        this.this$0 = followingPostActivity;
    }

    public final void accept(Object obj) {
        if (obj instanceof FeedEvent$LikePostClicked) {
            FeedEvent$LikePostClicked feedEvent$LikePostClicked = (FeedEvent$LikePostClicked) obj;
            this.this$0.getViewModel().updateLikeState(feedEvent$LikePostClicked.getPostId(), feedEvent$LikePostClicked.isLiked());
        } else if (obj instanceof FeedEvent$FollowClicked) {
            FeedEvent$FollowClicked feedEvent$FollowClicked = (FeedEvent$FollowClicked) obj;
            this.this$0.getViewModel().updateFollowState(feedEvent$FollowClicked.getUserId(), feedEvent$FollowClicked.isFollowed());
        }
    }
}
