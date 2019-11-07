package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kotlin.Unit;

final class ExchangeApplyActivity$onCreate$31<T> implements Observer<Unit> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$31(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(Unit unit) {
        this.this$0.showConfirmDialog();
    }
}
