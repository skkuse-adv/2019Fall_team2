package kr.co.popone.fitts.viewmodel.store.home;

import android.app.Activity;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import com.orhanobut.logger.Logger;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.paging.store.recommend.StoreRecommendDataSouceFactory;
import kr.co.popone.fitts.paging.store.recommend.StoreRecommendDataSource;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreFeedViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ShopBookmarkEvent> _bookmarkEvent = new MutableLiveData<>();
    private final LiveData<PagedList<Feed>> _feedLiveData;
    private final LiveData<NetworkState> _networkState;
    private final MutableLiveData<Pair<String, String>> _productFeedLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<WishStateUpdateEvent> _productLikeEvent = new MutableLiveData<>();
    private final MutableLiveData<Long> _shopFeedIdLiveData = new MutableLiveData<>();
    private final FittsCommerceRepository commerceRepository;
    private final MutableLiveData<StoreRecommendDataSource> dataSource;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final EventTracker eventTracker;
    private final FittsSchemeHandler schemeHandler;
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;
    private final StoreFeedType storeFeedType;
    private final StoreRepository storeRepository;

    public enum StoreFeedType {
        TODAY("recommend"),
        BEST("best"),
        SHOP("shop");
        
        @NotNull
        private final String value;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                $EnumSwitchMapping$0 = new int[StoreFeedType.values().length];
                $EnumSwitchMapping$0[StoreFeedType.TODAY.ordinal()] = 1;
                $EnumSwitchMapping$0[StoreFeedType.BEST.ordinal()] = 2;
                $EnumSwitchMapping$0[StoreFeedType.SHOP.ordinal()] = 3;
            }
        }

        private StoreFeedType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @NotNull
        public final String toSubPath() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return "Home";
            }
            if (i == 2) {
                return "Sale";
            }
            if (i == 3) {
                return "Shop";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[StoreFeedType.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[StoreFeedType.values().length];

        static {
            $EnumSwitchMapping$0[StoreFeedType.TODAY.ordinal()] = 1;
            $EnumSwitchMapping$0[StoreFeedType.BEST.ordinal()] = 2;
            $EnumSwitchMapping$0[StoreFeedType.SHOP.ordinal()] = 3;
            $EnumSwitchMapping$1[StoreFeedType.TODAY.ordinal()] = 1;
            $EnumSwitchMapping$1[StoreFeedType.BEST.ordinal()] = 2;
            $EnumSwitchMapping$1[StoreFeedType.SHOP.ordinal()] = 3;
        }
    }

    public StoreFeedViewModel(@NotNull StoreRepository storeRepository2, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull EventTracker eventTracker2, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull SessionManager sessionManager2, @NotNull StoreFeedType storeFeedType2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(storeFeedType2, "storeFeedType");
        this.storeRepository = storeRepository2;
        this.commerceRepository = fittsCommerceRepository;
        this.schemeHandler = fittsSchemeHandler;
        this.eventTracker = eventTracker2;
        this.serviceRepository = fittsServiceRepository;
        this.sessionManager = sessionManager2;
        this.storeFeedType = storeFeedType2;
        StoreRecommendDataSouceFactory storeRecommendDataSouceFactory = new StoreRecommendDataSouceFactory(this.storeFeedType.getValue(), this.storeRepository);
        this.dataSource = storeRecommendDataSouceFactory.getStoreBestLiveData();
        LiveData<NetworkState> switchMap = Transformations.switchMap(storeRecommendDataSouceFactory.getStoreBestLiveData(), StoreFeedViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…tworkState\n\n            }");
        this._networkState = switchMap;
        LiveData<PagedList<Feed>> build = new LivePagedListBuilder((Factory<Key, Value>) storeRecommendDataSouceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(it, getPageConfig()).build()");
        this._feedLiveData = build;
        registerLikeProductBus();
        registerShopBookmarkBus();
    }

    @NotNull
    public final SessionManager getSession() {
        return this.sessionManager;
    }

    @NotNull
    public final LiveData<PagedList<Feed>> updateStoreFeeds() {
        return this._feedLiveData;
    }

    @NotNull
    public final LiveData<NetworkState> updateNetworkState() {
        return this._networkState;
    }

    @NotNull
    public final MutableLiveData<ShopBookmarkEvent> bookmarkStateUpdated() {
        return this._bookmarkEvent;
    }

    @NotNull
    public final MutableLiveData<WishStateUpdateEvent> updateProductLikeState() {
        return this._productLikeEvent;
    }

    @NotNull
    public final MutableLiveData<Long> routeStoreBridge() {
        return this._shopFeedIdLiveData;
    }

    @NotNull
    public final MutableLiveData<Pair<String, String>> routeStoreBrowser() {
        return this._productFeedLiveData;
    }

    public final void refreshStoreFeeds() {
        StoreRecommendDataSource storeRecommendDataSource = (StoreRecommendDataSource) this.dataSource.getValue();
        if (storeRecommendDataSource != null) {
            storeRecommendDataSource.invalidate();
        }
    }

    private final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(10).setPrefetchDistance(3).setPageSize(10).build();
    }

    private final void registerLikeProductBus() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(WishStateUpdateEvent.class).subscribe(new StoreFeedViewModel$registerLikeProductBus$1(this), StoreFeedViewModel$registerLikeProductBus$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …vent\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    private final void registerShopBookmarkBus() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(ShopBookmarkEvent.class).subscribe(new StoreFeedViewModel$registerShopBookmarkBus$1(this), StoreFeedViewModel$registerShopBookmarkBus$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …vent\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void addLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.addWishProduct(j).subscribe(new StoreFeedViewModel$addLikeProductClick$1(this, j), new StoreFeedViewModel$addLikeProductClick$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.addWi…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void removeLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.deleteWishProduct(j).subscribe(new StoreFeedViewModel$removeLikeProductClick$1(this, j), new StoreFeedViewModel$removeLikeProductClick$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.delet…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void addShopBookmarkClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.addShopBookmark(j).subscribe(new StoreFeedViewModel$addShopBookmarkClick$1(this, j), StoreFeedViewModel$addShopBookmarkClick$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.addShopB…iled\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void removeShopBookmarkClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.deleteShopBookmark(j).subscribe(new StoreFeedViewModel$removeShopBookmarkClick$1(this, j), StoreFeedViewModel$removeShopBookmarkClick$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.deleteSh…iled\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void recordCurrentPostion(int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.storeFeedType.ordinal()];
        if (i2 == 1) {
            this.eventTracker.updateDistanceStoreHome(i);
        } else if (i2 == 2) {
            this.eventTracker.updateDistanceStoreBest(i);
        } else if (i2 == 3) {
            this.eventTracker.updateDistanceStoreList(i);
        }
    }

    public final void productFeedClick(long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        leaveProductClickActionLog(j);
        MutableLiveData<Pair<String, String>> mutableLiveData = this._productFeedLiveData;
        StringBuilder sb = new StringBuilder();
        sb.append("store ");
        sb.append(getTabName());
        mutableLiveData.setValue(new Pair(str, sb.toString()));
    }

    /* access modifiers changed from: private */
    public final String getTabName() {
        int i = WhenMappings.$EnumSwitchMapping$1[this.storeFeedType.ordinal()];
        if (i == 1) {
            return "home";
        }
        if (i == 2) {
            return "best";
        }
        if (i == 3) {
            return "shop";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void storeBannerClicked(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (str != null) {
            this.schemeHandler.handleScheme(activity, str);
            leaveCollectionClickActionLog(str);
        }
    }

    public final void storeViewSchemeClick(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (str != null) {
            this.schemeHandler.handleScheme(activity, str);
            leaveCollectionClickActionLog(str);
        }
    }

    private final void leaveProductClickActionLog(long j) {
        ActionLog actionLog = new ActionLog("product", "StoreHomeFeed", this.storeFeedType.toSubPath(), null, Long.valueOf(j), null, 32, null);
        DisposableKt.addTo(SubscribersKt.subscribeBy(this.serviceRepository.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) StoreFeedViewModel$leaveProductClickActionLog$1$1.INSTANCE, (Function0<Unit>) StoreFeedViewModel$leaveProductClickActionLog$1$2.INSTANCE), this.disposables);
    }

    private final void leaveCollectionClickActionLog(String str) {
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "fitts") && Intrinsics.areEqual((Object) parse.getHost(), (Object) "collection")) {
            try {
                String lastPathSegment = parse.getLastPathSegment();
                if (lastPathSegment != null) {
                    ActionLog actionLog = new ActionLog("collection", "StoreHomeFeed", this.storeFeedType.toSubPath(), null, Long.valueOf(Long.parseLong(lastPathSegment)), null, 32, null);
                    DisposableKt.addTo(SubscribersKt.subscribeBy(this.serviceRepository.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) StoreFeedViewModel$leaveCollectionClickActionLog$1$1$1.INSTANCE, (Function0<Unit>) StoreFeedViewModel$leaveCollectionClickActionLog$1$1$2.INSTANCE), this.disposables);
                }
            } catch (Exception unused) {
                Logger.d("uri parsing error", new Object[0]);
            }
        }
    }

    public final void shopFeedClick(long j) {
        this.eventTracker.customLogTapShopList("shop_list");
        this._shopFeedIdLiveData.setValue(Long.valueOf(j));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
