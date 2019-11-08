package kr.co.popone.fitts.feature.home.feed;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.base.EmptyTypeHolder;
import kr.co.popone.fitts.feature.feeds.BasePagedListAdapter;
import kr.co.popone.fitts.feature.feeds.BaseViewHolder;
import kr.co.popone.fitts.feature.feeds.CollectionFeedHolder;
import kr.co.popone.fitts.feature.feeds.FittieFeedHolder;
import kr.co.popone.fitts.feature.feeds.ImageFeedHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedBigLeftHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedBigRightHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedDoubleHolder;
import kr.co.popone.fitts.feature.feeds.PostFeedTripleHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedBigLeftHolder;
import kr.co.popone.fitts.feature.feeds.ProductFeedBigRightHolder;
import kr.co.popone.fitts.feature.feeds.ProductTripleHolder;
import kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder;
import kr.co.popone.fitts.feature.feeds.TagFeedHolder;
import kr.co.popone.fitts.feature.feeds.TitleOnlyFeedHolder;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed.Type;
import org.jetbrains.annotations.NotNull;

public final class HomeFeedAdapter extends BasePagedListAdapter<Feed, BaseViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public static final ItemCallback<Feed> COMPARATOR = new HomeFeedAdapter$Companion$COMPARATOR$1();
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
            return HomeFeedAdapter.COMPARATOR;
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.feeds.SlidingBannerFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.ImageFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedDoubleHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedBigLeftHolder.Delegate, kr.co.popone.fitts.feature.feeds.PostFeedBigRightHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedBigRightHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductFeedBigLeftHolder.Delegate, kr.co.popone.fitts.feature.feeds.ProductTripleHolder.Delegate, kr.co.popone.fitts.feature.feeds.CollectionFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.TagFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.FittieFeedHolder.Delegate, kr.co.popone.fitts.feature.feeds.TitleOnlyFeedHolder.Delegate {
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Type.values().length];

        static {
            $EnumSwitchMapping$0[Type.POST.ordinal()] = 1;
            $EnumSwitchMapping$0[Type.POST_TRIPLE.ordinal()] = 2;
            $EnumSwitchMapping$0[Type.POST_BIG_LEFT.ordinal()] = 3;
            $EnumSwitchMapping$0[Type.POST_BIG_RIGHT.ordinal()] = 4;
            $EnumSwitchMapping$0[Type.PRODUCT.ordinal()] = 5;
            $EnumSwitchMapping$0[Type.PRODUCT_BIG_LEFT.ordinal()] = 6;
            $EnumSwitchMapping$0[Type.PRODUCT_BIG_RIGHT.ordinal()] = 7;
            $EnumSwitchMapping$0[Type.IMAGE.ordinal()] = 8;
            $EnumSwitchMapping$0[Type.COLLECTION.ordinal()] = 9;
            $EnumSwitchMapping$0[Type.TAGS.ordinal()] = 10;
            $EnumSwitchMapping$0[Type.BANNER_HOME.ordinal()] = 11;
            $EnumSwitchMapping$0[Type.FITTIE.ordinal()] = 12;
            $EnumSwitchMapping$0[Type.ONLY_TITLE.ordinal()] = 13;
        }
    }

    public HomeFeedAdapter(@NotNull Delegate delegate2) {
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
        if (i == PostFeedDoubleHolder.Companion.getId()) {
            return PostFeedDoubleHolder.Companion.create(viewGroup, this.delegate);
        }
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
        if (i == TitleOnlyFeedHolder.Companion.getId()) {
            return TitleOnlyFeedHolder.Companion.create(viewGroup, this.delegate);
        }
        return EmptyTypeHolder.Companion.create(viewGroup);
    }

    public void onBindViewHolderWithoutLoading(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(baseViewHolder, "holder");
        BaseViewHolder.bind$default(baseViewHolder, getItem(i), null, 2, null);
    }

    public int getItemViewTypeWithoutLoading(int i) {
        Feed feed = (Feed) getItem(i);
        Type homeFeedType = feed != null ? feed.getHomeFeedType() : null;
        if (homeFeedType != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[homeFeedType.ordinal()]) {
                case 1:
                    return PostFeedDoubleHolder.Companion.getId();
                case 2:
                    return PostFeedTripleHolder.Companion.getId();
                case 3:
                    return PostFeedBigLeftHolder.Companion.getId();
                case 4:
                    return PostFeedBigRightHolder.Companion.getId();
                case 5:
                    return ProductTripleHolder.Companion.getId();
                case 6:
                    return ProductFeedBigLeftHolder.Companion.getId();
                case 7:
                    return ProductFeedBigRightHolder.Companion.getId();
                case 8:
                    return ImageFeedHolder.Companion.getId();
                case 9:
                    return CollectionFeedHolder.Companion.getId();
                case 10:
                    return TagFeedHolder.Companion.getId();
                case 11:
                    return SlidingBannerFeedHolder.Companion.getId();
                case 12:
                    return FittieFeedHolder.Companion.getId();
                case 13:
                    return TitleOnlyFeedHolder.Companion.getId();
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
