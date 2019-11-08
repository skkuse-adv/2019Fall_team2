package kr.co.popone.fitts.feature.coupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0001R$anim;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result;
import kr.co.popone.fitts.feature.search.ShopSearchActivity;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CouponUseActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final int RESULT_SUCCESS_CODE = 100;
    private HashMap _$_findViewCache;
    private long couponId = -1;
    /* access modifiers changed from: private */
    public int couponPoints;
    /* access modifiers changed from: private */
    public Disposable linkInfoRequest;
    @NotNull
    public PostAPI postAPI;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Integer> productPriceSubject;
    /* access modifiers changed from: private */
    public Disposable shippingAddressRequest;
    /* access modifiers changed from: private */
    public final BehaviorSubject<Integer> shippingFeeSubject;
    /* access modifiers changed from: private */
    public final BehaviorSubject<String> shippingZipCodeSubject;
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
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String PARAMETER_NAME = "parameters";
        private final long couponId;
        private final int couponPoints;

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
                return new Parameters(parcel.readLong(), parcel.readInt());
            }

            @NotNull
            public final Object[] newArray(int i) {
                return new Parameters[i];
            }
        }

        @NotNull
        public static /* synthetic */ Parameters copy$default(Parameters parameters, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = parameters.couponId;
            }
            if ((i2 & 2) != 0) {
                i = parameters.couponPoints;
            }
            return parameters.copy(j, i);
        }

        public final long component1() {
            return this.couponId;
        }

        public final int component2() {
            return this.couponPoints;
        }

        @NotNull
        public final Parameters copy(long j, int i) {
            return new Parameters(j, i);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    Parameters parameters = (Parameters) obj;
                    if (this.couponId == parameters.couponId) {
                        if (this.couponPoints == parameters.couponPoints) {
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
            return (((int) (j ^ (j >>> 32))) * 31) + this.couponPoints;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Parameters(couponId=");
            sb.append(this.couponId);
            sb.append(", couponPoints=");
            sb.append(this.couponPoints);
            sb.append(")");
            return sb.toString();
        }

        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            parcel.writeLong(this.couponId);
            parcel.writeInt(this.couponPoints);
        }

        public Parameters(long j, int i) {
            this.couponId = j;
            this.couponPoints = i;
        }

        public final long getCouponId() {
            return this.couponId;
        }

        public final int getCouponPoints() {
            return this.couponPoints;
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

    public CouponUseActivity() {
        Integer valueOf = Integer.valueOf(0);
        BehaviorSubject<Integer> createDefault = BehaviorSubject.createDefault(valueOf);
        String str = "BehaviorSubject.createDefault(0)";
        Intrinsics.checkExpressionValueIsNotNull(createDefault, str);
        this.productPriceSubject = createDefault;
        BehaviorSubject<Integer> createDefault2 = BehaviorSubject.createDefault(valueOf);
        Intrinsics.checkExpressionValueIsNotNull(createDefault2, str);
        this.shippingFeeSubject = createDefault2;
        BehaviorSubject<String> createDefault3 = BehaviorSubject.createDefault("");
        Intrinsics.checkExpressionValueIsNotNull(createDefault3, "BehaviorSubject.createDefault(\"\")");
        this.shippingZipCodeSubject = createDefault3;
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

    @NotNull
    public final PostAPI getPostAPI$app_productionFittsRelease() {
        PostAPI postAPI2 = this.postAPI;
        if (postAPI2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postAPI");
        }
        return postAPI2;
    }

    public final void setPostAPI$app_productionFittsRelease(@NotNull PostAPI postAPI2) {
        Intrinsics.checkParameterIsNotNull(postAPI2, "<set-?>");
        this.postAPI = postAPI2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_coupon_use);
        setSupportActionBar((Toolbar) _$_findCachedViewById(C0010R$id.toolbar));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.toolbarTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "toolbarTitle");
        textView.setText("핏츠 쿠폰 사용");
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setImageResource(C0008R$drawable.button_cancel);
        Parameters parameters = (Parameters) getIntent().getParcelableExtra("parameters");
        this.couponPoints = parameters.getCouponPoints();
        this.couponId = parameters.getCouponId();
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.availableCouponTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "availableCouponTextView");
        textView2.setText(IntExtensionsKt.commaString(this.couponPoints));
        ((Button) _$_findCachedViewById(C0010R$id.shopSearchButton)).setOnClickListener(new CouponUseActivity$onCreate$1(this));
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        String str = "productDetailPageLinkEditText";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str2 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str2);
        textChanges.map(CouponUseActivity$onCreate$2.INSTANCE).subscribe((Consumer<? super T>) new CouponUseActivity$onCreate$3<Object>(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str2);
        textChanges2.subscribe((Consumer<? super T>) new CouponUseActivity$onCreate$4<Object>(this));
        ((Button) _$_findCachedViewById(C0010R$id.showUrlLinkButton)).setOnClickListener(new CouponUseActivity$onCreate$5(this));
        ((TextView) _$_findCachedViewById(C0010R$id.pasteLinkTextView)).setOnClickListener(new CouponUseActivity$onCreate$6(this));
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.productPriceEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "productPriceEditText");
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str2);
        textChanges3.subscribe((Consumer<? super T>) new CouponUseActivity$onCreate$7<Object>(this));
        EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.shippingFeeEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "shippingFeeEditText");
        InitialValueObservable textChanges4 = RxTextView.textChanges(editText4);
        Intrinsics.checkExpressionValueIsNotNull(textChanges4, str2);
        textChanges4.subscribe((Consumer<? super T>) new CouponUseActivity$onCreate$8<Object>(this));
        EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.shippingMemoEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "shippingMemoEditText");
        InitialValueObservable textChanges5 = RxTextView.textChanges(editText5);
        Intrinsics.checkExpressionValueIsNotNull(textChanges5, str2);
        textChanges5.subscribe((Consumer<? super T>) new CouponUseActivity$onCreate$9<Object>(this));
        ((ImageButton) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new CouponUseActivity$onCreate$10(this));
        ((Button) _$_findCachedViewById(C0010R$id.searchAddressButton)).setOnClickListener(new CouponUseActivity$onCreate$11(this));
        ((Button) _$_findCachedViewById(C0010R$id.nextButton)).setOnClickListener(new CouponUseActivity$onCreate$12(this));
        Observable.combineLatest((ObservableSource<? extends T1>) this.productPriceSubject, (ObservableSource<? extends T2>) this.shippingFeeSubject, (BiFunction<? super T1, ? super T2, ? extends R>) CouponUseActivity$onCreate$13.INSTANCE).subscribe((Consumer<? super T>) new CouponUseActivity$onCreate$14<Object>(this));
        loadShippingAddress();
    }

    private final void loadShippingAddress() {
        if (this.shippingAddressRequest == null) {
            UserAPI userAPI2 = this.userAPI;
            if (userAPI2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userAPI");
            }
            this.shippingAddressRequest = userAPI2.requestShippingAddress().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((BiConsumer<? super T, ? super Throwable>) new CouponUseActivity$loadShippingAddress$1<Object,Object>(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        String str = "result";
        if (i != 100) {
            if (i != 200) {
                if (i != 300) {
                    super.onActivityResult(i, i2, intent);
                } else if (i2 == 1010) {
                    setResult(100);
                    finish();
                    overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
                }
            } else if (intent != null) {
                Result result = (Result) intent.getParcelableExtra(str);
                StringBuilder sb = new StringBuilder();
                sb.append("address search result ");
                sb.append(result);
                Logger.d(sb.toString(), new Object[0]);
                ((EditText) _$_findCachedViewById(C0010R$id.address1EditText)).setText(result.getAddress());
                this.shippingZipCodeSubject.onNext(result.getZoneCode());
            } else {
                Logger.d("address search cancelled", new Object[0]);
            }
        } else if (i2 == 1001 && intent != null) {
            ShopSearchActivity.Result result2 = (ShopSearchActivity.Result) intent.getParcelableExtra(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("shopSearch result ");
            sb2.append(result2);
            Logger.d(sb2.toString(), new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).setText(result2.getUrl());
        } else if (i2 == 1002) {
            Logger.d("shopSearch Direct Input", new Object[0]);
            ((EditText) _$_findCachedViewById(C0010R$id.productDetailPageLinkEditText)).requestFocus();
        } else {
            Logger.d("shopSearch cancelled", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Disposable disposable = this.linkInfoRequest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.shippingAddressRequest;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x027d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x027e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startCouponUseConfirmActivity() {
        /*
            r20 = this;
            r0 = r20
            kotlin.jvm.internal.Ref$BooleanRef r1 = new kotlin.jvm.internal.Ref$BooleanRef
            r1.<init>()
            r2 = 1
            r1.element = r2
            r3 = 2131099811(0x7f0600a3, float:1.7811986E38)
            int r3 = androidx.core.content.ContextCompat.getColor(r0, r3)
            r4 = 2131099765(0x7f060075, float:1.7811892E38)
            int r4 = androidx.core.content.ContextCompat.getColor(r0, r4)
            kr.co.popone.fitts.feature.coupon.CouponUseActivity$startCouponUseConfirmActivity$colorWithValidation$1 r5 = new kr.co.popone.fitts.feature.coupon.CouponUseActivity$startCouponUseConfirmActivity$colorWithValidation$1
            r5.<init>(r4, r1, r3)
            int r3 = kr.co.popone.fitts.C0010R$id.productDetailPageLinkEditText
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "productDetailPageLinkEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r9 = r3.toString()
            int r3 = kr.co.popone.fitts.C0010R$id.productLinkAddressLabel
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "productLinkAddressLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r9.length()
            r15 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            if (r4 <= 0) goto L_0x004c
            r4 = 1
            goto L_0x004d
        L_0x004c:
            r4 = 0
        L_0x004d:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            int r7 = kr.co.popone.fitts.C0010R$id.productDetailPageLinkEditText
            android.view.View r7 = r0._$_findCachedViewById(r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            java.lang.Object r4 = r5.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            int r3 = kr.co.popone.fitts.C0010R$id.productColorEditText
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "productColorEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r10 = r3.toString()
            int r3 = kr.co.popone.fitts.C0010R$id.productSizeEditText
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "productSizeEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r11 = r3.toString()
            int r3 = kr.co.popone.fitts.C0010R$id.productOptionTextView
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "productOptionTextView"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r10.length()
            if (r4 <= 0) goto L_0x00a5
            r4 = 1
            goto L_0x00a6
        L_0x00a5:
            r4 = 0
        L_0x00a6:
            if (r4 == 0) goto L_0x00b5
            int r4 = r11.length()
            if (r4 <= 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            if (r4 == 0) goto L_0x00b5
            r4 = 1
            goto L_0x00b6
        L_0x00b5:
            r4 = 0
        L_0x00b6:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            int r7 = kr.co.popone.fitts.C0010R$id.productColorEditText
            android.view.View r7 = r0._$_findCachedViewById(r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            java.lang.Object r4 = r5.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r3 = r0.productPriceSubject
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r3 = r6
        L_0x00db:
            java.lang.String r4 = "productPriceSubject.value ?: 0"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r12 = r3.intValue()
            io.reactivex.subjects.BehaviorSubject<java.lang.Integer> r3 = r0.shippingFeeSubject
            java.lang.Object r3 = r3.getValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = r6
        L_0x00f0:
            java.lang.String r4 = "shippingFeeSubject.value ?: 0"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r13 = r3.intValue()
            int r3 = kr.co.popone.fitts.C0010R$id.totalPriceTextLabel
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "totalPriceTextLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            if (r12 <= 0) goto L_0x010c
            if (r13 < 0) goto L_0x010c
            r4 = 1
            goto L_0x010d
        L_0x010c:
            r4 = 0
        L_0x010d:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            int r6 = kr.co.popone.fitts.C0010R$id.productPriceEditText
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.Object r4 = r5.invoke(r4, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            int r3 = kr.co.popone.fitts.C0010R$id.shippingPersonEditText
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "shippingPersonEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r14 = r3.toString()
            int r3 = kr.co.popone.fitts.C0010R$id.shippingPersonLabel
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "shippingPersonLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            int r4 = r14.length()
            if (r4 <= 0) goto L_0x0150
            r4 = 1
            goto L_0x0151
        L_0x0150:
            r4 = 0
        L_0x0151:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            int r6 = kr.co.popone.fitts.C0010R$id.shippingPersonEditText
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.Object r4 = r5.invoke(r4, r6)
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r3, r4)
            int r3 = kr.co.popone.fitts.C0010R$id.shippingContactEditText
            android.view.View r3 = r0._$_findCachedViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r4 = "shippingContactEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            int r4 = kr.co.popone.fitts.C0010R$id.shippingContactLabel
            android.view.View r4 = r0._$_findCachedViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r6 = "shippingContactLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            int r6 = r3.length()
            if (r6 <= 0) goto L_0x0194
            r6 = 1
            goto L_0x0195
        L_0x0194:
            r6 = 0
        L_0x0195:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            int r7 = kr.co.popone.fitts.C0010R$id.shippingContactEditText
            android.view.View r7 = r0._$_findCachedViewById(r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            java.lang.Object r6 = r5.invoke(r6, r7)
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r4, r6)
            io.reactivex.subjects.BehaviorSubject<java.lang.String> r4 = r0.shippingZipCodeSubject
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            java.lang.String r4 = ""
        L_0x01bb:
            java.lang.String r6 = "shippingZipCodeSubject.value ?: \"\""
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r6)
            int r6 = kr.co.popone.fitts.C0010R$id.address1EditText
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.String r7 = "address1EditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.text.Editable r6 = r6.getText()
            java.lang.String r17 = r6.toString()
            int r6 = kr.co.popone.fitts.C0010R$id.address2EditText
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.String r7 = "address2EditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.text.Editable r6 = r6.getText()
            java.lang.String r18 = r6.toString()
            int r6 = kr.co.popone.fitts.C0010R$id.shippingAddressLabel
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r7 = "shippingAddressLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            int r7 = r4.length()
            if (r7 <= 0) goto L_0x01ff
            r7 = 1
            goto L_0x0200
        L_0x01ff:
            r7 = 0
        L_0x0200:
            if (r7 == 0) goto L_0x021a
            int r7 = r17.length()
            if (r7 <= 0) goto L_0x020a
            r7 = 1
            goto L_0x020b
        L_0x020a:
            r7 = 0
        L_0x020b:
            if (r7 == 0) goto L_0x021a
            int r7 = r18.length()
            if (r7 <= 0) goto L_0x0215
            r7 = 1
            goto L_0x0216
        L_0x0215:
            r7 = 0
        L_0x0216:
            if (r7 == 0) goto L_0x021a
            r7 = 1
            goto L_0x021b
        L_0x021a:
            r7 = 0
        L_0x021b:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            int r8 = kr.co.popone.fitts.C0010R$id.address2EditText
            android.view.View r8 = r0._$_findCachedViewById(r8)
            android.widget.EditText r8 = (android.widget.EditText) r8
            java.lang.Object r7 = r5.invoke(r7, r8)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r6, r7)
            int r6 = kr.co.popone.fitts.C0010R$id.shippingMemoEditText
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            java.lang.String r7 = "shippingMemoEditText"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            android.text.Editable r6 = r6.getText()
            java.lang.String r19 = r6.toString()
            int r6 = kr.co.popone.fitts.C0010R$id.shippingMemoLabel
            android.view.View r6 = r0._$_findCachedViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r7 = "shippingMemoLabel"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            int r7 = r19.length()
            r8 = 50
            if (r7 > r8) goto L_0x025f
            goto L_0x0260
        L_0x025f:
            r2 = 0
        L_0x0260:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            int r7 = kr.co.popone.fitts.C0010R$id.shippingMemoEditText
            android.view.View r7 = r0._$_findCachedViewById(r7)
            android.widget.EditText r7 = (android.widget.EditText) r7
            java.lang.Object r2 = r5.invoke(r2, r7)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            org.jetbrains.anko.Sdk27PropertiesKt.setTextColor(r6, r2)
            boolean r1 = r1.element
            if (r1 != 0) goto L_0x027e
            return
        L_0x027e:
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity> r2 = kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity.class
            r1.<init>(r0, r2)
            kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity$Parameters r2 = new kr.co.popone.fitts.feature.coupon.CouponUseConfirmActivity$Parameters
            long r7 = r0.couponId
            r6 = r2
            r5 = 0
            r15 = r3
            r16 = r4
            r6.<init>(r7, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "confirmParameters "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r5]
            com.orhanobut.logger.Logger.d(r3, r4)
            java.lang.String r3 = "paremeters"
            r1.putExtra(r3, r2)
            r2 = 2130771996(0x7f01001c, float:1.7147098E38)
            r3 = 2130771988(0x7f010014, float:1.7147082E38)
            androidx.core.app.ActivityOptionsCompat r2 = androidx.core.app.ActivityOptionsCompat.makeCustomAnimation(r0, r2, r3)
            java.lang.String r3 = "ActivityOptionsCompat.ma…e_right, R.anim.fade_out)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r3)
            r3 = 300(0x12c, float:4.2E-43)
            android.os.Bundle r2 = r2.toBundle()
            r0.startActivityForResult(r1, r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.coupon.CouponUseActivity.startCouponUseConfirmActivity():void");
    }
}
