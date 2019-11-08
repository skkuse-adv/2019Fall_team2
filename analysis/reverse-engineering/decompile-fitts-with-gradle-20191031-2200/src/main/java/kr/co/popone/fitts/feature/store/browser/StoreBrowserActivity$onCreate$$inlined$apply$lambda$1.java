package kr.co.popone.fitts.feature.store.browser;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.widget.ContentLoadingProgressBar;
import com.orhanobut.logger.Logger;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserViewModel;
import org.jetbrains.annotations.Nullable;

public final class StoreBrowserActivity$onCreate$$inlined$apply$lambda$1 extends WebChromeClient {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$$inlined$apply$lambda$1(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public void onProgressChanged(@Nullable WebView webView, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreBrowserActivity::onProgressChanged url = ");
        sb.append(webView != null ? webView.getUrl() : null);
        String sb2 = sb.toString();
        boolean z = false;
        Logger.d(sb2, new Object[0]);
        this.this$0.getViewModel().updateWebPageLoadingProgress(i);
        StoreBrowserViewModel viewModel = this.this$0.getViewModel();
        if (i >= 100) {
            z = true;
        }
        viewModel.isWebpageLoaded(z);
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.contentLoadingProgressBar);
        Intrinsics.checkExpressionValueIsNotNull(contentLoadingProgressBar, "contentLoadingProgressBar");
        contentLoadingProgressBar.setProgress(i);
    }

    public boolean onCreateWindow(@Nullable WebView webView, boolean z, boolean z2, @Nullable Message message) {
        Logger.d("StoreBrowserActivity, onCreateWindow", new Object[0]);
        return super.onCreateWindow(webView, z, z2, message);
    }
}
