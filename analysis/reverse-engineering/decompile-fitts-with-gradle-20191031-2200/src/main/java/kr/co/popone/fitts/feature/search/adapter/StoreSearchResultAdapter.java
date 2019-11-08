package kr.co.popone.fitts.feature.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.holder.StoreSearchResultViewHolder;
import kr.co.popone.fitts.feature.search.holder.StoreSearchResultViewHolder.Delegate;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;

public final class StoreSearchResultAdapter extends Adapter<StoreSearchResultViewHolder> {
    private final Delegate delegate;
    @NotNull
    private List<StoreInfo> items = new ArrayList();

    public StoreSearchResultAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final List<StoreInfo> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<StoreInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public StoreSearchResultViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return StoreSearchResultViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull StoreSearchResultViewHolder storeSearchResultViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(storeSearchResultViewHolder, "holder");
        storeSearchResultViewHolder.bindTo((StoreInfo) this.items.get(i), this.delegate);
    }
}
