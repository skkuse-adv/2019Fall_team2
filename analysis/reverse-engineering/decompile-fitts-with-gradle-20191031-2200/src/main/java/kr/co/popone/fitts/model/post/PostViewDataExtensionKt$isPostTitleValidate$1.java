package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationEditDrawable;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$isPostTitleValidate$1<T, R> implements Function<T, R> {
    public static final PostViewDataExtensionKt$isPostTitleValidate$1 INSTANCE = new PostViewDataExtensionKt$isPostTitleValidate$1();

    PostViewDataExtensionKt$isPostTitleValidate$1() {
    }

    @NotNull
    public final ValidationEditDrawable apply(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        if (str.length() == 0) {
            return ValidationEditDrawable.INVALID;
        }
        return ValidationEditDrawable.VALID;
    }
}
