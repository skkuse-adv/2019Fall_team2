package kr.co.popone.fitts.feature.post.follow;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class FollowingPostActivity$getFollowingPostList$2<T> implements Observer<PagedList<Post>> {
    final /* synthetic */ FollowingPostActivity this$0;

    FollowingPostActivity$getFollowingPostList$2(FollowingPostActivity followingPostActivity) {
        this.this$0 = followingPostActivity;
    }

    public final void onChanged(PagedList<Post> pagedList) {
        this.this$0.getFollowingPostAdapter().submitList(pagedList);
    }
}
