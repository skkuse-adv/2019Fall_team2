package kr.co.popone.fitts.feature.category;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;

public final class CategorySearchFragment$initializeRecyclerView$$inlined$apply$lambda$1 extends SpanSizeLookup {
    final /* synthetic */ CategorySearchFragment this$0;

    CategorySearchFragment$initializeRecyclerView$$inlined$apply$lambda$1(CategorySearchFragment categorySearchFragment) {
        this.this$0 = categorySearchFragment;
    }

    public int getSpanSize(int i) {
        return this.this$0.getSpanSizeByViewType(i);
    }
}
