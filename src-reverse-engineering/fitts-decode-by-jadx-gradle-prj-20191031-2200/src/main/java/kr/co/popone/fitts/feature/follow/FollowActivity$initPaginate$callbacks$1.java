package kr.co.popone.fitts.feature.follow;

import com.paginate.Paginate.Callbacks;

public final class FollowActivity$initPaginate$callbacks$1 implements Callbacks {
    final /* synthetic */ FollowActivity this$0;

    FollowActivity$initPaginate$callbacks$1(FollowActivity followActivity) {
        this.this$0 = followActivity;
    }

    public void onLoadMore() {
        this.this$0.requestFollowList();
    }

    public boolean isLoading() {
        return this.this$0.isLoadingData;
    }

    public boolean hasLoadedAllItems() {
        return this.this$0.isTotalItemLoaded;
    }
}
