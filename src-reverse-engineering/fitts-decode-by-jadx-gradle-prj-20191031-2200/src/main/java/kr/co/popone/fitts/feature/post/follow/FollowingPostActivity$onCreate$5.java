package kr.co.popone.fitts.feature.post.follow;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class FollowingPostActivity$onCreate$5<T> implements Consumer<Throwable> {
    final /* synthetic */ FollowingPostActivity this$0;

    FollowingPostActivity$onCreate$5(FollowingPostActivity followingPostActivity) {
        this.this$0 = followingPostActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
