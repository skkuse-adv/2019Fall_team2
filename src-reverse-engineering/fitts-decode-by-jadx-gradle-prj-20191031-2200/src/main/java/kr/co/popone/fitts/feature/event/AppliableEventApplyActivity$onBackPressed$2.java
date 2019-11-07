package kr.co.popone.fitts.feature.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class AppliableEventApplyActivity$onBackPressed$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onBackPressed$2(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.isCancelling = false;
    }
}
