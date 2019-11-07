package kr.co.popone.fitts.feature.search;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.kakao.message.template.MessageTemplateProtocol;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopWebViewActivity$onCreate$2 extends WebViewClient {
    final /* synthetic */ ShopWebViewActivity this$0;

    ShopWebViewActivity$onCreate$2(ShopWebViewActivity shopWebViewActivity) {
        this.this$0 = shopWebViewActivity;
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.this$0.sendWebLog(str);
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

    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        StringBuilder sb = new StringBuilder();
        sb.append("webViewClient onPageFinished(");
        sb.append(str);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        Logger.d("logged non-fatal", new Object[0]);
    }

    @TargetApi(23)
    public void onReceivedHttpError(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest, @NotNull WebResourceResponse webResourceResponse) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "request");
        Intrinsics.checkParameterIsNotNull(webResourceResponse, "errorResponse");
        boolean areEqual = Intrinsics.areEqual((Object) webView.getUrl(), (Object) webResourceRequest.getUrl().toString());
        StringBuilder sb = new StringBuilder();
        sb.append("onRecevedHttpError matches currentURL(");
        sb.append(areEqual);
        sb.append(") view(");
        sb.append(webView);
        sb.append(") request(");
        sb.append(webResourceRequest);
        sb.append(") errorResponse(");
        sb.append(webResourceResponse);
        sb.append(") request.url(");
        sb.append(webResourceRequest.getUrl());
        Logger.d(sb.toString(), new Object[0]);
        if (areEqual) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.errorLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "errorLayout");
            constraintLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.linkCopyGuideLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "linkCopyGuideLayout");
            constraintLayout2.setVisibility(4);
            if (webResourceResponse.getStatusCode() == 404) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("log crashlytics with 404 ");
                sb2.append(webView.getUrl());
                Logger.d(sb2.toString(), new Object[0]);
            }
        }
    }

    @TargetApi(23)
    public void onReceivedError(@NotNull WebView webView, @NotNull WebResourceRequest webResourceRequest, @NotNull WebResourceError webResourceError) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(webResourceRequest, "request");
        Intrinsics.checkParameterIsNotNull(webResourceError, "error");
        boolean areEqual = Intrinsics.areEqual((Object) webView.getUrl(), (Object) webResourceRequest.getUrl().toString());
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedError matches currentURL(");
        sb.append(areEqual);
        sb.append(") view(");
        sb.append(webView);
        sb.append(") request(");
        sb.append(webResourceRequest);
        sb.append(") error(");
        sb.append(webResourceError);
        sb.append(") errorCode(");
        sb.append(webResourceError.getErrorCode());
        sb.append(")   request.url(");
        sb.append(webResourceRequest.getUrl());
        Logger.d(sb.toString(), new Object[0]);
        if (areEqual) {
            ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.errorLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "errorLayout");
            constraintLayout.setVisibility(0);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.linkCopyGuideLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "linkCopyGuideLayout");
            constraintLayout2.setVisibility(4);
        }
    }

    public void onReceivedError(@NotNull WebView webView, int i, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(webView, "view");
        Intrinsics.checkParameterIsNotNull(str, MessageTemplateProtocol.DESCRIPTION);
        Intrinsics.checkParameterIsNotNull(str2, "failingUrl");
        if (VERSION.SDK_INT < 23) {
            boolean areEqual = Intrinsics.areEqual((Object) webView.getUrl(), (Object) str2);
            StringBuilder sb = new StringBuilder();
            sb.append("onReceivedError matches currentURL(");
            sb.append(areEqual);
            sb.append(") view(");
            sb.append(webView);
            sb.append(") errorCode(");
            sb.append(i);
            sb.append(") description(");
            sb.append(str);
            sb.append(") failingUrl(");
            sb.append(str2);
            sb.append(')');
            Logger.d(sb.toString(), new Object[0]);
            if (areEqual) {
                ConstraintLayout constraintLayout = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.errorLayout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "errorLayout");
                constraintLayout.setVisibility(0);
                ConstraintLayout constraintLayout2 = (ConstraintLayout) this.this$0._$_findCachedViewById(C0010R$id.linkCopyGuideLayout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "linkCopyGuideLayout");
                constraintLayout2.setVisibility(4);
            }
        }
    }
}
