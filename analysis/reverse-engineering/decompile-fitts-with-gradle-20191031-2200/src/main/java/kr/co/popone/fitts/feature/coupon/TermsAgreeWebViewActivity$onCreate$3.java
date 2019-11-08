package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.feature.coupon.TermsAgreeWebViewActivity.Parameters;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponAgreementApply;

final class TermsAgreeWebViewActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ Parameters $parameters;
    final /* synthetic */ TermsAgreeWebViewActivity this$0;

    TermsAgreeWebViewActivity$onCreate$3(TermsAgreeWebViewActivity termsAgreeWebViewActivity, Parameters parameters) {
        this.this$0 = termsAgreeWebViewActivity;
        this.$parameters = parameters;
    }

    public final void onClick(View view) {
        if (this.this$0.termsAgreeDisposable == null) {
            TermsAgreeWebViewActivity termsAgreeWebViewActivity = this.this$0;
            termsAgreeWebViewActivity.termsAgreeDisposable = termsAgreeWebViewActivity.getCouponAPI().requestAgreeTerms(this.$parameters.getCouponId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<CouponAgreementApply>(this) {
                final /* synthetic */ TermsAgreeWebViewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(CouponAgreementApply couponAgreementApply) {
                    this.this$0.this$0.termsAgreeDisposable = null;
                    this.this$0.this$0.setResult(-1);
                    this.this$0.this$0.onBackPressed();
                }
            }, new Consumer<Throwable>(this) {
                final /* synthetic */ TermsAgreeWebViewActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    this.this$0.this$0.termsAgreeDisposable = null;
                    ActivityExtensionKt.showSnackbarMessage(this.this$0.this$0, String.valueOf(th.getMessage()));
                }
            });
        }
    }
}
