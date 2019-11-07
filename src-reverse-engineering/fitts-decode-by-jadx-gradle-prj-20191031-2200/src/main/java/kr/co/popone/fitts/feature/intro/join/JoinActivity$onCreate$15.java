package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.eventtracker.EventTracker.DefaultImpls;

final class JoinActivity$onCreate$15 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$15(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        DefaultImpls.logCustom$default(this.this$0.getEventTracker$app_productionFittsRelease(), "Enter Age Page For Sign Up", null, 2, null);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputLayout);
        String str = "shoeSizeInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, str);
        constraintLayout.setVisibility(0);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.bodyTypeInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "bodyTypeInputLayout");
        constraintLayout2.setVisibility(8);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, str);
        constraintLayout3.setAnimation(alphaAnimation);
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputEditText)).requestFocus();
        this.this$0.showKeyboard();
    }
}
