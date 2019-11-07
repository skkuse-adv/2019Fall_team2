package kr.co.popone.fitts.viewmodel.recommend.fittie;

import android.os.Bundle;
import android.os.Message;
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
import io.reactivex.functions.BiConsumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.BaseViewModel;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.paging.recommend.FittieRecommendDataSource;
import kr.co.popone.fitts.paging.recommend.FittieRecommendSourceFactory;
import org.jetbrains.annotations.NotNull;
import org.simple.eventbus.EventBus;

public final class FittieRecommendViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(FittieRecommendViewModel.class), "_followingCount", "get_followingCount()I"))};
    public static final Companion Companion = new Companion(null);
    private final MutableLiveData<Boolean> _buttonState = new MutableLiveData<>();
    private final MutableLiveData<String> _buttonText = new MutableLiveData<>();
    private final LiveData<FittieRecommendDataSource> _dataSourceLiveData;
    private final LiveData<PagedList<RecommendFittieInfo>> _fittiesLiveData;
    private final ReadWriteProperty _followingCount$delegate;
    private final LiveData<NetworkState> _networkState;
    /* access modifiers changed from: private */
    public final MutableLiveData<Unit> _startFittsLiveData = new MutableLiveData<>();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final FittsServiceRepository serviceRepository;
    private final SessionManager sessionManager;
    private final UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final int get_followingCount() {
        return ((Number) this._followingCount$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    /* access modifiers changed from: private */
    public final void set_followingCount(int i) {
        this._followingCount$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    public FittieRecommendViewModel(@NotNull FittsServiceRepository fittsServiceRepository, @NotNull UserAPI userAPI2, @NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository, "serviceRepository");
        Intrinsics.checkParameterIsNotNull(userAPI2, "userAPI");
        Intrinsics.checkParameterIsNotNull(sessionManager2, "sessionManager");
        this.serviceRepository = fittsServiceRepository;
        this.userAPI = userAPI2;
        this.sessionManager = sessionManager2;
        Delegates delegates = Delegates.INSTANCE;
        Integer valueOf = Integer.valueOf(5);
        this._followingCount$delegate = new FittieRecommendViewModel$$special$$inlined$observable$1(valueOf, valueOf, this);
        FittieRecommendSourceFactory fittieRecommendSourceFactory = new FittieRecommendSourceFactory(this.serviceRepository);
        LiveData<NetworkState> switchMap = Transformations.switchMap(fittieRecommendSourceFactory.getFittieRecommendLiveData(), FittieRecommendViewModel$1$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(switchMap, "Transformations.switchMa…ateLiveData\n            }");
        this._networkState = switchMap;
        this._dataSourceLiveData = fittieRecommendSourceFactory.getFittieRecommendLiveData();
        LiveData<PagedList<RecommendFittieInfo>> build = new LivePagedListBuilder((Factory<Key, Value>) fittieRecommendSourceFactory, getPagedListConfig()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "LivePagedListBuilder(fac…agedListConfig()).build()");
        this._fittiesLiveData = build;
        MyInfo userInfo = this.sessionManager.getUserInfo();
        set_followingCount(userInfo != null ? userInfo.getFollowingsCount() : 0);
    }

    @NotNull
    public final LiveData<NetworkState> updateNetworkState() {
        return this._networkState;
    }

    @NotNull
    public final LiveData<PagedList<RecommendFittieInfo>> updateFitties() {
        return this._fittiesLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> updateButtonsState() {
        return this._buttonState;
    }

    @NotNull
    public final MutableLiveData<String> updateButtonText() {
        return this._buttonText;
    }

    @NotNull
    public final MutableLiveData<Unit> startFitts() {
        return this._startFittsLiveData;
    }

    @NotNull
    public final MutableLiveData<Throwable> errorOccured() {
        return getErrorLiveData();
    }

    public final void refreshRecommendFitties() {
        FittieRecommendDataSource fittieRecommendDataSource = (FittieRecommendDataSource) this._dataSourceLiveData.getValue();
        if (fittieRecommendDataSource != null) {
            fittieRecommendDataSource.invalidate();
        }
    }

    /* access modifiers changed from: private */
    public final void handleFollowingCount(int i) {
        String str;
        this._buttonState.setValue(Boolean.valueOf(i >= 5));
        MutableLiveData<String> mutableLiveData = this._buttonText;
        if (i >= 5) {
            str = "핏츠 시작하기";
        } else if (1 <= i && 5 > i) {
            StringBuilder sb = new StringBuilder();
            sb.append(5 - i);
            sb.append("명을 더 팔로우 해보세요.");
            str = sb.toString();
        } else {
            str = "5명을 팔로우 해보세요.";
        }
        mutableLiveData.setValue(str);
    }

    public final void followButtonClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userAPI.putFollow(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new FittieRecommendViewModel$followButtonClick$1<Object,Object>(this, j));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.putFollow(id)\n  …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void unfollowButtonClick(long j) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.userAPI.deleteFollow(j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new FittieRecommendViewModel$unfollowButtonClick$1<Object,Object>(this, j));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "userAPI.deleteFollow(id)…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    private final Config getPagedListConfig() {
        Config build = new Builder().setEnablePlaceholders(true).setPageSize(10).setInitialLoadSizeHint(10).setPrefetchDistance(3).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "PagedList.Config.Builder…                 .build()");
        return build;
    }

    public final void fittsStartButtonClick() {
        this.sessionManager.loadUserInfo(new FittieRecommendViewModel$fittsStartButtonClick$1(this));
    }

    /* access modifiers changed from: private */
    public final void postFollowStateChangeEvent(long j, boolean z) {
        Message message = new Message();
        message.what = 2;
        Bundle bundle = new Bundle();
        bundle.putLong("userId", j);
        bundle.putBoolean("isFollowed", z);
        message.setData(bundle);
        EventBus.getDefault().post(message, AppManager.HOME_MESSAGE);
        EventBus.getDefault().post(message, AppManager.MY_MESSAGE);
        EventBus.getDefault().post(message, AppManager.SHOWROOM_MESSAGE);
        EventBus.getDefault().post(message, AppManager.POST_MESSAGE);
        EventBus.getDefault().post(message, AppManager.FOLLOW_MESSAGE);
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        this.disposables.dispose();
        super.onCleared();
    }
}
