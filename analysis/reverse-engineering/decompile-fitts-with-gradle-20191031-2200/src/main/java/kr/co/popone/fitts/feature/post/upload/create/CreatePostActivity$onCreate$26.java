package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData;
import kr.co.popone.fitts.model.post.PostViewData.PostMode;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$26<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$26 INSTANCE = new CreatePostActivity$onCreate$26();

    CreatePostActivity$onCreate$26() {
    }

    @NotNull
    public final PostMode apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getPostMode();
    }
}
