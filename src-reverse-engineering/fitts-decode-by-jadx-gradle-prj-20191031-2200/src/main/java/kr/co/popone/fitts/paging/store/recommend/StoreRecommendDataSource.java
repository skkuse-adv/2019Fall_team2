package kr.co.popone.fitts.paging.store.recommend;

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
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class StoreRecommendDataSource extends ItemKeyedDataSource<Long, Feed> {
    @NotNull
    private final MutableLiveData<NetworkState> _networkState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public String feedVersion;
    private final StoreRepository storeRepository;
    private final String type;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Feed> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public StoreRecommendDataSource(@NotNull String str, @NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.type = str;
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> get_networkState() {
        return this._networkState;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<Feed> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this._networkState.postValue(NetworkState.Companion.getINIT_LOADING());
        this.storeRepository.getStoreFeeds(this.type, null, null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe(new StoreRecommendDataSource$loadInitial$1(this, loadInitialCallback), new StoreRecommendDataSource$loadInitial$2(this));
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Feed> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        String str = this.feedVersion;
        if (str != null) {
            this._networkState.postValue(NetworkState.Companion.getLOADING());
            this.storeRepository.getStoreFeeds(this.type, str, (Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new StoreRecommendDataSource$loadAfter$$inlined$let$lambda$1(this, loadParams, loadCallback), new StoreRecommendDataSource$loadAfter$$inlined$let$lambda$2(this, loadParams, loadCallback));
        }
    }

    @NotNull
    public Long getKey(@NotNull Feed feed) {
        Intrinsics.checkParameterIsNotNull(feed, "item");
        return Long.valueOf(feed.getId());
    }
}
