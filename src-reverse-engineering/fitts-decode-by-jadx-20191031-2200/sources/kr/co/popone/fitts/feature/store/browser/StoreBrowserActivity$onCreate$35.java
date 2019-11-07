package kr.co.popone.fitts.feature.store.browser;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class StoreBrowserActivity$onCreate$35<T> implements Observer<Unit> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$35(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Unit unit) {
        ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.viewPartnerLoading);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "viewPartnerLoading");
        ViewExtensionsKt.goneWithAlphaAnimation$default(constraintLayout, 0, 1, null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.viewNonPartnerLoading);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "viewNonPartnerLoading");
        ViewExtensionsKt.goneWithAlphaAnimation$default(constraintLayout2, 0, 1, null);
    }
}
