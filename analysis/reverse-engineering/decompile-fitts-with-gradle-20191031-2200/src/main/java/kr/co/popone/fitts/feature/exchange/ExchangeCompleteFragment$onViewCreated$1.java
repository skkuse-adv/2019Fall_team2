package kr.co.popone.fitts.feature.exchange;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class ExchangeCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ ExchangeCompleteFragment this$0;

    ExchangeCompleteFragment$onViewCreated$1(ExchangeCompleteFragment exchangeCompleteFragment) {
        this.this$0 = exchangeCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
