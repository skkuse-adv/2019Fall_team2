package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$37<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$37 INSTANCE = new CreatePostActivity$onCreate$37();

    CreatePostActivity$onCreate$37() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Float.valueOf(apply((PostViewData) obj));
    }

    public final float apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getStarScore();
    }
}
