package kr.co.popone.fitts.paging.product;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.CategoryProductItem;
import kr.co.popone.fitts.repository.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedListSourceFactory extends Factory<Long, CategoryProductItem> {
    private final int categoryId;
    private final CategoryRepository categoryRepository;
    @NotNull
    private final MutableLiveData<ProductFeedListDataSource> productFeedLiveData = new MutableLiveData<>();
    private final Integer subCategoryId;

    public ProductFeedListSourceFactory(@NotNull CategoryRepository categoryRepository2, int i, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(categoryRepository2, "categoryRepository");
        this.categoryRepository = categoryRepository2;
        this.categoryId = i;
        this.subCategoryId = num;
    }

    @NotNull
    public final MutableLiveData<ProductFeedListDataSource> getProductFeedLiveData() {
        return this.productFeedLiveData;
    }

    @NotNull
    public DataSource<Long, CategoryProductItem> create() {
        ProductFeedListDataSource productFeedListDataSource = new ProductFeedListDataSource(this.categoryRepository, this.categoryId, this.subCategoryId);
        this.productFeedLiveData.postValue(productFeedListDataSource);
        return productFeedListDataSource;
    }
}
