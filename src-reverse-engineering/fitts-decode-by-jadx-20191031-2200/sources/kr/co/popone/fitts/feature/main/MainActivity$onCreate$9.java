package kr.co.popone.fitts.feature.main;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.banner.BannerActivity;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerType;

final class MainActivity$onCreate$9 implements OnClickListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$9(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onClick(View view) {
        BannerActivity.Companion.start(this.this$0, BannerType.RECOMMEND, MainActivity.PREF_RECOMMENDATION_BANNER_BADGE_TIMESTAMP);
        this.this$0.getEventTracker$app_productionFittsRelease().customLogTapRecommendedContentsList();
    }
}
