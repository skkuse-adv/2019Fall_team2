package kr.co.popone.fitts.feature.store.browser;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class StoreBrowserActivity$onCreate$45 implements OnClickListener {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$45(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onClick(View view) {
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.iconHart);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "iconHart");
        Object tag = imageView.getTag();
        if (Intrinsics.areEqual(tag, (Object) "fill")) {
            this.this$0.getViewModel().removeWishList();
        } else if (Intrinsics.areEqual(tag, (Object) "empty")) {
            this.this$0.getViewModel().enrollWishList();
        }
    }
}
