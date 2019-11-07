package kr.co.popone.fitts.viewmodel.wish;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.paging.wish.WishListDataSource;
import kr.co.popone.fitts.paging.wish.WishListSourceFactory;
import org.jetbrains.annotations.NotNull;

public final class WishListViewModel extends BaseViewModel {
    private final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    @NotNull
    private final LiveData<Boolean> isEmptyList;
    @NotNull
    private final LiveData<NetworkState> networkState;
    private final LiveData<WishListDataSource> wishListDataSource;
    @NotNull
    private final LiveData<PagedList<ProductFeedViewData>> wishListFeeds;

    public WishListViewModel(@NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.commerceRepository = fittsCommerceRepository;
        this.eventTracker = eventTracker2;
        WishListSourceFactory wishListSourceFactory = new WishListSourceFactory(this.commerceRepository);
        this.wishListDataSource = wishListSourceFactory.getWishListLiveData();
        LiveData<NetworkState> switchMap = Transformations.switchMap(wishListSourceFactory.getWishListLiveData(), WishListViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…ateLiveData\n            }");
        this.networkState = switchMap;
        LiveData<Boolean> switchMap2 = Transformations.switchMap(wishListSourceFactory.getWishListLiveData(), WishListViewModel$1$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…isEmptyList\n            }");
        this.isEmptyList = switchMap2;
        LiveData<PagedList<ProductFeedViewData>> build = new LivePagedListBuilder((Factory<Key, Value>) wishListSourceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(it, getPageConfig()).build()");
        this.wishListFeeds = build;
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().filter(AnonymousClass2.INSTANCE).subscribeOn(Schedulers.io()).subscribe((Consumer<? super T>) new Consumer<Object>(this) {
            final /* synthetic */ WishListViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Object obj) {
                this.this$0.refresh();
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …fresh()\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        leaveWishListLog();
    }

    @NotNull
    public final LiveData<PagedList<ProductFeedViewData>> getWishListFeeds() {
        return this.wishListFeeds;
    }

    @NotNull
    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    @NotNull
    public final LiveData<Boolean> isEmptyList() {
        return this.isEmptyList;
    }

    public final void leaveWishListLog() {
        DefaultImpls.logCustom$default(this.eventTracker, "Tap Wishlist", null, 2, null);
    }

    public final void refresh() {
        WishListDataSource wishListDataSource2 = (WishListDataSource) this.wishListDataSource.getValue();
        if (wishListDataSource2 != null) {
            wishListDataSource2.invalidate();
        }
    }

    private final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(15).setPrefetchDistance(3).setPageSize(15).setEnablePlaceholders(true).build();
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
