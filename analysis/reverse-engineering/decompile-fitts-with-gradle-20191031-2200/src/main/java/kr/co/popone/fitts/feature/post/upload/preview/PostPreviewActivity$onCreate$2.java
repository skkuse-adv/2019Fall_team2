package kr.co.popone.fitts.feature.post.upload.preview;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.utils.Snackbar;

final class PostPreviewActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ PostPreviewActivity this$0;

    PostPreviewActivity$onCreate$2(PostPreviewActivity postPreviewActivity) {
        this.this$0 = postPreviewActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.uploadPostRequest == null) {
            this.this$0.finish();
            this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
            return;
        }
        Snackbar.Companion.showMessage(this.this$0, "포스트가 작성중입니다. 잠시만 기다려 주세요");
    }
}
