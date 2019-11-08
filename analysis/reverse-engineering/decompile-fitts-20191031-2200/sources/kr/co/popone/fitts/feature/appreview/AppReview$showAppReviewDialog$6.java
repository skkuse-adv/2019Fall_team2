package kr.co.popone.fitts.feature.appreview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.setting.FeedbackActivity;

final class AppReview$showAppReviewDialog$6 implements OnClickListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Dialog $dialog;

    AppReview$showAppReviewDialog$6(Dialog dialog, Activity activity) {
        this.$dialog = dialog;
        this.$activity = activity;
    }

    public final void onClick(View view) {
        this.$dialog.dismiss();
        Activity activity = this.$activity;
        activity.startActivity(new Intent(activity, FeedbackActivity.class));
        this.$activity.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
    }
}
