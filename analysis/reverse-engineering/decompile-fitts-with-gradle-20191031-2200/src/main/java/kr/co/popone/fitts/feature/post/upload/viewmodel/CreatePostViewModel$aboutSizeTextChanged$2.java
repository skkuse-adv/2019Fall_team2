package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;

final class CreatePostViewModel$aboutSizeTextChanged$2<T> implements Consumer<ValidationTextColor> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$aboutSizeTextChanged$2(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(ValidationTextColor validationTextColor) {
        this.this$0.getAboutSizeValidate().onNext(validationTextColor);
    }
}
