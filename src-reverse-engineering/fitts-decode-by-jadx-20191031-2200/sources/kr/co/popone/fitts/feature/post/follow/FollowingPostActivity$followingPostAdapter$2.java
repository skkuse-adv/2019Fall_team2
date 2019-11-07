package kr.co.popone.fitts.feature.post.follow;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class FollowingPostActivity$followingPostAdapter$2 extends Lambda implements Function0<FollowingPostAdapter> {
    final /* synthetic */ FollowingPostActivity this$0;

    FollowingPostActivity$followingPostAdapter$2(FollowingPostActivity followingPostActivity) {
        this.this$0 = followingPostActivity;
        super(0);
    }

    @NotNull
    public final FollowingPostAdapter invoke() {
        return new FollowingPostAdapter(this.this$0.getViewModel().getUserId());
    }
}
