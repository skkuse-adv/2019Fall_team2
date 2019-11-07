package kr.co.popone.fitts.feature.openweb;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class OpenWebActivity$handleScheme$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OpenWebActivity this$0;

    OpenWebActivity$handleScheme$1(OpenWebActivity openWebActivity) {
        this.this$0 = openWebActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.onBackPressed();
    }
}
