package kr.co.popone.fitts.feature.post.detail;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.RelatedPost;

final class PostActivity$getRelatedPost$1<T> implements Consumer<RelatedPost> {
    final /* synthetic */ PostActivity this$0;

    PostActivity$getRelatedPost$1(PostActivity postActivity) {
        this.this$0 = postActivity;
    }

    public final void accept(RelatedPost relatedPost) {
        PostActivity postActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(relatedPost, "posts");
        postActivity.updateRelatedPost(relatedPost);
    }
}
