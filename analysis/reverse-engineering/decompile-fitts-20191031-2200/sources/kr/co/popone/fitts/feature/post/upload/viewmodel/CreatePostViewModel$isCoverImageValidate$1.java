package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationCoverRes;
import org.jetbrains.annotations.NotNull;

final class CreatePostViewModel$isCoverImageValidate$1<T> implements Predicate<ValidationCoverRes> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$isCoverImageValidate$1(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final boolean test(@NotNull ValidationCoverRes validationCoverRes) {
        Intrinsics.checkParameterIsNotNull(validationCoverRes, "it");
        return this.this$0.isPostValidateMode;
    }
}
