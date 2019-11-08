package kr.co.popone.fitts.feature.store.browser;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;

final class StoreBrowserActivity$onCreate$39<T> implements Observer<Boolean> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$39(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(Boolean bool) {
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutBuy);
        String str = "layoutBuy";
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
        linearLayout.setEnabled(false);
        ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.iconHart);
        String str2 = "iconHart";
        Intrinsics.checkExpressionValueIsNotNull(imageView, str2);
        imageView.setEnabled(false);
        LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C0010R$id.layoutBuy);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
        ViewExtensionsKt.gone(linearLayout2);
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.iconHart);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, str2);
        ViewExtensionsKt.gone(imageView2);
        ImageView imageView3 = (ImageView) this.this$0._$_findCachedViewById(C0010R$id.iconProductPost);
        Intrinsics.checkExpressionValueIsNotNull(imageView3, "iconProductPost");
        ViewExtensionsKt.gone(imageView3);
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.badgeProductPostCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "badgeProductPostCount");
        ViewExtensionsKt.gone(textView);
    }
}
