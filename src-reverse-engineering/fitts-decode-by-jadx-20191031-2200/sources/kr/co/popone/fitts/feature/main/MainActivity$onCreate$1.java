package kr.co.popone.fitts.feature.main;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.recommend.fittie.FittieRecommendActivity;
import kr.co.popone.fitts.feature.recommend.fittie.FittieRecommendActivity.Companion;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;

final class MainActivity$onCreate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(0);
    }

    public final void invoke() {
        MyInfo userInfo = this.this$0.getSessionManager$app_productionFittsRelease().getUserInfo();
        if (userInfo == null) {
            Intrinsics.throwNpe();
        }
        if (userInfo.getRequiredFittieRecommend()) {
            Companion companion = FittieRecommendActivity.Companion;
            MainActivity mainActivity = this.this$0;
            companion.start(mainActivity, mainActivity.REQUEST_FITTIE_RECOMMEND);
            return;
        }
        this.this$0.initMainUi();
    }
}
