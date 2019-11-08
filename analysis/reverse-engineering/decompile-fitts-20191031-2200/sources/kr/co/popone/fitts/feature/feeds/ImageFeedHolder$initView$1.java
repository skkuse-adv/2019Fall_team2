package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariant;

final class ImageFeedHolder$initView$1 implements OnClickListener {
    final /* synthetic */ FeedVariant $item;
    final /* synthetic */ ImageFeedHolder this$0;

    ImageFeedHolder$initView$1(ImageFeedHolder imageFeedHolder, FeedVariant feedVariant) {
        this.this$0 = imageFeedHolder;
        this.$item = feedVariant;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$item.getImageScheme());
    }
}
