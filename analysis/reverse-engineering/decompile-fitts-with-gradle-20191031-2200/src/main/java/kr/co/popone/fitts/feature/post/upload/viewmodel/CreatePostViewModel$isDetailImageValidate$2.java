package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;

final class CreatePostViewModel$isDetailImageValidate$2<T> implements Consumer<ValidationTextColor> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$isDetailImageValidate$2(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(ValidationTextColor validationTextColor) {
        this.this$0.getDetailImageValidate().onNext(Integer.valueOf(validationTextColor.getCaptionColor()));
    }
}
