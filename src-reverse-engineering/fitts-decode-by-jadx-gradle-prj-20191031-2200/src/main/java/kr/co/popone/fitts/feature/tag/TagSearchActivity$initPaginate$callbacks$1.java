package kr.co.popone.fitts.feature.tag;

import com.paginate.Paginate.Callbacks;

public final class TagSearchActivity$initPaginate$callbacks$1 implements Callbacks {
    final /* synthetic */ TagSearchActivity this$0;

    TagSearchActivity$initPaginate$callbacks$1(TagSearchActivity tagSearchActivity) {
        this.this$0 = tagSearchActivity;
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
