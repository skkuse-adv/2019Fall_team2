package kr.co.popone.fitts.feature.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ShopWebViewActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable linkCopyGuideTimerRequest;
    @NotNull
    public UserAPI userAPI;

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PARAMETER_NAME = "parameters";
        @Nullable
        private final String confirmMessage;
        @Nullable
        private final Integer copyLinkIcon;
        private final boolean isLinkCopyEnabled;
        @Nullable
        private final String linkCopyMessage;
        @Nullable
        private final String linkCopyTitle;
        @Nullable
        private final String title;
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
                Parameters parameters = new Parameters(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString());
                return parameters;
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, String str, String str2, boolean z, String str3, Integer num, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parameters.url;
            }
            if ((i & 2) != 0) {
                str2 = parameters.title;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                z = parameters.isLinkCopyEnabled;
            }
            boolean z2 = z;
            if ((i & 8) != 0) {
                str3 = parameters.confirmMessage;
            }
            String str7 = str3;
            if ((i & 16) != 0) {
                num = parameters.copyLinkIcon;
            }
            Integer num2 = num;
            if ((i & 32) != 0) {
                str4 = parameters.linkCopyTitle;
            }
            String str8 = str4;
            if ((i & 64) != 0) {
                str5 = parameters.linkCopyMessage;
            }
            return parameters.copy(str, str6, z2, str7, num2, str8, str5);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @Nullable
        public final String component2() {
            return this.title;
        }

        public final boolean component3() {
            return this.isLinkCopyEnabled;
        }

        @Nullable
        public final String component4() {
            return this.confirmMessage;
        }

        @Nullable
        public final Integer component5() {
            return this.copyLinkIcon;
        }

        @Nullable
        public final String component6() {
            return this.linkCopyTitle;
        }

        @Nullable
        public final String component7() {
            return this.linkCopyMessage;
        }

        @NotNull
        public final Parameters copy(@NotNull String str, @Nullable String str2, boolean z, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5) {
            String str6 = str;
            Intrinsics.checkParameterIsNotNull(str, "url");
            Parameters parameters = new Parameters(str6, str2, z, str3, num, str4, str5);
            return parameters;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (Intrinsics.areEqual((Object) this.url, (Object) parameters.url) && Intrinsics.areEqual((Object) this.title, (Object) parameters.title)) {
                        if (!(this.isLinkCopyEnabled == parameters.isLinkCopyEnabled) || !Intrinsics.areEqual((Object) this.confirmMessage, (Object) parameters.confirmMessage) || !Intrinsics.areEqual((Object) this.copyLinkIcon, (Object) parameters.copyLinkIcon) || !Intrinsics.areEqual((Object) this.linkCopyTitle, (Object) parameters.linkCopyTitle) || !Intrinsics.areEqual((Object) this.linkCopyMessage, (Object) parameters.linkCopyMessage)) {
                            return false;
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
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z = this.isLinkCopyEnabled;
            if (z) {
                z = true;
            }
            int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
            String str3 = this.confirmMessage;
            int hashCode3 = (i2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Integer num = this.copyLinkIcon;
            int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            String str4 = this.linkCopyTitle;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.linkCopyMessage;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode5 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(url=");
            sb.append(this.url);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", isLinkCopyEnabled=");
            sb.append(this.isLinkCopyEnabled);
            sb.append(", confirmMessage=");
            sb.append(this.confirmMessage);
            sb.append(", copyLinkIcon=");
            sb.append(this.copyLinkIcon);
            sb.append(", linkCopyTitle=");
            sb.append(this.linkCopyTitle);
            sb.append(", linkCopyMessage=");
            sb.append(this.linkCopyMessage);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            int i2;
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.url);
            parcel.writeString(this.title);
            parcel.writeInt(this.isLinkCopyEnabled ? 1 : 0);
            parcel.writeString(this.confirmMessage);
            Integer num = this.copyLinkIcon;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.linkCopyTitle);
            parcel.writeString(this.linkCopyMessage);
        }

        public Parameters(@NotNull String str, @Nullable String str2, boolean z, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            this.url = str;
            this.title = str2;
            this.isLinkCopyEnabled = z;
            this.confirmMessage = str3;
            this.copyLinkIcon = num;
            this.linkCopyTitle = str4;
            this.linkCopyMessage = str5;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public final boolean isLinkCopyEnabled() {
            return this.isLinkCopyEnabled;
        }

        @Nullable
        public final String getConfirmMessage() {
            return this.confirmMessage;
        }

        @Nullable
        public final Integer getCopyLinkIcon() {
            return this.copyLinkIcon;
        }

        @Nullable
        public final String getLinkCopyTitle() {
            return this.linkCopyTitle;
        }

        public /* synthetic */ Parameters(String str, String str2, boolean z, String str3, Integer num, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
        }

        @Nullable
        public final String getLinkCopyMessage() {
            return this.linkCopyMessage;
        }
    }

    public static final class Result implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        public static final int RESULT_CODE = 1000;
        @NotNull
        public static final String RESULT_KEY = "result";
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
                return new Result(parcel.readString());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Result[i];
            }
        }

        @NotNull
        public static /* synthetic */ Result copy$default(Result result, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = result.url;
            }
            return result.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @NotNull
        public final Result copy(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            return new Result(str);
        }

        public int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1.url, (java.lang.Object) ((kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result) r2).url) != false) goto L_0x0015;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
            /*
                r1 = this;
                if (r1 == r2) goto L_0x0015
                boolean r0 = r2 instanceof kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result
                if (r0 == 0) goto L_0x0013
                kr.co.popone.fitts.feature.search.ShopWebViewActivity$Result r2 = (kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result) r2
                java.lang.String r0 = r1.url
                java.lang.String r2 = r2.url
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
                if (r2 == 0) goto L_0x0013
                goto L_0x0015
            L_0x0013:
                r2 = 0
                return r2
            L_0x0015:
                r2 = 1
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.search.ShopWebViewActivity.Result.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            String str = this.url;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Result(url=");
            sb.append(this.url);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeString(this.url);
        }

        public Result(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            this.url = str;
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
    public final UserAPI getUserAPI$app_productionFittsRelease() {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        return userAPI2;
    }

    public final void setUserAPI$app_productionFittsRelease(@NotNull UserAPI userAPI2) {
        Intrinsics.checkParameterIsNotNull(userAPI2, "<set-?>");
        this.userAPI = userAPI2;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_shop_web_view);
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
        webView3.setWebChromeClient(new ShopWebViewActivity$onCreate$1(this));
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str);
        webView4.setWebViewClient(new ShopWebViewActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.errorPageBackButton)).setOnClickListener(new ShopWebViewActivity$onCreate$3(this));
        SpannableString spannableString = new SpannableString(getString(C0016R$string.webactivity_error_message));
        Drawable drawable = ContextCompat.getDrawable(this, C0008R$drawable.webactivity_error_emoji);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(drawable, "ContextCompat.getDrawabl…ebactivity_error_emoji)!!");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new ImageSpan(drawable, 0), spannableString.length() - 1, spannableString.length(), 34);
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.errorMessageTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "errorMessageTextView");
        textView.setText(spannableString);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new ShopWebViewActivity$onCreate$4(this));
        if (parameters.isLinkCopyEnabled()) {
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(C0010R$id.copyLinkButton);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, "copyLinkButton");
            imageButton.setVisibility(0);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C0010R$id.linkCopyGuideLayout);
            Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "linkCopyGuideLayout");
            constraintLayout.setVisibility(0);
            this.linkCopyGuideTimerRequest = Observable.timer(5, TimeUnit.SECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new ShopWebViewActivity$onCreate$5<Object>(this));
        }
        ((ImageButton) _$_findCachedViewById(C0010R$id.copyLinkButton)).setOnClickListener(new ShopWebViewActivity$onCreate$6(this, parameters));
        if (parameters.getCopyLinkIcon() != null) {
            ((ImageButton) _$_findCachedViewById(C0010R$id.copyLinkButton)).setImageResource(parameters.getCopyLinkIcon().intValue());
        }
        if (parameters.getLinkCopyTitle() != null) {
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.linkCopyGuideTitleTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "linkCopyGuideTitleTextView");
            textView2.setText(parameters.getLinkCopyTitle());
        }
        if (parameters.getLinkCopyMessage() != null) {
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.linkCopyGuideBodyTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "linkCopyGuideBodyTextView");
            textView3.setText(parameters.getLinkCopyMessage());
        }
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).loadUrl(parameters.getUrl());
        sendWebLog(parameters.getUrl());
    }

    /* access modifiers changed from: private */
    public final void sendWebLog(String str) {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        userAPI2.sendWebLog(str, "post").subscribeOn(Schedulers.io()).subscribe(ShopWebViewActivity$sendWebLog$1.INSTANCE, ShopWebViewActivity$sendWebLog$2.INSTANCE);
    }

    public void onBackPressed() {
        if (((WebView) _$_findCachedViewById(C0010R$id.webView)).canGoBack()) {
            ((WebView) _$_findCachedViewById(C0010R$id.webView)).goBack();
        } else {
            finish();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.linkCopyGuideTimerRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
