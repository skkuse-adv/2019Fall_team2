package kr.co.popone.fitts.feature.me;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.feature.coupon.CouponHomeActivity;

final class MeFragment$initClickListener$5 implements OnClickListener {
    final /* synthetic */ MeFragment this$0;

    MeFragment$initClickListener$5(MeFragment meFragment) {
        this.this$0 = meFragment;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.this$0.getContext(), CouponHomeActivity.class);
        Context context = this.this$0.getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        ActivityOptionsCompat makeCustomAnimation = ActivityOptionsCompat.makeCustomAnimation(context, C0001R$anim.slide_right, C0001R$anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(makeCustomAnimation, "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)");
        this.this$0.startActivity(intent, makeCustomAnimation.toBundle());
    }
}
