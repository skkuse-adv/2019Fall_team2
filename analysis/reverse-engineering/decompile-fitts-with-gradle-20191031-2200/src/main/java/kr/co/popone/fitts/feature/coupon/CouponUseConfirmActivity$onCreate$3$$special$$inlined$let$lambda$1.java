package kr.co.popone.fitts.feature.coupon;

import io.reactivex.functions.BiConsumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.model.payment.PaymentAPI.CouponEnrollResult;
import kr.co.popone.fitts.ui.DialogExtensions;

final class CouponUseConfirmActivity$onCreate$3$$special$$inlined$let$lambda$1<T1, T2> implements BiConsumer<CouponEnrollResult, Throwable> {
    final /* synthetic */ CouponUseConfirmActivity$onCreate$3 this$0;

    CouponUseConfirmActivity$onCreate$3$$special$$inlined$let$lambda$1(CouponUseConfirmActivity$onCreate$3 couponUseConfirmActivity$onCreate$3) {
        this.this$0 = couponUseConfirmActivity$onCreate$3;
    }

    public final void accept(CouponEnrollResult couponEnrollResult, Throwable th) {
        if (couponEnrollResult != null) {
            this.this$0.this$0.couponEnrollDisposable = null;
            DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "쿠폰 사용신청이 완료되었어요", "알림을 통해 신청하신 상품에 대한\n주문 소식을 알려드려요", new Function0<Unit>(this) {
                final /* synthetic */ CouponUseConfirmActivity$onCreate$3$$special$$inlined$let$lambda$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void invoke() {
                    this.this$0.this$0.this$0.setResult(1010);
                    this.this$0.this$0.this$0.finish();
                    this.this$0.this$0.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
                }
            }, "확인");
            return;
        }
        this.this$0.this$0.couponEnrollDisposable = null;
        DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0.this$0, "에러", "핏츠 쿠폰 사용신청에 실패했습니다.", null, null, 24, null);
    }
}
