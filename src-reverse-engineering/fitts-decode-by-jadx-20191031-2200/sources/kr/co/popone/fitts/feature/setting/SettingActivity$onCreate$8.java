package kr.co.popone.fitts.feature.setting;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;

final class SettingActivity$onCreate$8 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$8(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        String str = "android.intent.action.VIEW";
        try {
            this.this$0.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            this.this$0.startActivity(new Intent(str, Uri.parse("fb://page/109304279597125")), this.$options.toBundle());
        } catch (Exception unused) {
            this.this$0.startActivity(new Intent(str, Uri.parse("https://www.facebook.com/fitts.official")), this.$options.toBundle());
        }
    }
}
