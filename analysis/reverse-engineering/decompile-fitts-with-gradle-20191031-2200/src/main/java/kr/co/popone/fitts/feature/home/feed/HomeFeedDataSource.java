package kr.co.popone.fitts.feature.home.feed;

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
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed.Type;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HomeFeedDataSource extends ItemKeyedDataSource<Long, Feed> {
    private final String feedRequestType;
    @NotNull
    private final MutableLiveData<Type> firstFeedType = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public String lastVersion;
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();
    private final FittsSocialRepository socialRepository;

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Feed> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public HomeFeedDataSource(@Nullable String str, @NotNull FittsSocialRepository fittsSocialRepository) {
        Intrinsics.checkParameterIsNotNull(fittsSocialRepository, "socialRepository");
        this.feedRequestType = str;
        this.socialRepository = fittsSocialRepository;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Type> getFirstFeedType() {
        return this.firstFeedType;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<Feed> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        String str = this.feedRequestType;
        if (str != null) {
            this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
            this.socialRepository.getHomeFeeds(str, null, null, loadInitialParams.requestedLoadSize).subscribe(new HomeFeedDataSource$loadInitial$$inlined$let$lambda$1(this, loadInitialParams, loadInitialCallback), new HomeFeedDataSource$loadInitial$$inlined$let$lambda$2(this, loadInitialParams, loadInitialCallback));
        }
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Feed> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        String str = this.lastVersion;
        if (str != null) {
            String str2 = this.feedRequestType;
            if (str2 != null) {
                this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
                this.socialRepository.getHomeFeeds(str2, str, (Long) loadParams.key, loadParams.requestedLoadSize).subscribe(new HomeFeedDataSource$loadAfter$$inlined$let$lambda$1(str, this, loadParams, loadCallback), new HomeFeedDataSource$loadAfter$$inlined$let$lambda$2(str, this, loadParams, loadCallback));
            }
        }
    }

    @NotNull
    public Long getKey(@NotNull Feed feed) {
        Intrinsics.checkParameterIsNotNull(feed, "item");
        return Long.valueOf(feed.getId());
    }
}
