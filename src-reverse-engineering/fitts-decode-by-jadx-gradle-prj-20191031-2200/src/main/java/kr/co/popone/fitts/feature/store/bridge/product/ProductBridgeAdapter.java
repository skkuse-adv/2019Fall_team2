package kr.co.popone.fitts.feature.store.bridge.product;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.common.ImageRatioViewHolder;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.ProductRectangleFeedHolder;
import kr.co.popone.fitts.model.store.ProductBridgeViewData;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.ImageType;
import org.jetbrains.annotations.NotNull;

public final class ProductBridgeAdapter extends ListAdapter<ProductBridgeViewData, ViewHolder> {
    private static final ProductBridgeAdapter$Companion$COMPARATOR$1 COMPARATOR = new ProductBridgeAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;
    private final boolean hasProductInfo;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeHeaderViewHolder.Delegate, kr.co.popone.fitts.feature.common.ImageRatioViewHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductRectangleFeedHolder.Delegate {
    }

    public ProductBridgeAdapter(@NotNull Delegate delegate2, boolean z) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super((ItemCallback<T>) COMPARATOR);
        this.delegate = delegate2;
        this.hasProductInfo = z;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == ProductBridgeHeaderViewHolder.Companion.getId()) {
            return ProductBridgeHeaderViewHolder.Companion.create(viewGroup);
        }
        if (i == ImageRatioViewHolder.Companion.getId()) {
            return ImageRatioViewHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductRectangleFeedHolder.Companion.getId()) {
            return ProductRectangleFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        throw new IllegalAccessException("Type not exist");
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof ProductBridgeHeaderViewHolder) {
            ProductBridgeHeaderViewHolder productBridgeHeaderViewHolder = (ProductBridgeHeaderViewHolder) viewHolder;
            Object item = getItem(i);
            if (item != null) {
                productBridgeHeaderViewHolder.bind((HeaderType) item, this.hasProductInfo, this.delegate);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType");
        } else if (viewHolder instanceof ImageRatioViewHolder) {
            BaseViewHolder.bind$default((ImageRatioViewHolder) viewHolder, getItem(i), null, 2, null);
        } else if (viewHolder instanceof ProductRectangleFeedHolder) {
            BaseViewHolder.bind$default((ProductRectangleFeedHolder) viewHolder, getItem(i), null, 2, null);
        }
    }

    public int getItemViewType(int i) {
        ProductBridgeViewData productBridgeViewData = (ProductBridgeViewData) getItem(i);
        if (productBridgeViewData instanceof HeaderType) {
            return ProductBridgeHeaderViewHolder.Companion.getId();
        }
        if (productBridgeViewData instanceof ImageType) {
            return ImageRatioViewHolder.Companion.getId();
        }
        return ProductRectangleFeedHolder.Companion.getId();
    }
}
