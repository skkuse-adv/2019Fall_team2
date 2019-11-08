package kr.co.popone.fitts.feature.identification.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.SessionManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IdentificationWebViewFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    public SessionManager sessionManager;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IdentificationWebViewFragment newInstance() {
            return new IdentificationWebViewFragment();
        }
    }

    @NotNull
    public static final IdentificationWebViewFragment newInstance() {
        return Companion.newInstance();
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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final SessionManager getSessionManager$app_productionFittsRelease() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager$app_productionFittsRelease(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_identification_web_view, viewGroup, false);
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.backButton);
        imageButton.setImageResource(C0008R$drawable.button_cancel);
        imageButton.setOnClickListener(IdentificationWebViewFragment$onViewCreated$1$1.INSTANCE);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText("본인인증");
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webView);
        String str = "webView";
        Intrinsics.checkExpressionValueIsNotNull(webView, str);
        WebSettings settings = webView.getSettings();
        String str2 = "webView.settings";
        Intrinsics.checkExpressionValueIsNotNull(settings, str2);
        settings.setJavaScriptEnabled(true);
        WebView webView2 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView2, str);
        WebSettings settings2 = webView2.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, str2);
        settings2.setDomStorageEnabled(true);
        WebView webView3 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView3, str);
        webView3.setWebViewClient(new IdentificationWebViewFragment$onViewCreated$2(this));
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str);
        webView4.setWebChromeClient(new IdentificationWebViewFragment$onViewCreated$3(this));
        WebView webView5 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        StringBuilder sb = new StringBuilder();
        sb.append("https://fitts.co.kr//ivs?fittsid=");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sb.append(sessionManager2.getFittsID());
        webView5.loadUrl(sb.toString());
    }
}
