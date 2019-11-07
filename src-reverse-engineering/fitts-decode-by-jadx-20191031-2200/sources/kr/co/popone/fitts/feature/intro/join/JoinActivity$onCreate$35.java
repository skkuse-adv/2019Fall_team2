package kr.co.popone.fitts.feature.intro.join;

import android.widget.ImageButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$35<T> implements Consumer<Boolean> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$35(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(Boolean bool) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishBodyInfoInputButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "finishBodyInfoInputButton");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        imageButton.setClickable(bool.booleanValue());
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishBodyInfoInputButton)).setImageResource(bool.booleanValue() ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
