package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationEditDrawable;

final class CreatePostViewModel$postTitleChanged$2<T> implements Consumer<ValidationEditDrawable> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$postTitleChanged$2(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(ValidationEditDrawable validationEditDrawable) {
        this.this$0.getPostTitleValidate().onNext(validationEditDrawable);
    }
}
