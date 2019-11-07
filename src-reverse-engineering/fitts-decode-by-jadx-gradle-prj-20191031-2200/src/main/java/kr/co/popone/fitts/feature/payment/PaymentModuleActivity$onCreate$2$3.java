package kr.co.popone.fitts.feature.payment;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.orhanobut.logger.Logger;
import org.jetbrains.annotations.Nullable;

public final class PaymentModuleActivity$onCreate$2$3 extends WebChromeClient {
    PaymentModuleActivity$onCreate$2$3() {
    }

    public boolean onJsConfirm(@Nullable WebView webView, @Nullable String str, @Nullable String str2, @Nullable JsResult jsResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("PaymentModuleActivity::onJsConfirm = ");
        sb.append(str2);
        Logger.d(sb.toString(), new Object[0]);
        return super.onJsConfirm(webView, str, str2, jsResult);
    }
}
