package kr.co.popone.fitts.feature.event;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.event.AppliableCollaborativeEventApplyActivity.Parameters;

final class AppliableCollaborativeEventApplyActivity$parameters$2 extends Lambda implements Function0<Parameters> {
    final /* synthetic */ AppliableCollaborativeEventApplyActivity this$0;

    AppliableCollaborativeEventApplyActivity$parameters$2(AppliableCollaborativeEventApplyActivity appliableCollaborativeEventApplyActivity) {
        this.this$0 = appliableCollaborativeEventApplyActivity;
        super(0);
    }

    public final Parameters invoke() {
        Parameters parameters = (Parameters) this.this$0.getIntent().getParcelableExtra("parameters");
        if (parameters != null) {
            return parameters;
        }
        throw new IllegalAccessException();
    }
}
