package kr.co.popone.fitts.feature.trend;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.CollectionFeedHolder;
import kr.co.popone.fitts.feature.feeds.FittieFeedHolder;
import kr.co.popone.fitts.feature.feeds.ImageFeedHolder;
import kr.co.popone.fitts.feature.feeds.ImageTagHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedBigLeftHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedBigRightHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedTripleHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedBigLeftHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedBigRightHolder;
import kr.co.popone.fitts.feature.feeds.ProductTripleHolder;
import kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder;
import kr.co.popone.fitts.feature.feeds.TagFeedHolder;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed.Type;
import org.jetbrains.annotations.NotNull;

public final class TrendFeedAdapter extends Adapter<BaseViewHolder> {
    private List<Feed> _items = new ArrayList();
    @NotNull
    private final Delegate delegate;

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ImageFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedBigLeftHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedBigRightHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedBigRightHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedBigLeftHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.CollectionFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.TagFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.FittieFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ImageTagHolder.Delegate {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.POST.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.POST_BIG_LEFT.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.POST_BIG_RIGHT.ordinal()] = 3;
            $EnumSwitchMapping$0[Type.PRODUCT.ordinal()] = 4;
            $EnumSwitchMapping$0[Type.PRODUCT_BIG_LEFT.ordinal()] = 5;
            $EnumSwitchMapping$0[Type.PRODUCT_BIG_RIGHT.ordinal()] = 6;
            $EnumSwitchMapping$0[Type.IMAGE.ordinal()] = 7;
            $EnumSwitchMapping$0[Type.COLLECTION.ordinal()] = 8;
            $EnumSwitchMapping$0[Type.TAGS.ordinal()] = 9;
            $EnumSwitchMapping$0[Type.BANNER_HOME.ordinal()] = 10;
            $EnumSwitchMapping$0[Type.FITTIE.ordinal()] = 11;
            $EnumSwitchMapping$0[Type.IMAGE_TAG.ordinal()] = 12;
        }
    }

    @NotNull
    public final Delegate getDelegate() {
        return this.delegate;
    }

    public TrendFeedAdapter(@NotNull Delegate delegate2) {
        Intrinsics.checkParameterIsNotNull(delegate2, "delegate");
        this.delegate = delegate2;
    }

    public final void submitList(@NotNull List<Feed> list) {
        Intrinsics.checkParameterIsNotNull(list, "items");
        this._items = list;
        notifyDataSetChanged();
    }

    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == PostFeedTripleHolder.Companion.getId()) {
            return PostFeedTripleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == PostFeedBigLeftHolder.Companion.getId()) {
            return PostFeedBigLeftHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == PostFeedBigRightHolder.Companion.getId()) {
            return PostFeedBigRightHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductTripleHolder.Companion.getId()) {
            return ProductTripleHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedBigLeftHolder.Companion.getId()) {
            return ProductFeedBigLeftHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ProductFeedBigRightHolder.Companion.getId()) {
            return ProductFeedBigRightHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ImageFeedHolder.Companion.getId()) {
            return ImageFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == CollectionFeedHolder.Companion.getId()) {
            return CollectionFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == TagFeedHolder.Companion.getId()) {
            return TagFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == SlidingBannerFeedHolder.Companion.getId()) {
            return SlidingBannerFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == FittieFeedHolder.Companion.getId()) {
            return FittieFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        if (i == ImageTagHolder.Companion.getId()) {
            return ImageTagHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        BaseViewHolder.bind$default(baseViewHolder, this._items.get(i), null, 2, null);
    }

    public int getItemCount() {
        return this._items.size();
    }

    public int getItemViewType(int i) {
        Type trendFeedType = ((Feed) this._items.get(i)).getTrendFeedType();
        if (trendFeedType != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[trendFeedType.ordinal()]) {
                case 1:
                    return PostFeedTripleHolder.Companion.getId();
                case 2:
                    return PostFeedBigLeftHolder.Companion.getId();
                case 3:
                    return PostFeedBigRightHolder.Companion.getId();
                case 4:
                    return ProductTripleHolder.Companion.getId();
                case 5:
                    return ProductFeedBigLeftHolder.Companion.getId();
                case 6:
                    return ProductFeedBigRightHolder.Companion.getId();
                case 7:
                    return ImageFeedHolder.Companion.getId();
                case 8:
                    return CollectionFeedHolder.Companion.getId();
                case 9:
                    return TagFeedHolder.Companion.getId();
                case 10:
                    return SlidingBannerFeedHolder.Companion.getId();
                case 11:
                    return FittieFeedHolder.Companion.getId();
                case 12:
                    return ImageTagHolder.Companion.getId();
            }
        }
        return EmptyTypeHolder.Companion.getId();
    }

    public void onViewRecycled(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        baseViewHolder.recycle();
        super.onViewRecycled(baseViewHolder);
    }
}
