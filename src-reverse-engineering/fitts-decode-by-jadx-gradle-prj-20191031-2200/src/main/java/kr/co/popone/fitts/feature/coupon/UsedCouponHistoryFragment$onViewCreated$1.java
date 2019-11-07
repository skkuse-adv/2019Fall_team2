package kr.co.popone.fitts.feature.coupon;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.ActivityOptionsCompat;
import com.orhanobut.logger.Logger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.coupon.CouponUsageDetailActivity.Parameters;
import kr.co.popone.fitts.feature.coupon.UsedCouponHistoryAdapter.Delegate;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import org.jetbrains.annotations.NotNull;

public final class UsedCouponHistoryFragment$onViewCreated$1 implements Delegate {
    final /* synthetic */ UsedCouponHistoryFragment this$0;

    UsedCouponHistoryFragment$onViewCreated$1(UsedCouponHistoryFragment usedCouponHistoryFragment) {
        this.this$0 = usedCouponHistoryFragment;
    }

    @NotNull
    public List<PaymentUsage> getItems() {
        return this.this$0.usedPaymentHistoryList;
    }

    public void onItemClicked(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("couponUsageHistoryList clicked at position ");
        sb.append(i);
        Logger.d(sb.toString(), new Object[0]);
        PaymentUsage paymentUsage = (PaymentUsage) this.this$0.usedPaymentHistoryList.get(i);
        Intent intent = new Intent(this.this$0.getActivity(), CouponUsageDetailActivity.class);
        intent.putExtra("parameters", new Parameters(paymentUsage.getId()));
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivityForResult(intent, 100, makeCustomAnimation.toBundle());
    }
}
