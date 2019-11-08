package kr.co.popone.fitts.feature.identification.view;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class IdentificationActivity$onCreate$2<T> implements Consumer<Throwable> {
    final /* synthetic */ IdentificationActivity this$0;

    IdentificationActivity$onCreate$2(IdentificationActivity identificationActivity) {
        this.this$0 = identificationActivity;
    }

    public final void accept(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
