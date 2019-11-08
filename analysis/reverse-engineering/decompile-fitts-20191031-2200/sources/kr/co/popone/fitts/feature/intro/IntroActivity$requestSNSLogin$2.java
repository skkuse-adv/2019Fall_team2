package kr.co.popone.fitts.feature.intro;

import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.feature.main.MainActivity;
import kr.co.popone.fitts.model.datamodel.service.user.BodyFilter;
import kr.co.popone.fitts.model.datamodel.service.user.MyInfo;
import org.jetbrains.anko.internals.AnkoInternals;

final class IntroActivity$requestSNSLogin$2<T> implements Consumer<MyInfo> {
    final /* synthetic */ IntroActivity this$0;

    IntroActivity$requestSNSLogin$2(IntroActivity introActivity) {
        this.this$0 = introActivity;
    }

    public final void accept(MyInfo myInfo) {
        this.this$0.snsLoginRequest = null;
        this.this$0.getSessionManager$app_productionFittsRelease().setUserInfo(myInfo);
        this.this$0.getSessionManager$app_productionFittsRelease().setFirstAppStart(true);
        this.this$0.getSessionManager$app_productionFittsRelease().setHeight(myInfo.getBodyInfo().getHeight());
        this.this$0.getSessionManager$app_productionFittsRelease().setWeight(myInfo.getBodyInfo().getWeight());
        SessionManager sessionManager$app_productionFittsRelease = this.this$0.getSessionManager$app_productionFittsRelease();
        BodyFilter bodyFilter = myInfo.getBodyFilter();
        if (bodyFilter == null) {
            Intrinsics.throwNpe();
        }
        sessionManager$app_productionFittsRelease.setSimilarityBodyFilter(Integer.valueOf(bodyFilter.getMin_height()), Integer.valueOf(myInfo.getBodyFilter().getMax_height()), Integer.valueOf(myInfo.getBodyFilter().getMin_weight()), Integer.valueOf(myInfo.getBodyFilter().getMax_weight()));
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(this.this$0, C0001R$anim.fade_in, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…fade_in, R.anim.fade_out)");
        IntroActivity introActivity = this.this$0;
        Intent createIntent = AnkoInternals.createIntent(introActivity, MainActivity.class, new Pair[0]);
        createIntent.addFlags(32768);
        createIntent.addFlags(268435456);
        createIntent.addFlags(536870912);
        introActivity.startActivity(createIntent, makeCustomAnimation.toBundle());
    }
}
