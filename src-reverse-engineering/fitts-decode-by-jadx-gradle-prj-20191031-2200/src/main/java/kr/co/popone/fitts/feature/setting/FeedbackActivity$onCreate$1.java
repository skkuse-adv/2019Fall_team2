package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;

final class FeedbackActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$onCreate$1(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
    }

    public final void onClick(View view) {
        Logger.d("back button clicked", new Object[0]);
        this.this$0.onBackPressed();
    }
}
