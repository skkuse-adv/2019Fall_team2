package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$isAboutFitValidate$1<T, R> implements Function<T, R> {
    final /* synthetic */ PostViewData $this_isAboutFitValidate;

    PostViewDataExtensionKt$isAboutFitValidate$1(PostViewData postViewData) {
        this.$this_isAboutFitValidate = postViewData;
    }

    @NotNull
    public final ValidationTextColor apply(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        if (str.length() < PostViewDataExtensionKt.getAboutFitMinCount(this.$this_isAboutFitValidate)) {
            return ValidationTextColor.INVALID;
        }
        return ValidationTextColor.VALID;
    }
}
