package kr.co.popone.fitts.feature.exchange;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class ExchangeApplyCompleteFragment$onViewCreated$6<T> implements Observer<Unit> {
    final /* synthetic */ ExchangeApplyCompleteFragment this$0;

    ExchangeApplyCompleteFragment$onViewCreated$6(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        this.this$0 = exchangeApplyCompleteFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
