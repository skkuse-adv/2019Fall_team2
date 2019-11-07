package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnLongClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kr.co.popone.fitts.feature.comment.PostCommentAdapter.CommentHolder;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;

final class PostCommentAdapter$onBindViewHolder$7 implements OnLongClickListener {
    final /* synthetic */ Comment $currentItem;
    final /* synthetic */ ViewHolder $holder;
    final /* synthetic */ PostCommentAdapter this$0;

    PostCommentAdapter$onBindViewHolder$7(PostCommentAdapter postCommentAdapter, Comment comment, ViewHolder viewHolder) {
        this.this$0 = postCommentAdapter;
        this.$currentItem = comment;
        this.$holder = viewHolder;
    }

    public final boolean onLongClick(View view) {
        this.this$0.delegate.onReportCommentClicked(this.$currentItem, ((CommentHolder) this.$holder).getCommentLayout());
        return false;
    }
}
