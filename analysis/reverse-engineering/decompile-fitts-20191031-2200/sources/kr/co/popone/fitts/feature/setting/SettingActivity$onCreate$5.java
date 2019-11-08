package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Pair;
import kotlin.TuplesKt;
import kr.co.popone.fitts.feature.WebActivity;
import org.jetbrains.anko.internals.AnkoInternals;

final class SettingActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ ActivityOptionsCompat $options;
    final /* synthetic */ SettingActivity this$0;

    SettingActivity$onCreate$5(SettingActivity settingActivity, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0 = settingActivity;
        this.$options = activityOptionsCompat;
    }

    public final void onClick(View view) {
        SettingActivity settingActivity = this.this$0;
        settingActivity.startActivity(AnkoInternals.createIntent(settingActivity, WebActivity.class, new Pair[]{TuplesKt.to("shop_url", "https://fitts.co.kr/helps"), TuplesKt.to("shop_name", "도움말")}), this.$options.toBundle());
    }
}
