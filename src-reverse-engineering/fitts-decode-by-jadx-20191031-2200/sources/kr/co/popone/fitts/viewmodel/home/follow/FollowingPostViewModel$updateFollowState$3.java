package kr.co.popone.fitts.viewmodel.home.follow;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.service.user.FollowResult;

final class FollowingPostViewModel$updateFollowState$3<T> implements Consumer<FollowResult> {
    final /* synthetic */ long $userId;
    final /* synthetic */ FollowingPostViewModel this$0;

    FollowingPostViewModel$updateFollowState$3(FollowingPostViewModel followingPostViewModel, long j) {
        this.this$0 = followingPostViewModel;
        this.$userId = j;
    }

    public final void accept(FollowResult followResult) {
        this.this$0.postFollowStateChangeEvent(this.$userId, true);
    }
}
