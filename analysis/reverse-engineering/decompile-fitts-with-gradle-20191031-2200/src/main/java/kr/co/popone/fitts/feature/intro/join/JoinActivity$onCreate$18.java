package kr.co.popone.fitts.feature.intro.join;

import android.widget.ImageButton;
import androidx.recyclerview.widget.ItemTouchHelper.Callback;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$18<T> implements Consumer<Integer> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$18(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(Integer num) {
        boolean z = Intrinsics.compare(num.intValue(), (int) Callback.DEFAULT_DRAG_ANIMATION_DURATION) > 0 && num.intValue() % 5 == 0 && Intrinsics.compare(num.intValue(), 350) < 0;
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishShoeSizeInputButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "finishShoeSizeInputButton");
        imageButton.setEnabled(z);
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.finishShoeSizeInputButton)).setImageResource(z ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
