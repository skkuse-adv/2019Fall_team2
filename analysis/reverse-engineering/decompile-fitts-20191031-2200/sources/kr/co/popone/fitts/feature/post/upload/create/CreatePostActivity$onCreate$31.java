package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.PostType;

final class CreatePostActivity$onCreate$31<T> implements Consumer<PostType> {
    final /* synthetic */ CreatePostActivity this$0;

    CreatePostActivity$onCreate$31(CreatePostActivity createPostActivity) {
        this.this$0 = createPostActivity;
    }

    public final void accept(PostType postType) {
        CreatePostActivity createPostActivity = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(postType, "it");
        createPostActivity.updateCreatePostView(postType);
    }
}
