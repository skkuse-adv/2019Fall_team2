package kr.co.popone.fitts.paging.alarm;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class AlarmListDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ AlarmListDataSource this$0;

    AlarmListDataSource$loadInitial$2(AlarmListDataSource alarmListDataSource) {
        this.this$0 = alarmListDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.error(th));
    }
}
