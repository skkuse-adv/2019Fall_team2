package kr.co.popone.fitts.feature.setting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;

final class SettingActivity$onCreate$9 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$9(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        String str = "android.intent.action.VIEW";
        try {
            this.this$0.startActivity(new Intent(str, Uri.parse("kakaoplus://plusfriend/friend/@핏츠")), this.$options.toBundle());
        } catch (ActivityNotFoundException unused) {
            this.this$0.startActivity(new Intent(str, Uri.parse("http://plus.kakao.com/home/@핏츠")), this.$options.toBundle());
        }
    }
}
