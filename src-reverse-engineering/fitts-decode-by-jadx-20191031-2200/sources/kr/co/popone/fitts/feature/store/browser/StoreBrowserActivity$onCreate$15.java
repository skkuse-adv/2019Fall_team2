package kr.co.popone.fitts.feature.store.browser;

import android.content.Context;
import androidx.lifecycle.Observer;
import kr.co.popone.fitts.ui.ToastExtensionKt;

final class StoreBrowserActivity$onCreate$15<T> implements Observer<String> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$15(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(String str) {
        ToastExtensionKt.showToast((Context) this.this$0, str);
    }
}
