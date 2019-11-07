package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$onViewCreated$1(OrderCompleteFragment orderCompleteFragment) {
        this.this$0 = orderCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
