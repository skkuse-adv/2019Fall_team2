package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CreatePostActivity$onCreate$50<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$50 INSTANCE = new CreatePostActivity$onCreate$50();

    CreatePostActivity$onCreate$50() {
    }

    @Nullable
    public final PostVariantViewData apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getPostVariantViewData();
    }
}
