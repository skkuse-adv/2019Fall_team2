package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$17 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$17(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        this.this$0.hideKeyboard();
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.styleInputLayout);
        String str = "styleInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, str);
        constraintLayout.setVisibility(0);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.shoeSizeInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "shoeSizeInputLayout");
        constraintLayout2.setVisibility(8);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.styleInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, str);
        constraintLayout3.setAnimation(alphaAnimation);
    }
}
