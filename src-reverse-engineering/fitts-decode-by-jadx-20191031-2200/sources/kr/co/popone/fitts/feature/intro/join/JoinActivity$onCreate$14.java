package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;

final class JoinActivity$onCreate$14 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$14(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Enter Body Shape Page For Sign Up", null, 2, null);
        this.this$0.hideKeyboard();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.bodyTypeInputLayout);
        String str = "bodyTypeInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, str);
        constraintLayout.setVisibility(0);
        RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.bodyInfoInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bodyInfoInputLayout");
        relativeLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.bodyTypeInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, str);
        constraintLayout2.setAnimation(alphaAnimation);
    }
}
