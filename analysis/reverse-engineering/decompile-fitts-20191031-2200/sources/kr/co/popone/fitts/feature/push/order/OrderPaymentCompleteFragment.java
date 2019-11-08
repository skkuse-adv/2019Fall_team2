package kr.co.popone.fitts.feature.push.order;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.datamodel.social.point.ExpectedReceivablePoint;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderDiscountType;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.ScreenUtilsKt;

public final class OrderPaymentCompleteFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderPaymentCompleteFragment.class, "key_order_id");
    private HashMap _$_findViewCache;
    @NotNull
    public OrderPushRendingViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderPaymentCompleteFragment newInstance(long j) {
            OrderPaymentCompleteFragment orderPaymentCompleteFragment = new OrderPaymentCompleteFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(OrderPaymentCompleteFragment.KEY_ORDER_ID, j);
            orderPaymentCompleteFragment.setArguments(bundle);
            return orderPaymentCompleteFragment;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[OrderDiscountType.values().length];

        static {
            $EnumSwitchMapping$0[OrderDiscountType.GENERAL.ordinal()] = 1;
            $EnumSwitchMapping$0[OrderDiscountType.SPECIAL_DISCOUNT.ordinal()] = 2;
            $EnumSwitchMapping$0[OrderDiscountType.FITTS_CARD.ordinal()] = 3;
        }
    }

    @NotNull
    public static final OrderPaymentCompleteFragment newInstance(long j) {
        return Companion.newInstance(j);
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
        return layoutInflater.inflate(C0013R$layout.fragment_order_payment_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderPaymentCompleteFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrderDetail)).setOnClickListener(new OrderPaymentCompleteFragment$onViewCreated$2(this));
        ((TextView) _$_findCachedViewById(C0010R$id.tvNCommercePointPredict)).setOnClickListener(new OrderPaymentCompleteFragment$onViewCreated$3(this));
        Bundle arguments = getArguments();
        String str = "viewModel";
        if (arguments != null) {
            long j = arguments.getLong(KEY_ORDER_ID);
            OrderPushRendingViewModel orderPushRendingViewModel = this.viewModel;
            if (orderPushRendingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel.requestOrderInfo(j);
            OrderPushRendingViewModel orderPushRendingViewModel2 = this.viewModel;
            if (orderPushRendingViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            }
            orderPushRendingViewModel2.getExtendedEarnPoint(j);
        }
        OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
        if (orderPushRendingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel3.getOrderDetailViewDataLiveData().observe(new OrderPaymentCompleteFragment$onViewCreated$5(this), new OrderPaymentCompleteFragment$onViewCreated$6(this));
        OrderPushRendingViewModel orderPushRendingViewModel4 = this.viewModel;
        if (orderPushRendingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel4.onExpectedReceivablePointUpdate().observe(this, new OrderPaymentCompleteFragment$sam$androidx_lifecycle_Observer$0(new OrderPaymentCompleteFragment$onViewCreated$7(this)));
        OrderPushRendingViewModel orderPushRendingViewModel5 = this.viewModel;
        if (orderPushRendingViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel5.getErrorLiveData().observe(new OrderPaymentCompleteFragment$onViewCreated$8(this), new OrderPaymentCompleteFragment$onViewCreated$9(this));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void updateDepositUi(OrderDetailViewData orderDetailViewData) {
        String str;
        if (orderDetailViewData != null) {
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textOrderNumber);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textOrderNumber");
            textView.setText(orderDetailViewData.getOrderNumber());
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textShippingName);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textShippingName");
            textView2.setText(orderDetailViewData.getShippingAddress().getName());
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textShippingContact);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "textShippingContact");
            textView3.setText(orderDetailViewData.getShippingAddress().getContact());
            TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textAddress);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "textAddress");
            StringBuilder sb = new StringBuilder();
            sb.append(orderDetailViewData.getShippingAddress().getAddress());
            sb.append(10);
            sb.append(orderDetailViewData.getShippingAddress().getAddress2());
            textView4.setText(sb.toString());
            TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.textShippingMemo);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "textShippingMemo");
            String message = orderDetailViewData.getShippingAddress().getMessage();
            if (message != null) {
                if (!(message.length() == 0)) {
                    str = orderDetailViewData.getShippingAddress().getMessage();
                    textView5.setText(str);
                    TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.textPaidPrice);
                    Intrinsics.checkExpressionValueIsNotNull(textView6, "textPaidPrice");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(IntExtensionsKt.commaString(orderDetailViewData.getTotalOrderPrice()));
                    sb2.append(50896);
                    textView6.setText(sb2.toString());
                }
            }
            str = "-";
            textView5.setText(str);
            TextView textView62 = (TextView) _$_findCachedViewById(C0010R$id.textPaidPrice);
            Intrinsics.checkExpressionValueIsNotNull(textView62, "textPaidPrice");
            StringBuilder sb22 = new StringBuilder();
            sb22.append(IntExtensionsKt.commaString(orderDetailViewData.getTotalOrderPrice()));
            sb22.append(50896);
            textView62.setText(sb22.toString());
        }
    }

    /* access modifiers changed from: private */
    public final void updateOrderStateImage(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[orderDetailViewData.getOrderDiscountType().ordinal()];
            if (i == 1) {
                loadOrderStateImage(C0008R$drawable.img_payment_complete_general, 0.1f);
                updateOrderState("fitts://collection/85?type=mixed", "fitts://collection/282?type=mixed");
            } else if (i == 2) {
                loadOrderStateImage(C0008R$drawable.img_payment_complete_special_price, 0.31111112f);
                updateOrderState("fitts://collection/84?type=mixed", "fitts://collection/268?type=mixed");
            } else if (i == 3) {
                loadOrderStateImage(C0008R$drawable.img_payment_complete_fittca, 0.43888888f);
                updateOrderState("fitts://collection/90?type=mixed", "fitts://collection/285?type=mixed");
            }
        }
    }

    private final void updateOrderState(String str, String str2) {
        ((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState)).setOnClickListener(new OrderPaymentCompleteFragment$updateOrderState$1(this, str, str2));
    }

    private final void loadOrderStateImage(int i, float f) {
        Context context = getContext();
        int screenWidth = context != null ? ScreenUtilsKt.screenWidth(context) : 0;
        Glide.with((Fragment) this).load(Integer.valueOf(i)).apply(new RequestOptions().override(screenWidth, (int) (((float) screenWidth) * f))).into((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState));
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
}
