package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$isStarScoreValidate$1<T, R> implements Function<T, R> {
    public static final PostViewDataExtensionKt$isStarScoreValidate$1 INSTANCE = new PostViewDataExtensionKt$isStarScoreValidate$1();

    PostViewDataExtensionKt$isStarScoreValidate$1() {
    }

    @NotNull
    public final ValidationTextColor apply(@NotNull Float f) {
        Intrinsics.checkParameterIsNotNull(f, "it");
        if (f.floatValue() <= 0.0f) {
            return ValidationTextColor.INVALID;
        }
        return ValidationTextColor.VALID;
    }
}
