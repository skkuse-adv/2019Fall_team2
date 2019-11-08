package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.category.CategoryData;
import kr.co.popone.fitts.model.category.CategoryDataConverterKt;
import kr.co.popone.fitts.model.category.CategoryViewData;
import org.jetbrains.annotations.NotNull;

final class CategoryRepository$getCategoryList$1<T, R> implements Function<T, R> {
    public static final CategoryRepository$getCategoryList$1 INSTANCE = new CategoryRepository$getCategoryList$1();

    CategoryRepository$getCategoryList$1() {
    }

    @NotNull
    public final List<CategoryViewData> apply(@NotNull List<CategoryData> list) {
        Intrinsics.checkParameterIsNotNull(list, "it");
        return CategoryDataConverterKt.convert(list);
    }
}
