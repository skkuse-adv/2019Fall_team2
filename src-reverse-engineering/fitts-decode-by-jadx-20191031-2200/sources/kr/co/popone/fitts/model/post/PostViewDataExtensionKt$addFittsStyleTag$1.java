package kr.co.popone.fitts.model.post;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.viewmodel.CreatePostViewModel.ValidationStyleTag;
import org.jetbrains.annotations.NotNull;

final class PostViewDataExtensionKt$addFittsStyleTag$1<T, R> implements Function<T, R> {
    final /* synthetic */ String $tag;
    final /* synthetic */ PostViewData $this_addFittsStyleTag;

    PostViewDataExtensionKt$addFittsStyleTag$1(PostViewData postViewData, String str) {
        this.$this_addFittsStyleTag = postViewData;
        this.$tag = str;
    }

    @NotNull
    public final ValidationStyleTag apply(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "it");
        if (this.$this_addFittsStyleTag.getStyleTags().contains(this.$tag)) {
            this.$this_addFittsStyleTag.getStyleTags().remove(this.$tag);
            return ValidationStyleTag.REMOVED;
        } else if (this.$this_addFittsStyleTag.getStyleTags().size() >= 3) {
            return ValidationStyleTag.NOTHING;
        } else {
            this.$this_addFittsStyleTag.getStyleTags().add(this.$tag);
            return ValidationStyleTag.ADDED;
        }
    }
}
