package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class ImageTagHolder$initView$1 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item;
    final /* synthetic */ ImageTagHolder this$0;

    ImageTagHolder$initView$1(ImageTagHolder imageTagHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = imageTagHolder;
        this.$item = feedVariantInfo;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onImageTagClick(this.$item.getFeed().getId());
    }
}
