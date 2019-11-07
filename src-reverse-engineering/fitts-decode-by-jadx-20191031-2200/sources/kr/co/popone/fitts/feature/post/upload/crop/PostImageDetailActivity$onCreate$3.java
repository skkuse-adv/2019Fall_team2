package kr.co.popone.fitts.feature.post.upload.crop;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class PostImageDetailActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ PostImageDetailActivity this$0;

    PostImageDetailActivity$onCreate$3(PostImageDetailActivity postImageDetailActivity) {
        this.this$0 = postImageDetailActivity;
    }

    public final void onClick(View view) {
        this.this$0.hideKeyboard();
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
