package kr.co.popone.fitts.paging.store.list;

import android.annotation.SuppressLint;
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
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class ShopBookmarkDataSource extends ItemKeyedDataSource<Long, StoreInfo> {
    @NotNull
    private final MutableLiveData<Boolean> emptyListLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final StoreRepository storeRepository;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<StoreInfo> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public ShopBookmarkDataSource(@NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getEmptyListLiveData() {
        return this.emptyListLiveData;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<StoreInfo> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        this.storeRepository.getShopBookmarkList(null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe(new ShopBookmarkDataSource$loadInitial$1(this, loadInitialCallback), new ShopBookmarkDataSource$loadInitial$2(this));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<StoreInfo> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        this.storeRepository.getShopBookmarkList((Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ShopBookmarkDataSource$loadAfter$1(this, loadCallback), new ShopBookmarkDataSource$loadAfter$2(this));
    }

    @NotNull
    public Long getKey(@NotNull StoreInfo storeInfo) {
        Intrinsics.checkParameterIsNotNull(storeInfo, "item");
        return Long.valueOf(storeInfo.getId());
    }
}
