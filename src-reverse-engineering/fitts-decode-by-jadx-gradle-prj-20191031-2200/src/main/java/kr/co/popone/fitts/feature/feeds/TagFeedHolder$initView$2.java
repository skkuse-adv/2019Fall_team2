package kr.co.popone.fitts.feature.feeds;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.tag.TagGroup.OnTagClickListener;
import kr.co.popone.fitts.feature.tag.TagGroup.TagView;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class TagFeedHolder$initView$2 implements OnTagClickListener {
    final /* synthetic */ Feed $item;
    final /* synthetic */ TagFeedHolder this$0;

    TagFeedHolder$initView$2(TagFeedHolder tagFeedHolder, Feed feed) {
        this.this$0 = tagFeedHolder;
        this.$item = feed;
    }

    public final void onTagClick(String str, TagView tagView) {
        List feeds = this.$item.getFeeds();
        ArrayList<FeedVariantInfo> arrayList = new ArrayList<>();
        for (Object next : feeds) {
            if (Intrinsics.areEqual((Object) ((FeedVariantInfo) next).getFeed().getTitle(), (Object) str)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (FeedVariantInfo feed : arrayList) {
            arrayList2.add(feed.getFeed().getTagScheme());
        }
        this.this$0.delegate.onSchemeClick(this.this$0, (String) CollectionsKt___CollectionsKt.first((List<? extends T>) arrayList2));
    }
}
