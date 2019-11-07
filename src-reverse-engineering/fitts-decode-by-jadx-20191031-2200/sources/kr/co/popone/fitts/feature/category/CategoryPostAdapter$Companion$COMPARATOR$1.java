package kr.co.popone.fitts.feature.category;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostItem;
import org.jetbrains.annotations.NotNull;

public final class CategoryPostAdapter$Companion$COMPARATOR$1 extends ItemCallback<CategoryPostItem> {
    CategoryPostAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull CategoryPostItem categoryPostItem, @NotNull CategoryPostItem categoryPostItem2) {
        Intrinsics.checkParameterIsNotNull(categoryPostItem, "oldItem");
        Intrinsics.checkParameterIsNotNull(categoryPostItem2, "newItem");
        return categoryPostItem.getFeedId() == categoryPostItem2.getFeedId();
    }

    public boolean areContentsTheSame(@NotNull CategoryPostItem categoryPostItem, @NotNull CategoryPostItem categoryPostItem2) {
        Intrinsics.checkParameterIsNotNull(categoryPostItem, "oldItem");
        Intrinsics.checkParameterIsNotNull(categoryPostItem2, "newItem");
        return categoryPostItem.getFeedId() == categoryPostItem2.getFeedId();
    }
}
