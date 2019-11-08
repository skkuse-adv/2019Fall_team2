package kr.co.popone.fitts.feature.post;

import android.view.View;
import android.view.View.OnClickListener;

final class PostFirstWriteNoticeActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ PostFirstWriteNoticeActivity this$0;

    PostFirstWriteNoticeActivity$onCreate$1(PostFirstWriteNoticeActivity postFirstWriteNoticeActivity) {
        this.this$0 = postFirstWriteNoticeActivity;
    }

    public final void onClick(View view) {
        this.this$0.getSchemeHandler().handleScheme(this.this$0, "fitts://collection/304?type=mixed");
    }
}
