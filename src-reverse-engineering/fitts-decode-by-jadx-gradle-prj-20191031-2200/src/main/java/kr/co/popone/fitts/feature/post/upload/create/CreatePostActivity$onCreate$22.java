package kr.co.popone.fitts.feature.post.upload.create;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.tag.TagGroup;

final class CreatePostActivity$onCreate$22 implements OnTouchListener {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$22(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.this$0.hideKeyboard();
        if (((TagGroup) this.this$0._$_findCachedViewById(C0010R$id.tag_create_post)).hasFocus()) {
            ((TagGroup) this.this$0._$_findCachedViewById(C0010R$id.tag_create_post)).clearFocus();
        }
        return false;
    }
}
