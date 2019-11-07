package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;

final class PostCommentAdapter$onBindViewHolder$3 implements OnClickListener {
    final /* synthetic */ Comment $currentItem;
    final /* synthetic */ PostCommentAdapter this$0;

    PostCommentAdapter$onBindViewHolder$3(PostCommentAdapter postCommentAdapter, Comment comment) {
        this.this$0 = postCommentAdapter;
        this.$currentItem = comment;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onProfileImageClicked(this.$currentItem);
    }
}
