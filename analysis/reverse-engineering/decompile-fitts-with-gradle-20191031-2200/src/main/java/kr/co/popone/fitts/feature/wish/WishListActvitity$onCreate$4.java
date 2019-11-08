package kr.co.popone.fitts.feature.wish;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class WishListActvitity$onCreate$4 implements OnRefreshListener {
    final /* synthetic */ WishListActvitity this$0;

    WishListActvitity$onCreate$4(WishListActvitity wishListActvitity) {
        this.this$0 = wishListActvitity;
    }

    public final void onRefresh() {
        this.this$0.getViewModel().refresh();
    }
}
