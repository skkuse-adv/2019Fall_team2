package kr.co.popone.fitts.feature.category;

import java.util.List;
import kr.co.popone.fitts.feature.category.CategoryAdapter.CategoryHolder;
import kr.co.popone.fitts.feature.store.SubCategoryAdapter.Delegate;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.model.category.SubCategoryViewData;
import org.jetbrains.annotations.NotNull;

public final class CategoryAdapter$CategoryHolder$bindTo$$inlined$with$lambda$1 implements Delegate {
    final /* synthetic */ CategoryViewData $categoryViewData$inlined;
    final /* synthetic */ int $position$inlined;
    @NotNull
    private final List<SubCategoryViewData> items = this.$categoryViewData$inlined.getSubCategories();
    final /* synthetic */ CategoryHolder this$0;

    CategoryAdapter$CategoryHolder$bindTo$$inlined$with$lambda$1(CategoryHolder categoryHolder, int i, CategoryViewData categoryViewData) {
        this.this$0 = categoryHolder;
        this.$position$inlined = i;
        this.$categoryViewData$inlined = categoryViewData;
    }

    @NotNull
    public List<SubCategoryViewData> getItems() {
        return this.items;
    }

    public void onCategoryClicked(int i) {
        this.this$0.this$0.getDelegate().onCategoryClicked(this.this$0.this$0.getCategories(), this.$position$inlined, i);
    }
}
