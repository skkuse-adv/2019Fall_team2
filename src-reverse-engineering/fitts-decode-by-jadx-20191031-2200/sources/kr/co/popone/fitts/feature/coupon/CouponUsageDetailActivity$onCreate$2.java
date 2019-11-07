package kr.co.popone.fitts.feature.coupon;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class CouponUsageDetailActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ CouponUsageDetailActivity this$0;

    CouponUsageDetailActivity$onCreate$2(CouponUsageDetailActivity couponUsageDetailActivity) {
        this.this$0 = couponUsageDetailActivity;
    }

    public final void onClick(View view) {
        PaymentUsage access$getPaymentUsage$p = this.this$0.paymentUsage;
        if (access$getPaymentUsage$p == null) {
            Intrinsics.throwNpe();
        }
        Parameters parameters = new Parameters(access$getPaymentUsage$p.getLinkUrl(), "", false, null, null, null, null, 124, null);
        Intent intent = new Intent(this.this$0, ShopWebViewActivity.class);
        intent.putExtra("parameters", parameters);
        this.this$0.startActivity(intent);
    }
}
