package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

final class StoreBrowserActivity$onCreate$27<T> implements Observer<Boolean> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$27(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Boolean bool) {
        StoreBrowserActivity storeBrowserActivity = this.this$0;
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        storeBrowserActivity.updateWishIcon(bool.booleanValue());
    }
}
