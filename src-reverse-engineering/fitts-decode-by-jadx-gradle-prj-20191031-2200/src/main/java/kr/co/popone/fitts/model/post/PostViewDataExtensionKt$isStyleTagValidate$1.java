package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationTextColor;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$isStyleTagValidate$1<T, R> implements Function<T, R> {
    public static final PostViewDataExtensionKt$isStyleTagValidate$1 INSTANCE = new PostViewDataExtensionKt$isStyleTagValidate$1();

    PostViewDataExtensionKt$isStyleTagValidate$1() {
    }

    @NotNull
    public final ValidationTextColor apply(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "it");
        if (arrayList.size() < 1) {
            return ValidationTextColor.INVALID;
        }
        return ValidationTextColor.VALID;
    }
}
