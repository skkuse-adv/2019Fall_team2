package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Consumer;

final class JoinActivity$onCreate$19<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$19(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        if (StringsKt__StringNumberConversionsKt.toIntOrNull(charSequence.toString()) == null) {
            this.this$0.age = 0;
            this.this$0.ageObservable.onNext(Integer.valueOf(0));
        } else if (Integer.parseInt(charSequence.toString()) > 10) {
            this.this$0.age = Integer.parseInt(charSequence.toString());
            this.this$0.ageObservable.onNext(Integer.valueOf(Integer.parseInt(charSequence.toString())));
        }
    }
}
