package kr.co.popone.fitts.paging.category;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;
import kr.co.popone.fitts.repository.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CategoryFeedListDataSource extends ItemKeyedDataSource<Long, CategoryPostItem> {
    private final int categoryId;
    private final CategoryRepository categoryRepository;
    /* access modifiers changed from: private */
    public String lastVersion;
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final Integer subCategoryId;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<CategoryPostItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public CategoryFeedListDataSource(@NotNull CategoryRepository categoryRepository2, int i, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(categoryRepository2, "categoryRepository");
        this.categoryRepository = categoryRepository2;
        this.categoryId = i;
        this.subCategoryId = num;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<CategoryPostItem> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.categoryRepository.requestPostsByCategory(this.categoryId, this.subCategoryId, null, null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CategoryFeedListDataSource$loadInitial$1(this, loadInitialCallback), new CategoryFeedListDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<CategoryPostItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        String str = this.lastVersion;
        if (str != null) {
            this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
            this.categoryRepository.requestPostsByCategory(this.categoryId, this.subCategoryId, str, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CategoryFeedListDataSource$loadAfter$$inlined$let$lambda$1(this, loadParams, loadCallback), new CategoryFeedListDataSource$loadAfter$$inlined$let$lambda$2(this, loadParams, loadCallback));
        }
    }

    @NotNull
    public Long getKey(@NotNull CategoryPostItem categoryPostItem) {
        Intrinsics.checkParameterIsNotNull(categoryPostItem, "item");
        return Long.valueOf(categoryPostItem.getFeedId());
    }
}
