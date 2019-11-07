package kr.co.popone.fitts.feature.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class AppliableCollaborativeEventApplyActivity$onBackPressed$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppliableCollaborativeEventApplyActivity this$0;

    AppliableCollaborativeEventApplyActivity$onBackPressed$2(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
        this.this$0 = appliableCollaborativeEventApplyActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.isCancelling = false;
    }
}
