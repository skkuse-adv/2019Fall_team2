package kr.co.popone.fitts.feature.intro.join;

import android.widget.ImageButton;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$23<T> implements Consumer<List<? extends String>> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$23(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(List<String> list) {
        Intrinsics.checkExpressionValueIsNotNull(list, "it");
        boolean z = !list.isEmpty();
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishStyleInputButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "finishStyleInputButton");
        imageButton.setClickable(z);
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishStyleInputButton)).setImageResource(z ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
