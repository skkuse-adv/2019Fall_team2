package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;

final class CreatePostViewModel$loadCreatePostData$2<T> implements Consumer<Throwable> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$loadCreatePostData$2(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorOccured().onNext(th);
    }
}
