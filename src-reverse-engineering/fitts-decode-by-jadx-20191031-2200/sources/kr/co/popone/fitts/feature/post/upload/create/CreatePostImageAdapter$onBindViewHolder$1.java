package kr.co.popone.fitts.feature.post.upload.create;

import android.view.View;
import android.view.View.OnClickListener;

final class CreatePostImageAdapter$onBindViewHolder$1 implements OnClickListener {
    final /* synthetic */ CreatePostImageAdapter this$0;

    CreatePostImageAdapter$onBindViewHolder$1(CreatePostImageAdapter createPostImageAdapter) {
        this.this$0 = createPostImageAdapter;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onImageClick();
    }
}
