package kr.co.popone.fitts.feature.post.upload.preview;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.service.post.CreatePostImage;
import kr.co.popone.fitts.model.post.PostAPI.PostContent;
import kr.co.popone.fitts.model.post.PostAPI.ResponseImageId;
import org.jetbrains.annotations.NotNull;

final class PostPreviewActivity$onCreate$3$3$1$1$1<T, R> implements Function<T, R> {
    final /* synthetic */ CreatePostImage $image;

    PostPreviewActivity$onCreate$3$3$1$1$1(CreatePostImage createPostImage) {
        this.$image = createPostImage;
    }

    @NotNull
    public final PostContent apply(@NotNull ResponseImageId responseImageId) {
        Intrinsics.checkParameterIsNotNull(responseImageId, "<name for destructuring parameter 0>");
        return new PostContent(responseImageId.component1(), this.$image.getDescription());
    }
}
