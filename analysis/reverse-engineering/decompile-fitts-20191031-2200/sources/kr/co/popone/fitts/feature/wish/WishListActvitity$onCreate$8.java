package kr.co.popone.fitts.feature.wish;

import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.wish.WishListActvitity.WhenMappings;

final class WishListActvitity$onCreate$8<T> implements Observer<NetworkState> {
    final /* synthetic */ WishListAdapter $wishListAdapter;
    final /* synthetic */ WishListActvitity this$0;

    WishListActvitity$onCreate$8(WishListActvitity wishListActvitity, WishListAdapter wishListAdapter) {
        this.this$0 = wishListActvitity;
        this.$wishListAdapter = wishListAdapter;
    }

    public final void onChanged(NetworkState networkState) {
        Status status;
        if (networkState != null) {
            status = networkState.getStatus();
        } else {
            status = null;
        }
        if (status != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
            String str = "refreshLayout";
            if (i == 1) {
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, str);
                swipeRefreshLayout.setRefreshing(true);
                return;
            } else if (i == 2) {
                SwipeRefreshLayout swipeRefreshLayout2 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout2, str);
                swipeRefreshLayout2.setRefreshing(false);
                return;
            } else if (i == 3) {
                SwipeRefreshLayout swipeRefreshLayout3 = (SwipeRefreshLayout) this.this$0._$_findCachedViewById(C0010R$id.refreshLayout);
                Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout3, str);
                swipeRefreshLayout3.setRefreshing(false);
                ActivityExtensionKt.handleError(this.this$0, networkState.getMsg());
                return;
            }
        }
        this.$wishListAdapter.updateNetworkState(networkState);
    }
}
