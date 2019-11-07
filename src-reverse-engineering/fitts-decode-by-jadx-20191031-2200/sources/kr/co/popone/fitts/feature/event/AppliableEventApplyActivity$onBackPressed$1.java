package kr.co.popone.fitts.feature.event;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0001R$anim;

final class AppliableEventApplyActivity$onBackPressed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onBackPressed$1(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.isCancelling = false;
        this.this$0.setResult(0);
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
