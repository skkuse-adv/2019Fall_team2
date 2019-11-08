package kr.co.popone.fitts.feature.comment;

import android.view.View;
import android.view.View.OnLongClickListener;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kr.co.popone.fitts.feature.comment.PostCommentAdapter.CommentHolder;
import kr.co.popone.fitts.model.datamodel.service.post.Comment;

final class PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$2 implements OnLongClickListener {
    final /* synthetic */ Comment $currentItem$inlined;
    final /* synthetic */ ViewHolder $holder$inlined;
    final /* synthetic */ PostCommentAdapter this$0;

    PostCommentAdapter$onBindViewHolder$$inlined$run$lambda$2(PostCommentAdapter postCommentAdapter, Comment comment, ViewHolder viewHolder) {
        this.this$0 = postCommentAdapter;
        this.$currentItem$inlined = comment;
        this.$holder$inlined = viewHolder;
    }

    public final boolean onLongClick(View view) {
        this.this$0.delegate.onReportCommentClicked(this.$currentItem$inlined, ((CommentHolder) this.$holder$inlined).getCommentLayout());
        return true;
    }
}
