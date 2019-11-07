package kr.co.popone.fitts.feature.wish;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class WishListActvitity$onCreate$2 implements OnClickListener {
    final /* synthetic */ WishListActvitity this$0;

    WishListActvitity$onCreate$2(WishListActvitity wishListActvitity) {
        this.this$0 = wishListActvitity;
    }

    public final void onClick(View view) {
        ActivityExtensionKt.finishWithAnimation(this.this$0, ActivityAnimationType.SLIDE_LTOR);
    }
}
