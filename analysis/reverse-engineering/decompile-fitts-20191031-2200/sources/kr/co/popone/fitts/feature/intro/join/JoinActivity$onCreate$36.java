package kr.co.popone.fitts.feature.intro.join;

import android.widget.ImageButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$36<T> implements Consumer<String> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$36(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(String str) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishBodyTypeInputButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "finishBodyTypeInputButton");
        Intrinsics.checkExpressionValueIsNotNull(str, "it");
        boolean z = true;
        imageButton.setClickable(str.length() > 0);
        ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishBodyTypeInputButton);
        if (str.length() <= 0) {
            z = false;
        }
        imageButton2.setImageResource(z ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
