package kr.co.popone.fitts.feature.dialog;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class ProductPostAdapter$Companion$COMPARATOR$1 extends ItemCallback<Post> {
    ProductPostAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull Post post, @NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post, "oldItem");
        Intrinsics.checkParameterIsNotNull(post2, "newItem");
        return post.getId() == post2.getId();
    }

    public boolean areContentsTheSame(@NotNull Post post, @NotNull Post post2) {
        Intrinsics.checkParameterIsNotNull(post, "oldItem");
        Intrinsics.checkParameterIsNotNull(post2, "newItem");
        return post.getId() == post2.getId();
    }
}
