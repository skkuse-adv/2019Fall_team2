package kr.co.popone.fitts.feature.coupon;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity;

final class CouponUseActivity$onCreate$11 implements OnClickListener {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$11(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void onClick(View view) {
        CouponUseActivity couponUseActivity = this.this$0;
        couponUseActivity.startActivityForResult(new Intent(couponUseActivity, AddressWebViewActivity.class), Callback.DEFAULT_DRAG_ANIMATION_DURATION);
    }
}
