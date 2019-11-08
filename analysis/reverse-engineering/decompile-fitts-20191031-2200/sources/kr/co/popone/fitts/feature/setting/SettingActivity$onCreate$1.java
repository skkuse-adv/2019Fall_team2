package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class SettingActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$1(SettingActivity settingActivity) {
        this.this$0 = settingActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
