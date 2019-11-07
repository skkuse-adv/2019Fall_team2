package kr.co.popone.fitts.feature.identification.view;

import android.os.Build.VERSION;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;
import org.jetbrains.annotations.Nullable;

public final class IdentificationWebViewFragment$onViewCreated$2 extends WebViewClient {
    final /* synthetic */ IdentificationWebViewFragment this$0;

    IdentificationWebViewFragment$onViewCreated$2(IdentificationWebViewFragment identificationWebViewFragment) {
        this.this$0 = identificationWebViewFragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.Nullable android.webkit.WebView r4, @org.jetbrains.annotations.Nullable android.webkit.WebResourceRequest r5) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 <= r1) goto L_0x007b
            r0 = 0
            if (r5 == 0) goto L_0x0014
            android.net.Uri r1 = r5.getUrl()
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = r1.getScheme()
            goto L_0x0015
        L_0x0014:
            r1 = r0
        L_0x0015:
            java.lang.String r2 = "intent"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L_0x001f
            r4 = 1
            return r4
        L_0x001f:
            if (r5 == 0) goto L_0x0025
            android.net.Uri r0 = r5.getUrl()
        L_0x0025:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.hashCode()
            r2 = -1348785409(0xffffffffaf9b2aff, float:-2.8224886E-10)
            if (r1 == r2) goto L_0x006c
            r2 = 1106709239(0x41f70af7, float:30.880354)
            if (r1 == r2) goto L_0x004d
            r2 = 1740050602(0x67b710aa, float:1.729001E24)
            if (r1 == r2) goto L_0x003d
            goto L_0x007b
        L_0x003d:
            java.lang.String r1 = "https://fitts.co.kr/ivs_fail"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007b
            kr.co.popone.fitts.event.RxBus r0 = kr.co.popone.fitts.event.RxBus.INSTANCE
            kr.co.popone.fitts.feature.identification.IdentificationEvent r1 = kr.co.popone.fitts.feature.identification.IdentificationEvent.RESULT_NICE_ERROR
            r0.post(r1)
            goto L_0x007b
        L_0x004d:
            java.lang.String r1 = "https://fitts.co.kr/ivs_success"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007b
            kr.co.popone.fitts.feature.identification.view.IdentificationWebViewFragment r0 = r3.this$0
            int r1 = kr.co.popone.fitts.C0010R$id.webView
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.webkit.WebView r0 = (android.webkit.WebView) r0
            if (r0 == 0) goto L_0x0064
            r0.destroy()
        L_0x0064:
            kr.co.popone.fitts.event.RxBus r0 = kr.co.popone.fitts.event.RxBus.INSTANCE
            kr.co.popone.fitts.feature.identification.IdentificationEvent r1 = kr.co.popone.fitts.feature.identification.IdentificationEvent.RESULT_SUCCESS
            r0.post(r1)
            goto L_0x007b
        L_0x006c:
            java.lang.String r1 = "https://fitts.co.kr/ivs_duplicate"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x007b
            kr.co.popone.fitts.event.RxBus r0 = kr.co.popone.fitts.event.RxBus.INSTANCE
            kr.co.popone.fitts.feature.identification.IdentificationEvent r1 = kr.co.popone.fitts.feature.identification.IdentificationEvent.RESULT_DUPLICATION
            r0.post(r1)
        L_0x007b:
            boolean r4 = super.shouldOverrideUrlLoading(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.identification.view.IdentificationWebViewFragment$onViewCreated$2.shouldOverrideUrlLoading(android.webkit.WebView, android.webkit.WebResourceRequest):boolean");
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        if (str != null && VERSION.SDK_INT <= 23) {
            if (StringsKt__StringsJVMKt.startsWith$default(str, "intent:", false, 2, null)) {
                return true;
            }
            int hashCode = str.hashCode();
            if (hashCode != -1348785409) {
                if (hashCode != 1106709239) {
                    if (hashCode == 1740050602 && str.equals("https://fitts.co.kr/ivs_fail")) {
                        RxBus.INSTANCE.post(IdentificationEvent.RESULT_NICE_ERROR);
                    }
                } else if (str.equals("https://fitts.co.kr/ivs_success")) {
                    RxBus.INSTANCE.post(IdentificationEvent.RESULT_SUCCESS);
                }
            } else if (str.equals("https://fitts.co.kr/ivs_duplicate")) {
                RxBus.INSTANCE.post(IdentificationEvent.RESULT_DUPLICATION);
            }
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
