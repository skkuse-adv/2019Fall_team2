package kr.co.popone.fitts.feature.common.post;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.title.SimplePostHolder;
import kr.co.popone.fitts.feature.feeds.title.SimplePostHolder.Delegate;
import kr.co.popone.fitts.model.post.PostFeedViewData;
import org.jetbrains.annotations.NotNull;

public final class PostFeedAdapter extends Adapter<ViewHolder> {
    private final Delegate delegate;
    @NotNull
    private List<PostFeedViewData> items = new ArrayList();

    public PostFeedAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    @NotNull
    public final List<PostFeedViewData> getItems() {
        return this.items;
    }

    public final void setItems(@NotNull List<PostFeedViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "value");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return SimplePostHolder.Companion.create(viewGroup, this.delegate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof SimplePostHolder) {
            BaseViewHolder.bind$default((SimplePostHolder) viewHolder, this.items.get(i), null, 2, null);
        }
    }
}
