package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class WithdrawalActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ WithdrawalActivity this$0;

    WithdrawalActivity$onCreate$1(WithdrawalActivity withdrawalActivity) {
        this.this$0 = withdrawalActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
