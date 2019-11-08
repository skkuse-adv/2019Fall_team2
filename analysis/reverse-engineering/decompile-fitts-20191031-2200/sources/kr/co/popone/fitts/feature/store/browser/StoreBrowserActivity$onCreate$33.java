package kr.co.popone.fitts.feature.store.browser;

import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class StoreBrowserActivity$onCreate$33<T> implements Observer<Boolean> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$33(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Boolean bool) {
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        String str = "layoutStoreInfoBubble";
        if (bool.booleanValue()) {
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutStoreInfoBubble);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
            ViewExtensionsKt.visibleWithAlphaAnimation$default(linearLayout, 0, 1, null);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutStoreInfoBubble);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
        ViewExtensionsKt.goneWithAlphaAnimation$default(linearLayout2, 0, 1, null);
    }
}
