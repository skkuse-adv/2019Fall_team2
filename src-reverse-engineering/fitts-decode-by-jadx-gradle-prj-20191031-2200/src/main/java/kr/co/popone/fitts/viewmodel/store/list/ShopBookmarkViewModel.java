package kr.co.popone.fitts.viewmodel.store.list;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.store.StoreInfo;
import kr.co.popone.fitts.paging.store.list.ShopBookmarkDataSource;
import kr.co.popone.fitts.paging.store.list.ShopBookmarkListDataSourceFactory;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;
import org.jetbrains.annotations.NotNull;

public final class ShopBookmarkViewModel extends BaseViewModel {
    private final ActionLogUtil actionLogUtil;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final EventTracker eventTracker;
    private final LiveData<Boolean> isEmptyList;
    private final LiveData<NetworkState> networkState;
    private final FittsSchemeHandler schemeHandler;
    /* access modifiers changed from: private */
    public final LiveData<ShopBookmarkDataSource> shopBookmarkDataSource;
    private final MutableLiveData<Long> shopBridgeLiveData = new MutableLiveData<>();
    private final LiveData<PagedList<StoreInfo>> shopPagedBookmarksLiveData;
    private final StoreRepository storeRepository;

    public ShopBookmarkViewModel(@NotNull StoreRepository storeRepository2, @NotNull EventTracker eventTracker2, @NotNull ActionLogUtil actionLogUtil2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(actionLogUtil2, "actionLogUtil");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.storeRepository = storeRepository2;
        this.eventTracker = eventTracker2;
        this.actionLogUtil = actionLogUtil2;
        this.schemeHandler = fittsSchemeHandler;
        Logger.d("ShopBookmarkViewModel::INIT", new Object[0]);
        ShopBookmarkListDataSourceFactory shopBookmarkListDataSourceFactory = new ShopBookmarkListDataSourceFactory(this.storeRepository);
        this.shopBookmarkDataSource = shopBookmarkListDataSourceFactory.getShopBookmarkLiveData();
        LiveData<NetworkState> switchMap = Transformations.switchMap(shopBookmarkListDataSourceFactory.getShopBookmarkLiveData(), ShopBookmarkViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…ateLiveData\n            }");
        this.networkState = switchMap;
        LiveData<Boolean> switchMap2 = Transformations.switchMap(shopBookmarkListDataSourceFactory.getShopBookmarkLiveData(), ShopBookmarkViewModel$1$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…istLiveData\n            }");
        this.isEmptyList = switchMap2;
        LiveData<PagedList<StoreInfo>> build = new LivePagedListBuilder((Factory<Key, Value>) shopBookmarkListDataSourceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(fac… getPageConfig()).build()");
        this.shopPagedBookmarksLiveData = build;
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(ShopBookmarkEvent.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ShopBookmarkEvent>(this) {
            final /* synthetic */ ShopBookmarkViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(ShopBookmarkEvent shopBookmarkEvent) {
                ShopBookmarkDataSource shopBookmarkDataSource = (ShopBookmarkDataSource) this.this$0.shopBookmarkDataSource.getValue();
                if (shopBookmarkDataSource != null) {
                    shopBookmarkDataSource.invalidate();
                }
            }
        }, AnonymousClass3.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …iled\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final LiveData<PagedList<StoreInfo>> bookmarkListUpdated() {
        return this.shopPagedBookmarksLiveData;
    }

    @NotNull
    public final LiveData<NetworkState> networkStateUpdated() {
        return this.networkState;
    }

    @NotNull
    public final LiveData<Boolean> viewisiblityUpdated() {
        return this.isEmptyList;
    }

    @NotNull
    public final MutableLiveData<Long> navToShopBridge() {
        return this.shopBridgeLiveData;
    }

    private final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(8).setPrefetchDistance(3).setPageSize(10).build();
    }

    private final void actionLogShopSelect(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.actionLogUtil.actionLogShopListSelectedShop(j).subscribe(ShopBookmarkViewModel$actionLogShopSelect$1.INSTANCE, ShopBookmarkViewModel$actionLogShopSelect$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "actionLogUtil.actionLogS…:$it\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void moveToShopListButtonClick(@NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.schemeHandler.handleScheme(activity, "fitts://storeHome?tabName=shop");
    }

    public final void bookmarkShopClicked(long j) {
        this.eventTracker.customLogTapShopList("bookmark_list");
        actionLogShopSelect(j);
        this.shopBridgeLiveData.setValue(Long.valueOf(j));
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
