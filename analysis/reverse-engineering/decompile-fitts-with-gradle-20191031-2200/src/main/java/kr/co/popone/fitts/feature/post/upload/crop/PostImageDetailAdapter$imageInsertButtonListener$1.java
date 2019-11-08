package kr.co.popone.fitts.feature.post.upload.crop;

import android.view.View;
import android.view.View.OnClickListener;

final class PostImageDetailAdapter$imageInsertButtonListener$1 implements OnClickListener {
    final /* synthetic */ PostImageDetailAdapter this$0;

    PostImageDetailAdapter$imageInsertButtonListener$1(PostImageDetailAdapter postImageDetailAdapter) {
        this.this$0 = postImageDetailAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onAddImageClick();
    }
}
