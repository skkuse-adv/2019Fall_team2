package kr.co.popone.fitts.feature.me;

import io.reactivex.functions.Consumer;

final class ModifyBodyActivity$onCreate$7<T> implements Consumer<Integer> {
    final /* synthetic */ ModifyBodyActivity this$0;

    ModifyBodyActivity$onCreate$7(ModifyBodyActivity modifyBodyActivity) {
        this.this$0 = modifyBodyActivity;
    }

    public final void accept(Integer num) {
        this.this$0.getBodyInfo().setHeight(num);
    }
}
