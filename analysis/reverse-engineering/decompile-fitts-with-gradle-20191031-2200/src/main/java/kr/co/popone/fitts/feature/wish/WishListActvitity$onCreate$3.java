package kr.co.popone.fitts.feature.wish;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class WishListActvitity$onCreate$3 implements OnClickListener {
    final /* synthetic */ WishListActvitity this$0;

    WishListActvitity$onCreate$3(WishListActvitity wishListActvitity) {
        this.this$0 = wishListActvitity;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new MainEvent$MainTabChangeEvent(Tab.Store));
        ActivityExtensionKt.finishWithAnimation(this.this$0, ActivityAnimationType.SLIDE_LTOR);
    }
}
