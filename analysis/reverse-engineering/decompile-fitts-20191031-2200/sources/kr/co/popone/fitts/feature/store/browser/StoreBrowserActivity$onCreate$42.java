package kr.co.popone.fitts.feature.store.browser;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.OrderEvent$OrderCompleteEvent;

final class StoreBrowserActivity$onCreate$42<T> implements Consumer<Object> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$42(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void accept(Object obj) {
        if (obj instanceof OrderEvent$OrderCompleteEvent) {
            this.this$0.finish();
        }
    }
}
