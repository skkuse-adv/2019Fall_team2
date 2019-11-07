package kr.co.popone.fitts.feature.category;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.category.CategorySearchFragment.WhenMappings;

final class CategorySearchFragment$getProductFeeds$5<T> implements Observer<NetworkState> {
    final /* synthetic */ CategorySearchFragment this$0;

    CategorySearchFragment$getProductFeeds$5(CategorySearchFragment categorySearchFragment) {
        this.this$0 = categorySearchFragment;
    }

    public final void onChanged(NetworkState networkState) {
        Status status;
        if (networkState != null) {
            status = networkState.getStatus();
        } else {
            status = null;
        }
        if (status != null) {
            int i = WhenMappings.$EnumSwitchMapping$1[status.ordinal()];
            String str = "categorySearchRefresh";
            if (i == 1) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.categorySearchRefresh);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
                swipeRefreshLayout.setRefreshing(true);
                return;
            } else if (i == 2) {
                SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.categorySearchRefresh);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
                swipeRefreshLayout2.setRefreshing(false);
                return;
            } else if (i == 3) {
                SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.categorySearchRefresh);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
                swipeRefreshLayout3.setRefreshing(false);
                FragmentExtensionKt.handleError(this.this$0, networkState.getMsg());
                return;
            }
        }
        this.this$0.productFeedAdapter.updateNetworkState(networkState);
    }
}
