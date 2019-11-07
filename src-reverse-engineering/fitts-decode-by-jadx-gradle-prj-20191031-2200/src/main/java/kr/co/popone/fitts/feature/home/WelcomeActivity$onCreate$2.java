package kr.co.popone.fitts.feature.home;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;

final class WelcomeActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ WelcomeActivity this$0;

    WelcomeActivity$onCreate$2(WelcomeActivity welcomeActivity) {
        this.this$0 = welcomeActivity;
    }

    public final void onClick(View view) {
        CreatePostActivityUtil.showCreatePostActivity$default(this.this$0.getCreatePostActivityUtil$app_productionFittsRelease(), this.this$0, "welcome", false, null, 12, null);
    }
}
