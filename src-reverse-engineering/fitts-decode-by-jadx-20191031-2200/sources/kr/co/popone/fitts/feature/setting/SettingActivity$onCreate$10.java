package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Pair;
import kotlin.TuplesKt;
import kr.co.popone.fitts.feature.WebActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class SettingActivity$onCreate$10 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$10(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        SettingActivity settingActivity = this.this$0;
        settingActivity.startActivity(AnkoInternals.createIntent(settingActivity, WebActivity.class, new Pair[]{TuplesKt.to("shop_url", "https://fitts.co.kr/terms"), TuplesKt.to("shop_name", "이용약관")}), this.$options.toBundle());
    }
}
