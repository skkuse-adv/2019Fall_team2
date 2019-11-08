package kr.co.popone.fitts.feature.wish;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;

public final class WishListAdapter$Companion$COMPARATOR$1 extends ItemCallback<ProductFeedViewData> {
    WishListAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull ProductFeedViewData productFeedViewData, @NotNull ProductFeedViewData productFeedViewData2) {
        Intrinsics.checkParameterIsNotNull(productFeedViewData, "oldItem");
        Intrinsics.checkParameterIsNotNull(productFeedViewData2, "newItem");
        return productFeedViewData.getId() == productFeedViewData2.getId();
    }

    public boolean areContentsTheSame(@NotNull ProductFeedViewData productFeedViewData, @NotNull ProductFeedViewData productFeedViewData2) {
        Intrinsics.checkParameterIsNotNull(productFeedViewData, "oldItem");
        Intrinsics.checkParameterIsNotNull(productFeedViewData2, "newItem");
        return productFeedViewData.getId() == productFeedViewData2.getId();
    }
}
