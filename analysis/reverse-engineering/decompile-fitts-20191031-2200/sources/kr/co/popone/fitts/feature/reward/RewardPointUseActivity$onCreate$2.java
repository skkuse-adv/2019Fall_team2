package kr.co.popone.fitts.feature.reward;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;
import kr.co.popone.fitts.feature.search.ShopSearchActivity.Parameters;

final class RewardPointUseActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ RewardPointUseActivity this$0;

    RewardPointUseActivity$onCreate$2(RewardPointUseActivity rewardPointUseActivity) {
        this.this$0 = rewardPointUseActivity;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0, ShopSearchActivity.class);
        Parameters parameters = new Parameters("쇼핑몰홈 링크 주소가 아닌\n상세페이지 링크 주소가 맞는지 확인해주세요", null, null, null, 14, null);
        intent.putExtra("parameters", parameters);
        this.this$0.startActivityForResult(intent, 100);
    }
}
