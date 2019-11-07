package kr.co.popone.fitts.feature.common.fittie;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.view.FittieFollowViewData;

final class FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ FittieFollowViewData $this_run;
    final /* synthetic */ FittieHorizontalFeedViewHolder this$0;

    FittieHorizontalFeedViewHolder$bindTo$$inlined$with$lambda$1(FittieFollowViewData fittieFollowViewData, View view, FittieHorizontalFeedViewHolder fittieHorizontalFeedViewHolder, FittieFollowViewData fittieFollowViewData2, boolean z) {
        this.$this_run = fittieFollowViewData;
        this.this$0 = fittieHorizontalFeedViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onFollowClick(this.$this_run.getId(), this.$this_run.isFollowing());
    }
}
