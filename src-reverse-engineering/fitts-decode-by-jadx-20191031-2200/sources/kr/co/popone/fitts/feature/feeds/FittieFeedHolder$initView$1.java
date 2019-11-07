package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.user.User;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedVariantInfo;

final class FittieFeedHolder$initView$1 implements OnClickListener {
    final /* synthetic */ FeedVariantInfo $item;
    final /* synthetic */ FittieFeedHolder this$0;

    FittieFeedHolder$initView$1(FittieFeedHolder fittieFeedHolder, FeedVariantInfo feedVariantInfo) {
        this.this$0 = fittieFeedHolder;
        this.$item = feedVariantInfo;
    }

    public final void onClick(View view) {
        User user = this.$item.getFeed().getUser();
        if (user != null) {
            this.this$0.delegate.onFittieClick(user.getId());
        }
    }
}
