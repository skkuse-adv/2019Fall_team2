package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;

final class CreatePostViewModel$aboutFitTextChanged$2<T> implements Consumer<ValidationTextColor> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$aboutFitTextChanged$2(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(ValidationTextColor validationTextColor) {
        this.this$0.getAboutFitValidate().onNext(validationTextColor);
        this.this$0.getAboutFitErrorVisivility().onNext(Integer.valueOf(validationTextColor == ValidationTextColor.VALID ? 8 : 0));
    }
}
