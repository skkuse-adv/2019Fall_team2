package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import org.jetbrains.annotations.NotNull;

final class CreatePostViewModel$ratingChanged$1<T> implements Predicate<ValidationTextColor> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$ratingChanged$1(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final boolean test(@NotNull ValidationTextColor validationTextColor) {
        Intrinsics.checkParameterIsNotNull(validationTextColor, "it");
        return this.this$0.isPostValidateMode;
    }
}
