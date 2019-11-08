package kr.co.popone.fitts.feature.reward;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class RewardUsageDetailActivity$loadRewardUsage$1<T1, T2> implements BiConsumer<PaymentUsage, Throwable> {
    final /* synthetic */ RewardUsageDetailActivity this$0;

    RewardUsageDetailActivity$loadRewardUsage$1(RewardUsageDetailActivity rewardUsageDetailActivity) {
        this.this$0 = rewardUsageDetailActivity;
    }

    public final void accept(PaymentUsage paymentUsage, Throwable th) {
        this.this$0.paymentUsageRequest = null;
        this.this$0.paymentUsage = paymentUsage;
        StringBuilder sb = new StringBuilder();
        sb.append("paymentUsage(");
        sb.append(paymentUsage);
        sb.append(") throwable(");
        sb.append(th);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.updateUI();
    }
}
