package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnClickListener;

final class PostCommentAdapter$onBindViewHolder$8 implements OnClickListener {
    final /* synthetic */ PostCommentAdapter this$0;

    PostCommentAdapter$onBindViewHolder$8(PostCommentAdapter postCommentAdapter) {
        this.this$0 = postCommentAdapter;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onTotalCommentClicked();
    }
}
