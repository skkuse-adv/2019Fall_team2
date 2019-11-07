package kr.co.popone.fitts.feature.refund;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.Observables;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.domain.refund.RefundInvalidViewState;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundApplyActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_LINE_ITEM_VARIANT_ID = StringKeyGenerator.Companion.generate(RefundApplyActivity.class, "order_line_item_variant_id");
    /* access modifiers changed from: private */
    public static final String KEY_PAYMENT_METHOD = KEY_PAYMENT_METHOD;
    private HashMap _$_findViewCache;
    private final CompositeDisposable viewDisposables = new CompositeDisposable();
    @NotNull
    public RefundViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, long j, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, RefundApplyActivity.class);
            intent.putExtra(RefundApplyActivity.KEY_ORDER_LINE_ITEM_VARIANT_ID, j);
            intent.putExtra(RefundApplyActivity.KEY_PAYMENT_METHOD, str);
            ContextExtensionKt.activityStart(context, intent, ActivityAnimationType.SLIDE_RTOL);
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
    public final RefundViewModel getViewModel() {
        RefundViewModel refundViewModel = this.viewModel;
        if (refundViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return refundViewModel;
    }

    public final void setViewModel(@NotNull RefundViewModel refundViewModel) {
        Intrinsics.checkParameterIsNotNull(refundViewModel, "<set-?>");
        this.viewModel = refundViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_return_apply);
        RefundViewModel refundViewModel = this.viewModel;
        String str = "viewModel";
        if (refundViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel.initPaymentMethod(new RefundApplyActivity$onCreate$1(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonPlusCount)).setOnClickListener(new RefundApplyActivity$onCreate$2(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonMinusCount)).setOnClickListener(new RefundApplyActivity$onCreate$3(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonApply)).setOnClickListener(new RefundApplyActivity$onCreate$4(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new RefundApplyActivity$onCreate$5(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.layoutContainer)).setOnTouchListener(new RefundApplyActivity$onCreate$6(this));
        ((ExchangeReasonSelector) _$_findCachedViewById(C0010R$id.selectorReason)).getReasonLiveData().observe(new RefundApplyActivity$onCreate$7(this), new RefundApplyActivity$onCreate$8(this));
        RefundViewModel refundViewModel2 = this.viewModel;
        if (refundViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel2.getPaymentMethod().observe(new RefundApplyActivity$onCreate$9(this), new RefundApplyActivity$onCreate$10(this));
        CompositeDisposable compositeDisposable = this.viewDisposables;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editDetailReason);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editDetailReason");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str2 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str2);
        Disposable subscribe = textChanges.filter(new RefundApplyActivity$onCreate$11(this)).map(RefundApplyActivity$onCreate$12.INSTANCE).subscribe((Consumer<? super T>) new RefundApplyActivity$onCreate$13<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "editDetailReason.textCha….gray6)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.viewDisposables;
        Observables observables = Observables.INSTANCE;
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editBankName);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "editBankName");
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str2);
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editAccountHolder);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "editAccountHolder");
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str2);
        EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "editAccountNumber");
        InitialValueObservable textChanges4 = RxTextView.textChanges(editText4);
        Intrinsics.checkExpressionValueIsNotNull(textChanges4, str2);
        Disposable subscribe2 = observables.combineLatest((Observable<T1>) textChanges2, (Observable<T2>) textChanges3, (Observable<T3>) textChanges4).filter(new RefundApplyActivity$onCreate$14(this)).map(RefundApplyActivity$onCreate$15.INSTANCE).subscribe((Consumer<? super T>) new RefundApplyActivity$onCreate$16<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "Observables.combineLates…on_red)\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.viewDisposables;
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C0010R$id.conatinerRadio);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "conatinerRadio");
        InitialValueObservable checkedChanges = RxRadioGroup.checkedChanges(radioGroup);
        Intrinsics.checkExpressionValueIsNotNull(checkedChanges, "RxRadioGroup.checkedChanges(this)");
        Disposable subscribe3 = checkedChanges.filter(new RefundApplyActivity$onCreate$17(this)).map(new RefundApplyActivity$onCreate$18(this)).subscribe((Consumer<? super T>) new RefundApplyActivity$onCreate$19<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, "conatinerRadio.checkedCh…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        RefundViewModel refundViewModel3 = this.viewModel;
        if (refundViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel3.getPreRefundLiveData().observe(new RefundApplyActivity$onCreate$20(this), new RefundApplyActivity$onCreate$21(this));
        RefundViewModel refundViewModel4 = this.viewModel;
        if (refundViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel4.setOrderLineItemVariantId(new RefundApplyActivity$onCreate$22(this));
        RefundViewModel refundViewModel5 = this.viewModel;
        if (refundViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel5.getCountLiveData().observe(new RefundApplyActivity$onCreate$23(this), new RefundApplyActivity$onCreate$24(this));
        RefundViewModel refundViewModel6 = this.viewModel;
        if (refundViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel6.getInvalidStateListLiveData().observe(new RefundApplyActivity$onCreate$25(this), new RefundApplyActivity$onCreate$26(this));
        RefundViewModel refundViewModel7 = this.viewModel;
        if (refundViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel7.getShowDialogLiveData().observe(new RefundApplyActivity$onCreate$27(this), new RefundApplyActivity$onCreate$28(this));
        RefundViewModel refundViewModel8 = this.viewModel;
        if (refundViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel8.getErrorLiveData().observe(new RefundApplyActivity$onCreate$29(this), new RefundApplyActivity$onCreate$30(this));
        RefundViewModel refundViewModel9 = this.viewModel;
        if (refundViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundViewModel9.getPreRefundInfo();
    }

    public final void showConfirmDialog() {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "반품 신청을 진행하시겠어요?", "입력하신 정보가 맞는지\n다시 한 번 확인해주세요.\n확인 시 바로 반품 신청이 진행됩니다.", new RefundApplyActivity$showConfirmDialog$1(this), null, null, null, 0, DimensionsKt.HDPI, null);
    }

    public final void updatePreExchangeUi(@NotNull ExchangeRefundVariant exchangeRefundVariant) {
        Intrinsics.checkParameterIsNotNull(exchangeRefundVariant, "exchangeRefundVariant");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textProductInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductInfo");
        textView.setText(exchangeRefundVariant.getProductInfoSummary());
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textProductOptionInfo);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textProductOptionInfo");
        textView2.setText(exchangeRefundVariant.getProductOptionInfoSummary());
        if (exchangeRefundVariant.getRefundAccount() != null) {
            RefundAccount refundAccount = exchangeRefundVariant.getRefundAccount();
            ((EditText) _$_findCachedViewById(C0010R$id.editBankName)).setText(refundAccount.getBankName(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.editAccountNumber)).setText(refundAccount.getAccountNumber(), BufferType.EDITABLE);
            ((EditText) _$_findCachedViewById(C0010R$id.editAccountHolder)).setText(refundAccount.getAccountHolder(), BufferType.EDITABLE);
        }
    }

    public final void updateInvalidateView(@NotNull List<? extends RefundInvalidViewState> list) {
        Intrinsics.checkParameterIsNotNull(list, "invalidateList");
        updateValidViewAll();
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                RefundInvalidViewState refundInvalidViewState = (RefundInvalidViewState) list.get(i);
                View findViewById = findViewById(refundInvalidViewState.getViewId());
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(id)");
                TextView textView = (TextView) findViewById;
                if (i == 0) {
                    textView.requestFocus();
                    ((NestedScrollView) _$_findCachedViewById(C0010R$id.refundScrollView)).smoothScrollTo(0, (int) textView.getY());
                    ((NestedScrollView) _$_findCachedViewById(C0010R$id.refundScrollView)).smoothScrollTo(0, (int) textView.getY());
                }
                String str = "textAgreeNotice";
                if (refundInvalidViewState == RefundInvalidViewState.AGREEMENT_FAILED) {
                    TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textAgreeNotice);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                    textView2.setVisibility(0);
                } else {
                    TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textAgreeNotice);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, str);
                    textView3.setVisibility(4);
                }
                textView.setTextColor(ContextCompat.getColor(this, C0006R$color.neon_red));
                if (i != size) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void updateValidViewAll() {
        int color = ContextCompat.getColor(this, C0006R$color.gray6);
        ((TextView) _$_findCachedViewById(C0010R$id.textBankInfo)).setTextColor(color);
        ((TextView) _$_findCachedViewById(C0010R$id.textRefundReason)).setTextColor(color);
        ((TextView) _$_findCachedViewById(C0010R$id.textRefundDetailReason)).setTextColor(color);
        ((TextView) _$_findCachedViewById(C0010R$id.textAgreeWithTerms)).setTextColor(color);
    }

    public final void updateTextViewColor(@NotNull TextView textView, int i) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        textView.setTextColor(ContextCompat.getColor(this, i));
    }

    public final boolean isRadioButtonChecked() {
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C0010R$id.conatinerRadio);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "conatinerRadio");
        return radioGroup.getCheckedRadioButtonId() == 2131362740;
    }

    public void onBackPressed() {
        ActivityExtensionKt.finishWithAnimation(this, ActivityAnimationType.SLIDE_LTOR);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.viewDisposables.clear();
    }
}
