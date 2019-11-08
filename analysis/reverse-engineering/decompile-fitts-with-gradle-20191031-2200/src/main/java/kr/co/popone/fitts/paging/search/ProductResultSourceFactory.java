package kr.co.popone.fitts.paging.search;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.repository.SearchRepository;
import org.jetbrains.annotations.NotNull;

public final class ProductResultSourceFactory extends Factory<Long, SearchResult> {
    @NotNull
    private final String keyword;
    @NotNull
    private final MutableLiveData<ProductResultDataSource> productsDataSource = new MutableLiveData<>();
    @NotNull
    private final SearchRepository searchRepository;

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    public final SearchRepository getSearchRepository() {
        return this.searchRepository;
    }

    public ProductResultSourceFactory(@NotNull String str, @NotNull SearchRepository searchRepository2) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        this.keyword = str;
        this.searchRepository = searchRepository2;
    }

    @NotNull
    public final MutableLiveData<ProductResultDataSource> getProductsDataSource() {
        return this.productsDataSource;
    }

    @NotNull
    public DataSource<Long, SearchResult> create() {
        ProductResultDataSource productResultDataSource = new ProductResultDataSource(this.keyword, this.searchRepository);
        this.productsDataSource.postValue(productResultDataSource);
        return productResultDataSource;
    }
}
