package kr.co.popone.fitts.feature.store.browser;

import android.content.Context;
import androidx.lifecycle.Observer;
import kr.co.popone.fitts.ui.ToastExtensionKt;

final class StoreBrowserActivity$onCreate$13<T> implements Observer<Throwable> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$13(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Throwable th) {
        ToastExtensionKt.showToast((Context) this.this$0, "상품 선택에 에러가 발생");
    }
}
