package kr.co.popone.fitts.paging.alarm;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;

final class AlarmListDataSource$loadAfter$1<T> implements Consumer<List<? extends Alarm>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ AlarmListDataSource this$0;

    AlarmListDataSource$loadAfter$1(AlarmListDataSource alarmListDataSource, LoadCallback loadCallback) {
        this.this$0 = alarmListDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<Alarm> list) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(list);
    }
}
