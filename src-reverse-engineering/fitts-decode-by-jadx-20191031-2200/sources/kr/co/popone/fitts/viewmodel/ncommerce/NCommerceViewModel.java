package kr.co.popone.fitts.viewmodel.ncommerce;

import android.app.Activity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.paging.DataSource.Factory;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.PagedList.Config;
import androidx.paging.PagedList.Config.Builder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.event.NCommerceEvent$NCommercePostClickEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.datamodel.social.point.PointInfo;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import kr.co.popone.fitts.model.remote.user.UserResponse$NCommerceResponse;
import kr.co.popone.fitts.paging.ncommerce.PointHistorySourceFactory;
import kr.co.popone.fitts.paging.ncommerce.PointUsageHistorySourceFactory;
import kr.co.popone.fitts.repository.UserRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NCommerceViewModel extends BaseViewModel {
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @Nullable
    private LiveData<Boolean> emptyListState;
    private final EventTracker eventTracker;
    @NotNull
    private final MutableLiveData<Post> mostRevenuePostLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<UserResponse$NCommerceResponse> nCommerceResponseLiveData = new MutableLiveData<>();
    @Nullable
    private LiveData<NetworkState> networkState;
    @Nullable
    private LiveData<PagedList<PaymentUsage>> pagedPaymentUsageLiveData;
    @Nullable
    private LiveData<PagedList<PaymentHistory>> pagedPointHistoryLiveData;
    private final PaymentAPI paymentAPI;
    @NotNull
    private final MutableLiveData<PaymentUsage> paymentUsageLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<PointInfo> rewardPointsResultLiveData = new MutableLiveData<>();
    private final FittsSchemeHandler schemeHandler;
    private final UserRepository userRepository;

    public NCommerceViewModel(@NotNull UserRepository userRepository2, @NotNull PaymentAPI paymentAPI2, @NotNull EventTracker eventTracker2, @NotNull FittsSchemeHandler fittsSchemeHandler) {
        Intrinsics.checkParameterIsNotNull(userRepository2, "userRepository");
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "paymentAPI");
        Intrinsics.checkParameterIsNotNull(eventTracker2, "eventTracker");
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler, "schemeHandler");
        this.userRepository = userRepository2;
        this.paymentAPI = paymentAPI2;
        this.eventTracker = eventTracker2;
        this.schemeHandler = fittsSchemeHandler;
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<Object>(this) {
            final /* synthetic */ NCommerceViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Object obj) {
                if (obj instanceof NCommerceEvent$NCommercePostClickEvent) {
                    this.this$0.getMostRevenuePostLiveData().setValue(((NCommerceEvent$NCommercePostClickEvent) obj).getPost());
                }
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.eventTracker.customLogEnterFittsPoint();
    }

    @Nullable
    public final LiveData<PagedList<PaymentHistory>> getPagedPointHistoryLiveData() {
        return this.pagedPointHistoryLiveData;
    }

    public final void setPagedPointHistoryLiveData(@Nullable LiveData<PagedList<PaymentHistory>> liveData) {
        this.pagedPointHistoryLiveData = liveData;
    }

    @Nullable
    public final LiveData<PagedList<PaymentUsage>> getPagedPaymentUsageLiveData() {
        return this.pagedPaymentUsageLiveData;
    }

    public final void setPagedPaymentUsageLiveData(@Nullable LiveData<PagedList<PaymentUsage>> liveData) {
        this.pagedPaymentUsageLiveData = liveData;
    }

    @NotNull
    public final MutableLiveData<PointInfo> getRewardPointsResultLiveData() {
        return this.rewardPointsResultLiveData;
    }

    @NotNull
    public final MutableLiveData<UserResponse$NCommerceResponse> getNCommerceResponseLiveData() {
        return this.nCommerceResponseLiveData;
    }

    @NotNull
    public final MutableLiveData<Post> getMostRevenuePostLiveData() {
        return this.mostRevenuePostLiveData;
    }

    @NotNull
    public final MutableLiveData<PaymentUsage> getPaymentUsageLiveData() {
        return this.paymentUsageLiveData;
    }

    @Nullable
    public final LiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable LiveData<NetworkState> liveData) {
        this.networkState = liveData;
    }

    @Nullable
    public final LiveData<Boolean> getEmptyListState() {
        return this.emptyListState;
    }

    public final void setEmptyListState(@Nullable LiveData<Boolean> liveData) {
        this.emptyListState = liveData;
    }

    @NotNull
    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public final void requestFittsPointInfo() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userRepository.getFittsPointInfo().subscribe(new NCommerceViewModel$requestFittsPointInfo$1(this), new NCommerceViewModel$requestFittsPointInfo$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userRepository.getFittsP…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void requestNCommerceInfo() {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userRepository.getNCommerceInfo().subscribe(new NCommerceViewModel$requestNCommerceInfo$1(this), new NCommerceViewModel$requestNCommerceInfo$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userRepository.getNComme…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void requestPointHistory() {
        PointHistorySourceFactory pointHistorySourceFactory = new PointHistorySourceFactory(this.paymentAPI);
        this.networkState = Transformations.switchMap(pointHistorySourceFactory.getPointHistoryLiveData(), NCommerceViewModel$requestPointHistory$1.INSTANCE);
        this.emptyListState = Transformations.switchMap(pointHistorySourceFactory.getPointHistoryLiveData(), NCommerceViewModel$requestPointHistory$2.INSTANCE);
        this.pagedPointHistoryLiveData = new LivePagedListBuilder((Factory<Key, Value>) pointHistorySourceFactory, getPagedListConfig()).build();
    }

    public final void requestPointUsageHistory() {
        PointUsageHistorySourceFactory pointUsageHistorySourceFactory = new PointUsageHistorySourceFactory(this.paymentAPI);
        this.networkState = Transformations.switchMap(pointUsageHistorySourceFactory.getPointUsageHistoryLiveData(), NCommerceViewModel$requestPointUsageHistory$1.INSTANCE);
        this.pagedPaymentUsageLiveData = new LivePagedListBuilder((Factory<Key, Value>) pointUsageHistorySourceFactory, getPagedListConfig()).build();
    }

    public final void checkIdentityVerify(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "body");
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userRepository.getUserInfo().subscribe(new NCommerceViewModel$checkIdentityVerify$1(function0), new NCommerceViewModel$checkIdentityVerify$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userRepository.getUserIn…e = it\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void tabIndexChanged(int i) {
        if (i == 0) {
            this.eventTracker.customLogTapFittsTab("status");
        } else if (i == 1) {
            this.eventTracker.customLogTapFittsTab("history");
        }
    }

    public final void handleScheme(@NotNull Activity activity, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        if (str != null) {
            this.schemeHandler.handleScheme(activity, str);
        }
    }

    private final Config getPagedListConfig() {
        Config build = new Builder().setEnablePlaceholders(true).setInitialLoadSizeHint(12).setPageSize(12).setPrefetchDistance(3).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "PagedList.Config.Builder…                 .build()");
        return build;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
