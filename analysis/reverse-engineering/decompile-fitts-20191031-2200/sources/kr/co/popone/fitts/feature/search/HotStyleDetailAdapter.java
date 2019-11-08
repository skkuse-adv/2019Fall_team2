package kr.co.popone.fitts.feature.search;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.HotStyleDetailViewHolder.Delegate;
import kr.co.popone.fitts.model.search.StyleRecommendViewData;
import org.jetbrains.annotations.NotNull;

public final class HotStyleDetailAdapter extends Adapter<HotStyleDetailViewHolder> {
    @NotNull
    private final Delegate delegate;
    @NotNull
    private List<StyleRecommendViewData> items = new ArrayList();

    public HotStyleDetailAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final List<StyleRecommendViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<StyleRecommendViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.items = list;
    }

    @NotNull
    public HotStyleDetailViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return HotStyleDetailViewHolder.Companion.create(viewGroup, this.delegate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull HotStyleDetailViewHolder hotStyleDetailViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(hotStyleDetailViewHolder, "holder");
        hotStyleDetailViewHolder.bindTo((StyleRecommendViewData) this.items.get(i));
    }
}
