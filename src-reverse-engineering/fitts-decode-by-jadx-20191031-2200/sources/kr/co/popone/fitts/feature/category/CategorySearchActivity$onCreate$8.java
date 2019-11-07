package kr.co.popone.fitts.feature.category;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.CategoryEvent$CategoryTypeChanged;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;

final class CategorySearchActivity$onCreate$8<T> implements Observer<CategoryFeedType> {
    final /* synthetic */ CategorySearchActivity this$0;

    CategorySearchActivity$onCreate$8(CategorySearchActivity categorySearchActivity) {
        this.this$0 = categorySearchActivity;
    }

    public final void onChanged(CategoryFeedType categoryFeedType) {
        RxBus.INSTANCE.post(new CategoryEvent$CategoryTypeChanged(categoryFeedType));
        CategorySearchAdatper access$getCategorySearchAdatper$p = this.this$0.categorySearchAdatper;
        if (categoryFeedType == null) {
            Intrinsics.throwNpe();
        }
        access$getCategorySearchAdatper$p.setType(categoryFeedType);
    }
}
