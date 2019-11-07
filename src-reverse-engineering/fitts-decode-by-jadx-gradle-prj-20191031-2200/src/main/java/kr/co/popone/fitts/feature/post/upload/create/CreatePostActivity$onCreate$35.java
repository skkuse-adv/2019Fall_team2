package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$35<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$35 INSTANCE = new CreatePostActivity$onCreate$35();

    CreatePostActivity$onCreate$35() {
    }

    @NotNull
    public final String apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getTitle();
    }
}
