package kr.co.popone.fitts.paging.wish;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;

public final class WishListSourceFactory extends Factory<Long, ProductFeedViewData> {
    private final FittsCommerceRepository commerceRepository;
    @NotNull
    private final MutableLiveData<WishListDataSource> wishListLiveData = new MutableLiveData<>();

    public WishListSourceFactory(@NotNull FittsCommerceRepository fittsCommerceRepository) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        this.commerceRepository = fittsCommerceRepository;
    }

    @NotNull
    public final MutableLiveData<WishListDataSource> getWishListLiveData() {
        return this.wishListLiveData;
    }

    @NotNull
    public DataSource<Long, ProductFeedViewData> create() {
        WishListDataSource wishListDataSource = new WishListDataSource(this.commerceRepository);
        this.wishListLiveData.postValue(wishListDataSource);
        return wishListDataSource;
    }
}
