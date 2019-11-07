package kr.co.popone.fitts.feature.reward;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity.Parameters;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;

final class RewardPointUseConfirmActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ RewardPointUseConfirmActivity this$0;

    RewardPointUseConfirmActivity$onCreate$2(RewardPointUseConfirmActivity rewardPointUseConfirmActivity, Parameters parameters) {
        this.this$0 = rewardPointUseConfirmActivity;
        this.$parameters = parameters;
    }

    public final void onClick(View view) {
        ShopWebViewActivity.Parameters parameters = new ShopWebViewActivity.Parameters(this.$parameters.getProductUrl(), "", false, null, null, null, null, 124, null);
        Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
        intent.putExtra("parameters", parameters);
        this.this$0.startActivity(intent);
    }
}
