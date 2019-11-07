package kr.co.popone.fitts.feature.post.upload.viewmodel;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationEditDrawable;
import org.jetbrains.annotations.NotNull;

final class CreatePostViewModel$postTitleChanged$1<T> implements Predicate<ValidationEditDrawable> {
    final /* synthetic */ CreatePostViewModel this$0;

    CreatePostViewModel$postTitleChanged$1(CreatePostViewModel createPostViewModel) {
        this.this$0 = createPostViewModel;
    }

    public final boolean test(@NotNull ValidationEditDrawable validationEditDrawable) {
        Intrinsics.checkParameterIsNotNull(validationEditDrawable, "it");
        return this.this$0.isPostValidateMode;
    }
}
