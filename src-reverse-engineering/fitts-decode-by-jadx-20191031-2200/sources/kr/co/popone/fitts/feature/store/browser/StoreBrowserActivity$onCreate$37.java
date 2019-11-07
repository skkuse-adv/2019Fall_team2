package kr.co.popone.fitts.feature.store.browser;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class StoreBrowserActivity$onCreate$37<T> implements Observer<Pair<? extends Boolean, ? extends String>> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$37(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Pair<Boolean, String> pair) {
        if (pair == null) {
            Intrinsics.throwNpe();
        }
        String str = "viewNonPartnerLoading";
        String str2 = "viewPartnerLoading";
        if (((Boolean) pair.getFirst()).booleanValue()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.viewPartnerLoading);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, str2);
            ViewExtensionsKt.visible(constraintLayout);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.viewNonPartnerLoading);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, str);
            ViewExtensionsKt.gone(constraintLayout2);
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textPartnerShopName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textPartnerShopName");
            textView.setText((CharSequence) pair.getSecond());
            return;
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.viewPartnerLoading);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, str2);
        ViewExtensionsKt.gone(constraintLayout3);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.viewNonPartnerLoading);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, str);
        ViewExtensionsKt.visible(constraintLayout4);
    }
}
