package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class ExchangeCompleteActivity$onCreate$4<T> implements Observer<Throwable> {
    final /* synthetic */ ExchangeCompleteActivity this$0;

    ExchangeCompleteActivity$onCreate$4(ExchangeCompleteActivity exchangeCompleteActivity) {
        this.this$0 = exchangeCompleteActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
