package kr.co.popone.fitts.feature.store.browser;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class StoreBrowserActivity$onCreate$19<T> implements Observer<Throwable> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$19(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Throwable th) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutBuy);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "layoutBuy");
        ViewExtensionsKt.gone(linearLayout);
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.iconHart);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "iconHart");
        ViewExtensionsKt.gone(imageView);
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.iconProductPost);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "iconProductPost");
        ViewExtensionsKt.gone(imageView2);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.badgeProductPostCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "badgeProductPostCount");
        ViewExtensionsKt.gone(textView);
    }
}
