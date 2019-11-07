package kr.co.popone.fitts.feature.post.upload.crop;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class PostImageDetailActivity$onCreate$$inlined$run$lambda$2 implements OnTouchListener {
    final /* synthetic */ PostImageDetailActivity this$0;

    PostImageDetailActivity$onCreate$$inlined$run$lambda$2(PostImageDetailActivity postImageDetailActivity) {
        this.this$0 = postImageDetailActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.this$0.hideKeyboard();
        return false;
    }
}
