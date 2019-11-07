package kr.co.popone.fitts.paging.recommend;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendDataSource extends ItemKeyedDataSource<Long, RecommendFittieInfo> {
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final FittsServiceRepository fittsServiceRepository;
    @NotNull
    private final MutableLiveData<NetworkState> networkStateLiveData = new MutableLiveData<>();

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<RecommendFittieInfo> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public FittieRecommendDataSource(@NotNull FittsServiceRepository fittsServiceRepository2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        this.fittsServiceRepository = fittsServiceRepository2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkStateLiveData() {
        return this.networkStateLiveData;
    }

    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<RecommendFittieInfo> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getINIT_LOADING());
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.fittsServiceRepository.getFittieRecommendation(null, Integer.valueOf(loadInitialParams.requestedLoadSize)).subscribe(new FittieRecommendDataSource$loadInitial$1(this, loadInitialCallback), new FittieRecommendDataSource$loadInitial$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.g…r(it))\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<RecommendFittieInfo> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkStateLiveData.postValue(NetworkState.Companion.getLOADING());
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = this.fittsServiceRepository.getFittieRecommendation((Long) loadParams.key, Integer.valueOf(loadParams.requestedLoadSize)).subscribe(new FittieRecommendDataSource$loadAfter$1(this, loadCallback), new FittieRecommendDataSource$loadAfter$2(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "fittsServiceRepository.g…r(it))\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public Long getKey(@NotNull RecommendFittieInfo recommendFittieInfo) {
        Intrinsics.checkParameterIsNotNull(recommendFittieInfo, "item");
        return Long.valueOf(recommendFittieInfo instanceof RecommendFittie ? ((RecommendFittie) recommendFittieInfo).getUser().getId() : -1);
    }
}
