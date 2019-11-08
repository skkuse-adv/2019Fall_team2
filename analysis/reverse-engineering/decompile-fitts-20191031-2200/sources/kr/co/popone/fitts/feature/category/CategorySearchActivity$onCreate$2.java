package kr.co.popone.fitts.feature.category;

import androidx.viewpager.widget.ViewPager;
import io.reactivex.functions.BiConsumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class CategorySearchActivity$onCreate$2<T1, T2> implements BiConsumer<Unit, Throwable> {
    final /* synthetic */ CategorySearchActivity this$0;

    CategorySearchActivity$onCreate$2(CategorySearchActivity categorySearchActivity) {
        this.this$0 = categorySearchActivity;
    }

    public final void accept(Unit unit, Throwable th) {
        int intExtra = this.this$0.getIntent().getIntExtra(CategorySearchActivity.KEY_SUB_CATEGORY_POSITION, 0);
        ViewPager viewPager = (ViewPager) this.this$0._$_findCachedViewById(C0010R$id.pagerCategorySearch);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "pagerCategorySearch");
        viewPager.setCurrentItem(intExtra);
    }
}
