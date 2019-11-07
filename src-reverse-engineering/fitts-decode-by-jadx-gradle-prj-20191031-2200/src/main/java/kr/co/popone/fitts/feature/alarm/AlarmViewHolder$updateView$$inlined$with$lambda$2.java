package kr.co.popone.fitts.feature.alarm;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;

final class AlarmViewHolder$updateView$$inlined$with$lambda$2 implements OnClickListener {
    final /* synthetic */ Alarm $this_with;
    final /* synthetic */ AlarmViewHolder this$0;

    AlarmViewHolder$updateView$$inlined$with$lambda$2(Alarm alarm, AlarmViewHolder alarmViewHolder, Alarm alarm2) {
        this.$this_with = alarm;
        this.this$0 = alarmViewHolder;
    }

    public final void onClick(View view) {
        String scheme = this.$this_with.getScheme();
        if (scheme != null) {
            this.this$0.getDelegate().onAlarmClick(scheme, this.$this_with.getType());
        }
    }
}
