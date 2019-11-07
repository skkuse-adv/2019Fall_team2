package kr.co.popone.fitts.feature.intro.join;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class JoinActivity$onCreate$41<T> implements Consumer<Throwable> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$41(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
