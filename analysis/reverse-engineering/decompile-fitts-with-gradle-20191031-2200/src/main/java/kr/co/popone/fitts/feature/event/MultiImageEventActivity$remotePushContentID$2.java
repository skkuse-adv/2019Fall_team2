package kr.co.popone.fitts.feature.event;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class MultiImageEventActivity$remotePushContentID$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ MultiImageEventActivity this$0;

    MultiImageEventActivity$remotePushContentID$2(MultiImageEventActivity multiImageEventActivity) {
        this.this$0 = multiImageEventActivity;
        super(0);
    }

    public final long invoke() {
        long longExtra = this.this$0.getIntent().getLongExtra("id", -1);
        if (longExtra >= 1) {
            return longExtra;
        }
        throw new IllegalAccessException();
    }
}
