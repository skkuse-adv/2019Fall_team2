package kr.co.popone.fitts.viewmodel.alarm;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.alarm.AlarmListDataSource;
import org.jetbrains.annotations.NotNull;

final class AlarmViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final AlarmViewModel$1$1 INSTANCE = new AlarmViewModel$1$1();

    AlarmViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(AlarmListDataSource alarmListDataSource) {
        return alarmListDataSource.getNetworkState();
    }
}
