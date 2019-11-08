package kr.co.popone.fitts.feature.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.OrderEvent$OrderCompleteEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity;
import kr.co.popone.fitts.model.domain.payment.PaymentModuleData;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PaymentModuleActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PaymentModuleActivity.class), "URL_KAKAO_RESULT", "getURL_KAKAO_RESULT()Ljava/lang/String;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PaymentModuleActivity.class), "URL_INICIS_RESULT", "getURL_INICIS_RESULT()Ljava/lang/String;"))};
    public static final Companion Companion = new Companion(null);
    private final Lazy URL_INICIS_RESULT$delegate = LazyKt__LazyJVMKt.lazy(PaymentModuleActivity$URL_INICIS_RESULT$2.INSTANCE);
    private final Lazy URL_KAKAO_RESULT$delegate = LazyKt__LazyJVMKt.lazy(PaymentModuleActivity$URL_KAKAO_RESULT$2.INSTANCE);
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    public PaymentAPI paymentApi;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, PaymentModuleData paymentModuleData, int i, Object obj) {
            if ((i & 2) != 0) {
                paymentModuleData = null;
            }
            companion.start(context, paymentModuleData);
        }

        public final void start(@Nullable Context context, @Nullable PaymentModuleData paymentModuleData) {
            if (context != null) {
                Intent intent = new Intent(context, PaymentModuleActivity.class);
                intent.putExtra("payment_data", paymentModuleData);
                ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
            }
        }
    }

    private final String getURL_INICIS_RESULT() {
        Lazy lazy = this.URL_INICIS_RESULT$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (String) lazy.getValue();
    }

    private final String getURL_KAKAO_RESULT() {
        Lazy lazy = this.URL_KAKAO_RESULT$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (String) lazy.getValue();
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
    public final PaymentAPI getPaymentApi() {
        PaymentAPI paymentAPI = this.paymentApi;
        if (paymentAPI == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentApi");
        }
        return paymentAPI;
    }

    public final void setPaymentApi(@NotNull PaymentAPI paymentAPI) {
        Intrinsics.checkParameterIsNotNull(paymentAPI, "<set-?>");
        this.paymentApi = paymentAPI;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_payment_module);
        ((ImageButton) _$_findCachedViewById(C0010R$id.closeButton)).setOnClickListener(new PaymentModuleActivity$onCreate$1(this));
        WebView webView = (WebView) _$_findCachedViewById(C0010R$id.paymentModuleWebView);
        WebSettings settings = webView.getSettings();
        String str = "settings";
        Intrinsics.checkExpressionValueIsNotNull(settings, str);
        settings.setJavaScriptEnabled(true);
        WebSettings settings2 = webView.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings2, str);
        settings2.setDomStorageEnabled(true);
        if (VERSION.SDK_INT >= 21) {
            WebSettings settings3 = webView.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings3, str);
            settings3.setMixedContentMode(0);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.setAcceptThirdPartyCookies(webView, true);
        }
        webView.setWebViewClient(new PaymentModuleActivity$onCreate$$inlined$apply$lambda$1(this));
        webView.setWebChromeClient(new PaymentModuleActivity$onCreate$2$3());
        CompositeDisposable compositeDisposable = this.disposable;
        Disposable subscribe = RxBus.INSTANCE.toObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new PaymentModuleActivity$onCreate$3<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "RxBus.toObservable()\n   …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        load();
    }

    /* access modifiers changed from: private */
    public final void checkPaymentCompleteUrl(String str) {
        boolean z = false;
        if (str != null ? StringsKt__StringsJVMKt.startsWith$default(str, getURL_KAKAO_RESULT(), false, 2, null) : false) {
            handlePaymentCompleteUrl(str, "kakao_success");
            return;
        }
        if (str != null) {
            z = StringsKt__StringsJVMKt.startsWith$default(str, getURL_INICIS_RESULT(), false, 2, null);
        }
        if (z) {
            handlePaymentCompleteUrl(str, "imp_success");
        }
    }

    private final void handlePaymentCompleteUrl(String str, String str2) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter(str2);
        if (queryParameter != null ? Boolean.parseBoolean(queryParameter) : false) {
            String queryParameter2 = parse.getQueryParameter("order_id");
            Intrinsics.checkExpressionValueIsNotNull(queryParameter2, "uri.getQueryParameter(\"order_id\")");
            startOrderCompleteActivity(Long.parseLong(queryParameter2));
            return;
        }
        showPaymentFailDialog();
    }

    private final void startOrderCompleteActivity(long j) {
        OrderCompleteRenderActivity.Companion.start(this, j);
        RxBus.INSTANCE.post(new OrderEvent$OrderCompleteEvent());
        finish();
    }

    private final void showPaymentFailDialog() {
        DialogExtensions.INSTANCE.showMessageDialog(this, "결제에 실패했어요 😢", "다시 시도해주시기 바랍니다.", new PaymentModuleActivity$showPaymentFailDialog$1(this), "확인");
    }

    /* access modifiers changed from: private */
    public final void showPaymentCancelDialog() {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "결제를 취소하시겠어요?", "확인 시 이전 페이지로 돌아갑니다.", new PaymentModuleActivity$showPaymentCancelDialog$1(this), null, null, null, 0, DimensionsKt.HDPI, null);
    }

    private final void load() {
        PaymentModuleData paymentModuleData = (PaymentModuleData) getIntent().getParcelableExtra("payment_data");
        if (paymentModuleData != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
            textView.setText(Intrinsics.areEqual((Object) paymentModuleData.getType(), (Object) "kakao") ? "카카오페이 결제" : "신용카드 결제");
            PaymentAPI paymentAPI = this.paymentApi;
            if (paymentAPI == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paymentApi");
            }
            String type = paymentModuleData.getType();
            String from = paymentModuleData.getFrom();
            String variantsJson = paymentModuleData.getVariantsJson();
            String buyerName = paymentModuleData.getBuyerName();
            String buyerContact = paymentModuleData.getBuyerContact();
            String buyerEmail = paymentModuleData.getBuyerEmail();
            String shippingName = paymentModuleData.getShippingName();
            String shippingContact = paymentModuleData.getShippingContact();
            String shippingZipCode = paymentModuleData.getShippingZipCode();
            String shippingAddress = paymentModuleData.getShippingAddress();
            String shippingAddress2 = paymentModuleData.getShippingAddress2();
            String shippingMessage = paymentModuleData.getShippingMessage();
            String adjustType = paymentModuleData.getAdjustType();
            Integer adjustPrice = paymentModuleData.getAdjustPrice();
            Long couponId = paymentModuleData.getCouponId();
            Long membershipId = paymentModuleData.getMembershipId();
            Long postId = paymentModuleData.getPostId();
            Long eventId = paymentModuleData.getEventId();
            String str = (eventId != null && eventId.longValue() == -1) ? "normal" : "special_discount";
            Long eventId2 = paymentModuleData.getEventId();
            paymentAPI.requestPaymentIamPort(type, from, variantsJson, buyerName, buyerContact, buyerEmail, shippingName, shippingContact, shippingZipCode, shippingAddress, shippingAddress2, shippingMessage, adjustType, adjustPrice, couponId, membershipId, postId, str, (eventId2 != null && eventId2.longValue() == -1) ? null : paymentModuleData.getEventId()).enqueue(new PaymentModuleActivity$load$$inlined$let$lambda$1(this));
        }
    }

    public void onBackPressed() {
        if (((WebView) _$_findCachedViewById(C0010R$id.paymentModuleWebView)).canGoBack()) {
            ((WebView) _$_findCachedViewById(C0010R$id.paymentModuleWebView)).goBack();
        } else {
            showPaymentCancelDialog();
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.disposable.dispose();
        super.onDestroy();
    }
}
