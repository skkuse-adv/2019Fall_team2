package kr.co.popone.fitts.ui.custom;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.ProductOptionViewData;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import org.jetbrains.annotations.NotNull;

public final class StoreOptionAdapter extends Adapter<ViewHolder> {
    @NotNull
    private final Delegate delegate;
    @NotNull
    private List<ProductVariantViewData> items = new ArrayList();

    public interface Delegate {
        void onOptionSelectFinished(long j);

        void onOptionSelected(int i, @NotNull List<ProductOptionViewData> list);

        void onOptionSoldOut();
    }

    public StoreOptionAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final List<ProductVariantViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<ProductVariantViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return StoreOptionViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof StoreOptionViewHolder) {
            ((StoreOptionViewHolder) viewHolder).bindTo(this.delegate, i, (ProductVariantViewData) this.items.get(i));
        }
    }

    public final void update(int i, @NotNull List<ProductOptionViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "options");
        int i2 = i + 1;
        if (((ProductVariantViewData) this.items.get(i2)).getOptions() != null) {
            int size = this.items.size() - 1;
            if (i2 <= size) {
                int i3 = i2;
                while (true) {
                    ((ProductVariantViewData) this.items.get(i3)).setOptions(null);
                    notifyItemChanged(i3);
                    if (i3 == size) {
                        break;
                    }
                    i3++;
                }
            }
        }
        ((ProductVariantViewData) this.items.get(i2)).setOptions(list);
        notifyItemChanged(i2);
    }

    public final void reset() {
        int size = this.items.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                ((ProductVariantViewData) this.items.get(i)).setOptions(null);
            }
        }
        notifyDataSetChanged();
    }

    public final void clear() {
        if (!this.items.isEmpty()) {
            List<ProductVariantViewData> list = this.items;
            if (list != null) {
                ((ArrayList) list).clear();
                notifyDataSetChanged();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.ArrayList<kr.co.popone.fitts.model.store.ProductVariantViewData>");
        }
    }
}
