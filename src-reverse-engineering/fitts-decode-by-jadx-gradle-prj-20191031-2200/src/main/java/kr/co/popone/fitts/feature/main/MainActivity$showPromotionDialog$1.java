package kr.co.popone.fitts.feature.main;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.model.datamodel.service.promotion.Promotion;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

final class MainActivity$showPromotionDialog$1 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Promotion $promotion;
    final /* synthetic */ MainActivity this$0;

    MainActivity$showPromotionDialog$1(MainActivity mainActivity, Promotion promotion, Dialog dialog) {
        this.this$0 = mainActivity;
        this.$promotion = promotion;
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Response To Event Popup", new CustomAttributes().put("responseType", "acting"));
        ActionLogUtil.defineCurrentWindow$default(this.this$0.getActionLogUtil$app_productionFittsRelease(), "Popup", "", 0, 4, null);
        FittsSchemeHandler schemeHandler$app_productionFittsRelease = this.this$0.getSchemeHandler$app_productionFittsRelease();
        MainActivity mainActivity = this.this$0;
        String target = this.$promotion.getTarget();
        if (target == null) {
            Intrinsics.throwNpe();
        }
        schemeHandler$app_productionFittsRelease.handleScheme(mainActivity, target);
        this.$dialog.dismiss();
    }
}
