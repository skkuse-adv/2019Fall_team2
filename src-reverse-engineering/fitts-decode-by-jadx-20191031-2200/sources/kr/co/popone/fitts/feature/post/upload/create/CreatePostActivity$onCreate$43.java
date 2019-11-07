package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$43<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$43 INSTANCE = new CreatePostActivity$onCreate$43();

    CreatePostActivity$onCreate$43() {
    }

    @NotNull
    public final ArrayList<String> apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getUserTags();
    }
}
