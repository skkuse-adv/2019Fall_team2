package kr.co.popone.fitts.feature.reward;

import android.webkit.JavascriptInterface;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AddressWebViewActivity$onCreate$1 {
    final /* synthetic */ AddressWebViewActivity this$0;

    AddressWebViewActivity$onCreate$1(AddressWebViewActivity addressWebViewActivity) {
        this.this$0 = addressWebViewActivity;
    }

    @JavascriptInterface
    public final void onComplete(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "postData");
        StringBuilder sb = new StringBuilder();
        sb.append("postData : (");
        sb.append(str);
        sb.append(')');
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.processPostData(str);
    }
}
