package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.post.PostViewData;

final class CreatePostViewModel$loadCreatePostData$1<T> implements Consumer<PostViewData> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$loadCreatePostData$1(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(PostViewData postViewData) {
        this.this$0.getPostModelUpdated().onNext(postViewData);
    }
}
