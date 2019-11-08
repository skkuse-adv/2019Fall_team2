package kr.co.popone.fitts.feature.alarm;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class AlarmFragment$onViewCreated$1 implements OnRefreshListener {
    final /* synthetic */ AlarmFragment this$0;

    AlarmFragment$onViewCreated$1(AlarmFragment alarmFragment) {
        this.this$0 = alarmFragment;
    }

    public final void onRefresh() {
        this.this$0.getVm().refreshAlarmList();
    }
}
