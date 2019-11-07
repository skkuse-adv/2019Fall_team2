package kr.co.popone.fitts.feature.store.newest;

import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.ImageFeedHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedDoubleHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedTripleHolder;
import kr.co.popone.fitts.feature.feeds.SpecialDiscountDoubleFeedHolder;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountFeed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed.Type;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;

public final class NewestProductAdapter extends BasePagedListAdapter<FeedItem, BaseViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<FeedItem> COMPARATOR = new NewestProductAdapter$Companion$COMPARATOR$1();
    public static final Companion Companion = new Companion(null);
    private final Delegate delegate;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ItemCallback<FeedItem> getCOMPARATOR() {
            return NewestProductAdapter.COMPARATOR;
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.SpecialDiscountDoubleFeedHolder.Delegate, kr.co.popone.fitts.feature.store.newest.SpecialDiscountProductHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedDoubleHolder.Delegate, kr.co.popone.fitts.feature.feeds.ImageFeedHolder.Delegate {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[SpecialDiscountFeed.Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.IMAGE.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.PRODUCT.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.PRODUCT_DOUBLE.ordinal()] = 3;
            $EnumSwitchMapping$1[SpecialDiscountFeed.Type.SINGLE.ordinal()] = 1;
            $EnumSwitchMapping$1[SpecialDiscountFeed.Type.DOUBLE.ordinal()] = 2;
        }
    }

    public NewestProductAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        super(COMPARATOR);
        this.delegate = delegate2;
    }

    @NotNull
    public BaseViewHolder onCreateViewHolderWithoutLoading(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == SpecialDiscountDoubleFeedHolder.Companion.getId()) {
            return SpecialDiscountDoubleFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SpecialDiscountProductHolder.Companion.getId()) {
            return SpecialDiscountProductHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedTripleHolder.Companion.getId()) {
            return ProductFeedTripleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedDoubleHolder.Companion.getId()) {
            return ProductFeedDoubleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ImageFeedHolder.Companion.getId()) {
            return ImageFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        baseViewHolder.bind(super.getItem(i), Integer.valueOf(i));
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
        } else {
            super.onBindViewHolder(baseViewHolder, i, list);
        }
    }

    public int getItemViewTypeWithoutLoading(int i) {
        FeedItem feedItem = (FeedItem) getItem(i);
        if (feedItem instanceof Feed) {
            Type storeFeedType = ((Feed) feedItem).getStoreFeedType();
            if (storeFeedType != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[storeFeedType.ordinal()];
                if (i2 == 1) {
                    return ImageFeedHolder.Companion.getId();
                }
                if (i2 == 2) {
                    return ProductFeedTripleHolder.Companion.getId();
                }
                if (i2 == 3) {
                    return ProductFeedDoubleHolder.Companion.getId();
                }
            }
            return EmptyTypeHolder.Companion.getId();
        } else if (!(feedItem instanceof SpecialDiscountFeed)) {
            return EmptyTypeHolder.Companion.getId();
        } else {
            SpecialDiscountFeed.Type type = ((SpecialDiscountFeed) feedItem).getType();
            if (type != null) {
                int i3 = WhenMappings.$EnumSwitchMapping$1[type.ordinal()];
                if (i3 == 1) {
                    return SpecialDiscountProductHolder.Companion.getId();
                }
                if (i3 == 2) {
                    return SpecialDiscountDoubleFeedHolder.Companion.getId();
                }
            }
            return EmptyTypeHolder.Companion.getId();
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
                if ((feedItem instanceof Feed) && ((Feed) feedItem).updateProductLikeState(wishStateUpdateEvent.getProductId(), wishStateUpdateEvent.isInWishList())) {
                    notifyItemChanged(i, feedItem);
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
