package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class StoreBrowserActivity$onCreate$21<T> implements Observer<Throwable> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$21(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
