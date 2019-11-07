package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Consumer;

final class JoinActivity$onCreate$13<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$13(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(charSequence.toString());
        Integer valueOf = Integer.valueOf(0);
        if (intOrNull != null) {
            if (!(charSequence.toString().length() > 0)) {
                return;
            }
            if (Integer.parseInt(charSequence.toString()) > 9) {
                this.this$0.setWeight(Integer.parseInt(charSequence.toString()));
                this.this$0.weightObservable.onNext(Integer.valueOf(Integer.parseInt(charSequence.toString())));
                this.this$0.maxWeight = Integer.parseInt(charSequence.toString()) + 2;
                this.this$0.minWeight = Integer.parseInt(charSequence.toString()) - 2;
                return;
            }
            this.this$0.setWeight(0);
            this.this$0.weightObservable.onNext(valueOf);
            return;
        }
        this.this$0.setWeight(0);
        this.this$0.weightObservable.onNext(valueOf);
    }
}
