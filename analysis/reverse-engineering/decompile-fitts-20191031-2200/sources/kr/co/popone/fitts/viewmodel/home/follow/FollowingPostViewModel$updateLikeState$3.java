package kr.co.popone.fitts.viewmodel.home.follow;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.service.post.LikeResult;

final class FollowingPostViewModel$updateLikeState$3<T> implements Consumer<LikeResult> {
    final /* synthetic */ long $postId;
    final /* synthetic */ FollowingPostViewModel this$0;

    FollowingPostViewModel$updateLikeState$3(FollowingPostViewModel followingPostViewModel, long j) {
        this.this$0 = followingPostViewModel;
        this.$postId = j;
    }

    public final void accept(LikeResult likeResult) {
        this.this$0.postLikeStateChangeEvent(this.$postId, true);
    }
}
