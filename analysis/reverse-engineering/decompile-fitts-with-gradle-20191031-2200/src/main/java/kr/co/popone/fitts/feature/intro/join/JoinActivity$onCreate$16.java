package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Consumer;

final class JoinActivity$onCreate$16<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$16(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(charSequence.toString());
        if (intOrNull != null) {
            this.this$0.shoeSizeObservable.onNext(intOrNull);
        } else {
            this.this$0.shoeSizeObservable.onNext(Integer.valueOf(0));
        }
    }
}
