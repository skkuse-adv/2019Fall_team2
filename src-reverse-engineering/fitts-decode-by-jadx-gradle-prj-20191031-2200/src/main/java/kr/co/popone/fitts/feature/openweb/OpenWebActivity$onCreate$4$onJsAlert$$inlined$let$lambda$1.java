package kr.co.popone.fitts.feature.openweb;

import android.webkit.JsResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class OpenWebActivity$onCreate$4$onJsAlert$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsResult $result$inlined;

    OpenWebActivity$onCreate$4$onJsAlert$$inlined$let$lambda$1(OpenWebActivity$onCreate$4 openWebActivity$onCreate$4, JsResult jsResult) {
        this.$result$inlined = jsResult;
        super(0);
    }

    public final void invoke() {
        JsResult jsResult = this.$result$inlined;
        if (jsResult != null) {
            jsResult.confirm();
        }
    }
}
