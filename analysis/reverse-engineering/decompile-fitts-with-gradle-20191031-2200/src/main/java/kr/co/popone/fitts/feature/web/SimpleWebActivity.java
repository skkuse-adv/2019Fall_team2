package kr.co.popone.fitts.feature.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SimpleWebActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String URL_SERVICE_CENTER = "https://static.fitts.co.kr/service_center/service_center.html";
    private HashMap _$_findViewCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, @NotNull String str, @NotNull String str2) {
            String str3 = "url";
            Intrinsics.checkParameterIsNotNull(str, str3);
            String str4 = "title";
            Intrinsics.checkParameterIsNotNull(str2, str4);
            if (context != null) {
                Intent intent = new Intent(context, SimpleWebActivity.class);
                intent.putExtra(str3, str);
                intent.putExtra(str4, str2);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_simple_web);
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webView);
        WebSettings settings = webView.getSettings();
        String str = "settings";
        Intrinsics.checkExpressionValueIsNotNull(settings, str);
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, str);
        settings2.setDomStorageEnabled(true);
        webView.setWebViewClient(new SimpleWebActivity$onCreate$1$1());
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new SimpleWebActivity$onCreate$2(this));
        String stringExtra = getIntent().getStringExtra("title");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText(stringExtra);
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).loadUrl(getIntent().getStringExtra("url"));
    }

    public void onBackPressed() {
        if (((WebView) _$_findCachedViewById(C0010R$id.webView)).canGoBack()) {
            ((WebView) _$_findCachedViewById(C0010R$id.webView)).goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }
}
