package kr.co.popone.fitts.feature.main;

import io.reactivex.functions.Consumer;

final class MainActivity$onCreate$6<T> implements Consumer<Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$6(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(Throwable th) {
        this.this$0.showPostDialogOnInit();
    }
}
