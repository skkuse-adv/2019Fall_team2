package kr.co.popone.fitts.feature.setting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;

final class SettingActivity$onCreate$7 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$7(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        String str = "https://www.instagram.com/fitts_official";
        String str2 = "android.intent.action.VIEW";
        Intent intent = new Intent(str2, Uri.parse(str));
        intent.setPackage("com.instagram.android");
        try {
            this.this$0.startActivity(intent, this.$options.toBundle());
        } catch (ActivityNotFoundException unused) {
            this.this$0.startActivity(new Intent(str2, Uri.parse(str)), this.$options.toBundle());
        }
    }
}
