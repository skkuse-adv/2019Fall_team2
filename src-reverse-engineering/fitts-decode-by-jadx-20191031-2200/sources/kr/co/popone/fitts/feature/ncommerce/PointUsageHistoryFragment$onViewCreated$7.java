package kr.co.popone.fitts.feature.ncommerce;

import android.content.Intent;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;
import kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity;
import kr.co.popone.fitts.feature.reward.RewardUsageDetailActivity.Parameters;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class PointUsageHistoryFragment$onViewCreated$7<T> implements Observer<PaymentUsage> {
    final /* synthetic */ PointUsageHistoryFragment this$0;

    PointUsageHistoryFragment$onViewCreated$7(PointUsageHistoryFragment pointUsageHistoryFragment) {
        this.this$0 = pointUsageHistoryFragment;
    }

    public final void onChanged(PaymentUsage paymentUsage) {
        PointUsageHistoryFragment pointUsageHistoryFragment = this.this$0;
        Intent intent = new Intent(pointUsageHistoryFragment.getActivity(), RewardUsageDetailActivity.class);
        if (paymentUsage == null) {
            Intrinsics.throwNpe();
        }
        intent.putExtra("parameters", new Parameters(paymentUsage.getId()));
        FragmentExtensionKt.activityStart(pointUsageHistoryFragment, intent, ActivityAnimationType.SLIDE_RTOL);
    }
}
