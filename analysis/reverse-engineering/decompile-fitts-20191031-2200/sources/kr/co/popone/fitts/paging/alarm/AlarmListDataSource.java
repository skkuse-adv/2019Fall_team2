package kr.co.popone.fitts.paging.alarm;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import com.facebook.internal.NativeProtocol;
import com.kakao.auth.StringSet;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import org.jetbrains.annotations.NotNull;

public final class AlarmListDataSource extends ItemKeyedDataSource<Long, Alarm> {
    private final FittsServiceRepository fittsServiceRepository;
    @NotNull
    private final MutableLiveData<NetworkState> networkState = new MutableLiveData<>();

    public void loadBefore(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Alarm> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
    }

    public AlarmListDataSource(@NotNull FittsServiceRepository fittsServiceRepository2) {
        Intrinsics.checkParameterIsNotNull(fittsServiceRepository2, "fittsServiceRepository");
        this.fittsServiceRepository = fittsServiceRepository2;
    }

    @NotNull
    public final MutableLiveData<NetworkState> getNetworkState() {
        return this.networkState;
    }

    @SuppressLint({"CheckResult"})
    public void loadInitial(@NotNull LoadInitialParams<Long> loadInitialParams, @NotNull LoadInitialCallback<Alarm> loadInitialCallback) {
        Intrinsics.checkParameterIsNotNull(loadInitialParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadInitialCallback, StringSet.PARAM_CALLBACK);
        this.networkState.postValue(NetworkState.Companion.getINIT_LOADING());
        this.fittsServiceRepository.getActivities(null, loadInitialParams.requestedLoadSize).subscribe(new AlarmListDataSource$loadInitial$1(this, loadInitialCallback), new AlarmListDataSource$loadInitial$2(this));
    }

    @SuppressLint({"CheckResult"})
    public void loadAfter(@NotNull LoadParams<Long> loadParams, @NotNull LoadCallback<Alarm> loadCallback) {
        Intrinsics.checkParameterIsNotNull(loadParams, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkParameterIsNotNull(loadCallback, StringSet.PARAM_CALLBACK);
        this.networkState.postValue(NetworkState.Companion.getLOADING());
        this.fittsServiceRepository.getActivities((Long) loadParams.key, loadParams.requestedLoadSize).subscribe(new AlarmListDataSource$loadAfter$1(this, loadCallback), new AlarmListDataSource$loadAfter$2(this));
    }

    @NotNull
    public Long getKey(@NotNull Alarm alarm) {
        Intrinsics.checkParameterIsNotNull(alarm, "item");
        return Long.valueOf(alarm.getId());
    }
}
