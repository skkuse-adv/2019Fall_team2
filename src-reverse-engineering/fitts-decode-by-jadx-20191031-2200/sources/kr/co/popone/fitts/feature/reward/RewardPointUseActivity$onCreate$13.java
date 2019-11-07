package kr.co.popone.fitts.feature.reward;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;

final class RewardPointUseActivity$onCreate$13 implements OnClickListener {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$13(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void onClick(View view) {
        RewardPointUseActivity rewardPointUseActivity = this.this$0;
        rewardPointUseActivity.startActivityForResult(new Intent(rewardPointUseActivity, AddressWebViewActivity.class), Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    }
}
