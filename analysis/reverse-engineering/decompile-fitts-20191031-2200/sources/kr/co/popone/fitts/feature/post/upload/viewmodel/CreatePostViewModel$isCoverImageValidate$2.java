package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationCoverRes;

final class CreatePostViewModel$isCoverImageValidate$2<T> implements Consumer<ValidationCoverRes> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$isCoverImageValidate$2(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final void accept(ValidationCoverRes validationCoverRes) {
        this.this$0.getCoverImageValidate().onNext(new Pair(Integer.valueOf(validationCoverRes.getDrawable()), Integer.valueOf(validationCoverRes.getCaptionColor())));
    }
}
