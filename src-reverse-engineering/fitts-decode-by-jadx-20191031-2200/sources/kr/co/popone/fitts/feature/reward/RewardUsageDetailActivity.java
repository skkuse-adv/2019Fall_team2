package kr.co.popone.fitts.feature.reward;

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
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.C0016R$string;
import kr.co.popone.fitts.feature.payment.PaymentDataUIExtensionsKt;
import kr.co.popone.fitts.model.datamodel.commerce.PaymentInvoiceResult;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage.Status;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RewardUsageDetailActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final int DATA_CHANGED_RESULT_CODE = 100;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable cancelPaymentUsageRequest;
    @NotNull
    public PaymentAPI paymentAPI;
    /* access modifiers changed from: private */
    public PaymentUsage paymentUsage;
    /* access modifiers changed from: private */
    public long paymentUsageID;
    /* access modifiers changed from: private */
    public Disposable paymentUsageRequest;

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
        private final long rewardUsageID;

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
                j = parameters.rewardUsageID;
            }
            return parameters.copy(j);
        }

        public final long component1() {
            return this.rewardUsageID;
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
                    if (this.rewardUsageID == ((Parameters) obj).rewardUsageID) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.rewardUsageID;
            return (int) (j ^ (j >>> 32));
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(rewardUsageID=");
            sb.append(this.rewardUsageID);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.rewardUsageID);
        }

        public Parameters(long j) {
            this.rewardUsageID = j;
        }

        public final long getRewardUsageID() {
            return this.rewardUsageID;
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
        setContentView((int) C0013R$layout.activity_reward_usage_detail);
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
            supportActionBar3.setHomeAsUpIndicator((int) C0008R$drawable.button_cancel);
        }
        this.paymentUsageID = ((Parameters) getIntent().getParcelableExtra("parameters")).getRewardUsageID();
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout)).setOnRefreshListener(new RewardUsageDetailActivity$onCreate$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.showProductLinkButton)).setOnClickListener(new RewardUsageDetailActivity$onCreate$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.cancelButton)).setOnClickListener(new RewardUsageDetailActivity$onCreate$3(this));
        loadRewardUsage();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_DOWN.getEnter(), ActivityAnimationType.SLIDE_DOWN.getExit());
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
        Disposable disposable = this.paymentUsageRequest;
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
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.swipeRefreshLayout);
        Intrinsics.checkExpressionValueIsNotNull(swipeRefreshLayout, "swipeRefreshLayout");
        swipeRefreshLayout.setRefreshing(this.paymentUsageRequest != null);
        PaymentUsage paymentUsage2 = this.paymentUsage;
        String str = "contentLayout";
        if (this.paymentUsageRequest != null || paymentUsage2 == null) {
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
        String str3 = "netPriceSeparator";
        String str4 = "netPriceTextView";
        String str5 = "netPriceLabel";
        String str6 = null;
        if (i == 1) {
            ((TextView) _$_findCachedViewById(C0010R$id.titleTextView)).setText(C0016R$string.reward_usage_detail_pending_title);
            ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView)).setText(C0016R$string.reward_usage_detail_pending_message);
            ((TextView) _$_findCachedViewById(C0010R$id.detailDescriptionTextView)).setText(C0016R$string.reward_usage_detail_pending_detail_message);
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.netPriceSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str3);
            _$_findCachedViewById.setVisibility(0);
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.netPriceLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView, str5);
            textView.setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.netPriceLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str5);
            textView2.setText("사용예정\n포인트");
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.netPriceTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView3, str4);
            textView3.setVisibility(0);
            TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.netPriceTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView4, str4);
            PaymentUsage paymentUsage3 = this.paymentUsage;
            textView4.setText(paymentUsage3 != null ? IntExtensionsKt.commaString(PaymentDataUIExtensionsKt.totalPrice(paymentUsage3)) : null);
            Button button = (Button) _$_findCachedViewById(C0010R$id.cancelButton);
            Intrinsics.checkExpressionValueIsNotNull(button, str2);
            button.setVisibility(0);
        } else if (i == 2) {
            ((TextView) _$_findCachedViewById(C0010R$id.titleTextView)).setText(C0016R$string.reward_usage_detail_completed_title);
            ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView)).setText(C0016R$string.reward_usage_detail_completed_message);
            ((TextView) _$_findCachedViewById(C0010R$id.detailDescriptionTextView)).setText(C0016R$string.reward_usage_detail_completed_detail_message);
            View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.netPriceSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str3);
            _$_findCachedViewById2.setVisibility(0);
            TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.netPriceLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView5, str5);
            textView5.setVisibility(0);
            TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.netPriceLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView6, str5);
            textView6.setText("사용 핏츠 포인트");
            TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.netPriceTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView7, str4);
            textView7.setVisibility(0);
            TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.netPriceTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView8, str4);
            textView8.setText(IntExtensionsKt.commaString(paymentUsage2.getBalance()));
            Button button2 = (Button) _$_findCachedViewById(C0010R$id.cancelButton);
            Intrinsics.checkExpressionValueIsNotNull(button2, str2);
            button2.setVisibility(8);
        } else if (i == 3) {
            ((TextView) _$_findCachedViewById(C0010R$id.titleTextView)).setText(C0016R$string.reward_usage_detail_rejected_title);
            ((TextView) _$_findCachedViewById(C0010R$id.descriptionTextView)).setText(C0016R$string.reward_usage_detail_rejected_message);
            TextView textView9 = (TextView) _$_findCachedViewById(C0010R$id.detailDescriptionTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView9, "detailDescriptionTextView");
            textView9.setText(paymentUsage2.getRejectedDescription());
            View _$_findCachedViewById3 = _$_findCachedViewById(C0010R$id.netPriceSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, str3);
            _$_findCachedViewById3.setVisibility(8);
            TextView textView10 = (TextView) _$_findCachedViewById(C0010R$id.netPriceLabel);
            Intrinsics.checkExpressionValueIsNotNull(textView10, str5);
            textView10.setVisibility(8);
            TextView textView11 = (TextView) _$_findCachedViewById(C0010R$id.netPriceTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView11, str4);
            textView11.setVisibility(8);
            Button button3 = (Button) _$_findCachedViewById(C0010R$id.cancelButton);
            Intrinsics.checkExpressionValueIsNotNull(button3, str2);
            button3.setVisibility(8);
        }
        TextView textView12 = (TextView) _$_findCachedViewById(C0010R$id.productOptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView12, "productOptionTextView");
        PaymentUsage paymentUsage4 = this.paymentUsage;
        textView12.setText(paymentUsage4 != null ? PaymentDataUIExtensionsKt.productOption(paymentUsage4) : null);
        TextView textView13 = (TextView) _$_findCachedViewById(C0010R$id.productPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView13, "productPriceTextView");
        PaymentUsage paymentUsage5 = this.paymentUsage;
        textView13.setText(paymentUsage5 != null ? IntExtensionsKt.commaString(paymentUsage5.getPrice()) : null);
        TextView textView14 = (TextView) _$_findCachedViewById(C0010R$id.shippingFeeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView14, "shippingFeeTextView");
        PaymentUsage paymentUsage6 = this.paymentUsage;
        textView14.setText(paymentUsage6 != null ? IntExtensionsKt.commaString(paymentUsage6.getShippingPrice()) : null);
        TextView textView15 = (TextView) _$_findCachedViewById(C0010R$id.overallPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView15, "overallPriceTextView");
        PaymentUsage paymentUsage7 = this.paymentUsage;
        textView15.setText(paymentUsage7 != null ? IntExtensionsKt.commaString(PaymentDataUIExtensionsKt.totalPrice(paymentUsage7)) : null);
        TextView textView16 = (TextView) _$_findCachedViewById(C0010R$id.nameTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView16, "nameTextView");
        PaymentUsage paymentUsage8 = this.paymentUsage;
        textView16.setText(paymentUsage8 != null ? paymentUsage8.getShippingName() : null);
        TextView textView17 = (TextView) _$_findCachedViewById(C0010R$id.phoneNumberTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView17, "phoneNumberTextView");
        PaymentUsage paymentUsage9 = this.paymentUsage;
        textView17.setText(paymentUsage9 != null ? paymentUsage9.getShippingContact() : null);
        TextView textView18 = (TextView) _$_findCachedViewById(C0010R$id.shippingAddressTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView18, "shippingAddressTextView");
        PaymentUsage paymentUsage10 = this.paymentUsage;
        textView18.setText(paymentUsage10 != null ? PaymentDataUIExtensionsKt.compositeShippingAddress(paymentUsage10) : null);
        PaymentUsage paymentUsage11 = this.paymentUsage;
        if (paymentUsage11 != null) {
            str6 = paymentUsage11.getShippingMessage();
        }
        if (str6 == null) {
            str6 = "";
        }
        TextView textView19 = (TextView) _$_findCachedViewById(C0010R$id.shippingMemoTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView19, "shippingMemoTextView");
        if (!(!StringsKt__StringsJVMKt.isBlank(str6))) {
            str6 = "-";
        }
        textView19.setText(str6);
    }

    /* access modifiers changed from: private */
    public final void loadRewardUsage() {
        Disposable disposable = this.paymentUsageRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        PaymentAPI paymentAPI2 = this.paymentAPI;
        if (paymentAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentAPI");
        }
        this.paymentUsageRequest = paymentAPI2.requestPaymentInvoice(this.paymentUsageID).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new RewardUsageDetailActivity$loadRewardUsage$1<Object,Object>(this));
        updateUI();
    }
}
