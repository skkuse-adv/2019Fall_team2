package kr.co.popone.fitts.feature.alarm;

import androidx.lifecycle.Observer;
import kotlin.Unit;

final class AlarmFragment$onViewCreated$3<T> implements Observer<Unit> {
    final /* synthetic */ AlarmFragment this$0;

    AlarmFragment$onViewCreated$3(AlarmFragment alarmFragment) {
        this.this$0 = alarmFragment;
    }

    public final void onChanged(Unit unit) {
        this.this$0.showUpdateDialog();
    }
}
