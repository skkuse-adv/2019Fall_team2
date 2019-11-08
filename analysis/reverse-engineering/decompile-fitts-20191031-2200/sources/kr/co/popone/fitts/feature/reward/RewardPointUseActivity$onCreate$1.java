package kr.co.popone.fitts.feature.reward;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class RewardPointUseActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$1(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
