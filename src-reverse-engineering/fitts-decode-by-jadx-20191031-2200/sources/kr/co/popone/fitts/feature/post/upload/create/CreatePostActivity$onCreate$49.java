package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$49<T> implements Predicate<PostViewData> {
    public static final CreatePostActivity$onCreate$49 INSTANCE = new CreatePostActivity$onCreate$49();

    CreatePostActivity$onCreate$49() {
    }

    public final boolean test(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getPostVariantViewData() != null;
    }
}
