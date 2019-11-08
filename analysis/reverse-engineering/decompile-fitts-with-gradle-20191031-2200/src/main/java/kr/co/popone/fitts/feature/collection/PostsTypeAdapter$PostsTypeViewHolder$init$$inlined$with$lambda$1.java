package kr.co.popone.fitts.feature.collection;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.collection.PostsTypeAdapter.PostsTypeViewHolder;
import kr.co.popone.fitts.model.post.PostAPI.Post;

final class PostsTypeAdapter$PostsTypeViewHolder$init$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Post $post$inlined;
    final /* synthetic */ PostsTypeViewHolder this$0;

    PostsTypeAdapter$PostsTypeViewHolder$init$$inlined$with$lambda$1(View view, PostsTypeViewHolder postsTypeViewHolder, Post post) {
        this.this$0 = postsTypeViewHolder;
        this.$post$inlined = post;
    }

    public final void onClick(View view) {
        this.this$0.this$0.delegate.onPostClicked(this.$post$inlined);
    }
}
