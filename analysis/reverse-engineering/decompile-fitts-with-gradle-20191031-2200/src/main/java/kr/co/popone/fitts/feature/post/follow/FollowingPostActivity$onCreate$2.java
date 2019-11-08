package kr.co.popone.fitts.feature.post.follow;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class FollowingPostActivity$onCreate$2 implements OnRefreshListener {
    final /* synthetic */ FollowingPostActivity this$0;

    FollowingPostActivity$onCreate$2(FollowingPostActivity followingPostActivity) {
        this.this$0 = followingPostActivity;
    }

    public final void onRefresh() {
        this.this$0.getFollowingPostList();
    }
}
