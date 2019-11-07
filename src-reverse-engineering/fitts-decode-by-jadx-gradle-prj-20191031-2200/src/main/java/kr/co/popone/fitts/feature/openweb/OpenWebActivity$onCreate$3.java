package kr.co.popone.fitts.feature.openweb;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OpenWebActivity$onCreate$3 extends WebViewClient {
    final /* synthetic */ OpenWebActivity this$0;

    OpenWebActivity$onCreate$3(OpenWebActivity openWebActivity) {
        this.this$0 = openWebActivity;
    }

    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        StringBuilder sb = new StringBuilder();
        sb.append("webViewClient onPageFinished(");
        sb.append(str);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.leftNavigationButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "leftNavigationButton");
        imageButton.setEnabled(((WebView) this.this$0._$_findCachedViewById(C0010R$id.webView)).canGoBack());
        ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.rightNavigationButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton2, "rightNavigationButton");
        imageButton2.setEnabled(((WebView) this.this$0._$_findCachedViewById(C0010R$id.webView)).canGoForward());
        Logger.d("logged non-fatal", new Object[0]);
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("{url: ");
        sb.append(str);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        return this.this$0.handleScheme(str);
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "request");
        StringBuilder sb = new StringBuilder();
        sb.append("{url: ");
        sb.append(webResourceRequest.getUrl());
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        OpenWebActivity openWebActivity = this.this$0;
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "request.url.toString()");
        return openWebActivity.handleScheme(uri);
    }
}
