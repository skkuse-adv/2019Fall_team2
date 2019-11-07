package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class ImageTagHolder$initTitleView$$inlined$let$lambda$1 implements OnClickListener {
    final /* synthetic */ Feed $feed$inlined;
    final /* synthetic */ ImageTagHolder this$0;

    ImageTagHolder$initTitleView$$inlined$let$lambda$1(View view, ImageTagHolder imageTagHolder, Feed feed) {
        this.this$0 = imageTagHolder;
        this.$feed$inlined = feed;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onSchemeClick(this.this$0, this.$feed$inlined.getScheme());
    }
}
