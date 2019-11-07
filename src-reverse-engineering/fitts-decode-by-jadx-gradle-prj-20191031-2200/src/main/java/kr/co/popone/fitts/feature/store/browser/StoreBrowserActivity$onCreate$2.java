package kr.co.popone.fitts.feature.store.browser;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class StoreBrowserActivity$onCreate$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$2(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
        super(0);
    }

    public final long invoke() {
        return this.this$0.getIntent().getLongExtra(StoreBrowserActivity.KEY_EVENT_ID, -1);
    }
}
