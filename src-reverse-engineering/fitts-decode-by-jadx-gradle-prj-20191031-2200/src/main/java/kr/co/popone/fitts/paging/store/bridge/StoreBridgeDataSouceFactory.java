package kr.co.popone.fitts.paging.store.bridge;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class StoreBridgeDataSouceFactory extends Factory<Long, FeedItem> {
    @NotNull
    private final MutableLiveData<StoreBridgeDataSource> dataSourceLiveData = new MutableLiveData<>();
    private final long storeId;
    private final StoreRepository storeRepository;

    public StoreBridgeDataSouceFactory(@NotNull StoreRepository storeRepository2, long j) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.storeRepository = storeRepository2;
        this.storeId = j;
    }

    @NotNull
    public final MutableLiveData<StoreBridgeDataSource> getDataSourceLiveData() {
        return this.dataSourceLiveData;
    }

    @NotNull
    public DataSource<Long, FeedItem> create() {
        StoreBridgeDataSource storeBridgeDataSource = new StoreBridgeDataSource(this.storeRepository, this.storeId);
        this.dataSourceLiveData.postValue(storeBridgeDataSource);
        return storeBridgeDataSource;
    }
}
