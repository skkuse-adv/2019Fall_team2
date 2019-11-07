package kr.co.popone.fitts.feature.me;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.TypeCastException;
import kr.co.popone.fitts.feature.banner.BannerActivity;
import kr.co.popone.fitts.feature.banner.BannerActivity.Companion;
import kr.co.popone.fitts.feature.main.MainActivity;
import kr.co.popone.fitts.model.datamodel.service.banner.BannerType;

final class MeFragment$initClickListener$11 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$11(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        Companion companion = BannerActivity.Companion;
        Context context = this.this$0.getContext();
        if (context != null) {
            companion.start((Activity) context, BannerType.EVENT, MainActivity.PREF_EVENT_BANNER_BADGE_TIMESTAMP);
            this.this$0.getEventTracker$app_productionFittsRelease().customLogTapEventList("my");
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
}
