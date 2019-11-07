package kr.co.popone.fitts.feature.store.browser;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class StoreBrowserActivity$onCreate$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$1(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
        super(0);
    }

    @Nullable
    public final Long invoke() {
        long longExtra = this.this$0.getIntent().getLongExtra(StoreBrowserActivity.KEY_POST_ID, -1);
        if (longExtra == -1) {
            return null;
        }
        return Long.valueOf(longExtra);
    }
}
