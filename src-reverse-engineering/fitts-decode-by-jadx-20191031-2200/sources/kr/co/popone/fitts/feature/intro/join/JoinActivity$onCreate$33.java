package kr.co.popone.fitts.feature.intro.join;

import android.widget.ImageButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$33<T> implements Consumer<Boolean> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$33(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(Boolean bool) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.button_next_firstSNS);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "button_next_firstSNS");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        imageButton.setClickable(bool.booleanValue());
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.button_next_firstSNS)).setImageResource(bool.booleanValue() ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
