package kr.co.popone.fitts.feature.store.bridge.product;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.FeedType;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType;
import org.jetbrains.annotations.NotNull;

public final class ProductBridgeAdapter$Companion$COMPARATOR$1 extends ItemCallback<ProductBridgeViewData> {
    ProductBridgeAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull ProductBridgeViewData productBridgeViewData, @NotNull ProductBridgeViewData productBridgeViewData2) {
        Intrinsics.checkParameterIsNotNull(productBridgeViewData, "oldItem");
        Intrinsics.checkParameterIsNotNull(productBridgeViewData2, "newItem");
        if ((productBridgeViewData2 instanceof HeaderType) || (productBridgeViewData2 instanceof ImageType)) {
            return false;
        }
        if (!(productBridgeViewData2 instanceof FeedType)) {
            throw new NoWhenBranchMatchedException();
        } else if (!(productBridgeViewData instanceof FeedType) || ((FeedType) productBridgeViewData).getId() != ((FeedType) productBridgeViewData2).getId()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean areContentsTheSame(@NotNull ProductBridgeViewData productBridgeViewData, @NotNull ProductBridgeViewData productBridgeViewData2) {
        Intrinsics.checkParameterIsNotNull(productBridgeViewData, "oldItem");
        Intrinsics.checkParameterIsNotNull(productBridgeViewData2, "newItem");
        if ((productBridgeViewData2 instanceof HeaderType) || (productBridgeViewData2 instanceof ImageType)) {
            return false;
        }
        if (!(productBridgeViewData2 instanceof FeedType)) {
            throw new NoWhenBranchMatchedException();
        } else if (!(productBridgeViewData instanceof FeedType) || ((FeedType) productBridgeViewData).getId() != ((FeedType) productBridgeViewData2).getId()) {
            return false;
        } else {
            return true;
        }
    }
}
