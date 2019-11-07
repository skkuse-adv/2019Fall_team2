package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;

final class SettingActivity$onCreate$14 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$14(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        if (this.this$0.logout == null) {
            String firebaseToken = this.this$0.getSessionManager$app_productionFittsRelease().getFirebaseToken();
            if (firebaseToken != null) {
                this.this$0.logoutWithFirebaseToken(firebaseToken, this.$options);
            } else {
                this.this$0.logoutWithoutFirebaseToken(this.$options);
            }
        }
    }
}
