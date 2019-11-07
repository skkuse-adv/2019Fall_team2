package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$isDetailImagesValidate$1<T, R> implements Function<T, R> {
    final /* synthetic */ int $minCount;

    PostViewDataExtensionKt$isDetailImagesValidate$1(int i) {
        this.$minCount = i;
    }

    @NotNull
    public final ValidationTextColor apply(@NotNull ArrayList<PostDetailImage> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "it");
        if (arrayList.size() < this.$minCount) {
            return ValidationTextColor.INVALID;
        }
        return ValidationTextColor.VALID;
    }
}
