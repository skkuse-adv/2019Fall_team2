package kr.co.popone.fitts.feature.exchange;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class ExchangeApplyCompleteFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ ExchangeApplyCompleteFragment this$0;

    ExchangeApplyCompleteFragment$onViewCreated$2(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        this.this$0 = exchangeApplyCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
