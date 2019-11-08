package kr.co.popone.fitts.feature.common.fittie;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.view.FittieFollowViewData;
import org.jetbrains.annotations.NotNull;

public final class FittieHorizontalFeedAdapter extends Adapter<FittieHorizontalFeedViewHolder> {
    @NotNull
    private final Delegate delegate;
    @NotNull
    private List<FittieFollowViewData> items = new ArrayList();

    public interface Delegate extends kr.co.popone.fitts.feature.common.fittie.FittieHorizontalFeedViewHolder.Delegate {
    }

    public FittieHorizontalFeedAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final List<FittieFollowViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<FittieFollowViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public FittieHorizontalFeedViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return FittieHorizontalFeedViewHolder.Companion.create(viewGroup, this.delegate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull FittieHorizontalFeedViewHolder fittieHorizontalFeedViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(fittieHorizontalFeedViewHolder, "holder");
        fittieHorizontalFeedViewHolder.bindTo((FittieFollowViewData) this.items.get(i), i == CollectionsKt__CollectionsKt.getLastIndex(this.items));
    }
}
