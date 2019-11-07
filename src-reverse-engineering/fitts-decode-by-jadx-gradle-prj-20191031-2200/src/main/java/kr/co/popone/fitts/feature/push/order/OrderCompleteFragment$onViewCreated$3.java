package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import kr.co.popone.fitts.event.PushRendingEvent$ShowCreatePostDialogEvent;
import kr.co.popone.fitts.event.RxBus;

final class OrderCompleteFragment$onViewCreated$3 implements OnClickListener {
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$onViewCreated$3(OrderCompleteFragment orderCompleteFragment) {
        this.this$0 = orderCompleteFragment;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new PushRendingEvent$ShowCreatePostDialogEvent());
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
