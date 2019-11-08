package kr.co.popone.fitts.feature.reward;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.reward.RewardPointUseConfirmActivity.Parameters;
import kr.co.popone.fitts.model.payment.PaymentAPI.CouponEnrollResult;
import kr.co.popone.fitts.ui.DialogExtensions;

final class RewardPointUseConfirmActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ RewardPointUseConfirmActivity this$0;

    RewardPointUseConfirmActivity$onCreate$3(RewardPointUseConfirmActivity rewardPointUseConfirmActivity, Parameters parameters) {
        this.this$0 = rewardPointUseConfirmActivity;
        this.$parameters = parameters;
    }

    public final void onClick(View view) {
        if (this.this$0.enrollRewardUseRequest == null) {
            RewardPointUseConfirmActivity rewardPointUseConfirmActivity = this.this$0;
            rewardPointUseConfirmActivity.enrollRewardUseRequest = rewardPointUseConfirmActivity.getPaymentAPI$app_productionFittsRelease().requestEnrollRewardUse(this.$parameters.getProductPrice(), Integer.valueOf(this.$parameters.getShippingFee()), this.$parameters.getProductColor(), this.$parameters.getProductSize(), this.$parameters.getShippingName(), this.$parameters.getShippingContact(), this.$parameters.getShippingZipCode(), this.$parameters.getShippingAddress1(), this.$parameters.getShippingAddress2(), this.$parameters.getShippingMemo(), this.$parameters.getProductUrl(), Boolean.valueOf(true), null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<CouponEnrollResult, Throwable>(this) {
                final /* synthetic */ RewardPointUseConfirmActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(CouponEnrollResult couponEnrollResult, Throwable th) {
                    this.this$0.this$0.enrollRewardUseRequest = null;
                    if (couponEnrollResult != null) {
                        DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0.this$0, "완료", "핏츠 포인트 사용신청이 완료되었습니다.", new Function0<Unit>(this) {
                            final /* synthetic */ AnonymousClass1 this$0;

                            {
                                this.this$0 = r1;
                            }

                            public final void invoke() {
                                this.this$0.this$0.this$0.setResult(1010);
                                this.this$0.this$0.this$0.finish();
                                this.this$0.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
                            }
                        }, null, 16, null);
                        return;
                    }
                    DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0.this$0, "에러", "핏츠 포인트 사용신청에 실패했습니다.", null, null, 24, null);
                }
            });
        }
    }
}
