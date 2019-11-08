package kr.co.popone.fitts.feature.coupon;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity.Parameters;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;

final class CouponUseConfirmActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ CouponUseConfirmActivity this$0;

    CouponUseConfirmActivity$onCreate$2(CouponUseConfirmActivity couponUseConfirmActivity, Parameters parameters) {
        this.this$0 = couponUseConfirmActivity;
        this.$parameters = parameters;
    }

    public final void onClick(View view) {
        ShopWebViewActivity.Parameters parameters = new ShopWebViewActivity.Parameters(this.$parameters.getProductUrl(), "", false, null, null, null, null, 124, null);
        Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
        intent.putExtra("parameters", parameters);
        this.this$0.startActivity(intent);
    }
}
