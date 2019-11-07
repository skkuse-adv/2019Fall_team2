package kr.co.popone.fitts.feature.order.orderlist;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.MainEvent$MainTabChangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.main.MainTabBar.Tab;

final class OrderListActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ OrderListActivity this$0;

    OrderListActivity$onCreate$4(OrderListActivity orderListActivity) {
        this.this$0 = orderListActivity;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new MainEvent$MainTabChangeEvent(Tab.Store));
        this.this$0.finish();
    }
}
