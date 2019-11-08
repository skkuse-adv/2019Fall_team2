package kr.co.popone.fitts.repository;

import io.reactivex.functions.BiFunction;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscountInfo;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;
import kr.co.popone.fitts.repository.StoreRepository.WhenMappings;

public final class StoreRepository$getStoreNewFeeds$$inlined$zip$1<T1, T2, R> implements BiFunction<SpecialDiscountInfo, FeedInfo, R> {
    public final R apply(SpecialDiscountInfo specialDiscountInfo, FeedInfo feedInfo) {
        FeedInfo feedInfo2 = feedInfo;
        SpecialDiscountInfo specialDiscountInfo2 = specialDiscountInfo;
        int i = WhenMappings.$EnumSwitchMapping$0[specialDiscountInfo2.getState().ordinal()];
        if (i == 1) {
            return new Triple(feedInfo2.getVersion(), specialDiscountInfo2, CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(specialDiscountInfo2.toFeedItem(), feedInfo2.getItems())));
        } else if (i == 2) {
            return new Triple(feedInfo2.getVersion(), null, feedInfo2.getItems());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
