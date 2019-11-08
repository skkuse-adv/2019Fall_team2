package kr.co.popone.fitts.feature.event;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.model.datamodel.commerce.Shop;
import kr.co.popone.fitts.model.event.EventAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EventShopWebActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(EventShopWebActivity.class), "parameters", "getParameters()Lkr/co/popone/fitts/feature/event/EventShopWebActivity$Parameters;"))};
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PARAMETER_NAME = "parameters";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable checkEventAppliability;
    @NotNull
    public EventAPI eventAPI;
    /* access modifiers changed from: private */
    public Disposable linkCopyGuideTimerRequest;
    private final Lazy parameters$delegate = LazyKt__LazyJVMKt.lazy(new EventShopWebActivity$parameters$2(this));
    @NotNull
    public UserAPI userAPI;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        private final long eventID;
        @NotNull
        private final String linkUrl;
        @NotNull
        private final Shop shop;

        public static class Creator implements android.os.Parcelable.Creator {
            @NotNull
            public final Object createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkParameterIsNotNull(parcel, "in");
                return new Parameters(parcel.readLong(), parcel.readString(), (Shop) Shop.CREATOR.createFromParcel(parcel));
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, String str, Shop shop2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parameters.eventID;
            }
            if ((i & 2) != 0) {
                str = parameters.linkUrl;
            }
            if ((i & 4) != 0) {
                shop2 = parameters.shop;
            }
            return parameters.copy(j, str, shop2);
        }

        public final long component1() {
            return this.eventID;
        }

        @NotNull
        public final String component2() {
            return this.linkUrl;
        }

        @NotNull
        public final Shop component3() {
            return this.shop;
        }

        @NotNull
        public final Parameters copy(long j, @NotNull String str, @NotNull Shop shop2) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrl");
            Intrinsics.checkParameterIsNotNull(shop2, "shop");
            return new Parameters(j, str, shop2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (!(this.eventID == parameters.eventID) || !Intrinsics.areEqual((Object) this.linkUrl, (Object) parameters.linkUrl) || !Intrinsics.areEqual((Object) this.shop, (Object) parameters.shop)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.eventID;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.linkUrl;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Shop shop2 = this.shop;
            if (shop2 != null) {
                i2 = shop2.hashCode();
            }
            return hashCode + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(eventID=");
            sb.append(this.eventID);
            sb.append(", linkUrl=");
            sb.append(this.linkUrl);
            sb.append(", shop=");
            sb.append(this.shop);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.eventID);
            parcel.writeString(this.linkUrl);
            this.shop.writeToParcel(parcel, 0);
        }

        public Parameters(long j, @NotNull String str, @NotNull Shop shop2) {
            Intrinsics.checkParameterIsNotNull(str, "linkUrl");
            Intrinsics.checkParameterIsNotNull(shop2, "shop");
            this.eventID = j;
            this.linkUrl = str;
            this.shop = shop2;
        }

        public final long getEventID() {
            return this.eventID;
        }

        @NotNull
        public final String getLinkUrl() {
            return this.linkUrl;
        }

        @NotNull
        public final Shop getShop() {
            return this.shop;
        }
    }

    /* access modifiers changed from: private */
    public final Parameters getParameters() {
        Lazy lazy = this.parameters$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (Parameters) lazy.getValue();
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
    public final EventAPI getEventAPI$app_productionFittsRelease() {
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        return eventAPI2;
    }

    public final void setEventAPI$app_productionFittsRelease(@NotNull EventAPI eventAPI2) {
        Intrinsics.checkParameterIsNotNull(eventAPI2, "<set-?>");
        this.eventAPI = eventAPI2;
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
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C0013R$layout.activity_event_shop_web);
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
        webView3.setWebChromeClient(new EventShopWebActivity$onCreate$1(this));
        WebView webView4 = (WebView) _$_findCachedViewById(C0010R$id.webView);
        Intrinsics.checkExpressionValueIsNotNull(webView4, str);
        webView4.setWebViewClient(new EventShopWebActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.errorPageBackButton)).setOnClickListener(new EventShopWebActivity$onCreate$3(this));
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
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new EventShopWebActivity$onCreate$4(this));
        ((Button) _$_findCachedViewById(C0010R$id.applyButton)).setOnClickListener(new EventShopWebActivity$onCreate$5(this));
        ((WebView) _$_findCachedViewById(C0010R$id.webView)).loadUrl(getParameters().getLinkUrl());
        sendWebLog(getParameters().getLinkUrl());
        EventAPI eventAPI2 = this.eventAPI;
        if (eventAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventAPI");
        }
        this.checkEventAppliability = eventAPI2.requestAppliableEventAppliable(getParameters().getEventID(), Long.valueOf(getParameters().getShop().getId())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new EventShopWebActivity$onCreate$6<Object,Object>(this));
    }

    /* access modifiers changed from: private */
    public final void sendWebLog(String str) {
        UserAPI userAPI2 = this.userAPI;
        if (userAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userAPI");
        }
        userAPI2.sendWebLog(str, NotificationCompat.CATEGORY_EVENT).subscribeOn(Schedulers.io()).subscribe(EventShopWebActivity$sendWebLog$1.INSTANCE, EventShopWebActivity$sendWebLog$2.INSTANCE);
    }

    public void onBackPressed() {
        if (((WebView) _$_findCachedViewById(C0010R$id.webView)).canGoBack()) {
            ((WebView) _$_findCachedViewById(C0010R$id.webView)).goBack();
            return;
        }
        setResult(0);
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.linkCopyGuideTimerRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.checkEventAppliability;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 100) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        setResult(i2);
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
