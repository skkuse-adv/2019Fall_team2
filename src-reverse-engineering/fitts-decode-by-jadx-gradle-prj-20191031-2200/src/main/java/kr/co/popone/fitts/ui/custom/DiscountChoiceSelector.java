package kr.co.popone.fitts.ui.custom;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.MutableLiveData;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.KeyboardExtensionKt;
import kr.co.popone.fitts.feature.store.browser.StoreOptionSpinnerAdapter;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.coupon.CouponAPIKt;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import kr.co.popone.fitts.model.datamodel.social.membership.MembershipKt;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DiscountChoiceSelector extends FrameLayout {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DiscountChoiceSelector.class), "selectTextColor", "getSelectTextColor()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DiscountChoiceSelector.class), "unselectTextColor", "getUnselectTextColor()I"))};
    private HashMap _$_findViewCache;
    private final MutableLiveData<Discount> _discountLiveData;
    private final CompositeDisposable disposables;
    /* access modifiers changed from: private */
    public AdjustmentViewData pointAdjustmentViewData;
    private final Lazy selectTextColor$delegate;
    private final Lazy unselectTextColor$delegate;
    private Function1<? super Integer, Unit> updateAsCouponDiscountByIdx;
    private Function1<? super Integer, Unit> updateAsMembershipDiscountByIdx;

    public DiscountChoiceSelector(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    public DiscountChoiceSelector(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* access modifiers changed from: private */
    public final int getSelectTextColor() {
        Lazy lazy = this.selectTextColor$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final int getUnselectTextColor() {
        Lazy lazy = this.unselectTextColor$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
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

    public static final /* synthetic */ AdjustmentViewData access$getPointAdjustmentViewData$p(DiscountChoiceSelector discountChoiceSelector) {
        AdjustmentViewData adjustmentViewData = discountChoiceSelector.pointAdjustmentViewData;
        if (adjustmentViewData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointAdjustmentViewData");
        }
        return adjustmentViewData;
    }

    public /* synthetic */ DiscountChoiceSelector(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public DiscountChoiceSelector(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.disposables = new CompositeDisposable();
        this._discountLiveData = new MutableLiveData<>();
        this.selectTextColor$delegate = LazyKt__LazyJVMKt.lazy(new DiscountChoiceSelector$selectTextColor$2(context));
        this.unselectTextColor$delegate = LazyKt__LazyJVMKt.lazy(new DiscountChoiceSelector$unselectTextColor$2(context));
        LayoutInflater.from(context).inflate(C0013R$layout.view_discount_selector, this);
        ((RadioGroup) _$_findCachedViewById(C0010R$id.radioPointGroup)).setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ DiscountChoiceSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case C0010R$id.radioFittsCoupon /*2131362743*/:
                        this.this$0.updateView("사용 가능한 핏츠 쿠폰", 4, 8, 0, 8);
                        DiscountChoiceSelector discountChoiceSelector = this.this$0;
                        discountChoiceSelector.updateRadioTextColor(discountChoiceSelector.getUnselectTextColor(), this.this$0.getSelectTextColor(), this.this$0.getUnselectTextColor());
                        this.this$0.updateDicountInfoView(4, 4);
                        this.this$0.changeTypeAsCoupon();
                        return;
                    case C0010R$id.radioFittsMembership /*2131362744*/:
                        this.this$0.updateView("사용 가능한 핏츠 멤버십", 4, 8, 8, 0);
                        DiscountChoiceSelector discountChoiceSelector2 = this.this$0;
                        discountChoiceSelector2.updateRadioTextColor(discountChoiceSelector2.getUnselectTextColor(), this.this$0.getUnselectTextColor(), this.this$0.getSelectTextColor());
                        this.this$0.updateDicountInfoView(4, 0);
                        this.this$0.changeTypeAsMembership();
                        return;
                    case C0010R$id.radioFittsPoint /*2131362745*/:
                        this.this$0.updateView("사용 가능한 핏츠 포인트", 0, 0, 8, 8);
                        DiscountChoiceSelector discountChoiceSelector3 = this.this$0;
                        discountChoiceSelector3.updateRadioTextColor(discountChoiceSelector3.getSelectTextColor(), this.this$0.getUnselectTextColor(), this.this$0.getUnselectTextColor());
                        this.this$0.updateDicountInfoView(0, 4);
                        this.this$0.calculatePointValue();
                        return;
                    default:
                        return;
                }
            }
        });
        CompositeDisposable compositeDisposable = this.disposables;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
        String str = "editFittsPointInput";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        InitialValueObservable afterTextChangeEvents = RxTextView.afterTextChangeEvents(editText);
        String str2 = "RxTextView.afterTextChangeEvents(this)";
        Intrinsics.checkExpressionValueIsNotNull(afterTextChangeEvents, str2);
        Disposable subscribe = afterTextChangeEvents.map(AnonymousClass2.INSTANCE).filter(AnonymousClass3.INSTANCE).map(AnonymousClass4.INSTANCE).subscribe((Consumer<? super T>) new Consumer<Integer>(this) {
            final /* synthetic */ DiscountChoiceSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(Integer num) {
                String str = "textFittsPointUseInfo";
                if (Intrinsics.compare(num.intValue(), DiscountChoiceSelector.access$getPointAdjustmentViewData$p(this.this$0).getUsableValue()) > 0) {
                    ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editFittsPointInput)).setText(String.valueOf(DiscountChoiceSelector.access$getPointAdjustmentViewData$p(this.this$0).getUsableValue()), BufferType.EDITABLE);
                    TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textFittsPointUseInfo);
                    Intrinsics.checkExpressionValueIsNotNull(textView, str);
                    StringBuilder sb = new StringBuilder();
                    sb.append("결제금액의 ");
                    sb.append(DiscountChoiceSelector.access$getPointAdjustmentViewData$p(this.this$0).getAvailablePercentage());
                    sb.append("% 까지 사용 가능 합니다.");
                    textView.setText(sb.toString());
                    DiscountChoiceSelector discountChoiceSelector = this.this$0;
                    DiscountChoiceSelector.updateDiscount$default(discountChoiceSelector, Type.POINT, Integer.valueOf(DiscountChoiceSelector.access$getPointAdjustmentViewData$p(discountChoiceSelector).getUsableValue()), null, null, 12, null);
                    return;
                }
                TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textFittsPointUseInfo);
                Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                textView2.setText("");
                DiscountChoiceSelector.updateDiscount$default(this.this$0, Type.POINT, num, null, null, 12, null);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "editFittsPointInput\n    …      }\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.disposables;
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
        InitialValueObservable afterTextChangeEvents2 = RxTextView.afterTextChangeEvents(editText2);
        Intrinsics.checkExpressionValueIsNotNull(afterTextChangeEvents2, str2);
        Disposable subscribe2 = afterTextChangeEvents2.map(AnonymousClass6.INSTANCE).filter(AnonymousClass7.INSTANCE).observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new Consumer<String>(this) {
            final /* synthetic */ DiscountChoiceSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(String str) {
                EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editFittsPointInput);
                Intrinsics.checkExpressionValueIsNotNull(editText, "editFittsPointInput");
                Editable text = editText.getText();
                Intrinsics.checkExpressionValueIsNotNull(text, "editFittsPointInput.text");
                if (!StringsKt__StringsJVMKt.isBlank(text)) {
                    ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editFittsPointInput)).setText(str, BufferType.EDITABLE);
                }
                DiscountChoiceSelector.updateDiscount$default(this.this$0, null, null, null, null, 15, null);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "editFittsPointInput\n    …count()\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.disposables;
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
        Intrinsics.checkExpressionValueIsNotNull(editText3, str);
        InitialValueObservable textChanges = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        Disposable subscribe3 = textChanges.map(AnonymousClass9.INSTANCE).filter(AnonymousClass10.INSTANCE).subscribe((Consumer<? super T>) new Consumer<String>(this) {
            final /* synthetic */ DiscountChoiceSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(String str) {
                Intrinsics.checkExpressionValueIsNotNull(str, "it");
                if (str.length() > 0) {
                    EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editFittsPointInput);
                    String substring = str.substring(1);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
                    editText.setText(substring);
                    return;
                }
                ((EditText) this.this$0._$_findCachedViewById(C0010R$id.editFittsPointInput)).setText("");
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, "editFittsPointInput.text…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        ((EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput)).setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ DiscountChoiceSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (!z) {
                    DiscountChoiceSelector discountChoiceSelector = this.this$0;
                    EditText editText = (EditText) discountChoiceSelector._$_findCachedViewById(C0010R$id.editFittsPointInput);
                    Intrinsics.checkExpressionValueIsNotNull(editText, "editFittsPointInput");
                    discountChoiceSelector.calculateUsablePoint(editText, DiscountChoiceSelector.access$getPointAdjustmentViewData$p(this.this$0));
                }
            }
        });
    }

    @NotNull
    public final MutableLiveData<Discount> discountStateChanged() {
        return this._discountLiveData;
    }

    /* access modifiers changed from: private */
    public final void updateView(String str, int i, int i2, int i3, int i4) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textDiscountInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textDiscountInfo");
        textView.setText(str);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textFittsPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textFittsPoint");
        textView2.setVisibility(i);
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editFittsPointInput");
        editText.setVisibility(i2);
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerFittsCouponInput);
        Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner, "spinnerFittsCouponInput");
        appCompatSpinner.setVisibility(i3);
        AppCompatSpinner appCompatSpinner2 = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerFittsMembership);
        Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner2, "spinnerFittsMembership");
        appCompatSpinner2.setVisibility(i4);
    }

    /* access modifiers changed from: private */
    public final void updateRadioTextColor(int i, int i2, int i3) {
        ((RadioButton) _$_findCachedViewById(C0010R$id.radioFittsPoint)).setTextColor(i);
        ((RadioButton) _$_findCachedViewById(C0010R$id.radioFittsCoupon)).setTextColor(i2);
        ((RadioButton) _$_findCachedViewById(C0010R$id.radioFittsMembership)).setTextColor(i3);
    }

    /* access modifiers changed from: private */
    public final void updateDicountInfoView(int i, int i2) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textFittsPointUseInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textFittsPointUseInfo");
        textView.setVisibility(i);
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textFittsMembershipInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textFittsMembershipInfo");
        textView2.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public final void calculateUsablePoint(EditText editText, AdjustmentViewData adjustmentViewData) {
        CompositeDisposable compositeDisposable = this.disposables;
        Disposable subscribe = Observable.just(editText.getText().toString()).filter(DiscountChoiceSelector$calculateUsablePoint$1.INSTANCE).map(DiscountChoiceSelector$calculateUsablePoint$2.INSTANCE).filter(new DiscountChoiceSelector$calculateUsablePoint$3(adjustmentViewData)).map(new DiscountChoiceSelector$calculateUsablePoint$4(adjustmentViewData)).map(DiscountChoiceSelector$calculateUsablePoint$5.INSTANCE).subscribe((Consumer<? super T>) new DiscountChoiceSelector$calculateUsablePoint$6<Object>(this, editText, adjustmentViewData));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observable.just(editText…력해주세요\")\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void setAdjustment(int i, @NotNull AdjustmentViewData adjustmentViewData) {
        Intrinsics.checkParameterIsNotNull(adjustmentViewData, "pointAdjustmentViewData");
        initFittsPoint(i, adjustmentViewData);
    }

    private final void initFittsPoint(int i, AdjustmentViewData adjustmentViewData) {
        this.pointAdjustmentViewData = adjustmentViewData;
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textFittsPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textFittsPoint");
        textView.setText(IntExtensionsKt.commaString(adjustmentViewData.getOwnValue()));
        String str = "editFittsPointInput";
        if (adjustmentViewData.getOwnValue() < adjustmentViewData.getMinHoldValue()) {
            EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
            Intrinsics.checkExpressionValueIsNotNull(editText, str);
            editText.setEnabled(false);
            EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
            Intrinsics.checkExpressionValueIsNotNull(editText2, str);
            StringBuilder sb = new StringBuilder();
            sb.append(IntExtensionsKt.commaString(adjustmentViewData.getMinHoldValue()));
            sb.append("원 이상 보유하셔야 사용 가능합니다.");
            editText2.setHint(sb.toString());
        } else if (i < adjustmentViewData.getMinOrderValue()) {
            EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
            Intrinsics.checkExpressionValueIsNotNull(editText3, str);
            editText3.setEnabled(false);
            EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
            Intrinsics.checkExpressionValueIsNotNull(editText4, str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("상품금액이 ");
            sb2.append(IntExtensionsKt.commaString(adjustmentViewData.getMinOrderValue()));
            sb2.append("원 이상인 경우 사용 가능합니다.");
            editText4.setHint(sb2.toString());
        } else {
            EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
            Intrinsics.checkExpressionValueIsNotNull(editText5, str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(IntExtensionsKt.commaString(adjustmentViewData.getUsageValueUnit()));
            sb3.append("원 단위로 입력해주세요.");
            editText5.setHint(sb3.toString());
        }
    }

    static /* synthetic */ void updateDiscount$default(DiscountChoiceSelector discountChoiceSelector, Type type, Integer num, CouponInfo couponInfo, Membership membership, int i, Object obj) {
        if ((i & 1) != 0) {
            type = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            couponInfo = null;
        }
        if ((i & 8) != 0) {
            membership = null;
        }
        discountChoiceSelector.updateDiscount(type, num, couponInfo, membership);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r1 != null) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateDiscount(kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type r3, java.lang.Integer r4, kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo r5, kr.co.popone.fitts.model.datamodel.social.membership.Membership r6) {
        /*
            r2 = this;
            androidx.lifecycle.MutableLiveData<kr.co.popone.fitts.model.datamodel.commerce.discount.Discount> r0 = r2._discountLiveData
            java.lang.Object r1 = r0.getValue()
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r1 = (kr.co.popone.fitts.model.datamodel.commerce.discount.Discount) r1
            if (r1 == 0) goto L_0x0011
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r1 = r1.copy(r3, r4, r5, r6)
            if (r1 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Companion r1 = kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Companion
            kr.co.popone.fitts.model.datamodel.commerce.discount.Discount r1 = r1.m146new(r3, r4, r5, r6)
        L_0x0017:
            r0.setValue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.ui.custom.DiscountChoiceSelector.updateDiscount(kr.co.popone.fitts.model.datamodel.commerce.discount.Discount$Type, java.lang.Integer, kr.co.popone.fitts.model.coupon.CouponAPI$CouponInfo, kr.co.popone.fitts.model.datamodel.social.membership.Membership):void");
    }

    public final void setCouponList(@NotNull List<CouponInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "coupons");
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerFittsCouponInput);
        Context context = appCompatSpinner.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        appCompatSpinner.setAdapter((SpinnerAdapter) new StoreOptionSpinnerAdapter(context, CouponAPIKt.mapToCouponNameAndValueArray(list)));
        Sdk27CoroutinesListenersWithCoroutinesKt.onItemSelectedListener$default(appCompatSpinner, null, new DiscountChoiceSelector$setCouponList$$inlined$apply$lambda$1(this, list), 1, null);
        appCompatSpinner.setEnabled(!list.isEmpty());
        this.updateAsCouponDiscountByIdx = new DiscountChoiceSelector$setCouponList$$inlined$apply$lambda$2(this, list);
    }

    public final void setMemberships(@NotNull List<Membership> list) {
        Intrinsics.checkParameterIsNotNull(list, "memberships");
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerFittsMembership);
        Context context = appCompatSpinner.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        appCompatSpinner.setAdapter((SpinnerAdapter) new StoreOptionSpinnerAdapter(context, MembershipKt.toSpinnerViewData(list)));
        Sdk27CoroutinesListenersWithCoroutinesKt.onItemSelectedListener$default(appCompatSpinner, null, new DiscountChoiceSelector$setMemberships$$inlined$apply$lambda$1(this, list), 1, null);
        appCompatSpinner.setEnabled(!list.isEmpty());
        this.updateAsMembershipDiscountByIdx = new DiscountChoiceSelector$setMemberships$$inlined$apply$lambda$2(this, list);
    }

    public final void updateMembershipNotUsableReason(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "info");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textFittsMembershipInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textFittsMembershipInfo");
        textView.setText(str);
    }

    /* access modifiers changed from: private */
    public final void calculatePointValue() {
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editFittsPointInput");
        String obj = editText.getText().toString();
        if (obj.length() == 0) {
            updateDiscount$default(this, Type.POINT, null, null, null, 14, null);
        } else {
            updateDiscount$default(this, Type.POINT, Integer.valueOf(Integer.parseInt(obj)), null, null, 12, null);
        }
    }

    /* access modifiers changed from: private */
    public final void changeTypeAsCoupon() {
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerFittsCouponInput);
        Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner, "spinnerFittsCouponInput");
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            updateDiscount$default(this, Type.COUPON, null, null, null, 14, null);
            return;
        }
        Function1<? super Integer, Unit> function1 = this.updateAsCouponDiscountByIdx;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(Integer.valueOf(selectedItemPosition));
        }
    }

    /* access modifiers changed from: private */
    public final void changeTypeAsMembership() {
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerFittsMembership);
        Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner, "spinnerFittsMembership");
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            updateDiscount$default(this, Type.MEMBERSHIP, null, null, null, 14, null);
            return;
        }
        Function1<? super Integer, Unit> function1 = this.updateAsMembershipDiscountByIdx;
        if (function1 != null) {
            Unit unit = (Unit) function1.invoke(Integer.valueOf(selectedItemPosition));
        }
    }

    public final void scrollViewFocusChanged() {
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editFittsPointInput);
        if (editText.hasFocus()) {
            editText.clearFocus();
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            Intrinsics.checkExpressionValueIsNotNull(editText, "it");
            KeyboardExtensionKt.hideKeyboard(context, (View) editText);
        }
    }

    public final void clear() {
        this.disposables.clear();
    }
}
