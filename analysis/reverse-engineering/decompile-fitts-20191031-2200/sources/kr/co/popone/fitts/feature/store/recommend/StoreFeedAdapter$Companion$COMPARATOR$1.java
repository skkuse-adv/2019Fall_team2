package kr.co.popone.fitts.feature.store.recommend;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import org.jetbrains.annotations.NotNull;

public final class StoreFeedAdapter$Companion$COMPARATOR$1 extends ItemCallback<Feed> {
    StoreFeedAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull Feed feed, @NotNull Feed feed2) {
        Intrinsics.checkParameterIsNotNull(feed, "oldItem");
        Intrinsics.checkParameterIsNotNull(feed2, "newItem");
        return feed.getId() == feed2.getId();
    }

    public boolean areContentsTheSame(@NotNull Feed feed, @NotNull Feed feed2) {
        Intrinsics.checkParameterIsNotNull(feed, "oldItem");
        Intrinsics.checkParameterIsNotNull(feed2, "newItem");
        return feed.getId() == feed2.getId();
    }
}
