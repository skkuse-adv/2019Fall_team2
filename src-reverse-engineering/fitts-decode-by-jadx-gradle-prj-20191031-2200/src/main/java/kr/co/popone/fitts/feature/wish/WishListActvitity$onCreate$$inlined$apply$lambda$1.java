package kr.co.popone.fitts.feature.wish;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;

public final class WishListActvitity$onCreate$$inlined$apply$lambda$1 extends SpanSizeLookup {
    final /* synthetic */ WishListActvitity this$0;

    WishListActvitity$onCreate$$inlined$apply$lambda$1(RecyclerView recyclerView, WishListActvitity wishListActvitity, WishListAdapter wishListAdapter) {
        this.this$0 = wishListActvitity;
    }

    public int getSpanSize(int i) {
        return this.this$0.getGridSpanSize(i);
    }
}
