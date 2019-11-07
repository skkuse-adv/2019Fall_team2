package kr.co.popone.fitts.feature.card;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class FittsCardRendingActivity$issueFittsCard$2<T> implements Consumer<Throwable> {
    final /* synthetic */ FittsCardRendingActivity this$0;

    FittsCardRendingActivity$issueFittsCard$2(FittsCardRendingActivity fittsCardRendingActivity) {
        this.this$0 = fittsCardRendingActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
