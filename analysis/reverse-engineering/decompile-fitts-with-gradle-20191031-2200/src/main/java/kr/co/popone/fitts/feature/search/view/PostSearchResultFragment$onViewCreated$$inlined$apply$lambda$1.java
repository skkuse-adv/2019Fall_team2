package kr.co.popone.fitts.feature.search.view;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import kr.co.popone.fitts.feature.search.adapter.PostResultAdapter;

public final class PostSearchResultFragment$onViewCreated$$inlined$apply$lambda$1 extends SpanSizeLookup {
    final /* synthetic */ PostResultAdapter $postResultAdapter$inlined;

    PostSearchResultFragment$onViewCreated$$inlined$apply$lambda$1(PostResultAdapter postResultAdapter) {
        this.$postResultAdapter$inlined = postResultAdapter;
    }

    public int getSpanSize(int i) {
        return this.$postResultAdapter$inlined.getSpanSize(i);
    }
}
