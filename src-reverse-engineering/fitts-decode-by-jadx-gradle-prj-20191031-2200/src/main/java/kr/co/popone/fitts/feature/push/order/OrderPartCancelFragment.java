package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.Observables;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.ScreenUtilsKt;

public final class OrderPartCancelFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_FAULT_BY = StringKeyGenerator.Companion.generate(OrderPartCancelFragment.class, "key_fault_by");
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderPartCancelFragment.class, "key_order_id");
    /* access modifiers changed from: private */
    public static final String KEY_VARIANT_ID = StringKeyGenerator.Companion.generate(OrderPartCancelFragment.class, "key_variant_id");
    private final float IMAGE_RATIO_CUSTOMER_FAULT = 0.4888889f;
    private HashMap _$_findViewCache;
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    public OrderPushRendingViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderPartCancelFragment newInstance(long j, long j2, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "faultBy");
            OrderPartCancelFragment orderPartCancelFragment = new OrderPartCancelFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(OrderPartCancelFragment.KEY_ORDER_ID, j);
            bundle.putLong(OrderPartCancelFragment.KEY_VARIANT_ID, j2);
            bundle.putString(OrderPartCancelFragment.KEY_FAULT_BY, str);
            orderPartCancelFragment.setArguments(bundle);
            return orderPartCancelFragment;
        }
    }

    @NotNull
    public static final OrderPartCancelFragment newInstance(long j, long j2, @NotNull String str) {
        return Companion.newInstance(j, j2, str);
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
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final OrderPushRendingViewModel getViewModel() {
        OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
        if (orderPushRendingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderPushRendingViewModel;
    }

    public final void setViewModel(@NotNull OrderPushRendingViewModel orderPushRendingViewModel) {
        Intrinsics.checkParameterIsNotNull(orderPushRendingViewModel, "<set-?>");
        this.viewModel = orderPushRendingViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_order_cancel_partialy, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderPartCancelFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrderDetail)).setOnClickListener(new OrderPartCancelFragment$onViewCreated$2(this));
        Bundle arguments = getArguments();
        String str = "viewModel";
        if (arguments != null) {
            long j = arguments.getLong(KEY_ORDER_ID);
            OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
            if (orderPushRendingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel.requestOrderInfo(j);
        }
        OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
        if (orderPushRendingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel2.getOrderDetailViewDataLiveData().observe(new OrderPartCancelFragment$onViewCreated$4(this), new OrderPartCancelFragment$onViewCreated$5(this));
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            long j2 = arguments2.getLong(KEY_VARIANT_ID);
            OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
            if (orderPushRendingViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel3.requestPreRefundItemInfo(j2);
        }
        OrderPushRendingViewModel orderPushRendingViewModel4 = this.viewModel;
        if (orderPushRendingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel4.getExchangeRefundLiveData().observe(new OrderPartCancelFragment$onViewCreated$7(this), new OrderPartCancelFragment$onViewCreated$8(this));
        OrderPushRendingViewModel orderPushRendingViewModel5 = this.viewModel;
        if (orderPushRendingViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel5.getErrorLiveData().observe(new OrderPartCancelFragment$onViewCreated$9(this), new OrderPartCancelFragment$onViewCreated$10(this));
        updateReasonImage();
    }

    private final void updateReasonImage() {
        Context context = getContext();
        int screenWidth = context != null ? ScreenUtilsKt.screenWidth(context) : 0;
        Glide.with((Fragment) this).load(Integer.valueOf(C0008R$drawable.img_order_part_cancel)).apply(new RequestOptions().override(screenWidth, (int) (((float) screenWidth) * this.IMAGE_RATIO_CUSTOMER_FAULT))).into((ImageView) _$_findCachedViewById(C0010R$id.imageCancelReason));
    }

    /* access modifiers changed from: private */
    public final void updateViewByPaymentType(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textOrderNumber);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderNumber");
            textView.setText(orderDetailViewData.getOrderNumber());
            String paymentMethod = orderDetailViewData.getPaymentMethod();
            if (paymentMethod != null) {
                int hashCode = paymentMethod.hashCode();
                String str = "textRefundDesc";
                String str2 = "layoutInputDeposit";
                String str3 = "buttonInputDone";
                String str4 = "editAccountNumber";
                if (hashCode != -900308920) {
                    if (hashCode != -303793002) {
                        if (hashCode != 846974213 || !paymentMethod.equals("kakaopay")) {
                            return;
                        }
                    } else if (!paymentMethod.equals("credit_card")) {
                        return;
                    }
                    Button button = (Button) _$_findCachedViewById(C0010R$id.buttonInputDone);
                    Intrinsics.checkExpressionValueIsNotNull(button, str3);
                    button.setVisibility(8);
                    LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutInputDeposit);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout, str2);
                    linearLayout.setVisibility(8);
                    EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
                    Intrinsics.checkExpressionValueIsNotNull(editText, str4);
                    editText.setVisibility(8);
                    TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textRefundDesc);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                    textView2.setText("구매 시 결제하신 결제수단으로 \n자동 환불될 예정입니다.");
                } else if (paymentMethod.equals("direct_deposit")) {
                    Button button2 = (Button) _$_findCachedViewById(C0010R$id.buttonInputDone);
                    Intrinsics.checkExpressionValueIsNotNull(button2, str3);
                    button2.setVisibility(0);
                    LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutInputDeposit);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str2);
                    linearLayout2.setVisibility(0);
                    EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
                    Intrinsics.checkExpressionValueIsNotNull(editText2, str4);
                    editText2.setVisibility(0);
                    TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textRefundDesc);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, str);
                    textView3.setText("환불 계좌를 입력해 주시면\n환불을 도와드리도록 하겠습니다.");
                    ((Button) _$_findCachedViewById(C0010R$id.buttonInputDone)).setOnClickListener(new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$1(this));
                    OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
                    String str5 = "viewModel";
                    if (orderPushRendingViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str5);
                    }
                    orderPushRendingViewModel.requestRefundAccount();
                    OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
                    if (orderPushRendingViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str5);
                    }
                    orderPushRendingViewModel2.getRefundAccountLiveData().observe(new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$2(this), new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$3(this));
                    OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
                    if (orderPushRendingViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str5);
                    }
                    orderPushRendingViewModel3.getRefundAccountInputedLiveData().observe(new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$4(this), new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$5(this));
                    OrderPushRendingViewModel orderPushRendingViewModel4 = this.viewModel;
                    if (orderPushRendingViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str5);
                    }
                    orderPushRendingViewModel4.getInvalidStateLiveData().observe(new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$6(this), new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$7(this));
                    CompositeDisposable compositeDisposable = this.disposables;
                    Observables observables = Observables.INSTANCE;
                    EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editBankName);
                    Intrinsics.checkExpressionValueIsNotNull(editText3, "editBankName");
                    InitialValueObservable textChanges = RxTextView.textChanges(editText3);
                    String str6 = "RxTextView.textChanges(this)";
                    Intrinsics.checkExpressionValueIsNotNull(textChanges, str6);
                    EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.editAccountHolder);
                    Intrinsics.checkExpressionValueIsNotNull(editText4, "editAccountHolder");
                    InitialValueObservable textChanges2 = RxTextView.textChanges(editText4);
                    Intrinsics.checkExpressionValueIsNotNull(textChanges2, str6);
                    EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
                    Intrinsics.checkExpressionValueIsNotNull(editText5, str4);
                    InitialValueObservable textChanges3 = RxTextView.textChanges(editText5);
                    Intrinsics.checkExpressionValueIsNotNull(textChanges3, str6);
                    Disposable subscribe = observables.combineLatest((Observable<T1>) textChanges, (Observable<T2>) textChanges2, (Observable<T3>) textChanges3).filter(new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$8(this)).map(OrderPartCancelFragment$updateViewByPaymentType$1$9.INSTANCE).subscribe((Consumer<? super T>) new OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$9<Object>(this));
                    Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observables.combineLates…                        }");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                }
            }
        }
    }

    public void onDestroy() {
        this.disposables.dispose();
        super.onDestroy();
    }
}
