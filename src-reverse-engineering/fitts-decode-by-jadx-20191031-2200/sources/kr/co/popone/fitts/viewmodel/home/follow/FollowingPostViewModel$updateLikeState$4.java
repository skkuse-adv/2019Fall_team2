package kr.co.popone.fitts.viewmodel.home.follow;

import io.reactivex.functions.Consumer;

final class FollowingPostViewModel$updateLikeState$4<T> implements Consumer<Throwable> {
    final /* synthetic */ FollowingPostViewModel this$0;

    FollowingPostViewModel$updateLikeState$4(FollowingPostViewModel followingPostViewModel) {
        this.this$0 = followingPostViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
