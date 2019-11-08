package kr.co.popone.fitts.feature.common.fittie;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.social.feed.RecommendFittieInfo.RecommendFittie;

final class FittieRecommendViewHolder$initView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ RecommendFittie $this_run$inlined;
    final /* synthetic */ FittieRecommendViewHolder this$0;

    FittieRecommendViewHolder$initView$$inlined$with$lambda$1(RecommendFittie recommendFittie, View view, FittieRecommendViewHolder fittieRecommendViewHolder, RecommendFittie recommendFittie2) {
        this.$this_run$inlined = recommendFittie;
        this.this$0 = fittieRecommendViewHolder;
    }

    public final void onClick(View view) {
        if (this.$this_run$inlined.getUser().isFollowing()) {
            this.this$0.getDelegate().onUnFollowButtonClicked(this.$this_run$inlined.getUser().getId());
        } else {
            this.this$0.getDelegate().onFollowButtonClicked(this.$this_run$inlined.getUser().getId());
        }
    }
}
