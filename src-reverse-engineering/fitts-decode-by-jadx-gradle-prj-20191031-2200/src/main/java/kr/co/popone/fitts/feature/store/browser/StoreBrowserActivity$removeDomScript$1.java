package kr.co.popone.fitts.feature.store.browser;

import android.webkit.WebView;
import com.orhanobut.logger.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.Nullable;

final class StoreBrowserActivity$removeDomScript$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$removeDomScript$1(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreBrowserActivity::domScript = javascript:");
        sb.append(str);
        Logger.d(sb.toString(), new Object[0]);
        WebView webView = (WebView) this.this$0._$_findCachedViewById(C0010R$id.storeWebview);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("javascript:");
        sb2.append(str);
        webView.loadUrl(sb2.toString());
    }
}
