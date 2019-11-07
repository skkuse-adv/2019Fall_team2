package kr.co.popone.fitts.feature.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.search.holder.SearchHistoryDeleteHolder;
import kr.co.popone.fitts.feature.search.holder.SearchHistoryHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHistoryAdapter extends Adapter<BaseViewHolder> {
    @Nullable
    private final Delegate delegate;
    private List<String> items = new ArrayList();

    public interface Delegate extends kr.co.popone.fitts.feature.search.holder.SearchHistoryDeleteHolder.Delegate, kr.co.popone.fitts.feature.search.holder.SearchHistoryHolder.Delegate {
    }

    public SearchHistoryAdapter(@Nullable Delegate delegate2) {
        this.delegate = delegate2;
    }

    @Nullable
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public final void submitList(@NotNull List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == SearchHistoryHolder.Companion.getId()) {
            return SearchHistoryHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SearchHistoryDeleteHolder.Companion.getId()) {
            return SearchHistoryDeleteHolder.Companion.create(viewGroup, this.delegate);
        }
        throw new IllegalAccessException();
    }

    public int getItemCount() {
        return this.items.size() + 1;
    }

    public int getItemViewType(int i) {
        return i == this.items.size() ? SearchHistoryDeleteHolder.Companion.getId() : SearchHistoryHolder.Companion.getId();
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        if (baseViewHolder instanceof SearchHistoryHolder) {
            BaseViewHolder.bind$default(baseViewHolder, this.items.get(i), null, 2, null);
        } else if (baseViewHolder instanceof SearchHistoryDeleteHolder) {
            BaseViewHolder.bind$default(baseViewHolder, null, null, 2, null);
        }
    }
}
