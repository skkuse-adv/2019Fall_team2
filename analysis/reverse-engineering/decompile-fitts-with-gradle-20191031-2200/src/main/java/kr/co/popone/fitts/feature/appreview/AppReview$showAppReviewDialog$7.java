package kr.co.popone.fitts.feature.appreview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.orhanobut.logger.Logger;

final class AppReview$showAppReviewDialog$7 implements OnDismissListener {
    public static final AppReview$showAppReviewDialog$7 INSTANCE = new AppReview$showAppReviewDialog$7();

    AppReview$showAppReviewDialog$7() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Logger.d("appreview dialog dismissed", new Object[0]);
    }
}
