package kr.co.popone.fitts.feature.category;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;

final class CategorySearchFragment$onViewCreated$2<T> implements Consumer<Object> {
    final /* synthetic */ CategorySearchFragment this$0;

    CategorySearchFragment$onViewCreated$2(CategorySearchFragment categorySearchFragment) {
        this.this$0 = categorySearchFragment;
    }

    public final void accept(Object obj) {
        if (obj instanceof CategoryEvent$CategoryTypeChanged) {
            CategoryFeedType categoryType = ((CategoryEvent$CategoryTypeChanged) obj).getCategoryType();
            if (categoryType != null) {
                this.this$0.updateRecyclerAdapterAndDecorator(categoryType);
            }
        }
    }
}
