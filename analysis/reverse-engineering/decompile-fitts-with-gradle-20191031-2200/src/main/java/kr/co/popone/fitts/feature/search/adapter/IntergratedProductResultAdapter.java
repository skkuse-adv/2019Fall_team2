package kr.co.popone.fitts.feature.search.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder;
import kr.co.popone.fitts.feature.home.feed.ProductFeedHolder.Delegate;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;

public final class IntergratedProductResultAdapter extends Adapter<ProductFeedHolder> {
    private final Delegate delegate;
    @NotNull
    private List<ProductFeedViewData> items = new ArrayList();

    public IntergratedProductResultAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final List<ProductFeedViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<ProductFeedViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public ProductFeedHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return ProductFeedHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ProductFeedHolder productFeedHolder, int i) {
        Intrinsics.checkParameterIsNotNull(productFeedHolder, "holder");
        productFeedHolder.bindTo((ProductFeedViewData) this.items.get(i), this.delegate);
    }
}
