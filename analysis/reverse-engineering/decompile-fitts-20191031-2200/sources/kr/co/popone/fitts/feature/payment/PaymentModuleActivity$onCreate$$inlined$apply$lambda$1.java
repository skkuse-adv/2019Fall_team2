package kr.co.popone.fitts.feature.payment;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.Nullable;

public final class PaymentModuleActivity$onCreate$$inlined$apply$lambda$1 extends WebViewClient {
    final /* synthetic */ PaymentModuleActivity this$0;

    PaymentModuleActivity$onCreate$$inlined$apply$lambda$1(PaymentModuleActivity paymentModuleActivity) {
        this.this$0 = paymentModuleActivity;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object, android.content.Intent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.Nullable android.webkit.WebView r6, @org.jetbrains.annotations.Nullable java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r6 = "android.intent.action.VIEW"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "PaymentModuleActivity::shouldOverrideUrlLoading = "
            r0.append(r1)
            if (r7 == 0) goto L_0x0010
            r1 = r7
            goto L_0x0012
        L_0x0010:
            java.lang.String r1 = "empty"
        L_0x0012:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.orhanobut.logger.Logger.d(r0, r2)
            r0 = 2
            r2 = 0
            if (r7 == 0) goto L_0x002e
            java.lang.String r3 = "http://"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r3, r1, r0, r2)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x002f
        L_0x002e:
            r3 = r2
        L_0x002f:
            if (r3 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0034:
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L_0x0097
            java.lang.String r3 = "https://"
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r3, r1, r0, r2)
            if (r3 != 0) goto L_0x0097
            java.lang.String r3 = "javascript:"
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r7, r3, r1, r0, r2)
            if (r0 != 0) goto L_0x0097
            r0 = 1
            android.content.Intent r2 = android.content.Intent.parseUri(r7, r0)     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            if (r2 != 0) goto L_0x0054
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
        L_0x0054:
            java.lang.String r7 = r2.getDataString()     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            kr.co.popone.fitts.feature.payment.PaymentModuleActivity r3 = r5.this$0     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            r4.<init>(r6, r7)     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            r4.addFlags(r7)     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            r3.startActivity(r4)     // Catch:{ URISyntaxException -> 0x0096, ActivityNotFoundException -> 0x006c }
            return r0
        L_0x006c:
            if (r2 != 0) goto L_0x0070
            return r1
        L_0x0070:
            java.lang.String r7 = r2.getPackage()
            if (r7 == 0) goto L_0x0096
            kr.co.popone.fitts.feature.payment.PaymentModuleActivity r1 = r5.this$0
            android.content.Intent r2 = new android.content.Intent
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "market://details?id="
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r2.<init>(r6, r7)
            r1.startActivity(r2)
            return r0
        L_0x0096:
            return r1
        L_0x0097:
            kr.co.popone.fitts.feature.payment.PaymentModuleActivity r6 = r5.this$0
            r6.checkPaymentCompleteUrl(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.payment.PaymentModuleActivity$onCreate$$inlined$apply$lambda$1.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.progressLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "progressLoading");
        ViewExtensionsKt.gone(progressBar);
    }
}
