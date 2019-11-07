package kr.co.popone.fitts.feature.common.product;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.CategoryProductItem;
import org.jetbrains.annotations.NotNull;

public final class ProductFeedAdapter$Companion$COMPARATOR$1 extends ItemCallback<CategoryProductItem> {
    ProductFeedAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull CategoryProductItem categoryProductItem, @NotNull CategoryProductItem categoryProductItem2) {
        Intrinsics.checkParameterIsNotNull(categoryProductItem, "oldItem");
        Intrinsics.checkParameterIsNotNull(categoryProductItem2, "newItem");
        return categoryProductItem.getFeedId() == categoryProductItem2.getFeedId();
    }

    public boolean areContentsTheSame(@NotNull CategoryProductItem categoryProductItem, @NotNull CategoryProductItem categoryProductItem2) {
        Intrinsics.checkParameterIsNotNull(categoryProductItem, "oldItem");
        Intrinsics.checkParameterIsNotNull(categoryProductItem2, "newItem");
        return categoryProductItem.getFeedId() == categoryProductItem2.getFeedId();
    }
}
