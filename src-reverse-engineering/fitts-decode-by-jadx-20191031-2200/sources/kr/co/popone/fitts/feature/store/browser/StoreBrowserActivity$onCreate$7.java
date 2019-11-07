package kr.co.popone.fitts.feature.store.browser;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class StoreBrowserActivity$onCreate$7<T> implements Observer<Boolean> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$7(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Boolean bool) {
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.contentLoadingProgressBar);
        Intrinsics.checkExpressionValueIsNotNull(contentLoadingProgressBar, "contentLoadingProgressBar");
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        contentLoadingProgressBar.setVisibility(bool.booleanValue() ? 8 : 0);
        if (bool.booleanValue()) {
            this.this$0.removeDomScript();
        }
    }
}
