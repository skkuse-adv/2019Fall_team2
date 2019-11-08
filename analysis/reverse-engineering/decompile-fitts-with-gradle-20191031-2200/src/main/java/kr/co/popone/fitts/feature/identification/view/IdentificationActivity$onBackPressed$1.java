package kr.co.popone.fitts.feature.identification.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class IdentificationActivity$onBackPressed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ IdentificationActivity this$0;

    IdentificationActivity$onBackPressed$1(IdentificationActivity identificationActivity) {
        this.this$0 = identificationActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.setResult(0);
        this.this$0.finish();
    }
}
