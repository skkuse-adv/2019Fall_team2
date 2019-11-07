package kr.co.popone.fitts.feature.home.feed;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import org.jetbrains.annotations.NotNull;

public final class HomeFeedAdapter$Companion$COMPARATOR$1 extends ItemCallback<Feed> {
    HomeFeedAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull Feed feed, @NotNull Feed feed2) {
        Intrinsics.checkParameterIsNotNull(feed, "oldItem");
        Intrinsics.checkParameterIsNotNull(feed2, "newItem");
        return feed.getId() == feed.getId();
    }

    public boolean areContentsTheSame(@NotNull Feed feed, @NotNull Feed feed2) {
        Intrinsics.checkParameterIsNotNull(feed, "oldItem");
        Intrinsics.checkParameterIsNotNull(feed2, "newItem");
        return feed.getId() == feed.getId();
    }
}
