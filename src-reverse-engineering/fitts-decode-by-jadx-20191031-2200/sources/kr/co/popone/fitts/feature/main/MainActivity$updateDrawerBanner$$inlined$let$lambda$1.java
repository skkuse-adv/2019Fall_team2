package kr.co.popone.fitts.feature.main;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;
import kr.co.popone.fitts.model.datamodel.service.log.ActionLog;

final class MainActivity$updateDrawerBanner$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Banner $banner;
    final /* synthetic */ MainActivity this$0;

    MainActivity$updateDrawerBanner$$inlined$let$lambda$1(Banner banner, MainActivity mainActivity) {
        this.$banner = banner;
        this.this$0 = mainActivity;
    }

    public final void onClick(View view) {
        this.this$0.getSchemeHandler$app_productionFittsRelease().handleScheme(this.this$0, this.$banner.getScheme());
        ActionLog actionLog = new ActionLog("collection", "Menu", null, null, null, null, 32, null);
        DisposableKt.addTo(SubscribersKt.subscribeBy(this.this$0.getFittsServiceRepository$app_productionFittsRelease().postFittsActionLog(actionLog), (Function1<? super Throwable, Unit>) MainActivity$updateDrawerBanner$1$1$1$1.INSTANCE, (Function0<Unit>) MainActivity$updateDrawerBanner$1$1$1$2.INSTANCE), this.this$0.disposables);
    }
}
