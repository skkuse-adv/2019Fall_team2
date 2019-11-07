package kr.co.popone.fitts.feature.intro.join;

import android.widget.EditText;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$12<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$12(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(charSequence.toString());
        Integer valueOf = Integer.valueOf(0);
        if (intOrNull != null) {
            if (charSequence.toString().length() > 0) {
                if (Integer.parseInt(charSequence.toString()) > 99) {
                    this.this$0.setHeight(Integer.parseInt(charSequence.toString()));
                    this.this$0.heightObservable.onNext(Integer.valueOf(Integer.parseInt(charSequence.toString())));
                    this.this$0.maxHeight = Integer.parseInt(charSequence.toString()) + 2;
                    this.this$0.minHeight = Integer.parseInt(charSequence.toString()) - 2;
                } else {
                    this.this$0.setHeight(0);
                    this.this$0.heightObservable.onNext(valueOf);
                }
                if (charSequence.toString().length() == 3) {
                    ((EditText) this.this$0._$_findCachedViewById(C0010R$id.weightEditText)).requestFocus();
                    return;
                }
                return;
            }
            return;
        }
        this.this$0.setHeight(0);
        this.this$0.heightObservable.onNext(valueOf);
    }
}
