package kr.co.popone.fitts.feature.coupon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.payment.PaymentAPI;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponUseConfirmActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final int SUCCESS_RESULT_CODE = 1010;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Disposable couponEnrollDisposable;
    @NotNull
    public PaymentAPI paymentAPI;

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
        public static final String PARAMETER_NAME = "paremeters";
        private final long couponId;
        @NotNull
        private final String productColor;
        private final int productPrice;
        @NotNull
        private final String productSize;
        @NotNull
        private final String productUrl;
        @NotNull
        private final String shippingAddress1;
        @NotNull
        private final String shippingAddress2;
        @NotNull
        private final String shippingContact;
        private final int shippingFee;
        @NotNull
        private final String shippingMemo;
        @NotNull
        private final String shippingName;
        @NotNull
        private final String shippingZipCode;

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
                Parameters parameters = new Parameters(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                return parameters;
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7, String str8, String str9, int i3, Object obj) {
            Parameters parameters2 = parameters;
            int i4 = i3;
            return parameters.copy((i4 & 1) != 0 ? parameters2.couponId : j, (i4 & 2) != 0 ? parameters2.productUrl : str, (i4 & 4) != 0 ? parameters2.productColor : str2, (i4 & 8) != 0 ? parameters2.productSize : str3, (i4 & 16) != 0 ? parameters2.productPrice : i, (i4 & 32) != 0 ? parameters2.shippingFee : i2, (i4 & 64) != 0 ? parameters2.shippingName : str4, (i4 & 128) != 0 ? parameters2.shippingContact : str5, (i4 & 256) != 0 ? parameters2.shippingZipCode : str6, (i4 & 512) != 0 ? parameters2.shippingAddress1 : str7, (i4 & 1024) != 0 ? parameters2.shippingAddress2 : str8, (i4 & 2048) != 0 ? parameters2.shippingMemo : str9);
        }

        public final long component1() {
            return this.couponId;
        }

        @NotNull
        public final String component10() {
            return this.shippingAddress1;
        }

        @NotNull
        public final String component11() {
            return this.shippingAddress2;
        }

        @NotNull
        public final String component12() {
            return this.shippingMemo;
        }

        @NotNull
        public final String component2() {
            return this.productUrl;
        }

        @NotNull
        public final String component3() {
            return this.productColor;
        }

        @NotNull
        public final String component4() {
            return this.productSize;
        }

        public final int component5() {
            return this.productPrice;
        }

        public final int component6() {
            return this.shippingFee;
        }

        @NotNull
        public final String component7() {
            return this.shippingName;
        }

        @NotNull
        public final String component8() {
            return this.shippingContact;
        }

        @NotNull
        public final String component9() {
            return this.shippingZipCode;
        }

        @NotNull
        public final Parameters copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            String str10 = str;
            Intrinsics.checkParameterIsNotNull(str10, "productUrl");
            String str11 = str2;
            Intrinsics.checkParameterIsNotNull(str11, "productColor");
            String str12 = str3;
            Intrinsics.checkParameterIsNotNull(str12, "productSize");
            String str13 = str4;
            Intrinsics.checkParameterIsNotNull(str13, "shippingName");
            String str14 = str5;
            Intrinsics.checkParameterIsNotNull(str14, "shippingContact");
            String str15 = str6;
            Intrinsics.checkParameterIsNotNull(str15, "shippingZipCode");
            String str16 = str7;
            Intrinsics.checkParameterIsNotNull(str16, "shippingAddress1");
            String str17 = str8;
            Intrinsics.checkParameterIsNotNull(str17, "shippingAddress2");
            String str18 = str9;
            Intrinsics.checkParameterIsNotNull(str18, "shippingMemo");
            Parameters parameters = new Parameters(j, str10, str11, str12, i, i2, str13, str14, str15, str16, str17, str18);
            return parameters;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if ((this.couponId == parameters.couponId) && Intrinsics.areEqual((Object) this.productUrl, (Object) parameters.productUrl) && Intrinsics.areEqual((Object) this.productColor, (Object) parameters.productColor) && Intrinsics.areEqual((Object) this.productSize, (Object) parameters.productSize)) {
                        if (this.productPrice == parameters.productPrice) {
                            if (!(this.shippingFee == parameters.shippingFee) || !Intrinsics.areEqual((Object) this.shippingName, (Object) parameters.shippingName) || !Intrinsics.areEqual((Object) this.shippingContact, (Object) parameters.shippingContact) || !Intrinsics.areEqual((Object) this.shippingZipCode, (Object) parameters.shippingZipCode) || !Intrinsics.areEqual((Object) this.shippingAddress1, (Object) parameters.shippingAddress1) || !Intrinsics.areEqual((Object) this.shippingAddress2, (Object) parameters.shippingAddress2) || !Intrinsics.areEqual((Object) this.shippingMemo, (Object) parameters.shippingMemo)) {
                                return false;
                            }
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
            String str = this.productUrl;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.productColor;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.productSize;
            int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.productPrice) * 31) + this.shippingFee) * 31;
            String str4 = this.shippingName;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.shippingContact;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.shippingZipCode;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.shippingAddress1;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.shippingAddress2;
            int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.shippingMemo;
            if (str9 != null) {
                i2 = str9.hashCode();
            }
            return hashCode8 + i2;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(couponId=");
            sb.append(this.couponId);
            sb.append(", productUrl=");
            sb.append(this.productUrl);
            sb.append(", productColor=");
            sb.append(this.productColor);
            sb.append(", productSize=");
            sb.append(this.productSize);
            sb.append(", productPrice=");
            sb.append(this.productPrice);
            sb.append(", shippingFee=");
            sb.append(this.shippingFee);
            sb.append(", shippingName=");
            sb.append(this.shippingName);
            sb.append(", shippingContact=");
            sb.append(this.shippingContact);
            sb.append(", shippingZipCode=");
            sb.append(this.shippingZipCode);
            sb.append(", shippingAddress1=");
            sb.append(this.shippingAddress1);
            sb.append(", shippingAddress2=");
            sb.append(this.shippingAddress2);
            sb.append(", shippingMemo=");
            sb.append(this.shippingMemo);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.couponId);
            parcel.writeString(this.productUrl);
            parcel.writeString(this.productColor);
            parcel.writeString(this.productSize);
            parcel.writeInt(this.productPrice);
            parcel.writeInt(this.shippingFee);
            parcel.writeString(this.shippingName);
            parcel.writeString(this.shippingContact);
            parcel.writeString(this.shippingZipCode);
            parcel.writeString(this.shippingAddress1);
            parcel.writeString(this.shippingAddress2);
            parcel.writeString(this.shippingMemo);
        }

        public Parameters(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, int i, int i2, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9) {
            Intrinsics.checkParameterIsNotNull(str, "productUrl");
            Intrinsics.checkParameterIsNotNull(str2, "productColor");
            Intrinsics.checkParameterIsNotNull(str3, "productSize");
            Intrinsics.checkParameterIsNotNull(str4, "shippingName");
            Intrinsics.checkParameterIsNotNull(str5, "shippingContact");
            Intrinsics.checkParameterIsNotNull(str6, "shippingZipCode");
            Intrinsics.checkParameterIsNotNull(str7, "shippingAddress1");
            Intrinsics.checkParameterIsNotNull(str8, "shippingAddress2");
            Intrinsics.checkParameterIsNotNull(str9, "shippingMemo");
            this.couponId = j;
            this.productUrl = str;
            this.productColor = str2;
            this.productSize = str3;
            this.productPrice = i;
            this.shippingFee = i2;
            this.shippingName = str4;
            this.shippingContact = str5;
            this.shippingZipCode = str6;
            this.shippingAddress1 = str7;
            this.shippingAddress2 = str8;
            this.shippingMemo = str9;
        }

        public final long getCouponId() {
            return this.couponId;
        }

        @NotNull
        public final String getProductUrl() {
            return this.productUrl;
        }

        @NotNull
        public final String getProductColor() {
            return this.productColor;
        }

        @NotNull
        public final String getProductSize() {
            return this.productSize;
        }

        public final int getProductPrice() {
            return this.productPrice;
        }

        public final int getShippingFee() {
            return this.shippingFee;
        }

        @NotNull
        public final String getShippingName() {
            return this.shippingName;
        }

        @NotNull
        public final String getShippingContact() {
            return this.shippingContact;
        }

        @NotNull
        public final String getShippingZipCode() {
            return this.shippingZipCode;
        }

        @NotNull
        public final String getShippingAddress1() {
            return this.shippingAddress1;
        }

        @NotNull
        public final String getShippingAddress2() {
            return this.shippingAddress2;
        }

        @NotNull
        public final String getShippingMemo() {
            return this.shippingMemo;
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
        setContentView((int) C0013R$layout.activity_coupon_use_confirm);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C0010R$id.toolbar));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText("쿠폰 사용신청 확인");
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new CouponUseConfirmActivity$onCreate$1(this));
        Parameters parameters = (Parameters) getIntent().getParcelableExtra("paremeters");
        StringBuilder sb = new StringBuilder();
        sb.append("parameters : ");
        sb.append(parameters);
        Logger.d(sb.toString(), new Object[0]);
        ((Button) _$_findCachedViewById(C0010R$id.showProductLinkButton)).setOnClickListener(new CouponUseConfirmActivity$onCreate$2(this, parameters));
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.productOptionTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "productOptionTextView");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(parameters.getProductColor());
        sb2.append(' ');
        sb2.append(parameters.getProductSize());
        textView2.setText(sb2.toString());
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.productPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "productPriceTextView");
        textView3.setText(IntExtensionsKt.commaString(parameters.getProductPrice()));
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.shippingFeeTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "shippingFeeTextView");
        textView4.setText(IntExtensionsKt.commaString(parameters.getShippingFee()));
        int productPrice = parameters.getProductPrice() + parameters.getShippingFee();
        TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.overallPriceTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "overallPriceTextView");
        textView5.setText(IntExtensionsKt.commaString(productPrice));
        TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.nameTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "nameTextView");
        textView6.setText(parameters.getShippingName());
        TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.phoneNumberTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "phoneNumberTextView");
        textView7.setText(parameters.getShippingContact());
        TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.shippingAddressTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "shippingAddressTextView");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(parameters.getShippingAddress1());
        sb3.append(' ');
        sb3.append(parameters.getShippingAddress2());
        textView8.setText(sb3.toString());
        TextView textView9 = (TextView) _$_findCachedViewById(C0010R$id.shippingMemoTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "shippingMemoTextView");
        textView9.setText(StringsKt__StringsJVMKt.isBlank(parameters.getShippingMemo()) ^ true ? parameters.getShippingMemo() : "-");
        ((Button) _$_findCachedViewById(C0010R$id.requestCouponUseButton)).setOnClickListener(new CouponUseConfirmActivity$onCreate$3(this, parameters));
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.couponEnrollDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }
}
