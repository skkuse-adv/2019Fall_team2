package kr.co.popone.fitts.feature.post.upload.create;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.feature.post.upload.create.PostFirstWriteGuideDialogBuilder.Listener;
import org.jetbrains.annotations.NotNull;

public final class PostFirstWriteGuideDialogBuilder$showDialog$$inlined$apply$lambda$1 extends WebViewClient {
    final /* synthetic */ Listener $listener$inlined;

    PostFirstWriteGuideDialogBuilder$showDialog$$inlined$apply$lambda$1(Listener listener, String str) {
        this.$listener$inlined = listener;
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("{url: ");
        sb.append(str);
        sb.append('}');
        Logger.d(sb.toString(), new Object[0]);
        return this.$listener$inlined.onScheme(str);
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
        Listener listener = this.$listener$inlined;
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "request.url.toString()");
        return listener.onScheme(uri);
    }
}
