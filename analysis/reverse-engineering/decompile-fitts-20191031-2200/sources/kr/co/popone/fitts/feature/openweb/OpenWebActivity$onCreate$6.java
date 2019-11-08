package kr.co.popone.fitts.feature.openweb;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import kr.co.popone.fitts.C0010R$id;

final class OpenWebActivity$onCreate$6 implements OnClickListener {
    final /* synthetic */ OpenWebActivity this$0;

    OpenWebActivity$onCreate$6(OpenWebActivity openWebActivity) {
        this.this$0 = openWebActivity;
    }

    public final void onClick(View view) {
        ((WebView) this.this$0._$_findCachedViewById(C0010R$id.webView)).goForward();
    }
}
