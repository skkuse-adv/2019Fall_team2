package kr.co.popone.fitts.feature.alarm;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class AlarmSettingActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ AlarmSettingActivity this$0;

    AlarmSettingActivity$onCreate$1(AlarmSettingActivity alarmSettingActivity) {
        this.this$0 = alarmSettingActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
