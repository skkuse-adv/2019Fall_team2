package kr.co.popone.fitts.feature.alarm;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.alarm.Alarm;

final class AlarmViewHolder$updateView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Alarm $this_with$inlined;
    final /* synthetic */ AlarmViewHolder this$0;

    AlarmViewHolder$updateView$$inlined$with$lambda$1(Alarm alarm, AlarmViewHolder alarmViewHolder, Alarm alarm2) {
        this.$this_with$inlined = alarm;
        this.this$0 = alarmViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onProfileClick(this.$this_with$inlined.getUser());
    }
}
