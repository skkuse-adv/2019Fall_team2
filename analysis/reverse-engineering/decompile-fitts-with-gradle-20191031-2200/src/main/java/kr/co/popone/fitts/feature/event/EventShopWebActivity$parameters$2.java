package kr.co.popone.fitts.feature.event;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.feature.event.EventShopWebActivity.Parameters;

final class EventShopWebActivity$parameters$2 extends Lambda implements Function0<Parameters> {
    final /* synthetic */ EventShopWebActivity this$0;

    EventShopWebActivity$parameters$2(EventShopWebActivity eventShopWebActivity) {
        this.this$0 = eventShopWebActivity;
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
