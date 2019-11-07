package kr.co.popone.fitts.feature.main;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.eventtracker.EventTracker.CustomAttributes;
import kr.co.popone.fitts.ui.CalendarExtensionsKt;

final class MainActivity$showPromotionDialog$2 implements OnClickListener {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Function0 $dismiss;
    final /* synthetic */ MainActivity this$0;

    MainActivity$showPromotionDialog$2(MainActivity mainActivity, Function0 function0, Dialog dialog) {
        this.this$0 = mainActivity;
        this.$dismiss = function0;
        this.$dialog = dialog;
    }

    public final void onClick(View view) {
        this.this$0.getEventTracker$app_productionFittsRelease().logCustom("Response To Event Popup", new CustomAttributes().put("responseType", "do_not_show"));
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "cal");
        instance.setTime(new Date());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.this$0);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
        defaultSharedPreferences.edit().putString("no_show_event", CalendarExtensionsKt.dateString(instance)).apply();
        this.$dismiss.invoke();
        this.$dialog.dismiss();
    }
}
