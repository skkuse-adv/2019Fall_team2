package kr.co.popone.fitts.feature.store.bridge;

import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.paging.PagedList;
import java.util.ArrayList;
import java.util.Iterator;
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
import kr.co.popone.fitts.feature.feeds.ShopBridgeFeed;
import kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder;
import kr.co.popone.fitts.feature.feeds.TitleOnlyFeedHolder;
import kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeProduct;
import kr.co.popone.fitts.model.datamodel.commerce.shop.bridge.ShopBridgeTitleFeed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed.Type;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;

public final class ShopBridgeAdapter extends BasePagedListAdapter<FeedItem, BaseViewHolder> {
    private static final ShopBridgeAdapter$Companion$COMPARATOR$1 COMPARATOR = new ShopBridgeAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.store.bridge.ShopBridgeHeaderHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedDoubleHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.TitleOnlyFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ImageFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder.Delegate {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.PRODUCT.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.IMAGE.ordinal()] = 2;
        }
    }

    public ShopBridgeAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == ShopBridgeHeaderHolder.Companion.getId()) {
            return ShopBridgeHeaderHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedDoubleHolder.Companion.getId()) {
            return ProductFeedDoubleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedTripleHolder.Companion.getId()) {
            return ProductFeedTripleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == TitleOnlyFeedHolder.Companion.getId()) {
            return TitleOnlyFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ImageFeedHolder.Companion.getId()) {
            return ImageFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SlidingBannerFeedHolder.Companion.getId()) {
            return new SlidingBannerFeedHolder(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        BaseViewHolder.bind$default(baseViewHolder, getItem(i), null, 2, null);
    }

    public int getItemViewTypeWithoutLoading(int i) {
        FeedItem feedItem = (FeedItem) getItem(i);
        if (feedItem instanceof StoreInfo) {
            return ShopBridgeHeaderHolder.Companion.getId();
        }
        if (feedItem instanceof ShopBridgeProduct) {
            return ProductFeedDoubleHolder.Companion.getId();
        }
        if (feedItem instanceof ShopBridgeTitleFeed) {
            return TitleOnlyFeedHolder.Companion.getId();
        }
        if (!(feedItem instanceof ShopBridgeFeed)) {
            return EmptyTypeHolder.Companion.getId();
        }
        Type shopBridgeFeedType = ((ShopBridgeFeed) feedItem).getFeed().getShopBridgeFeedType();
        if (shopBridgeFeedType != null) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[shopBridgeFeedType.ordinal()];
            if (i2 == 1) {
                return ProductFeedTripleHolder.Companion.getId();
            }
            if (i2 == 2) {
                return ImageFeedHolder.Companion.getId();
            }
        }
        return EmptyTypeHolder.Companion.getId();
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        Intrinsics.checkParameterIsNotNull(list, "payloads");
        Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
        if (firstOrNull instanceof StoreInfo) {
            if (baseViewHolder instanceof ShopBridgeHeaderHolder) {
                ((ShopBridgeHeaderHolder) baseViewHolder).updateShopInfo((StoreInfo) firstOrNull);
            } else {
                super.onBindViewHolder(baseViewHolder, i, list);
            }
        } else if (!(firstOrNull instanceof ShopBridgeProduct)) {
            super.onBindViewHolder(baseViewHolder, i, list);
        } else if (baseViewHolder instanceof ProductFeedDoubleHolder) {
            ((ProductFeedDoubleHolder) baseViewHolder).updateShopBridgeFeed((ShopBridgeProduct) firstOrNull);
        } else {
            super.onBindViewHolder(baseViewHolder, i, list);
        }
    }

    public void onViewRecycled(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        baseViewHolder.recycle();
        super.onViewRecycled(baseViewHolder);
    }

    public final void updateBookmarkState(@NotNull ShopBookmarkEvent shopBookmarkEvent) {
        Intrinsics.checkParameterIsNotNull(shopBookmarkEvent, NotificationCompat.CATEGORY_EVENT);
        PagedList currentList = getCurrentList();
        if (currentList != null) {
            ArrayList arrayList = new ArrayList();
            for (Object next : currentList) {
                if (next instanceof StoreInfo) {
                    arrayList.add(next);
                }
            }
            Iterator it = arrayList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (((StoreInfo) it.next()).getId() == shopBookmarkEvent.getId()) {
                    break;
                }
                i++;
            }
            Object item = getItem(i);
            if (!(item instanceof StoreInfo)) {
                item = null;
            }
            StoreInfo storeInfo = (StoreInfo) item;
            if (storeInfo != null) {
                storeInfo.setBookmark(shopBookmarkEvent.getBookmark());
                notifyItemChanged(i, storeInfo);
            }
        }
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
                FeedItem feedItem = (FeedItem) next;
                if ((feedItem instanceof ShopBridgeProduct) && ((ShopBridgeProduct) feedItem).hasItemAndUpdate(wishStateUpdateEvent)) {
                    notifyItemChanged(i, feedItem);
                }
                i = i2;
            }
        }
    }
}
