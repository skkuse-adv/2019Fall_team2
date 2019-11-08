package kr.co.popone.fitts.feature.reward;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class RewardPointUseConfirmActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ RewardPointUseConfirmActivity this$0;

    RewardPointUseConfirmActivity$onCreate$1(RewardPointUseConfirmActivity rewardPointUseConfirmActivity) {
        this.this$0 = rewardPointUseConfirmActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
