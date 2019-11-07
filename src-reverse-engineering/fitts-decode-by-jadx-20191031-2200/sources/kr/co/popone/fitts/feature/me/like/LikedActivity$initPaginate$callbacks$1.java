package kr.co.popone.fitts.feature.me.like;

import com.paginate.Paginate.Callbacks;

public final class LikedActivity$initPaginate$callbacks$1 implements Callbacks {
    final /* synthetic */ LikedActivity this$0;

    LikedActivity$initPaginate$callbacks$1(LikedActivity likedActivity) {
        this.this$0 = likedActivity;
    }

    public void onLoadMore() {
        this.this$0.requestLikedPosts();
    }

    public boolean isLoading() {
        return this.this$0.isLoadingData;
    }

    public boolean hasLoadedAllItems() {
        return this.this$0.isTotalItemLoaded();
    }
}
