package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Consumer;

final class ModifyBodyActivity$onCreate$12<T> implements Consumer<Integer> {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$12(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public final void accept(Integer num) {
        this.this$0.getBodyInfo().setWeight(num);
    }
}
