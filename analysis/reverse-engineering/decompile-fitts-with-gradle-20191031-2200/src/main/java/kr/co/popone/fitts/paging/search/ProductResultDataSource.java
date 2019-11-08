package kr.co.popone.fitts.paging.search;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.search.SearchResult;
import kr.co.popone.fitts.model.search.SearchResult.ProductSearchResult;
import kr.co.popone.fitts.repository.SearchRepository;
import org.jetbrains.annotations.NotNull;

public final class ProductResultDataSource extends ItemKeyedDataSource<Long, SearchResult> {
    @NotNull
    private final MutableLiveData<Boolean> isEmptyProducts = new MutableLiveData<>();
    @NotNull
    private final String keyword;
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    @NotNull
    private final SearchRepository searchRepository;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<SearchResult> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public ProductResultDataSource(@NotNull String str, @NotNull SearchRepository searchRepository2) {
        Intrinsics.checkParameterIsNotNull(str, SearchResultFragment.KEY_KEYWORD);
        Intrinsics.checkParameterIsNotNull(searchRepository2, "searchRepository");
        this.keyword = str;
        this.searchRepository = searchRepository2;
    }

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    @NotNull
    public final SearchRepository getSearchRepository() {
        return this.searchRepository;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> isEmptyProducts() {
        return this.isEmptyProducts;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<SearchResult> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.searchRepository.getKeywordProductSearchList(this.keyword, null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe(new ProductResultDataSource$loadInitial$1(this, loadInitialCallback), new ProductResultDataSource$loadInitial$2(this));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<SearchResult> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        Long l = (Long) loadParams.key;
        if (l == null || l.longValue() != -35) {
            this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
            this.searchRepository.getKeywordProductSearchList(this.keyword, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribe(new ProductResultDataSource$loadAfter$1(this, loadCallback), new ProductResultDataSource$loadAfter$2(this));
        }
    }

    @NotNull
    public Long getKey(@NotNull SearchResult searchResult) {
        Intrinsics.checkParameterIsNotNull(searchResult, "item");
        return Long.valueOf(searchResult instanceof ProductSearchResult ? ((ProductSearchResult) searchResult).getProduct().getId() : -35);
    }
}
