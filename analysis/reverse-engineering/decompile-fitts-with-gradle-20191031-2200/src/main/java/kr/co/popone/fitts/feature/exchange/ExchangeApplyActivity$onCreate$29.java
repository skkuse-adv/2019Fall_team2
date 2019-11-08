package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState;

final class ExchangeApplyActivity$onCreate$29<T> implements Observer<List<? extends ExchangeInvalidViewState>> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$29(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(List<? extends ExchangeInvalidViewState> list) {
        ExchangeApplyActivity exchangeApplyActivity = this.this$0;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        exchangeApplyActivity.updateInvalidateView(list);
    }
}
