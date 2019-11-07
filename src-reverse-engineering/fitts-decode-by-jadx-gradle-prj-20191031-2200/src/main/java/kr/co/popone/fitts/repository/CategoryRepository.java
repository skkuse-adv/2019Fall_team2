package kr.co.popone.fitts.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.category.CategoryAPI;
import kr.co.popone.fitts.model.category.CategoryViewData;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse;
import kr.co.popone.fitts.model.product.CategoryProductListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategoryRepository {
    private final CategoryAPI categoryAPI;

    public CategoryRepository(@NotNull CategoryAPI categoryAPI2) {
        Intrinsics.checkParameterIsNotNull(categoryAPI2, "categoryAPI");
        this.categoryAPI = categoryAPI2;
    }

    public final Single<List<CategoryViewData>> getCategoryList() {
        return this.categoryAPI.getCategoryList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(CategoryRepository$getCategoryList$1.INSTANCE).retry(2);
    }

    @NotNull
    public final Single<CategoryPostListResponse> requestPostsByCategory(int i, @Nullable Integer num, @Nullable String str, @Nullable Long l, @Nullable Integer num2) {
        Single<CategoryPostListResponse> observeOn = this.categoryAPI.getPostCategoryList(i, num, str, l, num2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "categoryAPI.getPostCateg…dSchedulers.mainThread())");
        return observeOn;
    }

    @NotNull
    public final Single<CategoryProductListResponse> getProductCategories(int i, @Nullable Integer num, @Nullable String str, @Nullable Long l, @Nullable Integer num2) {
        Single<CategoryProductListResponse> observeOn = this.categoryAPI.getProductCategoryList(i, num, str, l, num2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "categoryAPI.getProductCa…dSchedulers.mainThread())");
        return observeOn;
    }
}
