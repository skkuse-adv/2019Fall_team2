package kr.co.popone.fitts.feature.exchange;

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
import kr.co.popone.fitts.model.domain.exchange.ExchangeInvalidViewState;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;
import kr.co.popone.fitts.model.remote.model.RefundAccount;
import kr.co.popone.fitts.ui.DialogExtensions;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector;
import kr.co.popone.fitts.utils.ActivityAnimationType;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeApplyActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_LINE_ITEM_VARIANT_ID = StringKeyGenerator.Companion.generate(ExchangeApplyActivity.class, "order_line_item_variant_id");
    /* access modifiers changed from: private */
    public static final String KEY_PAYMENT_METHOD = KEY_PAYMENT_METHOD;
    private HashMap _$_findViewCache;
    private final CompositeDisposable viewDisposables = new CompositeDisposable();
    @NotNull
    public ExchangeViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, long j, @Nullable String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, ExchangeApplyActivity.class);
            intent.putExtra(ExchangeApplyActivity.KEY_ORDER_LINE_ITEM_VARIANT_ID, j);
            intent.putExtra(ExchangeApplyActivity.KEY_PAYMENT_METHOD, str);
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
    public final ExchangeViewModel getViewModel() {
        ExchangeViewModel exchangeViewModel = this.viewModel;
        if (exchangeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return exchangeViewModel;
    }

    public final void setViewModel(@NotNull ExchangeViewModel exchangeViewModel) {
        Intrinsics.checkParameterIsNotNull(exchangeViewModel, "<set-?>");
        this.viewModel = exchangeViewModel;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C0013R$layout.activity_exchange_apply);
        ExchangeViewModel exchangeViewModel = this.viewModel;
        String str = "viewModel";
        if (exchangeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel.initPaymentMethod(new ExchangeApplyActivity$onCreate$1(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonPlusCount)).setOnClickListener(new ExchangeApplyActivity$onCreate$2(this));
        ((TextView) _$_findCachedViewById(C0010R$id.buttonMinusCount)).setOnClickListener(new ExchangeApplyActivity$onCreate$3(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonApply)).setOnClickListener(new ExchangeApplyActivity$onCreate$4(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new ExchangeApplyActivity$onCreate$5(this));
        ((LinearLayout) _$_findCachedViewById(C0010R$id.layoutContainer)).setOnTouchListener(new ExchangeApplyActivity$onCreate$6(this));
        ExchangeViewModel exchangeViewModel2 = this.viewModel;
        if (exchangeViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel2.getPaymentMethod().observe(new ExchangeApplyActivity$onCreate$7(this), new ExchangeApplyActivity$onCreate$8(this));
        ((ExchangeReasonSelector) _$_findCachedViewById(C0010R$id.selectorExchangeReason)).getReasonLiveData().observe(new ExchangeApplyActivity$onCreate$9(this), new ExchangeApplyActivity$onCreate$10(this));
        CompositeDisposable compositeDisposable = this.viewDisposables;
        EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editOption);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editOption");
        InitialValueObservable textChanges = RxTextView.textChanges(editText);
        String str2 = "RxTextView.textChanges(this)";
        Intrinsics.checkExpressionValueIsNotNull(textChanges, str2);
        Disposable subscribe = textChanges.filter(new ExchangeApplyActivity$onCreate$11(this)).map(ExchangeApplyActivity$onCreate$12.INSTANCE).subscribe((Consumer<? super T>) new ExchangeApplyActivity$onCreate$13<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "editOption.textChanges()….gray6)\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.viewDisposables;
        EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editDetailReason);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "editDetailReason");
        InitialValueObservable textChanges2 = RxTextView.textChanges(editText2);
        Intrinsics.checkExpressionValueIsNotNull(textChanges2, str2);
        Disposable subscribe2 = textChanges2.filter(new ExchangeApplyActivity$onCreate$14(this)).map(ExchangeApplyActivity$onCreate$15.INSTANCE).subscribe((Consumer<? super T>) new ExchangeApplyActivity$onCreate$16<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe2, "editDetailReason.textCha….gray6)\n                }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.viewDisposables;
        Observables observables = Observables.INSTANCE;
        EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editBankName);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "editBankName");
        InitialValueObservable textChanges3 = RxTextView.textChanges(editText3);
        Intrinsics.checkExpressionValueIsNotNull(textChanges3, str2);
        EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.editAccountHolder);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "editAccountHolder");
        InitialValueObservable textChanges4 = RxTextView.textChanges(editText4);
        Intrinsics.checkExpressionValueIsNotNull(textChanges4, str2);
        EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "editAccountNumber");
        InitialValueObservable textChanges5 = RxTextView.textChanges(editText5);
        Intrinsics.checkExpressionValueIsNotNull(textChanges5, str2);
        Disposable subscribe3 = observables.combineLatest((Observable<T1>) textChanges3, (Observable<T2>) textChanges4, (Observable<T3>) textChanges5).filter(new ExchangeApplyActivity$onCreate$17(this)).map(ExchangeApplyActivity$onCreate$18.INSTANCE).subscribe((Consumer<? super T>) new ExchangeApplyActivity$onCreate$19<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe3, "Observables.combineLates…on_red)\n                }");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.viewDisposables;
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(C0010R$id.conatinerRadio);
        Intrinsics.checkExpressionValueIsNotNull(radioGroup, "conatinerRadio");
        InitialValueObservable checkedChanges = RxRadioGroup.checkedChanges(radioGroup);
        Intrinsics.checkExpressionValueIsNotNull(checkedChanges, "RxRadioGroup.checkedChanges(this)");
        Disposable subscribe4 = checkedChanges.filter(new ExchangeApplyActivity$onCreate$20(this)).map(new ExchangeApplyActivity$onCreate$21(this)).subscribe((Consumer<? super T>) new ExchangeApplyActivity$onCreate$22<Object>(this));
        Intrinsics.checkExpressionValueIsNotNull(subscribe4, "conatinerRadio.checkedCh…      }\n                }");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        ExchangeViewModel exchangeViewModel3 = this.viewModel;
        if (exchangeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel3.getPreExchangeLiveData().observe(new ExchangeApplyActivity$onCreate$23(this), new ExchangeApplyActivity$onCreate$24(this));
        ExchangeViewModel exchangeViewModel4 = this.viewModel;
        if (exchangeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel4.setOrderLineItemVariantId(new ExchangeApplyActivity$onCreate$25(this));
        ExchangeViewModel exchangeViewModel5 = this.viewModel;
        if (exchangeViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel5.getCountLiveData().observe(new ExchangeApplyActivity$onCreate$26(this), new ExchangeApplyActivity$onCreate$27(this));
        ExchangeViewModel exchangeViewModel6 = this.viewModel;
        if (exchangeViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel6.getInvalidStateListLiveData().observe(new ExchangeApplyActivity$onCreate$28(this), new ExchangeApplyActivity$onCreate$29(this));
        ExchangeViewModel exchangeViewModel7 = this.viewModel;
        if (exchangeViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel7.getShowDialogLiveData().observe(new ExchangeApplyActivity$onCreate$30(this), new ExchangeApplyActivity$onCreate$31(this));
        ExchangeViewModel exchangeViewModel8 = this.viewModel;
        if (exchangeViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel8.getErrorLiveData().observe(new ExchangeApplyActivity$onCreate$32(this), new ExchangeApplyActivity$onCreate$33(this));
        ExchangeViewModel exchangeViewModel9 = this.viewModel;
        if (exchangeViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeViewModel9.getPreExchangeInfo();
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

    public final void showConfirmDialog() {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this, "교환 신청을 진행하시겠어요?", "입력하신 정보가 맞는지\n다시 한 번 확인해주세요.\n확인 시 바로 교환 신청이 진행됩니다.", new ExchangeApplyActivity$showConfirmDialog$1(this), null, null, null, 0, DimensionsKt.HDPI, null);
    }

    public final void updateInvalidateView(@NotNull List<? extends ExchangeInvalidViewState> list) {
        Intrinsics.checkParameterIsNotNull(list, "invalidateList");
        updateValidViewAll();
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                ExchangeInvalidViewState exchangeInvalidViewState = (ExchangeInvalidViewState) list.get(i);
                View findViewById = findViewById(exchangeInvalidViewState.getViewId());
                Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(id)");
                TextView textView = (TextView) findViewById;
                if (i == 0) {
                    textView.requestFocus();
                    ((NestedScrollView) _$_findCachedViewById(C0010R$id.exchangeScrollView)).smoothScrollTo(0, (int) textView.getY());
                    ((NestedScrollView) _$_findCachedViewById(C0010R$id.exchangeScrollView)).smoothScrollTo(0, (int) textView.getY());
                }
                String str = "textAgreeNotice";
                if (exchangeInvalidViewState == ExchangeInvalidViewState.AGREEMENT_FAILED) {
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
        ((TextView) _$_findCachedViewById(C0010R$id.textExchangeOption)).setTextColor(color);
        ((TextView) _$_findCachedViewById(C0010R$id.textBankInfo)).setTextColor(color);
        ((TextView) _$_findCachedViewById(C0010R$id.textExchangeReason)).setTextColor(color);
        ((TextView) _$_findCachedViewById(C0010R$id.textExchangeDetailReason)).setTextColor(color);
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
