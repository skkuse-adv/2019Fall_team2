package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$22 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$22(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.ageInputLayout);
        String str = "ageInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, str);
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.ageInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, str);
        relativeLayout2.setAnimation(alphaAnimation);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.styleInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "styleInputLayout");
        constraintLayout.setVisibility(8);
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.ageEditText)).requestFocus();
        this.this$0.showKeyboard();
    }
}
