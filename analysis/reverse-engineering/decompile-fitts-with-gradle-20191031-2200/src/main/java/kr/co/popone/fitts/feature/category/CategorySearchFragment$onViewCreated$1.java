package kr.co.popone.fitts.feature.category;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.common.product.ProductFeedAdapter;

final class CategorySearchFragment$onViewCreated$1 implements OnRefreshListener {
    final /* synthetic */ CategorySearchFragment this$0;

    CategorySearchFragment$onViewCreated$1(CategorySearchFragment categorySearchFragment) {
        this.this$0 = categorySearchFragment;
    }

    public final void onRefresh() {
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.recyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
        Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof ProductFeedAdapter) {
            this.this$0.getProductFeeds();
        } else if (adapter instanceof CategoryPostAdapter) {
            this.this$0.getPostFeeds();
        }
    }
}
