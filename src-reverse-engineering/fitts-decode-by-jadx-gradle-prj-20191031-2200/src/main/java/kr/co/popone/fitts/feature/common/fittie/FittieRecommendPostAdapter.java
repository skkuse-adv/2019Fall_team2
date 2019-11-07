package kr.co.popone.fitts.feature.common.fittie;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.post.PostAPI.Post;
import org.jetbrains.annotations.NotNull;

public final class FittieRecommendPostAdapter extends Adapter<FittieRecommendPostViewHolder> {
    private List<Post> items = new ArrayList();

    public final void update(@NotNull List<Post> list) {
        Intrinsics.checkParameterIsNotNull(list, "newItems");
        this.items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public FittieRecommendPostViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return FittieRecommendPostViewHolder.Companion.create(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull FittieRecommendPostViewHolder fittieRecommendPostViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(fittieRecommendPostViewHolder, "holder");
        fittieRecommendPostViewHolder.bindTo((Post) this.items.get(i));
    }

    public void onViewRecycled(@NotNull FittieRecommendPostViewHolder fittieRecommendPostViewHolder) {
        Intrinsics.checkParameterIsNotNull(fittieRecommendPostViewHolder, "holder");
        super.onViewRecycled(fittieRecommendPostViewHolder);
        fittieRecommendPostViewHolder.clear();
    }
}
