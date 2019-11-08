package kr.co.popone.fitts.feature.intro.join;

import android.widget.ImageButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$37<T> implements Consumer<Integer> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$37(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(Integer num) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishAgeInputButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "finishAgeInputButton");
        imageButton.setClickable(Intrinsics.compare(num.intValue(), 0) > 0);
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishAgeInputButton)).setImageResource(Intrinsics.compare(num.intValue(), 0) > 0 ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
