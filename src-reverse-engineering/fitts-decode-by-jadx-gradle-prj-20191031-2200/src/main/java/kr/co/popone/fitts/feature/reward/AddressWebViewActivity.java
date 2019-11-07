package kr.co.popone.fitts.feature.reward;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.kakao.message.template.MessageTemplateProtocol;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AddressWebViewActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;

    public static final class Result implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        public static final int RESULT_CODE = 1002;
        @NotNull
        public static final String RESULT_KEY = "result";
        @SerializedName("addr")
        @NotNull
        private final String address;
        @SerializedName("postcode")
        @NotNull
        private final String postCode;
        @SerializedName("zonecode")
        @NotNull
        private final String zoneCode;

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
                return new Result(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        @NotNull
        public static /* synthetic */ Result copy$default(Result result, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.postCode;
            }
            if ((i & 2) != 0) {
                str2 = result.zoneCode;
            }
            if ((i & 4) != 0) {
                str3 = result.address;
            }
            return result.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.postCode;
        }

        @NotNull
        public final String component2() {
            return this.zoneCode;
        }

        @NotNull
        public final String component3() {
            return this.address;
        }

        @NotNull
        public final Result copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "postCode");
            Intrinsics.checkParameterIsNotNull(str2, "zoneCode");
            Intrinsics.checkParameterIsNotNull(str3, MessageTemplateProtocol.ADDRESS);
            return new Result(str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.address, (java.lang.Object) r3.address) != false) goto L_0x0029;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r3) {
            /*
                r2 = this;
                if (r2 == r3) goto L_0x0029
                boolean r0 = r3 instanceof kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result
                if (r0 == 0) goto L_0x0027
                kr.co.popone.fitts.feature.reward.AddressWebViewActivity$Result r3 = (kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result) r3
                java.lang.String r0 = r2.postCode
                java.lang.String r1 = r3.postCode
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r2.zoneCode
                java.lang.String r1 = r3.zoneCode
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r2.address
                java.lang.String r3 = r3.address
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
                if (r3 == 0) goto L_0x0027
                goto L_0x0029
            L_0x0027:
                r3 = 0
                return r3
            L_0x0029:
                r3 = 1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.postCode;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.zoneCode;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.address;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Result(postCode=");
            sb.append(this.postCode);
            sb.append(", zoneCode=");
            sb.append(this.zoneCode);
            sb.append(", address=");
            sb.append(this.address);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.postCode);
            parcel.writeString(this.zoneCode);
            parcel.writeString(this.address);
        }

        public Result(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "postCode");
            Intrinsics.checkParameterIsNotNull(str2, "zoneCode");
            Intrinsics.checkParameterIsNotNull(str3, MessageTemplateProtocol.ADDRESS);
            this.postCode = str;
            this.zoneCode = str2;
            this.address = str3;
        }

        @NotNull
        public final String getPostCode() {
            return this.postCode;
        }

        @NotNull
        public final String getZoneCode() {
            return this.zoneCode;
        }

        @NotNull
        public final String getAddress() {
            return this.address;
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
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_address_web_view);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C0010R$id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator((int) C0008R$drawable.button_black_back);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
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
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).addJavascriptInterface(new AddressWebViewActivity$onCreate$1(this), "fittsWebInterface");
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str);
        webView4.setWebViewClient(new WebViewClient());
        WebView webView5 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView5, str);
        webView5.setWebChromeClient(new AddressWebViewActivity$onCreate$2(this));
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).loadUrl("https://fitts.co.kr/postcode");
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    /* access modifiers changed from: private */
    public final void processPostData(String str) {
        Result result = (Result) new Gson().fromJson(str, Result.class);
        Intent intent = new Intent();
        intent.putExtra("result", result);
        setResult(1002, intent);
        finish();
    }
}
