package kr.co.popone.fitts.paging.product;

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
import kr.co.popone.fitts.model.product.CategoryProductItem;
import kr.co.popone.fitts.repository.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedListDataSource extends ItemKeyedDataSource<Long, CategoryProductItem> {
    private final int categoryId;
    private final CategoryRepository categoryRepository;
    /* access modifiers changed from: private */
    public String lastVersion;
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final Integer subCategoryId;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<CategoryProductItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public ProductFeedListDataSource(@NotNull CategoryRepository categoryRepository2, int i, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(categoryRepository2, "categoryRepository");
        this.categoryRepository = categoryRepository2;
        this.categoryId = i;
        this.subCategoryId = num;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<CategoryProductItem> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.categoryRepository.getProductCategories(this.categoryId, this.subCategoryId, null, (Long) loadInitialParams.requestedInitialKey, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe(new ProductFeedListDataSource$loadInitial$1(this, loadInitialCallback), new ProductFeedListDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<CategoryProductItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        String str = this.lastVersion;
        if (str != null) {
            this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
            this.categoryRepository.getProductCategories(this.categoryId, this.subCategoryId, str, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribe(new ProductFeedListDataSource$loadAfter$$inlined$let$lambda$1(this, loadParams, loadCallback), new ProductFeedListDataSource$loadAfter$$inlined$let$lambda$2(this, loadParams, loadCallback));
        }
    }

    @NotNull
    public Long getKey(@NotNull CategoryProductItem categoryProductItem) {
        Intrinsics.checkParameterIsNotNull(categoryProductItem, "item");
        return Long.valueOf(categoryProductItem.getFeedId());
    }
}
