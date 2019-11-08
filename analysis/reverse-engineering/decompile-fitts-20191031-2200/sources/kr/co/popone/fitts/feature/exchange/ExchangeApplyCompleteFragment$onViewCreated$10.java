package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class ExchangeApplyCompleteFragment$onViewCreated$10<T> implements Observer<Throwable> {
    final /* synthetic */ ExchangeApplyCompleteFragment this$0;

    ExchangeApplyCompleteFragment$onViewCreated$10(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        this.this$0 = exchangeApplyCompleteFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
