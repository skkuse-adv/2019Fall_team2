package kr.co.popone.fitts.feature.banner;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class BannerActivity$onCreate$6<T> implements Observer<String> {
    final /* synthetic */ BannerActivity this$0;

    BannerActivity$onCreate$6(BannerActivity bannerActivity) {
        this.this$0 = bannerActivity;
    }

    public final void onChanged(String str) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText(str);
    }
}
