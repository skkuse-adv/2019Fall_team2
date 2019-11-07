package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$39<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$39 INSTANCE = new CreatePostActivity$onCreate$39();

    CreatePostActivity$onCreate$39() {
    }

    @NotNull
    public final String apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getAboutFit();
    }
}
