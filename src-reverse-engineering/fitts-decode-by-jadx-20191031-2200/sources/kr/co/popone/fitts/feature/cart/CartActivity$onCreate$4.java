package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;

final class CartActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$4(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new MainEvent$MainTabChangeEvent(Tab.Store));
        this.this$0.finish();
    }
}
