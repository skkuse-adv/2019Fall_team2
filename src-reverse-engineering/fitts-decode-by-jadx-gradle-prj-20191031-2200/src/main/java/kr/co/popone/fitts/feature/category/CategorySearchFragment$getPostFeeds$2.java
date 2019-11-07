package kr.co.popone.fitts.feature.category;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;

final class CategorySearchFragment$getPostFeeds$2<T> implements Observer<PagedList<CategoryPostItem>> {
    final /* synthetic */ CategorySearchFragment this$0;

    CategorySearchFragment$getPostFeeds$2(CategorySearchFragment categorySearchFragment) {
        this.this$0 = categorySearchFragment;
    }

    public final void onChanged(PagedList<CategoryPostItem> pagedList) {
        this.this$0.postFeedAdapter.submitList(pagedList);
    }
}
