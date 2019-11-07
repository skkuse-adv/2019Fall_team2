package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$27<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$27 INSTANCE = new CreatePostActivity$onCreate$27();

    CreatePostActivity$onCreate$27() {
    }

    @NotNull
    public final String apply(@NotNull PostMode postMode) {
        Intrinsics.checkParameterIsNotNull(postMode, "it");
        return postMode == PostMode.CREATE ? "포스트 작성" : "포스트 수정";
    }
}
