package kr.co.popone.fitts.feature.appreview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import org.jetbrains.anko.IntentsKt;

final class AppReview$showAppReviewDialog$4 implements OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Dialog $dialog;

    AppReview$showAppReviewDialog$4(Dialog dialog, Activity activity) {
        this.$dialog = dialog;
        this.$activity = activity;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
        AppReview.appReviewShown = true;
        AppReview.INSTANCE.saveData();
        IntentsKt.browse$default((Context) this.$activity, "market://details?id=kr.co.popone.fitts", false, 2, (Object) null);
    }
}
