package kr.co.popone.fitts.feature.store.recommend;

import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.ShopBookmarkEvent;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.ImageFeedHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedDoubleHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedTripleHolder;
import kr.co.popone.fitts.feature.feeds.ShopParallelFeedHolder;
import kr.co.popone.fitts.feature.feeds.ShopPreviewFeedHolder;
import kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed.Type;
import org.jetbrains.annotations.NotNull;

public final class StoreFeedAdapter extends BasePagedListAdapter<Feed, BaseViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<Feed> COMPARATOR = new StoreFeedAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<Feed> getCOMPARATOR() {
            return StoreFeedAdapter.COMPARATOR;
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.ImageFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedDoubleHolder.Delegate, kr.co.popone.fitts.feature.feeds.ShopParallelFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ShopPreviewFeedHolder.Delegate {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.BANNER.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.IMAGE.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.PRODUCT.ordinal()] = 3;
            $EnumSwitchMapping$0[Type.PRODUCT_DOUBLE.ordinal()] = 4;
            $EnumSwitchMapping$0[Type.SHOP_PARALLEL.ordinal()] = 5;
            $EnumSwitchMapping$0[Type.SHOP_PREVIEW.ordinal()] = 6;
        }
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public StoreFeedAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == ImageFeedHolder.Companion.getId()) {
            return ImageFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SlidingBannerFeedHolder.Companion.getId()) {
            return SlidingBannerFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedTripleHolder.Companion.getId()) {
            return ProductFeedTripleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedDoubleHolder.Companion.getId()) {
            return ProductFeedDoubleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ShopParallelFeedHolder.Companion.getId()) {
            return ShopParallelFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ShopPreviewFeedHolder.Companion.getId()) {
            return ShopPreviewFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        BaseViewHolder.bind$default(baseViewHolder, getItem(i), null, 2, null);
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        if (baseViewHolder instanceof ProductFeedDoubleHolder) {
            Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
            if (firstOrNull instanceof Feed) {
                ((ProductFeedDoubleHolder) baseViewHolder).updateFeedState((Feed) firstOrNull);
            } else {
                super.onBindViewHolder(baseViewHolder, i, list);
            }
        } else if (baseViewHolder instanceof ShopPreviewFeedHolder) {
            Object firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull(list);
            if (firstOrNull2 instanceof Feed) {
                ((ShopPreviewFeedHolder) baseViewHolder).updateFeedState((Feed) firstOrNull2);
            } else {
                super.onBindViewHolder(baseViewHolder, i, list);
            }
        } else {
            super.onBindViewHolder(baseViewHolder, i, list);
        }
    }

    public int getItemViewTypeWithoutLoading(int i) {
        Feed feed = (Feed) getItem(i);
        Type storeFeedType = feed != null ? feed.getStoreFeedType() : null;
        if (storeFeedType != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[storeFeedType.ordinal()]) {
                case 1:
                    return SlidingBannerFeedHolder.Companion.getId();
                case 2:
                    return ImageFeedHolder.Companion.getId();
                case 3:
                    return ProductFeedTripleHolder.Companion.getId();
                case 4:
                    return ProductFeedDoubleHolder.Companion.getId();
                case 5:
                    return ShopParallelFeedHolder.Companion.getId();
                case 6:
                    return ShopPreviewFeedHolder.Companion.getId();
            }
        }
        return EmptyTypeHolder.Companion.getId();
    }

    public final void updateProductLikeState(@NotNull WishStateUpdateEvent wishStateUpdateEvent) {
        Intrinsics.checkParameterIsNotNull(wishStateUpdateEvent, NotificationCompat.CATEGORY_EVENT);
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            int i = 0;
            for (Object next : currentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Feed feed = (Feed) next;
                if (feed.updateProductLikeState(wishStateUpdateEvent.getProductId(), wishStateUpdateEvent.isInWishList())) {
                    notifyItemChanged(i, feed);
                }
                i = i2;
            }
        }
    }

    public final void updateShopBookmarkState(@NotNull ShopBookmarkEvent shopBookmarkEvent) {
        Intrinsics.checkParameterIsNotNull(shopBookmarkEvent, NotificationCompat.CATEGORY_EVENT);
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            int i = 0;
            for (Object next : currentList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Feed feed = (Feed) next;
                if (feed.updateShopBookmarkState(shopBookmarkEvent.getId(), shopBookmarkEvent.getBookmark())) {
                    notifyItemChanged(i, feed);
                }
                i = i2;
            }
        }
    }

    public void onViewRecycled(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        baseViewHolder.recycle();
        super.onViewRecycled(baseViewHolder);
    }
}
