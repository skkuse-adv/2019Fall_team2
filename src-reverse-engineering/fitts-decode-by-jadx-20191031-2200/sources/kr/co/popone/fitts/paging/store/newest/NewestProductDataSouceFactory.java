package kr.co.popone.fitts.paging.store.newest;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.repository.StoreRepository;
import org.jetbrains.annotations.NotNull;

public final class NewestProductDataSouceFactory extends Factory<Long, FeedItem> {
    @NotNull
    private final MutableLiveData<NewestProductDataSource> dataSourceLiveData = new MutableLiveData<>();
    private final StoreRepository storeRepository;

    public NewestProductDataSouceFactory(@NotNull StoreRepository storeRepository2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        this.storeRepository = storeRepository2;
    }

    @NotNull
    public final MutableLiveData<NewestProductDataSource> getDataSourceLiveData() {
        return this.dataSourceLiveData;
    }

    @NotNull
    public DataSource<Long, FeedItem> create() {
        NewestProductDataSource newestProductDataSource = new NewestProductDataSource(this.storeRepository);
        this.dataSourceLiveData.postValue(newestProductDataSource);
        return newestProductDataSource;
    }
}
