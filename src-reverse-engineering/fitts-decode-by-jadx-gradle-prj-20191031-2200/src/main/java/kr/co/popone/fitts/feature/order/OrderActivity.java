package kr.co.popone.fitts.feature.order;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.orhanobut.logger.Logger;
import dagger.android.AndroidInjection;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.reward.AddressWebViewActivity.Result;
import kr.co.popone.fitts.feature.store.browser.StoreOptionSpinnerAdapter;
import kr.co.popone.fitts.model.ImageUrlWithRatio;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderInitialData;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderPrice;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.order.BankAccountKt;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserInfo;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.custom.DiscountChoiceSelector;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_ORDER_INITIAL_DATA = "order_initial_data";
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final OrderProductAdapter orderProductAdapter = new OrderProductAdapter();
    @NotNull
    public OrderViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Activity activity, @NotNull OrderInitialData orderInitialData) {
            Intrinsics.checkParameterIsNotNull(activity, "activity");
            Intrinsics.checkParameterIsNotNull(orderInitialData, "orderInitialData");
            Intent intent = new Intent(activity, OrderActivity.class);
            intent.putExtra(OrderActivity.KEY_ORDER_INITIAL_DATA, orderInitialData);
            ContextExtensionKt.activityStart(activity, intent, ActivityAnimationType.SLIDE_RTOL);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[PaymentType.values().length];

        static {
            $EnumSwitchMapping$0[PaymentType.KAKAO.ordinal()] = 1;
            $EnumSwitchMapping$0[PaymentType.CREDIT_CARD.ordinal()] = 2;
            $EnumSwitchMapping$0[PaymentType.DIRECT_DEPOSIT.ordinal()] = 3;
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
    public final OrderViewModel getViewModel() {
        OrderViewModel orderViewModel = this.viewModel;
        if (orderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderViewModel;
    }

    public final void setViewModel(@NotNull OrderViewModel orderViewModel) {
        Intrinsics.checkParameterIsNotNull(orderViewModel, "<set-?>");
        this.viewModel = orderViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_order);
        CompositeDisposable compositeDisposable = this.disposables;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.shippingMemoEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "shippingMemoEditText");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        Intrinsics.checkExpressionValueIsNotNull(textChanges, "RxTextView.textChanges(this)");
        compositeDisposable.addAll(textChanges.map(OrderActivity$onCreate$1.INSTANCE).subscribe((Consumer<? super T>) new OrderActivity$onCreate$2<Object>(this)), RxBus.INSTANCE.toObservable().observeOn(AndroidSchedulers.mainThread()).subscribe((Consumer<? super T>) new OrderActivity$onCreate$3<Object>(this)));
        OrderViewModel orderViewModel = this.viewModel;
        String str = "viewModel";
        if (orderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel.getOrderInfoLiveData().observe(new OrderActivity$onCreate$4(this), new OrderActivity$onCreate$5(this));
        OrderViewModel orderViewModel2 = this.viewModel;
        if (orderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel2.getOrderCompleteLiveData().observe(new OrderActivity$onCreate$6(this), new OrderActivity$onCreate$7(this));
        OrderViewModel orderViewModel3 = this.viewModel;
        if (orderViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel3.observePaymentType().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$8(this)));
        OrderViewModel orderViewModel4 = this.viewModel;
        if (orderViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel4.updateCouponList().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$9((DiscountChoiceSelector) _$_findCachedViewById(C0010R$id.discountSelector))));
        OrderViewModel orderViewModel5 = this.viewModel;
        if (orderViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel5.updateMembershipList().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$10(this)));
        OrderViewModel orderViewModel6 = this.viewModel;
        if (orderViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel6.updateMembershipNotUsableReason().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$11((DiscountChoiceSelector) _$_findCachedViewById(C0010R$id.discountSelector))));
        OrderViewModel orderViewModel7 = this.viewModel;
        if (orderViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel7.showMembershipDialog().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$12(this)));
        OrderViewModel orderViewModel8 = this.viewModel;
        if (orderViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel8.showToastMessage().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$13(this)));
        OrderViewModel orderViewModel9 = this.viewModel;
        if (orderViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel9.updateOrderPriceView().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$14(this)));
        OrderViewModel orderViewModel10 = this.viewModel;
        if (orderViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel10.showVaildationMessage().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$15(this)));
        OrderViewModel orderViewModel11 = this.viewModel;
        if (orderViewModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel11.isSpecialDiscount().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$16(this)));
        OrderViewModel orderViewModel12 = this.viewModel;
        if (orderViewModel12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel12.visiblePaymentType().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$17(this)));
        OrderViewModel orderViewModel13 = this.viewModel;
        if (orderViewModel13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel13.orderErrorOccured().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$18(this)));
        OrderViewModel orderViewModel14 = this.viewModel;
        if (orderViewModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel14.updateAddressInfoView().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$19(this)));
        OrderViewModel orderViewModel15 = this.viewModel;
        if (orderViewModel15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel15.onExpectedReceivablePointUpdate().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$20(this)));
        OrderViewModel orderViewModel16 = this.viewModel;
        if (orderViewModel16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel16.getErrorLiveData().observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$21(this)));
        OrderViewModel orderViewModel17 = this.viewModel;
        if (orderViewModel17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderViewModel17.observePaymentModuleData().observe(new OrderActivity$onCreate$22(this), new OrderActivity$onCreate$23(this));
        MutableLiveData discountStateChanged = ((DiscountChoiceSelector) _$_findCachedViewById(C0010R$id.discountSelector)).discountStateChanged();
        OrderViewModel orderViewModel18 = this.viewModel;
        if (orderViewModel18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        discountStateChanged.observe(this, new OrderActivity$sam$androidx_lifecycle_Observer$0(new OrderActivity$onCreate$24(orderViewModel18)));
        ((Button) _$_findCachedViewById(C0010R$id.searchAddressButton)).setOnClickListener(new OrderActivity$onCreate$25(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderActivity$onCreate$26(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrder)).setOnClickListener(new OrderActivity$onCreate$27(this));
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(C0010R$id.checkEqualInfo);
        Intrinsics.checkExpressionValueIsNotNull(checkBox, "checkEqualInfo");
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default((CompoundButton) checkBox, (CoroutineContext) null, (Function4) new OrderActivity$onCreate$28(this, null), 1, (Object) null);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.layoutCheckEqualInfo)).setOnClickListener(new OrderActivity$onCreate$29(this));
        ((NestedScrollView) _$_findCachedViewById(C0010R$id.orderScrollView)).setOnTouchListener(new OrderActivity$onCreate$30(this));
        ((RecyclerView) _$_findCachedViewById(C0010R$id.productRecyclerView)).setAdapter(this.orderProductAdapter);
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerCashRecept);
        Context context = appCompatSpinner.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        appCompatSpinner.setAdapter((SpinnerAdapter) new TaxDeductionSpinnerAdapter(context, new String[]{"휴대폰 번호"}));
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default((RadioGroup) _$_findCachedViewById(C0010R$id.radioGroupPayment), (CoroutineContext) null, (Function4) new OrderActivity$onCreate$$inlined$apply$lambda$1(null, this), 1, (Object) null);
        ((RadioGroup) _$_findCachedViewById(C0010R$id.radioCashRecept)).setOnCheckedChangeListener(new OrderActivity$onCreate$34(this));
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.tvNCommercePointPredict);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setCompoundDrawablePadding(0);
    }

    /* access modifiers changed from: private */
    public final void updateDiscountView(boolean z) {
        String str = "groupNormalAdjustment";
        String str2 = "layoutOrderDiscount";
        String str3 = "groupSpecialDiscount";
        if (z) {
            Group group = (Group) _$_findCachedViewById(C0010R$id.groupSpecialDiscount);
            Intrinsics.checkExpressionValueIsNotNull(group, str3);
            ViewExtensionsKt.visible(group);
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.layoutOrderDiscount);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str2);
            ViewExtensionsKt.gone(_$_findCachedViewById);
            Group group2 = (Group) _$_findCachedViewById(C0010R$id.groupNormalAdjustment);
            Intrinsics.checkExpressionValueIsNotNull(group2, str);
            ViewExtensionsKt.gone(group2);
            return;
        }
        Group group3 = (Group) _$_findCachedViewById(C0010R$id.groupSpecialDiscount);
        Intrinsics.checkExpressionValueIsNotNull(group3, str3);
        ViewExtensionsKt.gone(group3);
        View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.layoutOrderDiscount);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str2);
        ViewExtensionsKt.visible(_$_findCachedViewById2);
        Group group4 = (Group) _$_findCachedViewById(C0010R$id.groupNormalAdjustment);
        Intrinsics.checkExpressionValueIsNotNull(group4, str);
        ViewExtensionsKt.visible(group4);
    }

    /* access modifiers changed from: private */
    public final void updatePriceInfoView(OrderPrice orderPrice) {
        String str;
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textTotalPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTotalPrice");
        textView.setText(IntExtensionsKt.commaString(orderPrice.getTotalPrice()));
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textShippingPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textShippingPrice");
        textView2.setText(IntExtensionsKt.commaString(orderPrice.getShippingPrice()));
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textDiscountPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textDiscountPrice");
        if (orderPrice.getDiscountPrice() == 0) {
            str = IntExtensionsKt.commaString(0);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("- ");
            sb.append(IntExtensionsKt.commaString(orderPrice.getDiscountPrice()));
            str = sb.toString();
        }
        textView3.setText(str);
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textUsedPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "textUsedPoint");
        textView4.setText(IntExtensionsKt.commaString(orderPrice.getPointValue()));
        TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.textUsedCoupon);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "textUsedCoupon");
        textView5.setText(IntExtensionsKt.commaString(orderPrice.getCouponValue()));
        TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.textDiscountMembershipPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "textDiscountMembershipPrice");
        textView6.setText(IntExtensionsKt.commaString(orderPrice.getMembershipValue()));
        TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.textAmountOfPayment);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "textAmountOfPayment");
        textView7.setText(IntExtensionsKt.commaString(orderPrice.getFinalOrderPrice()));
        TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.textSpecialDiscount);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "textSpecialDiscount");
        textView8.setText(IntExtensionsKt.commaString(orderPrice.getSpecialDiscountValue()));
    }

    /* access modifiers changed from: private */
    public final void updatePaymentTypeVisiblity(boolean z) {
        String str = "groupPaymentUi";
        if (z) {
            Group group = (Group) _$_findCachedViewById(C0010R$id.groupPaymentUi);
            Intrinsics.checkExpressionValueIsNotNull(group, str);
            group.setVisibility(0);
            OrderViewModel orderViewModel = this.viewModel;
            if (orderViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            orderViewModel.triggerCurrentPaymentType();
            return;
        }
        Group group2 = (Group) _$_findCachedViewById(C0010R$id.groupPaymentUi);
        Intrinsics.checkExpressionValueIsNotNull(group2, str);
        group2.setVisibility(8);
        Group group3 = (Group) _$_findCachedViewById(C0010R$id.groupCacheReceiptUi);
        Intrinsics.checkExpressionValueIsNotNull(group3, "groupCacheReceiptUi");
        group3.setVisibility(8);
        Group group4 = (Group) _$_findCachedViewById(C0010R$id.groupDepotlessPayUi);
        Intrinsics.checkExpressionValueIsNotNull(group4, "groupDepotlessPayUi");
        group4.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void updatePaymentTypeView(PaymentType paymentType) {
        int i = WhenMappings.$EnumSwitchMapping$0[paymentType.ordinal()];
        String str = "groupDepotlessPayUi";
        String str2 = "groupCacheReceiptUi";
        if (i == 1 || i == 2) {
            Group group = (Group) _$_findCachedViewById(C0010R$id.groupDepotlessPayUi);
            Intrinsics.checkExpressionValueIsNotNull(group, str);
            ViewExtensionsKt.gone(group);
            Group group2 = (Group) _$_findCachedViewById(C0010R$id.groupCacheReceiptUi);
            Intrinsics.checkExpressionValueIsNotNull(group2, str2);
            ViewExtensionsKt.gone(group2);
        } else if (i == 3) {
            Group group3 = (Group) _$_findCachedViewById(C0010R$id.groupDepotlessPayUi);
            Intrinsics.checkExpressionValueIsNotNull(group3, str);
            ViewExtensionsKt.visible(group3);
            RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C0010R$id.radioCashRecept);
            Intrinsics.checkExpressionValueIsNotNull(radioGroup, "radioCashRecept");
            if (radioGroup.getCheckedRadioButtonId() == 2131362749) {
                Group group4 = (Group) _$_findCachedViewById(C0010R$id.groupCacheReceiptUi);
                Intrinsics.checkExpressionValueIsNotNull(group4, str2);
                ViewExtensionsKt.visible(group4);
                return;
            }
            Group group5 = (Group) _$_findCachedViewById(C0010R$id.groupCacheReceiptUi);
            Intrinsics.checkExpressionValueIsNotNull(group5, str2);
            ViewExtensionsKt.gone(group5);
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ActivityAnimationType.SLIDE_LTOR.getEnter(), ActivityAnimationType.SLIDE_LTOR.getExit());
    }

    /* access modifiers changed from: private */
    public final void updateNameAndContact() {
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editUseName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editUseName");
        ((EditText) _$_findCachedViewById(C0010R$id.shippingPersonEditText)).setText(editText.getText().toString(), BufferType.EDITABLE);
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editUserContact);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "editUserContact");
        ((EditText) _$_findCachedViewById(C0010R$id.shippingContactEditText)).setText(editText2.getText().toString(), BufferType.EDITABLE);
    }

    /* access modifiers changed from: private */
    public final void updateUserInfoView(UserInfo userInfo) {
        if (userInfo != null) {
            ((EditText) _$_findCachedViewById(C0010R$id.editUseName)).setText(userInfo.getName(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.editUserContact)).setText(userInfo.getContact(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.editUserEmail)).setText(userInfo.getEmail(), BufferType.EDITABLE);
        }
    }

    /* access modifiers changed from: private */
    public final void updateProductLineItemsView(OrderInfoViewData orderInfoViewData) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textTotalCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTotalCount");
        StringBuilder sb = new StringBuilder();
        sb.append("총 ");
        sb.append(orderInfoViewData.getTotalProductCount());
        sb.append(44060);
        textView.setText(sb.toString());
        OrderProductAdapter orderProductAdapter2 = this.orderProductAdapter;
        orderProductAdapter2.setItems(CollectionsKt___CollectionsKt.plus((Collection<? extends T>) orderProductAdapter2.getItems(), (Iterable<? extends T>) orderInfoViewData.getLineItems()));
    }

    /* access modifiers changed from: private */
    public final void updateBankInfoView(OrderInfoViewData orderInfoViewData) {
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerBank);
        appCompatSpinner.setAdapter((SpinnerAdapter) new StoreOptionSpinnerAdapter(this, BankAccountKt.mapToBankNameArray(orderInfoViewData.getBankAccount())));
        Sdk27CoroutinesListenersWithCoroutinesKt.onItemSelectedListener$default(appCompatSpinner, null, new OrderActivity$updateBankInfoView$$inlined$with$lambda$1(orderInfoViewData, this), 1, null);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textDueDate);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textDueDate");
        textView.setText(simpleDateFormat.format(orderInfoViewData.getDueData()));
    }

    /* access modifiers changed from: private */
    public final void userDefaultAddressInfo(ShippingAddressResponse shippingAddressResponse) {
        if (shippingAddressResponse != null) {
            ((EditText) _$_findCachedViewById(C0010R$id.shippingPersonEditText)).setText(shippingAddressResponse.getName(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.shippingContactEditText)).setText(shippingAddressResponse.getContact(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.address1EditText)).setText(shippingAddressResponse.getAddress(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.address2EditText)).setText(shippingAddressResponse.getAddress2(), BufferType.EDITABLE);
            OrderViewModel orderViewModel = this.viewModel;
            if (orderViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            orderViewModel.setZipCode(shippingAddressResponse.getZipCode());
        }
    }

    /* access modifiers changed from: private */
    public final void updateFittsMemberships(List<Membership> list) {
        ((DiscountChoiceSelector) _$_findCachedViewById(C0010R$id.discountSelector)).setMemberships(list);
    }

    /* access modifiers changed from: private */
    public final void updateAddressInfoView(Result result) {
        ((EditText) _$_findCachedViewById(C0010R$id.address1EditText)).setText(result.getAddress(), BufferType.EDITABLE);
    }

    /* access modifiers changed from: private */
    public final String getTaxDeductionType() {
        if (!isTaxDeduction()) {
            return null;
        }
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) _$_findCachedViewById(C0010R$id.spinnerCashRecept);
        Intrinsics.checkExpressionValueIsNotNull(appCompatSpinner, "spinnerCashRecept");
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            return "contact";
        }
        if (selectedItemPosition != 1) {
            return null;
        }
        return "card_number";
    }

    private final boolean isTaxDeduction() {
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C0010R$id.radioCashRecept);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "radioCashRecept");
        switch (radioGroup.getCheckedRadioButtonId()) {
            case C0010R$id.radioPublishRecept /*2131362749*/:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public final String getTaxDeductionValue() {
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editCashRecept);
        String str = "editCashRecept";
        Intrinsics.checkExpressionValueIsNotNull(editText, str);
        if (StringsKt__StringsJVMKt.isBlank(editText.getText().toString())) {
            return null;
        }
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editCashRecept);
        Intrinsics.checkExpressionValueIsNotNull(editText2, str);
        return editText2.getText().toString();
    }

    /* access modifiers changed from: private */
    public final void updateExpectedReceivablePoint(ExpectedReceivablePoint expectedReceivablePoint) {
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.tvMaxExpectedPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvMaxExpectedPoint");
        textView.setText(expectedReceivablePoint.getExpectedReceivablePoint());
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.tvShoppingPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvShoppingPoint");
        textView2.setText(expectedReceivablePoint.getExpectedShoppingPoint());
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.tvPostingPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvPostingPoint");
        textView3.setText(expectedReceivablePoint.getExpectedPostingPoint());
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.tvNCommercePoint);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "tvNCommercePoint");
        textView4.setText(expectedReceivablePoint.getExpectedNCommercePoint());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i != 101) {
            super.onActivityResult(i, i2, intent);
        } else if (intent != null) {
            Result result = (Result) intent.getParcelableExtra("result");
            if (result != null) {
                OrderViewModel orderViewModel = this.viewModel;
                if (orderViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                orderViewModel.updateAddressInfo(result);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showMembershipDialog(Membership membership) {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderActivity Membership = ");
        sb.append(membership);
        Logger.d(sb.toString(), new Object[0]);
        if (membership != null && checkShowMembershipDialog(membership)) {
            Dialog buildDialog = DialogExtensions.INSTANCE.buildDialog(this, C0013R$layout.dialog_event);
            ImageView imageView = (ImageView) buildDialog.findViewById(C0010R$id.imageView);
            RequestManager with = Glide.with((FragmentActivity) this);
            ImageUrlWithRatio popup = membership.getPopup();
            with.load(popup != null ? popup.getUrl() : null).into(imageView);
            TextView textView = (TextView) buildDialog.findViewById(C0010R$id.noShowTodayTextView);
            textView.setText("7일동안 보지 않기");
            textView.setOnClickListener(new OrderActivity$showMembershipDialog$$inlined$run$lambda$1(buildDialog, this, membership));
            Button button = (Button) buildDialog.findViewById(C0010R$id.closeButton);
            button.setText("확인");
            button.setOnClickListener(new OrderActivity$$special$$inlined$let$lambda$2(buildDialog));
            buildDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void save(long j, Function0<Unit> function0) {
        try {
            long currentTimeMillis = System.currentTimeMillis() + getTargetPeriod();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
            Editor edit = defaultSharedPreferences.edit();
            StringBuilder sb = new StringBuilder();
            sb.append("membership_dialog");
            sb.append(j);
            edit.putLong(sb.toString(), currentTimeMillis).apply();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TimeSavedMillis = ");
            sb2.append(currentTimeMillis);
            Logger.d(sb2.toString(), new Object[0]);
        } finally {
            function0.invoke();
        }
    }

    private final long getTargetPeriod() {
        int hashCode = "production".hashCode();
        return 604800000;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ((DiscountChoiceSelector) _$_findCachedViewById(C0010R$id.discountSelector)).clear();
        this.disposables.dispose();
        super.onDestroy();
    }

    private final boolean checkShowMembershipDialog(Membership membership) {
        if (membership == null) {
            return true;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Intrinsics.checkExpressionValueIsNotNull(defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
        StringBuilder sb = new StringBuilder();
        sb.append("membership_dialog");
        sb.append(membership.getId());
        long j = defaultSharedPreferences.getLong(sb.toString(), 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TimeSavedMillis, isTrigger = ");
        sb2.append(j - System.currentTimeMillis() <= 0);
        Logger.d(sb2.toString(), new Object[0]);
        if (j - System.currentTimeMillis() <= 0) {
            return true;
        }
        return false;
    }
}
