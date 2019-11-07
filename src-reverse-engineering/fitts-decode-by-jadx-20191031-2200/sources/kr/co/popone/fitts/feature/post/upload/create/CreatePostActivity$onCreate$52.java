package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostDetailImage;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$52<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$52 INSTANCE = new CreatePostActivity$onCreate$52();

    CreatePostActivity$onCreate$52() {
    }

    @NotNull
    public final ArrayList<PostDetailImage> apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        return postViewData.getDetailImages();
    }
}
