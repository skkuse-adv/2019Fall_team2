package kr.co.popone.fitts.feature.exchange;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel;

final class ExchangeApplyActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$3(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onClick(View view) {
        ExchangeViewModel viewModel = this.this$0.getViewModel();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        viewModel.canMinusCount(Integer.parseInt(textView.getText().toString()));
    }
}
