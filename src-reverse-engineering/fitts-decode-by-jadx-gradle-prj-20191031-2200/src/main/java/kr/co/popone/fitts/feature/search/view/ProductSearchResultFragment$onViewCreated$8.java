package kr.co.popone.fitts.feature.search.view;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.search.adapter.ProductSearchResultAdapter;
import kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment.WhenMappings;

final class ProductSearchResultFragment$onViewCreated$8<T> implements Observer<NetworkState> {
    final /* synthetic */ ProductSearchResultAdapter $productResultAdapter;
    final /* synthetic */ ProductSearchResultFragment this$0;

    ProductSearchResultFragment$onViewCreated$8(ProductSearchResultFragment productSearchResultFragment, ProductSearchResultAdapter productSearchResultAdapter) {
        this.this$0 = productSearchResultFragment;
        this.$productResultAdapter = productSearchResultAdapter;
    }

    public final void onChanged(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        String str = "refreshLayout";
        if (i == 1) {
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
            swipeRefreshLayout.setRefreshing(true);
        } else if (i == 2) {
            SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
            swipeRefreshLayout2.setRefreshing(false);
        } else if (i != 3) {
            this.$productResultAdapter.updateNetworkState(networkState);
        } else {
            SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
            Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
            swipeRefreshLayout3.setRefreshing(false);
            this.$productResultAdapter.updateNetworkState(networkState);
            FragmentExtensionKt.handleError(this.this$0, networkState.getMsg());
        }
    }
}
