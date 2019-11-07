package kr.co.popone.fitts.feature.openweb;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.annotations.Nullable;

public final class OpenWebActivity$onCreate$4 extends WebChromeClient {
    final /* synthetic */ OpenWebActivity this$0;

    OpenWebActivity$onCreate$4(OpenWebActivity openWebActivity) {
        this.this$0 = openWebActivity;
    }

    public boolean onJsAlert(@Nullable WebView webView, @Nullable String str, @Nullable String str2, @Nullable JsResult jsResult) {
        if (str2 == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        DialogExtensions.showMessageDialog$default(DialogExtensions.INSTANCE, this.this$0, "", str2, new OpenWebActivity$onCreate$4$onJsAlert$$inlined$let$lambda$1(this, jsResult), null, 16, null);
        return true;
    }

    public void onCloseWindow(@Nullable WebView webView) {
        super.onCloseWindow(webView);
        this.this$0.onBackPressed();
    }
}
