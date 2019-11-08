package kr.co.popone.fitts.paging.store.newest;

import android.annotation.SuppressLint;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class NewestProductDataSource extends ItemKeyedDataSource<Long, FeedItem> implements LifecycleObserver {
    /* access modifiers changed from: private */
    public String _version;
    @NotNull
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<SpecialDiscountInfo> specialDiscount = new MutableLiveData<>();
    @NotNull
    private final StoreRepository storeRepository;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<FeedItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public NewestProductDataSource(@NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final StoreRepository getStoreRepository() {
        return this.storeRepository;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    @NotNull
    public final MutableLiveData<SpecialDiscountInfo> getSpecialDiscount() {
        return this.specialDiscount;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<FeedItem> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkState.postValue(NetworkState.Companion.getINIT_LOADING());
        this.storeRepository.getStoreNewFeeds(Integer.valueOf(10)).subscribe(new NewestProductDataSource$loadInitial$1(this, loadInitialCallback), new NewestProductDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<FeedItem> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        String str = this._version;
        if (str != null) {
            this.networkState.postValue(NetworkState.Companion.getLOADING());
            this.storeRepository.getStoreFeeds(AppSettingsData.STATUS_NEW, str, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribe(new NewestProductDataSource$loadAfter$$inlined$let$lambda$1(this, loadParams, loadCallback), new NewestProductDataSource$loadAfter$$inlined$let$lambda$2(this, loadParams, loadCallback));
        }
    }

    @NotNull
    public Long getKey(@NotNull FeedItem feedItem) {
        Intrinsics.checkParameterIsNotNull(feedItem, "item");
        return Long.valueOf(feedItem instanceof Feed ? ((Feed) feedItem).getId() : -1);
    }
}
