package kr.co.popone.fitts.feature.identification.view;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.widget.ContentLoadingProgressBar;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.Nullable;

public final class IdentificationWebViewFragment$onViewCreated$3 extends WebChromeClient {
    final /* synthetic */ IdentificationWebViewFragment this$0;

    IdentificationWebViewFragment$onViewCreated$3(IdentificationWebViewFragment identificationWebViewFragment) {
        this.this$0 = identificationWebViewFragment;
    }

    public void onProgressChanged(@Nullable WebView webView, int i) {
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.contentLoadingProgressBar);
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.setProgress(i);
        }
        if (i >= 100) {
            ContentLoadingProgressBar contentLoadingProgressBar2 = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.contentLoadingProgressBar);
            if (contentLoadingProgressBar2 != null) {
                contentLoadingProgressBar2.setVisibility(4);
                return;
            }
            return;
        }
        ContentLoadingProgressBar contentLoadingProgressBar3 = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C0010R$id.contentLoadingProgressBar);
        if (contentLoadingProgressBar3 != null) {
            contentLoadingProgressBar3.setVisibility(0);
        }
    }
}
