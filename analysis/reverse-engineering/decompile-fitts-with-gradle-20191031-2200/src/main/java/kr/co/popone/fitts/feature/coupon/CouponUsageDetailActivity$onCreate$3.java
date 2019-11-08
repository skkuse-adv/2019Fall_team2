package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.anko.DimensionsKt;

final class CouponUsageDetailActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ CouponUsageDetailActivity this$0;

    CouponUsageDetailActivity$onCreate$3(CouponUsageDetailActivity couponUsageDetailActivity) {
        this.this$0 = couponUsageDetailActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.cancelCouponUsageRequest != null) {
            DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0, "핏츠 쿠폰 사용신청 취소", "취소 중입니다", null, null, 24, null);
            return;
        }
        DialogExtensions dialogExtensions = DialogExtensions.INSTANCE;
        CouponUsageDetailActivity couponUsageDetailActivity = this.this$0;
        PaymentUsage access$getPaymentUsage$p = couponUsageDetailActivity.paymentUsage;
        DialogExtensions.showConfirmDialog$default(dialogExtensions, couponUsageDetailActivity, "정말 취소하시겠어요?", couponUsageDetailActivity.getDialogMessage(access$getPaymentUsage$p != null ? access$getPaymentUsage$p.getCoupon() : null), new Function0<Unit>(this) {
            final /* synthetic */ CouponUsageDetailActivity$onCreate$3 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                CouponUsageDetailActivity couponUsageDetailActivity = this.this$0.this$0;
                couponUsageDetailActivity.cancelCouponUsageRequest = couponUsageDetailActivity.getPaymentAPI$app_productionFittsRelease().deletePaymentUsageHistory(this.this$0.this$0.couponUsageID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new BiConsumer<String, Throwable>(this) {
                    final /* synthetic */ AnonymousClass1 this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final void accept(String str, Throwable th) {
                        this.this$0.this$0.this$0.cancelCouponUsageRequest = null;
                        if (th == null) {
                            this.this$0.this$0.this$0.setResult(100);
                            this.this$0.this$0.this$0.finish();
                            this.this$0.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
                            return;
                        }
                        DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0.this$0.this$0, "핏츠 쿠폰 사용신청 취소", "에러가 발생했습니다.", null, null, 24, null);
                    }
                });
            }
        }, null, null, null, 0, DimensionsKt.HDPI, null);
    }
}
