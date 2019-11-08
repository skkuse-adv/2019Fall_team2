package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class CommentsActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ CommentsActivity this$0;

    CommentsActivity$onCreate$1(CommentsActivity commentsActivity) {
        this.this$0 = commentsActivity;
    }

    public final void onClick(View view) {
        this.this$0.hideKeyboard();
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
