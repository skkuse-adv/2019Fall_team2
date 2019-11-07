package kr.co.popone.fitts.feature;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import org.jetbrains.annotations.Nullable;

public final class WebActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

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
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_web);
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webview);
        String str = "webview";
        Intrinsics.checkExpressionValueIsNotNull(webView, str);
        WebSettings settings = webView.getSettings();
        String str2 = "webview.settings";
        Intrinsics.checkExpressionValueIsNotNull(settings, str2);
        settings.setJavaScriptEnabled(true);
        WebView webView2 = (WebView) _$_findCachedViewById(C0010R$id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView2, str);
        webView2.getSettings().setSupportZoom(true);
        WebView webView3 = (WebView) _$_findCachedViewById(C0010R$id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView3, str);
        WebSettings settings2 = webView3.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, str2);
        settings2.setUseWideViewPort(true);
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str);
        WebSettings settings3 = webView4.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings3, str2);
        settings3.setDomStorageEnabled(true);
        WebView webView5 = (WebView) _$_findCachedViewById(C0010R$id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView5, str);
        webView5.setWebViewClient(new WebActivity$onCreate$1(this));
        WebView webView6 = (WebView) _$_findCachedViewById(C0010R$id.webview);
        Intrinsics.checkExpressionValueIsNotNull(webView6, str);
        webView6.setWebChromeClient(new WebActivity$onCreate$2(this));
        String str3 = "shop_url";
        ((WebView) _$_findCachedViewById(C0010R$id.webview)).loadUrl(getIntent().getStringExtra(str3));
        String str4 = "shop_name";
        String str5 = "titleTextView";
        if (getIntent().getStringExtra(str4) != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.titleTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, str5);
            textView.setText(getIntent().getStringExtra(str4));
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.titleTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str5);
            textView2.setText(getIntent().getStringExtra(str3));
        }
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new WebActivity$onCreate$3(this));
        ((Button) _$_findCachedViewById(C0010R$id.errorPageBackButton)).setOnClickListener(new WebActivity$onCreate$4(this));
        SpannableString spannableString = new SpannableString(getString(C0016R$string.webactivity_error_message));
        Drawable drawable = ContextCompat.getDrawable(this, C0008R$drawable.webactivity_error_emoji);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(drawable, "ContextCompat.getDrawabl…ebactivity_error_emoji)!!");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new ImageSpan(drawable, 0), spannableString.length() - 1, spannableString.length(), 34);
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.errorMessageTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "errorMessageTextView");
        textView3.setText(spannableString);
    }

    public boolean onKeyDown(int i, @Nullable KeyEvent keyEvent) {
        if (i != 4 || !((WebView) _$_findCachedViewById(C0010R$id.webview)).canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        ((WebView) _$_findCachedViewById(C0010R$id.webview)).goBack();
        return true;
    }
}
