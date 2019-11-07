package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$11 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$11(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.bodyInfoInputLayout);
        String str = "bodyInfoInputLayout";
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, str);
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.idInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "idInputLayout");
        relativeLayout2.setVisibility(8);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.bodyInfoInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, str);
        relativeLayout3.setAnimation(alphaAnimation);
        ((EditText) this.this$0._$_findCachedViewById(C0010R$id.heightEditText)).requestFocus();
        this.this$0.showKeyboard();
    }
}
