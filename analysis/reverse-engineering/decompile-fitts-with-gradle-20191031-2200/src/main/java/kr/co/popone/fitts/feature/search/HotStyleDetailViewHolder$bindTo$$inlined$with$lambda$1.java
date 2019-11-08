package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.search.StyleRecommendViewData;

final class HotStyleDetailViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ StyleRecommendViewData $item$inlined;
    final /* synthetic */ HotStyleDetailViewHolder this$0;

    HotStyleDetailViewHolder$bindTo$$inlined$with$lambda$1(HotStyleDetailViewHolder hotStyleDetailViewHolder, StyleRecommendViewData styleRecommendViewData) {
        this.this$0 = hotStyleDetailViewHolder;
        this.$item$inlined = styleRecommendViewData;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onStyleClicked(this.$item$inlined.getStyleKeyword());
    }
}
