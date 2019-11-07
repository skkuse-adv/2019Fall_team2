package kr.co.popone.fitts.feature.setting;

import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import com.kakao.usermgmt.callback.LogoutResponseCallback;
import com.orhanobut.logger.Logger;
import kr.co.popone.fitts.feature.intro.IntroActivity;

public final class SettingActivity$logoutKakaoAuth$1 extends LogoutResponseCallback {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$logoutKakaoAuth$1(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public void onCompleteLogout() {
        Logger.d("KakaoTest::onCompleteLogout", new Object[0]);
        Intent intent = new Intent(this.this$0, IntroActivity.class);
        intent.addFlags(32768);
        intent.addFlags(268435456);
        this.this$0.startActivity(intent, this.$options.toBundle());
    }
}
