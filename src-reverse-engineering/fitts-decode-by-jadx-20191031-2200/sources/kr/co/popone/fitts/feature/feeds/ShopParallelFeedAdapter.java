package kr.co.popone.fitts.feature.feeds;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.feeds.ShopCircleFeedHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;
import org.jetbrains.annotations.NotNull;

public final class ShopParallelFeedAdapter extends Adapter<ShopCircleFeedHolder> {
    private final Delegate delegate;
    private final List<FeedVariantInfo> items;

    public ShopParallelFeedAdapter(@NotNull List<FeedVariantInfo> list, @NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.items = list;
        this.delegate = delegate2;
    }

    @NotNull
    public ShopCircleFeedHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        return ShopCircleFeedHolder.Companion.create(viewGroup, this.delegate);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ShopCircleFeedHolder shopCircleFeedHolder, int i) {
        Intrinsics.checkParameterIsNotNull(shopCircleFeedHolder, "holder");
        BaseViewHolder.bind$default(shopCircleFeedHolder, this.items.get(i), null, 2, null);
    }
}
