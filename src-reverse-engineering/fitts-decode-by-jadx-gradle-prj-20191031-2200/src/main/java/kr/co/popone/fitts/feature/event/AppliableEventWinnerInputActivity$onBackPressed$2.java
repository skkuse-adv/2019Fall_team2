package kr.co.popone.fitts.feature.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class AppliableEventWinnerInputActivity$onBackPressed$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onBackPressed$2(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.isCancelling = false;
    }
}
