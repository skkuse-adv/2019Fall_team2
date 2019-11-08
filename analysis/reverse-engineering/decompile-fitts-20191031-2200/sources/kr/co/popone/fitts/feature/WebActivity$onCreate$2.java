package kr.co.popone.fitts.feature;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.widget.ContentLoadingProgressBar;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

public final class WebActivity$onCreate$2 extends WebChromeClient {
    final /* synthetic */ WebActivity this$0;

    WebActivity$onCreate$2(WebActivity webActivity) {
        this.this$0 = webActivity;
    }

    public void onProgressChanged(@NotNull WebView webView, int i) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.webViewLoadProgressBar);
        Intrinsics.checkExpressionValueIsNotNull(contentLoadingProgressBar, "webViewLoadProgressBar");
        contentLoadingProgressBar.setProgress(i);
        if (i >= 100) {
            ((ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.webViewLoadProgressBar)).hide();
        } else {
            ((ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.webViewLoadProgressBar)).show();
        }
    }
}
