package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity.Parameters;

final class CouponUseConfirmActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ CouponUseConfirmActivity this$0;

    CouponUseConfirmActivity$onCreate$3(CouponUseConfirmActivity couponUseConfirmActivity, Parameters parameters) {
        this.this$0 = couponUseConfirmActivity;
        this.$parameters = parameters;
    }

    public final void onClick(View view) {
        if (this.this$0.couponEnrollDisposable == null) {
            Parameters parameters = this.$parameters;
            CouponUseConfirmActivity couponUseConfirmActivity = this.this$0;
            couponUseConfirmActivity.couponEnrollDisposable = couponUseConfirmActivity.getPaymentAPI$app_productionFittsRelease().requestEnrollCouponUse(parameters.getProductPrice(), Integer.valueOf(parameters.getShippingFee()), Long.valueOf(parameters.getCouponId()), parameters.getProductColor(), parameters.getProductSize(), parameters.getShippingName(), parameters.getShippingContact(), parameters.getShippingZipCode(), parameters.getShippingAddress1(), parameters.getShippingAddress2(), parameters.getShippingMemo(), parameters.getProductUrl(), Boolean.valueOf(true), null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponUseConfirmActivity$onCreate$3$$special$$inlined$let$lambda$1<Object,Object>(this));
        }
    }
}
