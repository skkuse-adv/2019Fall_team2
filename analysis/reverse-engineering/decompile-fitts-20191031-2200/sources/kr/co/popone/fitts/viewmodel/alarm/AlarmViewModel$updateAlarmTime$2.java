package kr.co.popone.fitts.viewmodel.alarm;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class AlarmViewModel$updateAlarmTime$2<T> implements Consumer<Throwable> {
    public static final AlarmViewModel$updateAlarmTime$2 INSTANCE = new AlarmViewModel$updateAlarmTime$2();

    AlarmViewModel$updateAlarmTime$2() {
    }

    public final void accept(Throwable th) {
        Logger.d("AlarmTouch Failed", new Object[0]);
    }
}
