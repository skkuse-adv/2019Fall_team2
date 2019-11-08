package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity;
import kr.co.popone.fitts.feature.search.ShopWebViewActivity.Parameters;
import org.jetbrains.anko.internals.AnkoInternals;

final class CouponUseActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$5(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void onClick(View view) {
        CouponUseActivity couponUseActivity = this.this$0;
        EditText editText = (EditText) couponUseActivity._$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "productDetailPageLinkEditText");
        Parameters parameters = new Parameters(editText.getText().toString(), "", false, null, null, null, null, 124, null);
        couponUseActivity.startActivity(AnkoInternals.createIntent(couponUseActivity, ShopWebViewActivity.class, new Pair[]{TuplesKt.to("parameters", parameters)}));
        this.this$0.overridePendingTransition(C0001R$anim.slide_up, C0001R$anim.fade_out);
    }
}
