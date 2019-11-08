package kr.co.popone.fitts.feature.intro.join;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.EditText;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class JoinActivity$onCreate$24 implements OnClickListener {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$24(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void onClick(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        View _$_findCachedViewById = this.this$0._$_findCachedViewById(C0010R$id.viewJoinInvitation);
        String str = "viewJoinInvitation";
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str);
        ViewExtensionsKt.visible(_$_findCachedViewById);
        View _$_findCachedViewById2 = this.this$0._$_findCachedViewById(C0010R$id.viewJoinInvitation);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str);
        _$_findCachedViewById2.setAnimation(alphaAnimation);
        RelativeLayout relativeLayout = (RelativeLayout) this.this$0._$_findCachedViewById(C0010R$id.ageInputLayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "ageInputLayout");
        ViewExtensionsKt.gone(relativeLayout);
        View _$_findCachedViewById3 = this.this$0._$_findCachedViewById(C0010R$id.viewJoinInvitation);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, str);
        ((EditText) _$_findCachedViewById3.findViewById(C0010R$id.editInvitationCode)).requestFocus();
        this.this$0.showKeyboard();
    }
}
