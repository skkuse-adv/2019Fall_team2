package kr.co.popone.fitts.paging.store.recommend;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class StoreRecommendDataSouceFactory extends Factory<Long, Feed> {
    @NotNull
    private final MutableLiveData<StoreRecommendDataSource> storeBestLiveData = new MutableLiveData<>();
    private final StoreRepository storeRepository;
    private final String type;

    public StoreRecommendDataSouceFactory(@NotNull String str, @NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.type = str;
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final MutableLiveData<StoreRecommendDataSource> getStoreBestLiveData() {
        return this.storeBestLiveData;
    }

    @NotNull
    public DataSource<Long, Feed> create() {
        StoreRecommendDataSource storeRecommendDataSource = new StoreRecommendDataSource(this.type, this.storeRepository);
        this.storeBestLiveData.postValue(storeRecommendDataSource);
        return storeRecommendDataSource;
    }
}
