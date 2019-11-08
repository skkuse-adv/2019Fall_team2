package kr.co.popone.fitts.feature.openweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OpenWebActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_NAME = "parameters";
    private HashMap _$_findViewCache;
    @NotNull
    public EventTracker eventTracker;
    @NotNull
    public FittsSchemeHandler fittsSchemeHandler;
    /* access modifiers changed from: private */
    public Parameters parameters;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        private final boolean hasNavigation;
        private final boolean hasToolbar;
        private final boolean isModal;
        @Nullable
        private final String title;
        @NotNull
        private final String url;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                Parameters parameters = new Parameters(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0);
                return parameters;
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, String str, boolean z, boolean z2, String str2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parameters.url;
            }
            if ((i & 2) != 0) {
                z = parameters.hasNavigation;
            }
            boolean z4 = z;
            if ((i & 4) != 0) {
                z2 = parameters.hasToolbar;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                str2 = parameters.title;
            }
            String str3 = str2;
            if ((i & 16) != 0) {
                z3 = parameters.isModal;
            }
            return parameters.copy(str, z4, z5, str3, z3);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        public final boolean component2() {
            return this.hasNavigation;
        }

        public final boolean component3() {
            return this.hasToolbar;
        }

        @Nullable
        public final String component4() {
            return this.title;
        }

        public final boolean component5() {
            return this.isModal;
        }

        @NotNull
        public final Parameters copy(@NotNull String str, boolean z, boolean z2, @Nullable String str2, boolean z3) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            Parameters parameters = new Parameters(str, z, z2, str2, z3);
            return parameters;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (Intrinsics.areEqual((Object) this.url, (Object) parameters.url)) {
                        if (this.hasNavigation == parameters.hasNavigation) {
                            if ((this.hasToolbar == parameters.hasToolbar) && Intrinsics.areEqual((Object) this.title, (Object) parameters.title)) {
                                if (this.isModal == parameters.isModal) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String str = this.url;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.hasNavigation;
            if (z) {
                z = true;
            }
            int i2 = (hashCode + (z ? 1 : 0)) * 31;
            boolean z2 = this.hasToolbar;
            if (z2) {
                z2 = true;
            }
            int i3 = (i2 + (z2 ? 1 : 0)) * 31;
            String str2 = this.title;
            if (str2 != null) {
                i = str2.hashCode();
            }
            int i4 = (i3 + i) * 31;
            boolean z3 = this.isModal;
            if (z3) {
                z3 = true;
            }
            return i4 + (z3 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(url=");
            sb.append(this.url);
            sb.append(", hasNavigation=");
            sb.append(this.hasNavigation);
            sb.append(", hasToolbar=");
            sb.append(this.hasToolbar);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", isModal=");
            sb.append(this.isModal);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.url);
            parcel.writeInt(this.hasNavigation ? 1 : 0);
            parcel.writeInt(this.hasToolbar ? 1 : 0);
            parcel.writeString(this.title);
            parcel.writeInt(this.isModal ? 1 : 0);
        }

        public Parameters(@NotNull String str, boolean z, boolean z2, @Nullable String str2, boolean z3) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            this.url = str;
            this.hasNavigation = z;
            this.hasToolbar = z2;
            this.title = str2;
            this.isModal = z3;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final boolean getHasNavigation() {
            return this.hasNavigation;
        }

        public final boolean getHasToolbar() {
            return this.hasToolbar;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public /* synthetic */ Parameters(String str, boolean z, boolean z2, String str2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, z2, str2, (i & 16) != 0 ? false : z3);
        }

        public final boolean isModal() {
            return this.isModal;
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

    public static final /* synthetic */ Parameters access$getParameters$p(OpenWebActivity openWebActivity) {
        Parameters parameters2 = openWebActivity.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameters");
        }
        return parameters2;
    }

    @NotNull
    public final FittsSchemeHandler getFittsSchemeHandler$app_productionFittsRelease() {
        FittsSchemeHandler fittsSchemeHandler2 = this.fittsSchemeHandler;
        if (fittsSchemeHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fittsSchemeHandler");
        }
        return fittsSchemeHandler2;
    }

    public final void setFittsSchemeHandler$app_productionFittsRelease(@NotNull FittsSchemeHandler fittsSchemeHandler2) {
        Intrinsics.checkParameterIsNotNull(fittsSchemeHandler2, "<set-?>");
        this.fittsSchemeHandler = fittsSchemeHandler2;
    }

    @NotNull
    public final EventTracker getEventTracker$app_productionFittsRelease() {
        EventTracker eventTracker2 = this.eventTracker;
        if (eventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return eventTracker2;
    }

    public final void setEventTracker$app_productionFittsRelease(@NotNull EventTracker eventTracker2) {
        Intrinsics.checkParameterIsNotNull(eventTracker2, "<set-?>");
        this.eventTracker = eventTracker2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_open_web);
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OpenWebActivity$onCreate$1(this));
        String str = "parameters";
        Parcelable parcelableExtra = getIntent().getParcelableExtra(str);
        Intrinsics.checkExpressionValueIsNotNull(parcelableExtra, "intent.getParcelableExtra(PARAMETER_NAME)");
        this.parameters = (Parameters) parcelableExtra;
        Parameters parameters2 = this.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        if (parameters2.isModal()) {
            ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        }
        Parameters parameters3 = this.parameters;
        if (parameters3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        String str2 = "webView";
        if (parameters3.getHasToolbar()) {
            ((AppBarLayout) _$_findCachedViewById(C0010R$id.appBar)).setBackgroundColor(ContextCompat.getColor(this, 17170443));
            ((TextView) _$_findCachedViewById(C0010R$id.toolbarTitle)).setTextColor(ContextCompat.getColor(this, 17170444));
            ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setColorFilter(ContextCompat.getColor(this, 17170444));
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone((ConstraintLayout) _$_findCachedViewById(C0010R$id.constraintLayout));
            WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webView);
            Intrinsics.checkExpressionValueIsNotNull(webView, str2);
            int id = webView.getId();
            AppBarLayout appBarLayout = (AppBarLayout) _$_findCachedViewById(C0010R$id.appBar);
            Intrinsics.checkExpressionValueIsNotNull(appBarLayout, "appBar");
            constraintSet.connect(id, 3, appBarLayout.getId(), 4);
            constraintSet.applyTo((ConstraintLayout) _$_findCachedViewById(C0010R$id.constraintLayout));
        }
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        Parameters parameters4 = this.parameters;
        if (parameters4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        textView.setText(parameters4.getTitle());
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.bottomBar);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "bottomBar");
        Parameters parameters5 = this.parameters;
        if (parameters5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        linearLayout.setVisibility(parameters5.getHasNavigation() ? 0 : 8);
        WebView webView2 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView2, str2);
        WebSettings settings = webView2.getSettings();
        String str3 = "webView.settings";
        Intrinsics.checkExpressionValueIsNotNull(settings, str3);
        settings.setJavaScriptEnabled(true);
        WebView webView3 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView3, str2);
        WebSettings settings2 = webView3.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, str3);
        settings2.setUseWideViewPort(true);
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str2);
        WebSettings settings3 = webView4.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings3, str3);
        settings3.setDomStorageEnabled(true);
        WebView webView5 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView5, str2);
        webView5.setWebViewClient(new OpenWebActivity$onCreate$3(this));
        WebView webView6 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView6, str2);
        webView6.setWebChromeClient(new OpenWebActivity$onCreate$4(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.leftNavigationButton)).setOnClickListener(new OpenWebActivity$onCreate$5(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.rightNavigationButton)).setOnClickListener(new OpenWebActivity$onCreate$6(this));
        StringBuilder sb = new StringBuilder();
        sb.append("OpenWebActivity::url=");
        Parameters parameters6 = this.parameters;
        if (parameters6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        sb.append(parameters6.getUrl());
        Logger.d(sb.toString(), new Object[0]);
        WebView webView7 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Parameters parameters7 = this.parameters;
        if (parameters7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        webView7.loadUrl(parameters7.getUrl());
    }

    public void onBackPressed() {
        finish();
        Parameters parameters2 = this.parameters;
        if (parameters2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parameters");
        }
        if (parameters2.isModal()) {
            overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
        } else {
            overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0163  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleScheme(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r10.hashCode()
            r1 = -1348785409(0xffffffffaf9b2aff, float:-2.8224886E-10)
            r2 = 1
            if (r0 == r1) goto L_0x0052
            r1 = 1106709239(0x41f70af7, float:30.880354)
            if (r0 == r1) goto L_0x0039
            r1 = 1740050602(0x67b710aa, float:1.729001E24)
            if (r0 == r1) goto L_0x0015
            goto L_0x006c
        L_0x0015:
            java.lang.String r0 = "https://fitts.co.kr/ivs_fail"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x006c
            kr.co.popone.fitts.ui.DialogExtensions r3 = kr.co.popone.fitts.ui.DialogExtensions.INSTANCE
            r10 = 2131755055(0x7f10002f, float:1.9140978E38)
            java.lang.String r6 = r9.getString(r10)
            java.lang.String r10 = "getString(R.string.auth_fail_msg)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r10)
            kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$2 r7 = new kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$2
            r7.<init>(r9)
            java.lang.String r5 = ""
            java.lang.String r8 = "확인"
            r4 = r9
            r3.showMessageDialog(r4, r5, r6, r7, r8)
            goto L_0x006b
        L_0x0039:
            java.lang.String r0 = "https://fitts.co.kr/ivs_success"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x006c
            kr.co.popone.fitts.feature.openweb.OpenWebActivity$Parameters r10 = r9.parameters
            if (r10 != 0) goto L_0x004a
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L_0x004a:
            java.lang.String r10 = r10.getUrl()
            r9.clearAndReload(r10)
            goto L_0x006b
        L_0x0052:
            java.lang.String r0 = "https://fitts.co.kr/ivs_duplicate"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x006c
            kr.co.popone.fitts.ui.DialogExtensions r3 = kr.co.popone.fitts.ui.DialogExtensions.INSTANCE
            kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$1 r7 = new kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$1
            r7.<init>(r9)
            java.lang.String r5 = "이미 인증된 계정이 있어요"
            java.lang.String r6 = "핏츠는 1인당 1계정만 사용하실 수 있어요! 인증하신 계정을 사용해주시기 바랍니다."
            java.lang.String r8 = "확인"
            r4 = r9
            r3.showMessageDialog(r4, r5, r6, r7, r8)
        L_0x006b:
            return r2
        L_0x006c:
            android.net.Uri r0 = android.net.Uri.parse(r10)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "fitts scheme("
            r1.append(r3)
            java.lang.String r3 = "uri"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r3 = r0.getScheme()
            r1.append(r3)
            java.lang.String r3 = ") host("
            r1.append(r3)
            java.lang.String r3 = r0.getHost()
            r1.append(r3)
            java.lang.String r3 = ") path("
            r1.append(r3)
            java.lang.String r3 = r0.getPath()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.orhanobut.logger.Logger.d(r1, r4)
            java.lang.String r1 = r0.getScheme()
            java.lang.String r4 = "fitts"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 == 0) goto L_0x015f
            java.lang.String r1 = r0.getHost()
            java.lang.String r4 = "web"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 == 0) goto L_0x015f
            java.lang.String r1 = r0.getPath()
            java.lang.String r4 = "/shareLink"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 == 0) goto L_0x015f
            java.lang.String r10 = "url"
            java.lang.String r10 = r0.getQueryParameter(r10)
            if (r10 == 0) goto L_0x015e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "show share UI with "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.orhanobut.logger.Logger.d(r0, r1)
            com.google.android.material.bottomsheet.BottomSheetDialog r0 = new com.google.android.material.bottomsheet.BottomSheetDialog
            r0.<init>(r9)
            r1 = 2131558769(0x7f0d0171, float:1.8742863E38)
            r0.setContentView(r1)
            r1 = 2131362116(0x7f0a0144, float:1.8344003E38)
            android.view.View r1 = r0.findViewById(r1)
            if (r1 != 0) goto L_0x0101
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0101:
            java.lang.String r3 = "dialog.findViewById<View>(R.id.deletePostLayout)!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r3 = 8
            r1.setVisibility(r3)
            r1 = 2131362873(0x7f0a0439, float:1.8345539E38)
            android.view.View r1 = r0.findViewById(r1)
            if (r1 != 0) goto L_0x0117
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0117:
            java.lang.String r4 = "dialog.findViewById<View>(R.id.share_facebook)!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r3)
            r1 = 2131362111(0x7f0a013f, float:1.8343993E38)
            android.view.View r1 = r0.findViewById(r1)
            if (r1 != 0) goto L_0x012b
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x012b:
            java.lang.String r4 = "dialog.findViewById<View>(R.id.declaration_post)!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r3)
            r1 = 2131362877(0x7f0a043d, float:1.8345547E38)
            android.view.View r1 = r0.findViewById(r1)
            if (r1 != 0) goto L_0x013f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x013f:
            kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$3 r3 = new kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$3
            r3.<init>(r9, r10, r0)
            r1.setOnClickListener(r3)
            r1 = 2131362875(0x7f0a043b, float:1.8345543E38)
            android.view.View r1 = r0.findViewById(r1)
            if (r1 != 0) goto L_0x0153
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0153:
            kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$4 r3 = new kr.co.popone.fitts.feature.openweb.OpenWebActivity$handleScheme$4
            r3.<init>(r9, r10, r0)
            r1.setOnClickListener(r3)
            r0.show()
        L_0x015e:
            return r2
        L_0x015f:
            kr.co.popone.fitts.services.FittsSchemeHandler r0 = r9.fittsSchemeHandler
            if (r0 != 0) goto L_0x0168
            java.lang.String r1 = "fittsSchemeHandler"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0168:
            boolean r10 = r0.handleScheme(r9, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.openweb.OpenWebActivity.handleScheme(java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void clearAndReload(String str) {
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webView);
        if (webView != null) {
            webView.clearHistory();
            webView.loadUrl(str);
        }
    }

    private final void clearWebview() {
        try {
            WebView webView = (WebView) _$_findCachedViewById(C0010R$id.webView);
            if (webView != null) {
                webView.clearHistory();
                webView.loadUrl("about:blank");
                webView.destroy();
            }
        } catch (Exception e) {
            Logger.d(String.valueOf(e.getMessage()), new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        clearWebview();
        super.onDestroy();
    }
}
