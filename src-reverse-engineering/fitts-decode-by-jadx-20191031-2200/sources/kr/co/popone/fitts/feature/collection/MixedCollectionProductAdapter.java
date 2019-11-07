package kr.co.popone.fitts.feature.collection;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.collection.MixedCollectionAdapter.Delegate;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.ProductRectangleFeedHolder;
import kr.co.popone.fitts.feature.feeds.ProductSquareFeedHolder;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;

public final class MixedCollectionProductAdapter extends Adapter<ViewHolder> {
    private final int columns;
    private final Delegate delegate;
    @NotNull
    private List<Product> items = new ArrayList();

    public MixedCollectionProductAdapter(int i, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.columns = i;
        this.delegate = delegate2;
    }

    @NotNull
    public final List<Product> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<Product> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == ProductSquareFeedHolder.Companion.getId()) {
            return ProductSquareFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductRectangleFeedHolder.Companion.getId()) {
            return ProductRectangleFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof ProductRectangleFeedHolder) {
            BaseViewHolder.bind$default((ProductRectangleFeedHolder) viewHolder, this.items.get(i), null, 2, null);
        } else if (viewHolder instanceof ProductSquareFeedHolder) {
            BaseViewHolder.bind$default((ProductSquareFeedHolder) viewHolder, this.items.get(i), null, 2, null);
        }
    }

    public int getItemViewType(int i) {
        int i2 = this.columns;
        if (i2 == 2) {
            return ProductSquareFeedHolder.Companion.getId();
        }
        if (i2 != 3) {
            return EmptyTypeHolder.Companion.getId();
        }
        return ProductRectangleFeedHolder.Companion.getId();
    }

    public void onViewDetachedFromWindow(@NotNull ViewHolder viewHolder) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof BaseViewHolder) {
            ((BaseViewHolder) viewHolder).clear();
        }
        super.onViewDetachedFromWindow(viewHolder);
    }
}
