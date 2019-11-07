package kr.co.popone.fitts.feature.setting;

import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.kakao.auth.Session;
import io.reactivex.functions.BiConsumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.intro.IntroActivity;

final class SettingActivity$logoutWithFirebaseToken$2<T1, T2> implements BiConsumer<String, Throwable> {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$logoutWithFirebaseToken$2(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void accept(String str, Throwable th) {
        this.this$0.logout = null;
        this.this$0.getSessionManager$app_productionFittsRelease().logout();
        Session currentSession = Session.getCurrentSession();
        Intrinsics.checkExpressionValueIsNotNull(currentSession, "Session.getCurrentSession()");
        if (currentSession.isOpened()) {
            this.this$0.logoutKakaoAuth(this.$options);
            return;
        }
        if (AccessToken.getCurrentAccessToken() != null) {
            LoginManager.getInstance().logOut();
        }
        Intent intent = new Intent(this.this$0, IntroActivity.class);
        intent.addFlags(32768);
        intent.addFlags(268435456);
        this.this$0.startActivity(intent, this.$options.toBundle());
    }
}
