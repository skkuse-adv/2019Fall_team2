package kr.co.popone.fitts.feature.store.bridge;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;

public final class ShopBridgeAdapter$Companion$COMPARATOR$1 extends ItemCallback<FeedItem> {
    ShopBridgeAdapter$Companion$COMPARATOR$1() {
    }

    public boolean areItemsTheSame(@NotNull FeedItem feedItem, @NotNull FeedItem feedItem2) {
        Intrinsics.checkParameterIsNotNull(feedItem, "oldItem");
        Intrinsics.checkParameterIsNotNull(feedItem2, "newItem");
        return (feedItem instanceof Feed) && (feedItem2 instanceof Feed) && ((Feed) feedItem).getId() == ((Feed) feedItem2).getId();
    }

    public boolean areContentsTheSame(@NotNull FeedItem feedItem, @NotNull FeedItem feedItem2) {
        Intrinsics.checkParameterIsNotNull(feedItem, "oldItem");
        Intrinsics.checkParameterIsNotNull(feedItem2, "newItem");
        return (feedItem instanceof Feed) && (feedItem2 instanceof Feed) && ((Feed) feedItem).getId() == ((Feed) feedItem2).getId();
    }
}
