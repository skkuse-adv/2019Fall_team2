package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationCoverRes;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$isCoverImageValidate$1<T, R> implements Function<T, R> {
    public static final PostViewDataExtensionKt$isCoverImageValidate$1 INSTANCE = new PostViewDataExtensionKt$isCoverImageValidate$1();

    PostViewDataExtensionKt$isCoverImageValidate$1() {
    }

    @NotNull
    public final ValidationCoverRes apply(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        if (str.length() == 0) {
            return ValidationCoverRes.INVALID;
        }
        return ValidationCoverRes.VALID;
    }
}
