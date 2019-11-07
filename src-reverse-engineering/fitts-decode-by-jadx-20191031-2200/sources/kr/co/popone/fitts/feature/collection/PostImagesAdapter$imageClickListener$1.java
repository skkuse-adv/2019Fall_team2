package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;

final class PostImagesAdapter$imageClickListener$1 implements OnClickListener {
    final /* synthetic */ PostImagesAdapter this$0;

    PostImagesAdapter$imageClickListener$1(PostImagesAdapter postImagesAdapter) {
        this.this$0 = postImagesAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onShowPost(this.this$0.getPostPosition());
    }
}
