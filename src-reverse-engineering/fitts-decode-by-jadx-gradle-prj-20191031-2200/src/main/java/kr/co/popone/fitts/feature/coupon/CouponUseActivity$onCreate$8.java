package kr.co.popone.fitts.feature.coupon;

import io.reactivex.functions.Consumer;

final class CouponUseActivity$onCreate$8<T> implements Consumer<CharSequence> {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$8(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void accept(CharSequence charSequence) {
        try {
            this.this$0.shippingFeeSubject.onNext(Integer.valueOf(Integer.parseInt(charSequence.toString())));
        } catch (NumberFormatException unused) {
            this.this$0.shippingFeeSubject.onNext(Integer.valueOf(0));
        }
    }
}
