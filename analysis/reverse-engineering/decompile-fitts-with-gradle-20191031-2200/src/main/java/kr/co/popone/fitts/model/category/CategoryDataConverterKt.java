package kr.co.popone.fitts.model.category;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CategoryDataConverterKt {
    @NotNull
    public static final CategoryViewData convert(@NotNull CategoryData categoryData) {
        Intrinsics.checkParameterIsNotNull(categoryData, "receiver$0");
        CategoryViewData categoryViewData = new CategoryViewData(categoryData.getId(), categoryData.getIcon(), categoryData.getSection(), convertAsSubcategoryViewData(categoryData.getSubSections()));
        return categoryViewData;
    }

    @NotNull
    public static final SubCategoryViewData convert(@NotNull CategorySubData categorySubData) {
        Intrinsics.checkParameterIsNotNull(categorySubData, "receiver$0");
        return new SubCategoryViewData(Long.valueOf(categorySubData.getId()), categorySubData.getName());
    }

    @NotNull
    public static final List<CategoryViewData> convert(@NotNull List<CategoryData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CategoryData convert : list) {
            arrayList.add(convert(convert));
        }
        return arrayList;
    }

    @NotNull
    public static final List<SubCategoryViewData> convertAsSubcategoryViewData(@NotNull List<CategorySubData> list) {
        Intrinsics.checkParameterIsNotNull(list, "receiver$0");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (CategorySubData convert : list) {
            arrayList.add(convert(convert));
        }
        return arrayList;
    }
}
