package kr.co.popone.fitts.feature.store.browser;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class StoreBrowserActivity$onCreate$31<T> implements Observer<Boolean> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$31(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Boolean bool) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutBottomLoading);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "layoutBottomLoading");
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        linearLayout.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
