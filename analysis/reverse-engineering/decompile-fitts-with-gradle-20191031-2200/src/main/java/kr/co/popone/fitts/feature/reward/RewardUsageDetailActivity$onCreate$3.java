package kr.co.popone.fitts.feature.reward;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.anko.DimensionsKt;

final class RewardUsageDetailActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ RewardUsageDetailActivity this$0;

    RewardUsageDetailActivity$onCreate$3(RewardUsageDetailActivity rewardUsageDetailActivity) {
        this.this$0 = rewardUsageDetailActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.cancelPaymentUsageRequest != null) {
            DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0, "핏츠 포인트 사용신청 취소", "취소 중입니다", null, null, 24, null);
            return;
        }
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this.this$0, "핏츠 포인트 사용신청 취소", "핏츠 포인트 사용신청을 취소하시겠습니까?", new Function0<Unit>(this) {
            final /* synthetic */ RewardUsageDetailActivity$onCreate$3 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                RewardUsageDetailActivity rewardUsageDetailActivity = this.this$0.this$0;
                rewardUsageDetailActivity.cancelPaymentUsageRequest = rewardUsageDetailActivity.getPaymentAPI$app_productionFittsRelease().deletePaymentUsageHistory(this.this$0.this$0.paymentUsageID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(String str, Throwable th) {
                        this.this$0.this$0.this$0.cancelPaymentUsageRequest = null;
                        if (th == null) {
                            this.this$0.this$0.this$0.setResult(100);
                            this.this$0.this$0.this$0.finish();
                            return;
                        }
                        DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0.this$0.this$0, "핏츠 포인트 사용신청 취소", "에러가 발생했습니다.", null, null, 24, null);
                    }
                });
            }
        }, null, null, null, 0, DimensionsKt.HDPI, null);
    }
}
