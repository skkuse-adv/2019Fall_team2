package kr.co.popone.fitts.feature.category;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.product.CategoryProductItem;

final class CategorySearchFragment$getProductFeeds$2<T> implements Observer<PagedList<CategoryProductItem>> {
    final /* synthetic */ CategorySearchFragment this$0;

    CategorySearchFragment$getProductFeeds$2(CategorySearchFragment categorySearchFragment) {
        this.this$0 = categorySearchFragment;
    }

    public final void onChanged(PagedList<CategoryProductItem> pagedList) {
        this.this$0.productFeedAdapter.submitList(pagedList);
    }
}
