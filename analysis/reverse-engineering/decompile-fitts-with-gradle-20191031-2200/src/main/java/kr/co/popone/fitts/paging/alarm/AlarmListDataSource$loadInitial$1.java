package kr.co.popone.fitts.paging.alarm;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;

final class AlarmListDataSource$loadInitial$1<T> implements Consumer<List<? extends Alarm>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ AlarmListDataSource this$0;

    AlarmListDataSource$loadInitial$1(AlarmListDataSource alarmListDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = alarmListDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<Alarm> list) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.getINIT_LOADED());
        this.$callback.onResult(list);
    }
}
