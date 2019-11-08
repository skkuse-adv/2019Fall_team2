package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.feeds.SlidingBannerItemHolder.Delegate;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class SlidingBannerItemHolder$updateSlideBannerUi$1 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item;
    final /* synthetic */ SlidingBannerItemHolder this$0;

    SlidingBannerItemHolder$updateSlideBannerUi$1(SlidingBannerItemHolder slidingBannerItemHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = slidingBannerItemHolder;
        this.$item = feedVariantInfo;
    }

    public final void onClick(View view) {
        Delegate access$getDelegate$p = this.this$0.delegate;
        String bannerScheme = this.$item.getFeed().getBannerScheme();
        if (bannerScheme == null) {
            bannerScheme = "";
        }
        access$getDelegate$p.onSlidingBannerClick(bannerScheme);
    }
}
