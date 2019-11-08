package kr.co.popone.fitts.viewmodel.store.bridge;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI.DefaultImpls;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.paging.store.bridge.StoreBridgeDataSouceFactory;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopBridgeViewModel extends BaseViewModel {
    private final LiveData<NetworkState> _networkState;
    /* access modifiers changed from: private */
    public final MutableLiveData<WishStateUpdateEvent> _productLikeEvent = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<ShopBookmarkEvent> _shopBookmarkEvent = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MediatorLiveData<Integer> _shopBookmarkIcon = new MediatorLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _shopBookmarkState = new MutableLiveData<>();
    private final Function0<LiveData<PagedList<FeedItem>>> _shopBridgeFeeds;
    private final MutableLiveData<String> _shopLinkUrl = new MutableLiveData<>();
    private final MutableLiveData<String> _shopTitleName = new MutableLiveData<>();
    private final MutableLiveData<String> _storeBrowserUrl = new MutableLiveData<>();
    private final ActionLogAPI actionLogAPI;
    private final FittsCommerceRepository commerceRepository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final EventTracker eventTracker;
    private final FittsSchemeHandler schemeHandler;
    private final SessionManager sessionManager;
    /* access modifiers changed from: private */
    public final long storeId;
    private final StoreRepository storeRepository;

    public ShopBridgeViewModel(long j, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull StoreRepository storeRepository2, @NotNull ActionLogAPI actionLogAPI2, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull SessionManager sessionManager2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(actionLogAPI2, "actionLogAPI");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.storeId = j;
        this.commerceRepository = fittsCommerceRepository;
        this.storeRepository = storeRepository2;
        this.actionLogAPI = actionLogAPI2;
        this.schemeHandler = fittsSchemeHandler;
        this.sessionManager = sessionManager2;
        this.eventTracker = eventTracker2;
        StringBuilder sb = new StringBuilder();
        sb.append("StoreId = ");
        sb.append(this.storeId);
        Logger.d(sb.toString(), new Object[0]);
        StoreBridgeDataSouceFactory storeBridgeDataSouceFactory = new StoreBridgeDataSouceFactory(this.storeRepository, this.storeId);
        LiveData<NetworkState> switchMap = Transformations.switchMap(storeBridgeDataSouceFactory.getDataSourceLiveData(), ShopBridgeViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…ateLiveData\n            }");
        this._networkState = switchMap;
        this._shopBridgeFeeds = new ShopBridgeViewModel$$special$$inlined$run$lambda$1(storeBridgeDataSouceFactory, this);
        this._shopBookmarkIcon.addSource(this._shopBookmarkState, new Observer<S>(this) {
            final /* synthetic */ ShopBridgeViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(Boolean bool) {
                Integer num;
                MediatorLiveData access$get_shopBookmarkIcon$p = this.this$0._shopBookmarkIcon;
                if (Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(true))) {
                    num = Integer.valueOf(C0008R$drawable.img_icon_bookmark_on);
                } else if (Intrinsics.areEqual((Object) bool, (Object) Boolean.valueOf(false))) {
                    num = Integer.valueOf(C0008R$drawable.img_icon_bookmark_off);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                access$get_shopBookmarkIcon$p.setValue(num);
            }
        });
        getShopDetailInfo();
        registerShopBookmarkEvent();
        registerProductLikeEvent();
    }

    @NotNull
    public final LiveData<PagedList<FeedItem>> shopBridgeFeedsUpdated() {
        return (LiveData) this._shopBridgeFeeds.invoke();
    }

    @NotNull
    public final MutableLiveData<String> shopTitleUpdated() {
        return this._shopTitleName;
    }

    @NotNull
    public final MutableLiveData<String> shopLinkUrlUpdated() {
        return this._shopLinkUrl;
    }

    @NotNull
    public final MediatorLiveData<Integer> updateBookmarkIcon() {
        return this._shopBookmarkIcon;
    }

    @NotNull
    public final MutableLiveData<ShopBookmarkEvent> shopBookmarkEventUpdated() {
        return this._shopBookmarkEvent;
    }

    @NotNull
    public final MutableLiveData<WishStateUpdateEvent> productLikeEventUpdated() {
        return this._productLikeEvent;
    }

    @NotNull
    public final LiveData<NetworkState> updateNetworkState() {
        return this._networkState;
    }

    @NotNull
    public final MutableLiveData<String> routeToStoreBrowser() {
        return this._storeBrowserUrl;
    }

    @NotNull
    public final MutableLiveData<Throwable> errorOccur() {
        return getErrorLiveData();
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    /* access modifiers changed from: private */
    public final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(10).setPrefetchDistance(3).setPageSize(10).build();
    }

    private final void getShopDetailInfo() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.getStoreDetailInfo(this.storeId).subscribe(new ShopBridgeViewModel$getShopDetailInfo$1(this), ShopBridgeViewModel$getShopDetailInfo$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.getStore….d(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final void updateShopInfo(StoreInfo storeInfo) {
        this._shopTitleName.postValue(storeInfo.getStoreName());
        this._shopLinkUrl.postValue(storeInfo.getStoreUrl());
        this._shopBookmarkState.postValue(Boolean.valueOf(storeInfo.isBookmark()));
    }

    private final void registerShopBookmarkEvent() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(ShopBookmarkEvent.class).subscribe(new ShopBridgeViewModel$registerShopBookmarkEvent$1(this), ShopBridgeViewModel$registerShopBookmarkEvent$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   … }, {\n\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    private final void registerProductLikeEvent() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(WishStateUpdateEvent.class).subscribe(new ShopBridgeViewModel$registerProductLikeEvent$1(this), ShopBridgeViewModel$registerProductLikeEvent$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   … }, {\n\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void productFeedClick(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this._storeBrowserUrl.setValue(str);
        shopBridgeActionLog();
    }

    private final void shopBridgeActionLog() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = DefaultImpls.collectActionLog$default(this.actionLogAPI, "Product", "ShopBridge", null, Long.valueOf(this.storeId), null, 16, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ShopBridgeViewModel$shopBridgeActionLog$1(this), new ShopBridgeViewModel$shopBridgeActionLog$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "actionLogAPI.collectActi…reId\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void handleScheme(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (str != null) {
            this.schemeHandler.handleScheme(activity, str);
        }
    }

    public final void bookmarkButtonClick() {
        if (Intrinsics.areEqual((Object) (Boolean) this._shopBookmarkState.getValue(), (Object) Boolean.valueOf(true))) {
            removeShopBookmark(this.storeId);
        } else {
            addShopBookmark(this.storeId);
        }
    }

    public final void addShopBookmark(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.addShopBookmark(j).subscribe(new ShopBridgeViewModel$addShopBookmark$1(this, j), new ShopBridgeViewModel$addShopBookmark$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.addShopB…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void removeShopBookmark(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.storeRepository.deleteShopBookmark(j).subscribe(new ShopBridgeViewModel$removeShopBookmark$1(this, j), new ShopBridgeViewModel$removeShopBookmark$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "storeRepository.deleteSh…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void addLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.addWishProduct(j).subscribe(new ShopBridgeViewModel$addLikeProductClick$1(j), new ShopBridgeViewModel$addLikeProductClick$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.addWi…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void removeLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.deleteWishProduct(j).subscribe(new ShopBridgeViewModel$removeLikeProductClick$1(j), new ShopBridgeViewModel$removeLikeProductClick$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.delet…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
