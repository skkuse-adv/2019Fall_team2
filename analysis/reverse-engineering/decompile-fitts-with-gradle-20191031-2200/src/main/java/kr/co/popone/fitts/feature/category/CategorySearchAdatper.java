package kr.co.popone.fitts.feature.category;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.category.CategorySearchFragment.Companion;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.model.category.SubCategoryViewData;
import kr.co.popone.fitts.ui.custom.CateSearchTypeCustomView.CategoryFeedType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategorySearchAdatper extends FragmentStatePagerAdapter {
    private int categoryId;
    @NotNull
    private final PublishSubject<Unit> initialSubCategories;
    private List<SubCategoryViewData> subCategories = new ArrayList();
    @NotNull
    private CategoryFeedType type;

    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "object");
        return -2;
    }

    public CategorySearchAdatper(@Nullable FragmentManager fragmentManager) {
        super(fragmentManager);
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkExpressionValueIsNotNull(create, "PublishSubject.create<Unit>()");
        this.initialSubCategories = create;
        this.type = CategoryFeedType.POST;
    }

    private final void setSubCategories(List<SubCategoryViewData> list) {
        this.subCategories = list;
        this.initialSubCategories.onNext(Unit.INSTANCE);
    }

    @NotNull
    public final PublishSubject<Unit> getInitialSubCategories() {
        return this.initialSubCategories;
    }

    @NotNull
    public final CategoryFeedType getType() {
        return this.type;
    }

    public final void setType(@NotNull CategoryFeedType categoryFeedType) {
        Intrinsics.checkParameterIsNotNull(categoryFeedType, "<set-?>");
        this.type = categoryFeedType;
    }

    public final void setCategoryItem(@NotNull ArrayList<CategoryViewData> arrayList, int i) {
        Intrinsics.checkParameterIsNotNull(arrayList, "categories");
        this.categoryId = (int) ((CategoryViewData) arrayList.get(i)).getCategoryId();
        setSubCategories(((CategoryViewData) arrayList.get(i)).getSubCategories());
        notifyDataSetChanged();
    }

    @Nullable
    public CharSequence getPageTitle(int i) {
        return i != 0 ? ((SubCategoryViewData) this.subCategories.get(i - 1)).getSubCategory() : "전체";
    }

    @NotNull
    public Fragment getItem(int i) {
        Integer num = null;
        if (i == 0) {
            return CategorySearchFragment.Companion.newInstance(this.categoryId, null, this.type.name());
        }
        Companion companion = CategorySearchFragment.Companion;
        int i2 = this.categoryId;
        Long subCategoryId = ((SubCategoryViewData) this.subCategories.get(i - 1)).getSubCategoryId();
        if (subCategoryId != null) {
            num = Integer.valueOf((int) subCategoryId.longValue());
        }
        return companion.newInstance(i2, num, this.type.name());
    }

    public int getCount() {
        return this.subCategories.size() + 1;
    }
}
