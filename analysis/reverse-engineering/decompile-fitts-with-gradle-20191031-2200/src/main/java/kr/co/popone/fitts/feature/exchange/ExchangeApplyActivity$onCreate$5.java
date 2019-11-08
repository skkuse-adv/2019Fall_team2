package kr.co.popone.fitts.feature.exchange;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class ExchangeApplyActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$5(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onClick(View view) {
        ActivityExtensionKt.finishWithAnimation(this.this$0, ActivityAnimationType.SLIDE_LTOR);
    }
}
