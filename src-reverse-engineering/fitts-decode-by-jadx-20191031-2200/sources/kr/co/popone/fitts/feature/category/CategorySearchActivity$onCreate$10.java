package kr.co.popone.fitts.feature.category;

import androidx.lifecycle.Observer;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;

final class CategorySearchActivity$onCreate$10<T> implements Observer<CategoryFeedType> {
    final /* synthetic */ CategorySearchActivity this$0;

    CategorySearchActivity$onCreate$10(CategorySearchActivity categorySearchActivity) {
        this.this$0 = categorySearchActivity;
    }

    public final void onChanged(CategoryFeedType categoryFeedType) {
        if (categoryFeedType != null) {
            String name = categoryFeedType.name();
            if (name == null) {
                return;
            }
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (lowerCase != null) {
                    this.this$0.getViewModel().logTapToSwitchCategoryContent(lowerCase);
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }
}
