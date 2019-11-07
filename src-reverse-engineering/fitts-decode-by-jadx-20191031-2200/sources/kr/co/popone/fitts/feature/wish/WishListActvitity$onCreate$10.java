package kr.co.popone.fitts.feature.wish;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class WishListActvitity$onCreate$10<T> implements Observer<Boolean> {
    final /* synthetic */ WishListActvitity this$0;

    WishListActvitity$onCreate$10(WishListActvitity wishListActvitity) {
        this.this$0 = wishListActvitity;
    }

    public final void onChanged(Boolean bool) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.emptyLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "emptyLayout");
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        int i = 0;
        constraintLayout.setVisibility(bool.booleanValue() ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C0010R$id.wishListRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "wishListRecyclerView");
        if (bool.booleanValue()) {
            i = 8;
        }
        recyclerView.setVisibility(i);
    }
}
