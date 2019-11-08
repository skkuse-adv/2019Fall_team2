package kr.co.popone.fitts.feature.event;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class AppliableCollaborativeEventActivity$eventID$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ AppliableCollaborativeEventActivity this$0;

    AppliableCollaborativeEventActivity$eventID$2(AppliableCollaborativeEventActivity appliableCollaborativeEventActivity) {
        this.this$0 = appliableCollaborativeEventActivity;
        super(0);
    }

    public final long invoke() {
        long longExtra = this.this$0.getIntent().getLongExtra("id", 0);
        if (longExtra != 0) {
            return longExtra;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("eventID ");
        sb.append(longExtra);
        throw new IllegalArgumentException(sb.toString());
    }
}
