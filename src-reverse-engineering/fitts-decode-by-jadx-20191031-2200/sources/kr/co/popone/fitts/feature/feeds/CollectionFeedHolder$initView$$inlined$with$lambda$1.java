package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class CollectionFeedHolder$initView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item$inlined;
    final /* synthetic */ CollectionFeedHolder this$0;

    CollectionFeedHolder$initView$$inlined$with$lambda$1(CollectionFeedHolder collectionFeedHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = collectionFeedHolder;
        this.$item$inlined = feedVariantInfo;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$item$inlined.getFeed().getImageScheme());
    }
}
