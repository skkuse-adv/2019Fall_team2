package kr.co.popone.fitts.feature.post.upload.create;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0017R$style;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostFirstWriteGuideDialogBuilder {
    public static final PostFirstWriteGuideDialogBuilder INSTANCE = new PostFirstWriteGuideDialogBuilder();

    public interface Listener {
        void onCancel();

        void onConfirm();

        boolean onScheme(@NotNull String str);
    }

    private PostFirstWriteGuideDialogBuilder() {
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void showDialog(@NotNull Activity activity, @Nullable String str, @NotNull Listener listener) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (!activity.isDestroyed()) {
            Dialog dialog = new Dialog(activity, C0017R$style.AppTheme_NoActionBar);
            dialog.setContentView(C0013R$layout.dialog_post_first_write_guide);
            WebView webView = (WebView) dialog.findViewById(C0010R$id.firstPostWebView);
            WebSettings settings = webView.getSettings();
            String str2 = "settings";
            Intrinsics.checkExpressionValueIsNotNull(settings, str2);
            settings.setJavaScriptEnabled(true);
            WebSettings settings2 = webView.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings2, str2);
            settings2.setDomStorageEnabled(true);
            webView.setWebViewClient(new PostFirstWriteGuideDialogBuilder$showDialog$$inlined$apply$lambda$1(listener, str));
            StringBuilder sb = new StringBuilder();
            sb.append("https://fitts.co.kr/posting_guide?fittsid=");
            sb.append(str);
            webView.loadUrl(sb.toString());
            ((TextView) dialog.findViewById(C0010R$id.buttonConfirm)).setOnClickListener(new PostFirstWriteGuideDialogBuilder$showDialog$$inlined$apply$lambda$2(dialog, listener, str));
            Window window = dialog.getWindow();
            if (window != null) {
                LayoutParams attributes = window.getAttributes();
                if (attributes != null) {
                    attributes.windowAnimations = C0017R$style.DialogAnimation;
                }
            }
            dialog.show();
        }
    }
}
