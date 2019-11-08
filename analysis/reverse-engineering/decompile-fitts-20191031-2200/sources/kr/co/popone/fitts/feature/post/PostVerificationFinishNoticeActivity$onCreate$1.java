package kr.co.popone.fitts.feature.post;

import android.view.View;
import android.view.View.OnClickListener;

final class PostVerificationFinishNoticeActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ PostVerificationFinishNoticeActivity this$0;

    PostVerificationFinishNoticeActivity$onCreate$1(PostVerificationFinishNoticeActivity postVerificationFinishNoticeActivity) {
        this.this$0 = postVerificationFinishNoticeActivity;
    }

    public final void onClick(View view) {
        this.this$0.getSchemeHandler().handleScheme(this.this$0, "fitts://storeHome?tabName=home");
    }
}
