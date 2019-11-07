package kr.co.popone.fitts.feature.coupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.feature.payment.PaymentDataUIExtensionsKt;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.PaymentInvoiceResult;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage.Status;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponUsageDetailActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final int DATA_CHANGED_RESULT_CODE = 100;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable cancelCouponUsageRequest;
    @NotNull
    public CouponAPI couponAPI;
    /* access modifiers changed from: private */
    public long couponUsageID;
    /* access modifiers changed from: private */
    public Disposable couponUsageRequest;
    @NotNull
    public PaymentAPI paymentAPI;
    /* access modifiers changed from: private */
    public PaymentUsage paymentUsage;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class Parameters implements Parcelable {
        public static final android.os.Parcelable.Creator CREATOR = new Creator();
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PARAMETER_NAME = "parameters";
        private final long couponUsageID;

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
                return new Parameters(parcel.readLong());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = parameters.couponUsageID;
            }
            return parameters.copy(j);
        }

        public final long component1() {
            return this.couponUsageID;
        }

        @NotNull
        public final Parameters copy(long j) {
            return new Parameters(j);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (this.couponUsageID == ((Parameters) obj).couponUsageID) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.couponUsageID;
            return (int) (j ^ (j >>> 32));
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(couponUsageID=");
            sb.append(this.couponUsageID);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.couponUsageID);
        }

        public Parameters(long j) {
            this.couponUsageID = j;
        }

        public final long getCouponUsageID() {
            return this.couponUsageID;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.PENDING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.COMPLETED.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.REJECTED.ordinal()] = 3;
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
    public final CouponAPI getCouponAPI$app_productionFittsRelease() {
        CouponAPI couponAPI2 = this.couponAPI;
        if (couponAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("couponAPI");
        }
        return couponAPI2;
    }

    public final void setCouponAPI$app_productionFittsRelease(@NotNull CouponAPI couponAPI2) {
        Intrinsics.checkParameterIsNotNull(couponAPI2, "<set-?>");
        this.couponAPI = couponAPI2;
    }

    @NotNull
    public final PaymentAPI getPaymentAPI$app_productionFittsRelease() {
        PaymentAPI paymentAPI2 = this.paymentAPI;
        if (paymentAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentAPI");
        }
        return paymentAPI2;
    }

    public final void setPaymentAPI$app_productionFittsRelease(@NotNull PaymentAPI paymentAPI2) {
        Intrinsics.checkParameterIsNotNull(paymentAPI2, "<set-?>");
        this.paymentAPI = paymentAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_coupon_usage_detail);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C0010R$id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setHomeAsUpIndicator((int) C0008R$drawable.button_black_back);
        }
        this.couponUsageID = ((Parameters) getIntent().getParcelableExtra("parameters")).getCouponUsageID();
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout)).setOnRefreshListener(new CouponUsageDetailActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.showProductLinkButton)).setOnClickListener(new CouponUsageDetailActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.cancelButton)).setOnClickListener(new CouponUsageDetailActivity$onCreate$3(this));
        loadCouponUsage();
    }

    /* access modifiers changed from: private */
    public final String getDialogMessage(CouponInfo couponInfo) {
        return (couponInfo == null || !couponInfo.getExpired()) ? "쿠폰 사용신청을 취소하시겠습니까?" : "쿠폰 사용기간이 만료되어 \n지금 취소하시면 쿠폰을 되돌려 받으실 수 없어요.";
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.couponUsageRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        PaymentUsage paymentUsage2 = this.paymentUsage;
        if (paymentUsage2 != null && paymentUsage2.getStatus() == Status.COMPLETED) {
            Intent intent = new Intent();
            intent.putExtra("result", new PaymentInvoiceResult(true));
            setResult(-1, intent);
        }
        finish();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(this.couponUsageRequest != null);
        PaymentUsage paymentUsage2 = this.paymentUsage;
        String str = "contentLayout";
        if (this.couponUsageRequest != null || paymentUsage2 == null) {
            ScrollView scrollView = (ScrollView) _$_findCachedViewById(C0010R$id.contentLayout);
            Intrinsics.checkExpressionValueIsNotNull(scrollView, str);
            scrollView.setVisibility(4);
            return;
        }
        ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C0010R$id.contentLayout);
        Intrinsics.checkExpressionValueIsNotNull(scrollView2, str);
        scrollView2.setVisibility(0);
        int i = WhenMappings.$EnumSwitchMapping$0[paymentUsage2.getStatus().ordinal()];
        String str2 = "cancelButton";
        if (i == 1) {
            ((TextView) _$_findCachedViewById(C0010R$id.titleTextView)).setText(C0016R$string.coupon_usage_detail_pending_title);
            ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView)).setText(C0016R$string.coupon_usage_detail_pending_message);
            ((TextView) _$_findCachedViewById(C0010R$id.detailDescriptionTextView)).setText(C0016R$string.coupon_usage_detail_pending_detail_message);
            Button button = (Button) _$_findCachedViewById(C0010R$id.cancelButton);
            Intrinsics.checkExpressionValueIsNotNull(button, str2);
            button.setVisibility(0);
        } else if (i == 2) {
            ((TextView) _$_findCachedViewById(C0010R$id.titleTextView)).setText(C0016R$string.coupon_usage_detail_completed_title);
            ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView)).setText(C0016R$string.coupon_usage_detail_completed_message);
            ((TextView) _$_findCachedViewById(C0010R$id.detailDescriptionTextView)).setText(C0016R$string.coupon_usage_detail_completed_detail_message);
            Button button2 = (Button) _$_findCachedViewById(C0010R$id.cancelButton);
            Intrinsics.checkExpressionValueIsNotNull(button2, str2);
            button2.setVisibility(8);
        } else if (i == 3) {
            ((TextView) _$_findCachedViewById(C0010R$id.titleTextView)).setText(C0016R$string.coupon_usage_detail_rejected_title);
            ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView)).setText(C0016R$string.coupon_usage_detail_rejected_message);
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.detailDescriptionTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "detailDescriptionTextView");
            textView.setText(paymentUsage2.getRejectedDescription());
            Button button3 = (Button) _$_findCachedViewById(C0010R$id.cancelButton);
            Intrinsics.checkExpressionValueIsNotNull(button3, str2);
            button3.setVisibility(8);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.productOptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "productOptionTextView");
        PaymentUsage paymentUsage3 = this.paymentUsage;
        String str3 = null;
        textView2.setText(paymentUsage3 != null ? PaymentDataUIExtensionsKt.productOption(paymentUsage3) : null);
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.productPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "productPriceTextView");
        PaymentUsage paymentUsage4 = this.paymentUsage;
        textView3.setText(paymentUsage4 != null ? IntExtensionsKt.commaString(paymentUsage4.getPrice()) : null);
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.shippingFeeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "shippingFeeTextView");
        PaymentUsage paymentUsage5 = this.paymentUsage;
        textView4.setText(paymentUsage5 != null ? IntExtensionsKt.commaString(paymentUsage5.getShippingPrice()) : null);
        TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.overallPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "overallPriceTextView");
        PaymentUsage paymentUsage6 = this.paymentUsage;
        textView5.setText(paymentUsage6 != null ? IntExtensionsKt.commaString(PaymentDataUIExtensionsKt.totalPrice(paymentUsage6)) : null);
        TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.nameTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "nameTextView");
        PaymentUsage paymentUsage7 = this.paymentUsage;
        textView6.setText(paymentUsage7 != null ? paymentUsage7.getShippingName() : null);
        TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.phoneNumberTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "phoneNumberTextView");
        PaymentUsage paymentUsage8 = this.paymentUsage;
        textView7.setText(paymentUsage8 != null ? paymentUsage8.getShippingContact() : null);
        TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.shippingAddressTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "shippingAddressTextView");
        PaymentUsage paymentUsage9 = this.paymentUsage;
        textView8.setText(paymentUsage9 != null ? PaymentDataUIExtensionsKt.compositeShippingAddress(paymentUsage9) : null);
        PaymentUsage paymentUsage10 = this.paymentUsage;
        if (paymentUsage10 != null) {
            str3 = paymentUsage10.getShippingMessage();
        }
        if (str3 == null) {
            str3 = "";
        }
        TextView textView9 = (TextView) _$_findCachedViewById(C0010R$id.shippingMemoTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "shippingMemoTextView");
        if (!(!StringsKt__StringsJVMKt.isBlank(str3))) {
            str3 = "-";
        }
        textView9.setText(str3);
    }

    /* access modifiers changed from: private */
    public final void loadCouponUsage() {
        Disposable disposable = this.couponUsageRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        PaymentAPI paymentAPI2 = this.paymentAPI;
        if (paymentAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentAPI");
        }
        this.couponUsageRequest = paymentAPI2.requestPaymentInvoice(this.couponUsageID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponUsageDetailActivity$loadCouponUsage$1<Object,Object>(this));
        updateUI();
    }
}
