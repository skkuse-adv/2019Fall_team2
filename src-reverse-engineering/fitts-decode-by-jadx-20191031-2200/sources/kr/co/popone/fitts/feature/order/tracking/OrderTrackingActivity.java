package kr.co.popone.fitts.feature.order.tracking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderTrackingActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_TRAKING_URL = StringKeyGenerator.Companion.generate(OrderDetailActivity.class, "tracking");
    private HashMap _$_findViewCache;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@Nullable Context context, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            if (context != null) {
                Intent intent = new Intent(context, OrderTrackingActivity.class);
                intent.putExtra(OrderTrackingActivity.KEY_ORDER_TRAKING_URL, str);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    public static final void start(@Nullable Context context, @NotNull String str) {
        Companion.start(context, str);
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
        setContentView((int) C0013R$layout.activity_order_tracking);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new OrderTrackingActivity$onCreate$1(this));
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webView);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "settings");
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new OrderTrackingActivity$onCreate$2$1());
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).loadUrl(getIntent().getStringExtra(KEY_ORDER_TRAKING_URL));
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }
}
