package kr.co.popone.fitts.feature.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kr.co.popone.fitts.feature.me.ModifyProfileActivity;

final class SettingActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$2(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        this.this$0.startActivity(new Intent(this.this$0, ModifyProfileActivity.class), this.$options.toBundle());
    }
}
