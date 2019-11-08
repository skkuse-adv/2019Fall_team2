package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kotlin.Unit;

final class StoreBrowserActivity$onCreate$29<T> implements Observer<Unit> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$29(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Unit unit) {
        if (!this.this$0.getSoldOutDialog().isShowing()) {
            this.this$0.getSoldOutDialog().show();
        }
    }
}
