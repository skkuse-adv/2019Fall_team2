package kr.co.popone.fitts.paging.category;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;
import kr.co.popone.fitts.repository.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategoryFeedListSourceFactory extends Factory<Long, CategoryPostItem> {
    @NotNull
    private final MutableLiveData<CategoryFeedListDataSource> categoryFeedLiveData = new MutableLiveData<>();
    private final int categoryId;
    private final CategoryRepository categoryRepository;
    private final Integer subCategoryId;

    public CategoryFeedListSourceFactory(@NotNull CategoryRepository categoryRepository2, int i, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(categoryRepository2, "categoryRepository");
        this.categoryRepository = categoryRepository2;
        this.categoryId = i;
        this.subCategoryId = num;
    }

    @NotNull
    public final MutableLiveData<CategoryFeedListDataSource> getCategoryFeedLiveData() {
        return this.categoryFeedLiveData;
    }

    @NotNull
    public DataSource<Long, CategoryPostItem> create() {
        CategoryFeedListDataSource categoryFeedListDataSource = new CategoryFeedListDataSource(this.categoryRepository, this.categoryId, this.subCategoryId);
        this.categoryFeedLiveData.postValue(categoryFeedListDataSource);
        return categoryFeedListDataSource;
    }
}
