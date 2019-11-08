package kr.co.popone.fitts.feature.post.upload.create;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostVariantViewData;
import kr.co.popone.fitts.model.post.PostViewData;
import org.jetbrains.annotations.NotNull;

final class CreatePostActivity$onCreate$47<T, R> implements Function<T, R> {
    public static final CreatePostActivity$onCreate$47 INSTANCE = new CreatePostActivity$onCreate$47();

    CreatePostActivity$onCreate$47() {
    }

    @NotNull
    public final String apply(@NotNull PostViewData postViewData) {
        Intrinsics.checkParameterIsNotNull(postViewData, "it");
        if (postViewData.getPostVariantViewData() == null) {
            return postViewData.getShopUrl();
        }
        PostVariantViewData postVariantViewData = postViewData.getPostVariantViewData();
        if (postVariantViewData != null) {
            String variantUrl = postVariantViewData.getVariantUrl();
            if (variantUrl != null) {
                return variantUrl;
            }
        }
        return "";
    }
}
