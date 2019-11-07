package kr.co.popone.fitts.feature.store.browser;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StoreBrowserActivity$onCreate$$inlined$apply$lambda$2 extends WebViewClient {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$$inlined$apply$lambda$2(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("StoreBrowserActivity::shouldOverrideUrlLoading url = ");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.hidePartnerlayout();
        Uri parse = Uri.parse(str);
        String str2 = "Uri.parse(url)";
        Intrinsics.checkExpressionValueIsNotNull(parse, str2);
        if (Intrinsics.areEqual((Object) parse.getScheme(), (Object) "market")) {
            this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
        Uri parse2 = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse2, str2);
        if (!Intrinsics.areEqual((Object) parse2.getScheme(), (Object) "intent")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        this.this$0.handleIntentScheme(str);
        return true;
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "request");
        Uri url = webResourceRequest.getUrl();
        String str = "request.url";
        Intrinsics.checkExpressionValueIsNotNull(url, str);
        if (Intrinsics.areEqual((Object) url.getScheme(), (Object) "market")) {
            this.this$0.startActivity(new Intent("android.intent.action.VIEW", webResourceRequest.getUrl()));
            return true;
        }
        Uri url2 = webResourceRequest.getUrl();
        Intrinsics.checkExpressionValueIsNotNull(url2, str);
        String str2 = "request.url.toString()";
        if (Intrinsics.areEqual((Object) url2.getScheme(), (Object) "intent")) {
            StoreBrowserActivity storeBrowserActivity = this.this$0;
            String uri = webResourceRequest.getUrl().toString();
            Intrinsics.checkExpressionValueIsNotNull(uri, str2);
            storeBrowserActivity.handleIntentScheme(uri);
            return true;
        }
        String uri2 = webResourceRequest.getUrl().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri2, str2);
        return shouldOverrideUrlLoading(webView, uri2);
    }

    public void doUpdateVisitedHistory(@Nullable WebView webView, @Nullable String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreBrowserActivity::doUpdateVisitedHistory : isReload = ");
        sb.append(z);
        sb.append(", url = ");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.getOptionSelectDialog().clear();
        this.this$0.getViewModel().isWebpageLoaded(false);
        this.this$0.getViewModel().checkProductLink(str != null ? str : "");
        super.doUpdateVisitedHistory(webView, str, z);
    }

    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        StringBuilder sb = new StringBuilder();
        sb.append("StoreBrowserActivity::shouldOverrideUrlLoading finished = ");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.removeDomScript();
    }
}
