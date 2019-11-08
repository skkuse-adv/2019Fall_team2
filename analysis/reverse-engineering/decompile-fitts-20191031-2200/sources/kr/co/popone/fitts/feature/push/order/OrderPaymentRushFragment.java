package kr.co.popone.fitts.feature.push.order;

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
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderDiscountType;
import kr.co.popone.fitts.ui.StringKeyGenerator;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.ScreenUtilsKt;

public final class OrderPaymentRushFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final String KEY_ORDER_ID = StringKeyGenerator.Companion.generate(OrderPaymentRushFragment.class, "key_order_id");
    private final float FITTS_CARD_IMAGE_RATIO = 0.42222223f;
    private final float GENERAL_IMAGE_RATIO = 0.4333f;
    /* access modifiers changed from: private */
    public final String SCHEME_ALPHA = "fitts://collection/85?type=mixed";
    /* access modifiers changed from: private */
    public final String SCHEME_BETA = "fitts://collection/282?type=mixed";
    private final float SPECIAL_DISCOUNT_IMAGE_RATIO = 0.3444f;
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
        public final OrderPaymentRushFragment newInstance(long j) {
            OrderPaymentRushFragment orderPaymentRushFragment = new OrderPaymentRushFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(OrderPaymentRushFragment.KEY_ORDER_ID, j);
            orderPaymentRushFragment.setArguments(bundle);
            return orderPaymentRushFragment;
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
    public static final OrderPaymentRushFragment newInstance(long j) {
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
        return layoutInflater.inflate(C0013R$layout.fragment_order_payment_rush, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new OrderPaymentRushFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrderDetail)).setOnClickListener(new OrderPaymentRushFragment$onViewCreated$2(this));
        ((TextView) _$_findCachedViewById(C0010R$id.textCopyAccount)).setOnClickListener(new OrderPaymentRushFragment$onViewCreated$3(this));
        ((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState)).setOnClickListener(new OrderPaymentRushFragment$onViewCreated$4(this));
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
        orderPushRendingViewModel2.getOrderDetailViewDataLiveData().observe(new OrderPaymentRushFragment$onViewCreated$6(this), new OrderPaymentRushFragment$onViewCreated$7(this));
        OrderPushRendingViewModel orderPushRendingViewModel3 = this.viewModel;
        if (orderPushRendingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderPushRendingViewModel3.getErrorLiveData().observe(new OrderPaymentRushFragment$onViewCreated$8(this), new OrderPaymentRushFragment$onViewCreated$9(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0081, code lost:
        if (r1 != null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009f, code lost:
        if (r1 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001b, code lost:
        if (r1 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0039, code lost:
        if (r1 != null) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateDepositUi(kr.co.popone.fitts.model.order.OrderDetailViewData r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x00ba
            int r0 = kr.co.popone.fitts.C0010R$id.textRemittorName
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textRemittorName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r5.getPaymentInfo()
            java.lang.String r2 = "-"
            if (r1 == 0) goto L_0x001e
            java.lang.String r1 = r1.getRemittorName()
            if (r1 == 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textBankName
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textBankName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r5.getPaymentInfo()
            if (r1 == 0) goto L_0x003c
            java.lang.String r1 = r1.getBankName()
            if (r1 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textPrice
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textPrice"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r3 = r5.getTotalOrderPrice()
            java.lang.String r3 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r3)
            r1.append(r3)
            r3 = 50896(0xc6d0, float:7.132E-41)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textAccountHolder
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textAccountHolder"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r5.getPaymentInfo()
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = r1.getAccountHolder()
            if (r1 == 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r1 = r2
        L_0x0085:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textAccountNumber
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textAccountNumber"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r1 = r5.getPaymentInfo()
            if (r1 == 0) goto L_0x00a2
            java.lang.String r1 = r1.getAccountNumber()
            if (r1 == 0) goto L_0x00a2
            goto L_0x00a3
        L_0x00a2:
            r1 = r2
        L_0x00a3:
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textOrderNumber
            android.view.View r0 = r4._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textOrderNumber"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r5 = r5.getOrderNumber()
            r0.setText(r5)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.push.order.OrderPaymentRushFragment.updateDepositUi(kr.co.popone.fitts.model.order.OrderDetailViewData):void");
    }

    /* access modifiers changed from: private */
    public final void updateOrderStateImage(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[orderDetailViewData.getOrderDiscountType().ordinal()];
            if (i == 1) {
                loadOrderStateImage(C0008R$drawable.img_reservation_rush_general, this.GENERAL_IMAGE_RATIO);
            } else if (i == 2) {
                loadOrderStateImage(C0008R$drawable.img_reservation_rush_special_discount, this.SPECIAL_DISCOUNT_IMAGE_RATIO);
            } else if (i == 3) {
                loadOrderStateImage(C0008R$drawable.img_reservation_rush_fittca, this.FITTS_CARD_IMAGE_RATIO);
            }
        }
    }

    private final void loadOrderStateImage(int i, float f) {
        Context context = getContext();
        int screenWidth = context != null ? ScreenUtilsKt.screenWidth(context) : 0;
        Glide.with((Fragment) this).load(Integer.valueOf(i)).apply(new RequestOptions().override(screenWidth, (int) (((float) screenWidth) * f))).into((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState));
    }
}
