package kr.co.popone.fitts.feature.coupon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TermsAgreeWebViewActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public CouponAPI couponAPI;
    /* access modifiers changed from: private */
    public Disposable termsAgreeDisposable;

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PARAMETER_NAME = "parameters";
        private final boolean agreement;
        private final long couponId;
        @NotNull
        private final String url;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readLong(), parcel.readString(), parcel.readInt() != 0);
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parameters.couponId;
            }
            if ((i & 2) != 0) {
                str = parameters.url;
            }
            if ((i & 4) != 0) {
                z = parameters.agreement;
            }
            return parameters.copy(j, str, z);
        }

        public final long component1() {
            return this.couponId;
        }

        @NotNull
        public final String component2() {
            return this.url;
        }

        public final boolean component3() {
            return this.agreement;
        }

        @NotNull
        public final Parameters copy(long j, @NotNull String str, boolean z) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            return new Parameters(j, str, z);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if ((this.couponId == parameters.couponId) && Intrinsics.areEqual((Object) this.url, (Object) parameters.url)) {
                        if (this.agreement == parameters.agreement) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.couponId;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.url;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            boolean z = this.agreement;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(couponId=");
            sb.append(this.couponId);
            sb.append(", url=");
            sb.append(this.url);
            sb.append(", agreement=");
            sb.append(this.agreement);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.couponId);
            parcel.writeString(this.url);
            parcel.writeInt(this.agreement ? 1 : 0);
        }

        public Parameters(long j, @NotNull String str, boolean z) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            this.couponId = j;
            this.url = str;
            this.agreement = z;
        }

        public final boolean getAgreement() {
            return this.agreement;
        }

        public final long getCouponId() {
            return this.couponId;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
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

    @NotNull
    public final CouponAPI getCouponAPI() {
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        return couponAPI2;
    }

    public final void setCouponAPI(@NotNull CouponAPI couponAPI2) {
        Intrinsics.checkParameterIsNotNull(couponAPI2, "<set-?>");
        this.couponAPI = couponAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_terms_agree_webview);
        ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.backButton);
        imageButton.setImageResource(C0008R$drawable.button_cancel);
        imageButton.setOnClickListener(new TermsAgreeWebViewActivity$onCreate$$inlined$apply$lambda$1(this));
        Parameters parameters = (Parameters) getIntent().getParcelableExtra("parameters");
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
        WebSettings settings3 = webView3.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings3, str2);
        settings3.setJavaScriptCanOpenWindowsAutomatically(true);
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str);
        WebSettings settings4 = webView4.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings4, str2);
        settings4.setLoadWithOverviewMode(true);
        WebView webView5 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView5, str);
        WebSettings settings5 = webView5.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings5, str2);
        settings5.setUseWideViewPort(true);
        WebView webView6 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView6, str);
        webView6.setWebViewClient(new WebViewClient());
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).loadUrl(parameters.getUrl());
        boolean agreement = parameters.getAgreement();
        Button button = (Button) _$_findCachedViewById(C0010R$id.termsAgreeButton);
        String str3 = "termsAgreeButton";
        Intrinsics.checkExpressionValueIsNotNull(button, str3);
        button.setEnabled(!agreement);
        if (agreement) {
            Button button2 = (Button) _$_findCachedViewById(C0010R$id.termsAgreeButton);
            Intrinsics.checkExpressionValueIsNotNull(button2, str3);
            button2.setText("약관에 동의하셨습니다.");
            ((Button) _$_findCachedViewById(C0010R$id.termsAgreeButton)).setTextSize(0, (float) ViewExtensionsKt.spToPx((Context) this, 17.0f));
        } else {
            Button button3 = (Button) _$_findCachedViewById(C0010R$id.termsAgreeButton);
            Intrinsics.checkExpressionValueIsNotNull(button3, str3);
            button3.setText("약관에 동의합니다.");
            ((Button) _$_findCachedViewById(C0010R$id.termsAgreeButton)).setTextSize(0, (float) ViewExtensionsKt.spToPx((Context) this, 15.0f));
        }
        Button button4 = (Button) _$_findCachedViewById(C0010R$id.termsAgreeButton);
        Intrinsics.checkExpressionValueIsNotNull(button4, str3);
        button4.setEnabled(!parameters.getAgreement());
        ((Button) _$_findCachedViewById(C0010R$id.termsAgreeButton)).setOnClickListener(new TermsAgreeWebViewActivity$onCreate$3(this, parameters));
    }

    public void onBackPressed() {
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.termsAgreeDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
