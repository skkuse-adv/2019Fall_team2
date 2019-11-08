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

public final class OrderAllCancelFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_FAULT_BY = StringKeyGenerator.Companion.generate(OrderAllCancelFragment.class, "key_fault_by");
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderAllCancelFragment.class, "key_order_id");
    private final float IMAGE_RATIO_CUSTOMER_FAULT = 0.3888889f;
    private HashMap _$_findViewCache;
    private final CompositeDisposable dispoables = new CompositeDisposable();
    @NotNull
    public OrderPushRendingViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderAllCancelFragment newInstance(long j, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "faultBy");
            OrderAllCancelFragment orderAllCancelFragment = new OrderAllCancelFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(OrderAllCancelFragment.KEY_ORDER_ID, j);
            bundle.putString(OrderAllCancelFragment.KEY_FAULT_BY, str);
            orderAllCancelFragment.setArguments(bundle);
            return orderAllCancelFragment;
        }
    }

    @NotNull
    public static final OrderAllCancelFragment newInstance(long j, @NotNull String str) {
        return Companion.newInstance(j, str);
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
        return layoutInflater.inflate(C0013R$layout.fragment_order_cancel_all, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderAllCancelFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrderDetail)).setOnClickListener(new OrderAllCancelFragment$onViewCreated$2(this));
        OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
        String str = "viewModel";
        if (orderPushRendingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel.getOrderDetailViewDataLiveData().observe(new OrderAllCancelFragment$onViewCreated$3(this), new OrderAllCancelFragment$onViewCreated$4(this));
        OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
        if (orderPushRendingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel2.getErrorLiveData().observe(new OrderAllCancelFragment$onViewCreated$5(this), new OrderAllCancelFragment$onViewCreated$6(this));
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j = arguments.getLong(KEY_ORDER_ID);
            OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
            if (orderPushRendingViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel3.requestOrderInfo(j);
        }
        updateReasonImage();
    }

    private final void updateReasonImage() {
        Context context = getContext();
        int screenWidth = context != null ? ScreenUtilsKt.screenWidth(context) : 0;
        Glide.with((Fragment) this).load(Integer.valueOf(C0008R$drawable.img_order_all_cancel)).apply(new RequestOptions().override(screenWidth, (int) (((float) screenWidth) * this.IMAGE_RATIO_CUSTOMER_FAULT))).into((ImageView) _$_findCachedViewById(C0010R$id.imageCancelReason));
    }

    /* access modifiers changed from: private */
    public final void updateUiByPaymentMethod(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textOrderNumber);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderNumber");
            textView.setText(orderDetailViewData.getOrderNumber());
            String paymentMethod = orderDetailViewData.getPaymentMethod();
            if (paymentMethod != null) {
                int hashCode = paymentMethod.hashCode();
                String str = "layoutInputRefundInfo";
                String str2 = "buttonInputDone";
                String str3 = "textRefundDesc";
                String str4 = "editAccountNumber";
                if (hashCode != -900308920) {
                    if (hashCode != -303793002) {
                        if (hashCode != 846974213 || !paymentMethod.equals("kakaopay")) {
                            return;
                        }
                    } else if (!paymentMethod.equals("credit_card")) {
                        return;
                    }
                    TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textRefundDesc);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str3);
                    textView2.setText("구매 시 결제하신 결제수단으로 \n자동 환불될 예정입니다.");
                    EditText editText = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
                    Intrinsics.checkExpressionValueIsNotNull(editText, str4);
                    editText.setVisibility(8);
                    Button button = (Button) _$_findCachedViewById(C0010R$id.buttonInputDone);
                    Intrinsics.checkExpressionValueIsNotNull(button, str2);
                    button.setVisibility(8);
                    LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutInputRefundInfo);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout, str);
                    linearLayout.setVisibility(8);
                } else if (paymentMethod.equals("direct_deposit")) {
                    TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textRefundDesc);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, str3);
                    textView3.setText("환불 계좌를 입력해 주시면\n환불을 도와드리도록 하겠습니다.");
                    EditText editText2 = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
                    Intrinsics.checkExpressionValueIsNotNull(editText2, str4);
                    editText2.setVisibility(0);
                    Button button2 = (Button) _$_findCachedViewById(C0010R$id.buttonInputDone);
                    Intrinsics.checkExpressionValueIsNotNull(button2, str2);
                    button2.setVisibility(0);
                    LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C0010R$id.layoutInputRefundInfo);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout2, str);
                    linearLayout2.setVisibility(0);
                    CompositeDisposable compositeDisposable = this.dispoables;
                    Observables observables = Observables.INSTANCE;
                    EditText editText3 = (EditText) _$_findCachedViewById(C0010R$id.editBankName);
                    Intrinsics.checkExpressionValueIsNotNull(editText3, "editBankName");
                    InitialValueObservable textChanges = RxTextView.textChanges(editText3);
                    String str5 = "RxTextView.textChanges(this)";
                    Intrinsics.checkExpressionValueIsNotNull(textChanges, str5);
                    EditText editText4 = (EditText) _$_findCachedViewById(C0010R$id.editAccountHolder);
                    Intrinsics.checkExpressionValueIsNotNull(editText4, "editAccountHolder");
                    InitialValueObservable textChanges2 = RxTextView.textChanges(editText4);
                    Intrinsics.checkExpressionValueIsNotNull(textChanges2, str5);
                    EditText editText5 = (EditText) _$_findCachedViewById(C0010R$id.editAccountNumber);
                    Intrinsics.checkExpressionValueIsNotNull(editText5, str4);
                    InitialValueObservable textChanges3 = RxTextView.textChanges(editText5);
                    Intrinsics.checkExpressionValueIsNotNull(textChanges3, str5);
                    Disposable subscribe = observables.combineLatest((Observable<T1>) textChanges, (Observable<T2>) textChanges2, (Observable<T3>) textChanges3).filter(new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$1(this)).map(OrderAllCancelFragment$updateUiByPaymentMethod$1$2.INSTANCE).subscribe((Consumer<? super T>) new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$2<Object>(this));
                    Intrinsics.checkExpressionValueIsNotNull(subscribe, "Observables.combineLates…                        }");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                    OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
                    String str6 = "viewModel";
                    if (orderPushRendingViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                    }
                    orderPushRendingViewModel.requestRefundAccount();
                    OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
                    if (orderPushRendingViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                    }
                    orderPushRendingViewModel2.getRefundAccountLiveData().observe(new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$3(this), new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$4(this));
                    ((Button) _$_findCachedViewById(C0010R$id.buttonInputDone)).setOnClickListener(new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$5(this));
                    OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
                    if (orderPushRendingViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                    }
                    orderPushRendingViewModel3.getInvalidStateLiveData().observe(new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$6(this), new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$7(this));
                    OrderPushRendingViewModel orderPushRendingViewModel4 = this.viewModel;
                    if (orderPushRendingViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str6);
                    }
                    orderPushRendingViewModel4.getRefundAccountInputedLiveData().observe(new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$8(this), new OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$9(this));
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.dispoables.clear();
    }
}
