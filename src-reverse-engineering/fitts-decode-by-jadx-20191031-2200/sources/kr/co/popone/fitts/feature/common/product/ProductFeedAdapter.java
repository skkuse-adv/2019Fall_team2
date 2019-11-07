package kr.co.popone.fitts.feature.common.product;

import android.view.ViewGroup;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder.Delegate;
import kr.co.popone.fitts.model.product.CategoryProductItem;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import kr.co.popone.fitts.ui.custom.RecyclerLoadingItemView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductFeedAdapter extends PagedListAdapter<CategoryProductItem, ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<CategoryProductItem> COMPARATOR = new ProductFeedAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;
    @Nullable
    private NetworkState networkState;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<CategoryProductItem> getCOMPARATOR() {
            return ProductFeedAdapter.COMPARATOR;
        }
    }

    public ProductFeedAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @Nullable
    public final NetworkState getNetworkState() {
        return this.networkState;
    }

    public final void setNetworkState(@Nullable NetworkState networkState2) {
        this.networkState = networkState2;
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == 2131558640) {
            return ProductFeedHolder.Companion.create(viewGroup);
        }
        if (i == 2131558709) {
            return RecyclerLoadingItemView.Companion.create(viewGroup);
        }
        throw new IllegalAccessException();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        ProductFeedViewData productFeedViewData;
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof ProductFeedHolder) {
            ProductFeedHolder productFeedHolder = (ProductFeedHolder) viewHolder;
            CategoryProductItem categoryProductItem = (CategoryProductItem) getItem(i);
            if (categoryProductItem != null) {
                Product item = categoryProductItem.getItem();
                if (item != null) {
                    productFeedViewData = ProductEntityExtensionKt.mapToDomain(item);
                    productFeedHolder.bindTo(productFeedViewData, this.delegate);
                }
            }
            productFeedViewData = null;
            productFeedHolder.bindTo(productFeedViewData, this.delegate);
        } else if (viewHolder instanceof RecyclerLoadingItemView) {
            ((RecyclerLoadingItemView) viewHolder).bindTo(this.networkState);
        }
    }

    public int getItemViewType(int i) {
        return (!hasExtraRow() || i != getItemCount() + -1) ? C0013R$layout.item_feed_product : C0013R$layout.item_recycler_loading;
    }

    public final void updateNetworkState(@Nullable NetworkState networkState2) {
        NetworkState networkState3 = this.networkState;
        boolean hasExtraRow = hasExtraRow();
        this.networkState = networkState2;
        boolean hasExtraRow2 = hasExtraRow();
        if (hasExtraRow != hasExtraRow2) {
            if (hasExtraRow) {
                notifyItemRemoved(super.getItemCount());
            } else {
                notifyItemInserted(super.getItemCount());
            }
        } else if (hasExtraRow2 && (!Intrinsics.areEqual((Object) networkState3, (Object) networkState2))) {
            notifyItemChanged(getItemCount() - 1);
        }
    }

    public int getItemCount() {
        return super.getItemCount() + (hasExtraRow() ? 1 : 0);
    }

    private final boolean hasExtraRow() {
        NetworkState networkState2 = this.networkState;
        return networkState2 != null && (Intrinsics.areEqual((Object) networkState2, (Object) NetworkState.Companion.getLOADED()) ^ true);
    }
}
