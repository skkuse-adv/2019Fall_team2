package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class ExchangeApplyActivity$onCreate$33<T> implements Observer<Throwable> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$33(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleErrorCodeMessage(this.this$0, th);
    }
}
