package kr.co.popone.fitts.feature.order.complete;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import photopicker.utils.ScreenUtilsKt;

public final class OrderCompleteRenderReservationFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private final float FITTS_CARD_IMAGE_RATIO = 0.41944444f;
    private final float GENERAL_IMAGE_RATIO = 0.375f;
    /* access modifiers changed from: private */
    public final String SCHEME_ALPHA = "fitts://collection/85?type=mixed";
    /* access modifiers changed from: private */
    public final String SCHEME_BETA = "fitts://collection/282?type=mixed";
    private final float SPECIAL_DISCOUNT_IMAGE_RATIO = 0.2666f;
    private HashMap _$_findViewCache;
    @NotNull
    public OrderCompleteRenderViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrderCompleteRenderReservationFragment newInstance() {
            return new OrderCompleteRenderReservationFragment();
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
    public static final OrderCompleteRenderReservationFragment newInstance() {
        return Companion.newInstance();
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
    public final OrderCompleteRenderViewModel getViewModel() {
        OrderCompleteRenderViewModel orderCompleteRenderViewModel = this.viewModel;
        if (orderCompleteRenderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return orderCompleteRenderViewModel;
    }

    public final void setViewModel(@NotNull OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        Intrinsics.checkParameterIsNotNull(orderCompleteRenderViewModel, "<set-?>");
        this.viewModel = orderCompleteRenderViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_order_result_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(C0010R$id.textCopyAccount)).setOnClickListener(new OrderCompleteRenderReservationFragment$onViewCreated$1(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonGoShopping)).setOnClickListener(new OrderCompleteRenderReservationFragment$onViewCreated$2(this));
        ((Button) _$_findCachedViewById(C0010R$id.buttonOrderDetail)).setOnClickListener(new OrderCompleteRenderReservationFragment$onViewCreated$3(this));
        ((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState)).setOnClickListener(new OrderCompleteRenderReservationFragment$onViewCreated$4(this));
        OrderCompleteRenderViewModel orderCompleteRenderViewModel = this.viewModel;
        String str = "viewModel";
        if (orderCompleteRenderViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderCompleteRenderViewModel.getOrderDetailViewDataLiveData().observe(new OrderCompleteRenderReservationFragment$onViewCreated$5(this), new OrderCompleteRenderReservationFragment$onViewCreated$6(this));
        OrderCompleteRenderViewModel orderCompleteRenderViewModel2 = this.viewModel;
        if (orderCompleteRenderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        orderCompleteRenderViewModel2.getErrorLiveData().observe(new OrderCompleteRenderReservationFragment$onViewCreated$7(this), new OrderCompleteRenderReservationFragment$onViewCreated$8(this));
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
            if (r5 == 0) goto L_0x0109
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
            java.lang.String r1 = r5.getOrderNumber()
            r0.setText(r1)
            kr.co.popone.fitts.model.payment.PaymentInfo r0 = r5.getPaymentInfo()
            if (r0 == 0) goto L_0x00e8
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r2 = "M월 d일"
            r0.<init>(r2, r1)
            int r1 = kr.co.popone.fitts.C0010R$id.textDate
            android.view.View r1 = r4._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "textDate"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            kr.co.popone.fitts.model.payment.PaymentInfo r5 = r5.getPaymentInfo()
            java.util.Date r5 = r5.getDueDate()
            java.lang.String r5 = r0.format(r5)
            r1.setText(r5)
            goto L_0x0109
        L_0x00e8:
            int r5 = kr.co.popone.fitts.C0010R$id.endDateLayout
            android.view.View r5 = r4._$_findCachedViewById(r5)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            java.lang.String r0 = "endDateLayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r0)
            r0 = 4
            r5.setVisibility(r0)
            int r5 = kr.co.popone.fitts.C0010R$id.textEndDateWarning
            android.view.View r5 = r4._$_findCachedViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r1 = "textEndDateWarning"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)
            r5.setVisibility(r0)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderReservationFragment.updateDepositUi(kr.co.popone.fitts.model.order.OrderDetailViewData):void");
    }

    /* access modifiers changed from: private */
    public final void updateOrderStateImage(OrderDetailViewData orderDetailViewData) {
        if (orderDetailViewData != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[orderDetailViewData.getOrderDiscountType().ordinal()];
            if (i == 1) {
                loadOrderStateImage(C0008R$drawable.img_reservation_complete_general, this.GENERAL_IMAGE_RATIO);
            } else if (i == 2) {
                loadOrderStateImage(C0008R$drawable.img_reservation_complete_special_discount, this.SPECIAL_DISCOUNT_IMAGE_RATIO);
            } else if (i == 3) {
                loadOrderStateImage(C0008R$drawable.img_reservation_complete_fittca, this.FITTS_CARD_IMAGE_RATIO);
            }
        }
    }

    private final void loadOrderStateImage(int i, float f) {
        Context context = getContext();
        int screenWidth = context != null ? ScreenUtilsKt.screenWidth(context) : 0;
        Glide.with((Fragment) this).load(Integer.valueOf(i)).apply(new RequestOptions().override(screenWidth, (int) (((float) screenWidth) * f))).into((ImageView) _$_findCachedViewById(C0010R$id.imageOrderState));
    }
}
