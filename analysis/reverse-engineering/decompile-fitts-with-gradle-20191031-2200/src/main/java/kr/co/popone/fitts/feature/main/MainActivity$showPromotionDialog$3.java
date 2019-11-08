package kr.co.popone.fitts.feature.main;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;

final class MainActivity$showPromotionDialog$3 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Function0 $dismiss;
    final /* synthetic */ MainActivity this$0;

    MainActivity$showPromotionDialog$3(MainActivity mainActivity, Function0 function0, Dialog dialog) {
        this.this$0 = mainActivity;
        this.$dismiss = function0;
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Response To Event Popup", new CustomAttributes().put("responseType", "close"));
        this.$dismiss.invoke();
        this.$dialog.dismiss();
    }
}
