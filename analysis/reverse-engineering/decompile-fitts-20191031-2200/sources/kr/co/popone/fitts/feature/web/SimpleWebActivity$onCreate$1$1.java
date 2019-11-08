package kr.co.popone.fitts.feature.web;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class SimpleWebActivity$onCreate$1$1 extends WebViewClient {
    SimpleWebActivity$onCreate$1$1() {
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("StoreBrowserActivity::shouldOverrideUrlLoading url = ");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "request");
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "request.url.toString()");
        return shouldOverrideUrlLoading(webView, uri);
    }
}
