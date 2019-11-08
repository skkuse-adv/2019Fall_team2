package kr.co.popone.fitts.viewmodel.store.newest;

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
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.paging.store.newest.NewestProductDataSouceFactory;
import kr.co.popone.fitts.paging.store.newest.NewestProductDataSource;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewestProductViewModel extends BaseViewModel {
    private final LiveData<PagedList<FeedItem>> _feedPagedList;
    private final LiveData<NetworkState> _networkState;
    /* access modifiers changed from: private */
    public final MutableLiveData<WishStateUpdateEvent> _productLikeEvent = new MutableLiveData<>();
    private final LiveData<SpecialDiscountInfo> _specialDiscount;
    private final FittsCommerceRepository commerceRepository;
    private final MutableLiveData<NewestProductDataSource> dataSource;
    private final CompositeDisposable disposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final EventTracker eventTracker;
    private long remainTime;
    private final FittsSchemeHandler schemeHandler;
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;
    private final CompositeDisposable specialDiscountDisposables = new CompositeDisposable();
    /* access modifiers changed from: private */
    public final MutableLiveData<String> specialDiscountRemainTime = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Integer> specialDiscountRemainTimePercentage = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> specialDisountNow = new MutableLiveData<>();
    private final StoreRepository storeRepository;
    private long totalRemainTime;

    public NewestProductViewModel(@NotNull StoreRepository storeRepository2, @NotNull FittsServiceRepository fittsServiceRepository, @NotNull FittsCommerceRepository fittsCommerceRepository, @NotNull FittsSchemeHandler fittsSchemeHandler, @NotNull SessionManager sessionManager2, @NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(storeRepository2, "storeRepository");
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(fittsCommerceRepository, "commerceRepository");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        this.storeRepository = storeRepository2;
        this.serviceRepository = fittsServiceRepository;
        this.commerceRepository = fittsCommerceRepository;
        this.schemeHandler = fittsSchemeHandler;
        this.sessionManager = sessionManager2;
        this.eventTracker = eventTracker2;
        NewestProductDataSouceFactory newestProductDataSouceFactory = new NewestProductDataSouceFactory(this.storeRepository);
        this.dataSource = newestProductDataSouceFactory.getDataSourceLiveData();
        LiveData<NetworkState> switchMap = Transformations.switchMap(newestProductDataSouceFactory.getDataSourceLiveData(), NewestProductViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…etworkState\n            }");
        this._networkState = switchMap;
        LiveData<SpecialDiscountInfo> switchMap2 = Transformations.switchMap(newestProductDataSouceFactory.getDataSourceLiveData(), NewestProductViewModel$1$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMa…ialDiscount\n            }");
        this._specialDiscount = switchMap2;
        LiveData<PagedList<FeedItem>> build = new LivePagedListBuilder((Factory<Key, Value>) newestProductDataSouceFactory, getPageConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(it, getPageConfig()).build()");
        this._feedPagedList = build;
        registerLikeProductBus();
    }

    @NotNull
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    @NotNull
    public final LiveData<NetworkState> updateNetworkState() {
        return this._networkState;
    }

    @NotNull
    public final LiveData<PagedList<FeedItem>> updateStoreNewFeeds() {
        return this._feedPagedList;
    }

    @NotNull
    public final LiveData<SpecialDiscountInfo> updateSpecialDiscountEvent() {
        return this._specialDiscount;
    }

    @NotNull
    public final MutableLiveData<String> updateRemainTimeText() {
        return this.specialDiscountRemainTime;
    }

    @NotNull
    public final MutableLiveData<Integer> updateRemainPercentage() {
        return this.specialDiscountRemainTimePercentage;
    }

    @NotNull
    public final MutableLiveData<Boolean> updateSpecialDiscountView() {
        return this.specialDisountNow;
    }

    @NotNull
    public final MutableLiveData<WishStateUpdateEvent> updateProductLikeState() {
        return this._productLikeEvent;
    }

    public final void refreshStoreNewFeeds() {
        NewestProductDataSource newestProductDataSource = (NewestProductDataSource) this.dataSource.getValue();
        if (newestProductDataSource != null) {
            newestProductDataSource.invalidate();
        }
        this.remainTime = 0;
        this.totalRemainTime = 0;
        this.specialDiscountDisposables.clear();
    }

    private final void registerLikeProductBus() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).ofType(WishStateUpdateEvent.class).subscribe(new NewestProductViewModel$registerLikeProductBus$1(this), NewestProductViewModel$registerLikeProductBus$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …vent\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void handleSpecialDiscountInfo(@Nullable SpecialDiscountInfo specialDiscountInfo) {
        if (specialDiscountInfo != null) {
            calculateRemainTime(specialDiscountInfo.getCurrentDate(), specialDiscountInfo.getStartDate(), specialDiscountInfo.getEndDate());
        } else {
            hideSpecialDiscountView();
        }
    }

    private final void hideSpecialDiscountView() {
        this.specialDisountNow.setValue(Boolean.valueOf(false));
    }

    private final Config getPageConfig() {
        return new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(10).setPrefetchDistance(3).setPageSize(10).build();
    }

    private final void calculateRemainTime(Date date, Date date2, Date date3) {
        this.specialDisountNow.setValue(Boolean.valueOf(true));
        this.remainTime = date3.getTime() - date.getTime();
        this.totalRemainTime = date3.getTime() - date2.getTime();
        CompositeDisposable compositeDisposable = this.specialDiscountDisposables;
        Disposable subscribe = Observable.interval(1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).map(new NewestProductViewModel$calculateRemainTime$1(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new NewestProductViewModel$calculateRemainTime$2(this), NewestProductViewModel$calculateRemainTime$3.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observable.interval(1, T… $it\")\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* access modifiers changed from: private */
    public final Pair<String, Integer> startTimer() {
        long j = (long) 1000;
        this.remainTime -= j;
        long j2 = this.remainTime;
        long j3 = j2 - j;
        long j4 = j3 / ((long) 3600000);
        long j5 = (long) 60;
        long j6 = (j3 / ((long) 60000)) % j5;
        long j7 = (j3 / j) % j5;
        double d = (double) j2;
        double d2 = (double) this.totalRemainTime;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        double d4 = (double) AbstractSpiCall.DEFAULT_TIMEOUT;
        Double.isNaN(d4);
        double d5 = d3 * d4;
        StringBuilder sb = new StringBuilder();
        sb.append(designTimeUnit(j4));
        String str = "  :  ";
        sb.append(str);
        sb.append(designTimeUnit(j6));
        sb.append(str);
        sb.append(designTimeUnit(j7));
        return new Pair<>(sb.toString(), Integer.valueOf((int) Math.ceil(d5)));
    }

    private final String designTimeUnit(long j) {
        if (j >= ((long) 10)) {
            return String.valueOf(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        sb.append(j);
        return sb.toString();
    }

    public final void handleScheme(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (str != null) {
            this.schemeHandler.handleScheme(activity, str);
            leaveCollectionClickActionLog(str);
        }
    }

    public final void addLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.addWishProduct(j).subscribe(new NewestProductViewModel$addLikeProductClick$1(this, j), new NewestProductViewModel$addLikeProductClick$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.addWi…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void removeLikeProductClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.commerceRepository.deleteWishProduct(j).subscribe(new NewestProductViewModel$removeLikeProductClick$1(this, j), new NewestProductViewModel$removeLikeProductClick$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "commerceRepository.delet…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void recordCurrentPostion(int i) {
        this.eventTracker.updateDistanceStoreNew(i);
    }

    public final void onProductClicked(long j) {
        leaveProductClickActionLog(j);
    }

    private final void leaveProductClickActionLog(long j) {
        ActionLog actionLog = new ActionLog("product", "StoreHomeFeed", "Sale", null, Long.valueOf(j), null, 32, null);
        DisposableKt.addTo(SubscribersKt.subscribeBy(this.serviceRepository.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) NewestProductViewModel$leaveProductClickActionLog$1$1.INSTANCE, (Function0<Unit>) NewestProductViewModel$leaveProductClickActionLog$1$2.INSTANCE), this.disposables);
    }

    private final void leaveCollectionClickActionLog(String str) {
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "fitts") && Intrinsics.areEqual((Object) parse.getHost(), (Object) "collection")) {
            try {
                String lastPathSegment = parse.getLastPathSegment();
                if (lastPathSegment != null) {
                    ActionLog actionLog = new ActionLog("collection", "StoreHomeFeed", "Sale", null, Long.valueOf(Long.parseLong(lastPathSegment)), null, 32, null);
                    DisposableKt.addTo(SubscribersKt.subscribeBy(this.serviceRepository.postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) NewestProductViewModel$leaveCollectionClickActionLog$1$1$1.INSTANCE, (Function0<Unit>) NewestProductViewModel$leaveCollectionClickActionLog$1$1$2.INSTANCE), this.disposables);
                }
            } catch (Exception unused) {
                Logger.d("uri parsing error", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.specialDiscountDisposables.dispose();
        this.disposables.dispose();
        super.onCleared();
    }
}
