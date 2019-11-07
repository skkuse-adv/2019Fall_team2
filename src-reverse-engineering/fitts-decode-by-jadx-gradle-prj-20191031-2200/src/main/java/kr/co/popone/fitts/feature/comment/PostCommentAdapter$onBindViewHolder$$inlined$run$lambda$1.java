package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;

final class PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ Comment $currentItem$inlined;
    final /* synthetic */ PostCommentAdapter this$0;

    PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$1(PostCommentAdapter postCommentAdapter, Comment comment) {
        this.this$0 = postCommentAdapter;
        this.$currentItem$inlined = comment;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onCommentIDClicked(this.$currentItem$inlined);
    }
}
