package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;

final class SettingActivity$onCreate$12 implements OnClickListener {
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$12(SettingActivity settingActivity) {
        this.this$0 = settingActivity;
    }

    public final void onClick(View view) {
        BusinessInfoActivity.Companion.start(this.this$0);
    }
}
