package kr.co.popone.fitts.feature.refund;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector.ExchangeReason;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundApplyCompleteFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    public RefundDetailViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RefundApplyCompleteFragment newInstance() {
            return new RefundApplyCompleteFragment();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[ExchangeReason.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[ExchangeReason.values().length];

        static {
            $EnumSwitchMapping$0[ExchangeReason.CUSTOMER_REMORSE.ordinal()] = 1;
            $EnumSwitchMapping$0[ExchangeReason.WRONG_ORDER.ordinal()] = 2;
            $EnumSwitchMapping$0[ExchangeReason.FAULTY_PRODUCT.ordinal()] = 3;
            $EnumSwitchMapping$0[ExchangeReason.SHIPPING_PROBLEM.ordinal()] = 4;
            $EnumSwitchMapping$1[ExchangeReason.CUSTOMER_REMORSE.ordinal()] = 1;
            $EnumSwitchMapping$1[ExchangeReason.WRONG_ORDER.ordinal()] = 2;
            $EnumSwitchMapping$1[ExchangeReason.FAULTY_PRODUCT.ordinal()] = 3;
            $EnumSwitchMapping$1[ExchangeReason.SHIPPING_PROBLEM.ordinal()] = 4;
        }
    }

    @NotNull
    public static final RefundApplyCompleteFragment newInstance() {
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
    public final RefundDetailViewModel getViewModel() {
        RefundDetailViewModel refundDetailViewModel = this.viewModel;
        if (refundDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return refundDetailViewModel;
    }

    public final void setViewModel(@NotNull RefundDetailViewModel refundDetailViewModel) {
        Intrinsics.checkParameterIsNotNull(refundDetailViewModel, "<set-?>");
        this.viewModel = refundDetailViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_return_apply_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonChangeMind)).setOnClickListener(new RefundApplyCompleteFragment$onViewCreated$1(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new RefundApplyCompleteFragment$onViewCreated$2(this));
        RefundDetailViewModel refundDetailViewModel = this.viewModel;
        String str = "viewModel";
        if (refundDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundDetailViewModel.getRefundInfoLiveData().observe(new RefundApplyCompleteFragment$onViewCreated$3(this), new RefundApplyCompleteFragment$onViewCreated$4(this));
        RefundDetailViewModel refundDetailViewModel2 = this.viewModel;
        if (refundDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundDetailViewModel2.getCancelCompleteLiveData().observe(new RefundApplyCompleteFragment$onViewCreated$5(this), new RefundApplyCompleteFragment$onViewCreated$6(this));
        RefundDetailViewModel refundDetailViewModel3 = this.viewModel;
        if (refundDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundDetailViewModel3.getPaymentMethod().observe(new RefundApplyCompleteFragment$onViewCreated$7(this), new RefundApplyCompleteFragment$onViewCreated$8(this));
        RefundDetailViewModel refundDetailViewModel4 = this.viewModel;
        if (refundDetailViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        refundDetailViewModel4.getErrorLiveData().observe(new RefundApplyCompleteFragment$onViewCreated$9(this), new RefundApplyCompleteFragment$onViewCreated$10(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateRefundDetailUi(@org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.remote.refund.RefundApplyResponse r7) {
        /*
            r6 = this;
            java.lang.String r0 = "exchangeApplyResponse"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.String r0 = r7.getRefundReason()
            if (r0 == 0) goto L_0x0246
            java.lang.String r0 = r0.toUpperCase()
            java.lang.String r1 = "(this as java.lang.String).toUpperCase()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.ui.custom.ExchangeReasonSelector$ExchangeReason r0 = kr.co.popone.fitts.ui.custom.ExchangeReasonSelector.ExchangeReason.valueOf(r0)
            int[] r1 = kr.co.popone.fitts.feature.refund.RefundApplyCompleteFragment.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 8
            java.lang.String r3 = "layoutSellerFault"
            r4 = 0
            java.lang.String r5 = "layoutUserFault"
            if (r0 == r1) goto L_0x0051
            r1 = 2
            if (r0 == r1) goto L_0x0051
            r1 = 3
            if (r0 == r1) goto L_0x0034
            r1 = 4
            if (r0 == r1) goto L_0x0034
            goto L_0x006d
        L_0x0034:
            int r0 = kr.co.popone.fitts.C0010R$id.layoutUserFault
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TableLayout r0 = (android.widget.TableLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setVisibility(r2)
            int r0 = kr.co.popone.fitts.C0010R$id.layoutSellerFault
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TableLayout r0 = (android.widget.TableLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r4)
            goto L_0x006d
        L_0x0051:
            int r0 = kr.co.popone.fitts.C0010R$id.layoutUserFault
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TableLayout r0 = (android.widget.TableLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setVisibility(r4)
            int r0 = kr.co.popone.fitts.C0010R$id.layoutSellerFault
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TableLayout r0 = (android.widget.TableLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r2)
        L_0x006d:
            int r0 = kr.co.popone.fitts.C0010R$id.textSellerName
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textSellerName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.store.StoreInfo r1 = r7.getStoreInfo()
            java.lang.String r1 = r1.getStoreName()
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textSellerAddress
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textSellerAddress"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.store.StoreInfo r1 = r7.getStoreInfo()
            java.lang.String r1 = r1.getReturnAddress()
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textProductSummary
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textProductSummary"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            kr.co.popone.fitts.model.store.StoreInfo r2 = r7.getStoreInfo()
            java.lang.String r2 = r2.getStoreName()
            r1.append(r2)
            java.lang.String r2 = " / "
            r1.append(r2)
            kr.co.popone.fitts.model.order.OrderListLineItemVariant r3 = r7.getOrderLineItemVariant()
            kr.co.popone.fitts.model.cart.CartVariants r3 = r3.getVariant()
            kr.co.popone.fitts.model.product.Product r3 = r3.getProduct()
            java.lang.String r3 = r3.getTitle()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textProductOptionSummary
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textProductOptionSummary"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            kr.co.popone.fitts.model.order.OrderListLineItemVariant r3 = r7.getOrderLineItemVariant()
            kr.co.popone.fitts.model.cart.CartVariants r3 = r3.getVariant()
            java.util.List r3 = r3.getOption()
            java.lang.String r3 = r6.getProductDetailSummary(r3)
            r1.append(r3)
            r1.append(r2)
            int r2 = r7.getQuantity()
            r1.append(r2)
            r2 = 44060(0xac1c, float:6.1741E-41)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textExchangeReason
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textExchangeReason"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.String r1 = r6.getExchangeReason(r7)
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textRefundDate
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textRefundDate"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy.MM.dd"
            r1.<init>(r2)
            java.util.Date r2 = r7.getAppliedAt()
            java.lang.String r1 = r1.format(r2)
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textRefundValue
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textRefundValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r1 = r7.getRefundValue()
            java.lang.String r1 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r1)
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textFinalRefundValue
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textFinalRefundValue"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r1 = r7.getRefundValue()
            int r2 = r7.getAdjustmentValue()
            int r1 = r1 + r2
            java.lang.String r1 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r1)
            r0.setText(r1)
            java.lang.String r0 = r7.getAdjustmentType()
            java.lang.String r1 = "textCouponAdjust"
            java.lang.String r2 = "textPointAdjust"
            if (r0 != 0) goto L_0x0188
            goto L_0x01d5
        L_0x0188:
            int r3 = r0.hashCode()
            r4 = -1354573786(0xffffffffaf42d826, float:-1.7720989E-10)
            if (r3 == r4) goto L_0x01b6
            r4 = 106845584(0x65e5590, float:4.181642E-35)
            if (r3 == r4) goto L_0x0197
            goto L_0x01d5
        L_0x0197:
            java.lang.String r3 = "point"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01d5
            int r0 = kr.co.popone.fitts.C0010R$id.textPointAdjust
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            int r1 = r7.getAdjustmentValue()
            java.lang.String r1 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r1)
            r0.setText(r1)
            goto L_0x01f3
        L_0x01b6:
            java.lang.String r3 = "coupon"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x01d5
            int r0 = kr.co.popone.fitts.C0010R$id.textCouponAdjust
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r1 = r7.getAdjustmentValue()
            java.lang.String r1 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r1)
            r0.setText(r1)
            goto L_0x01f3
        L_0x01d5:
            int r0 = kr.co.popone.fitts.C0010R$id.textPointAdjust
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            java.lang.String r2 = "0"
            r0.setText(r2)
            int r0 = kr.co.popone.fitts.C0010R$id.textCouponAdjust
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setText(r2)
        L_0x01f3:
            kr.co.popone.fitts.model.remote.model.RefundAccount r0 = r7.getRefundAccount()
            if (r0 == 0) goto L_0x0245
            int r0 = kr.co.popone.fitts.C0010R$id.textBankName
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textBankName"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            kr.co.popone.fitts.model.remote.model.RefundAccount r1 = r7.getRefundAccount()
            java.lang.String r1 = r1.getBankName()
            r0.setText(r1)
            int r0 = kr.co.popone.fitts.C0010R$id.textBankAccount
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "textBankAccount"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            kr.co.popone.fitts.model.remote.model.RefundAccount r2 = r7.getRefundAccount()
            java.lang.String r2 = r2.getAccountNumber()
            r1.append(r2)
            r2 = 32
            r1.append(r2)
            kr.co.popone.fitts.model.remote.model.RefundAccount r7 = r7.getRefundAccount()
            java.lang.String r7 = r7.getAccountHolder()
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.setText(r7)
        L_0x0245:
            return
        L_0x0246:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.refund.RefundApplyCompleteFragment.updateRefundDetailUi(kr.co.popone.fitts.model.remote.refund.RefundApplyResponse):void");
    }

    @NotNull
    public final String getExchangeReason(@NotNull RefundApplyResponse refundApplyResponse) {
        String str;
        Intrinsics.checkParameterIsNotNull(refundApplyResponse, "refundApplyResponse");
        String refundReason = refundApplyResponse.getRefundReason();
        if (refundReason != null) {
            String upperCase = refundReason.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            int i = WhenMappings.$EnumSwitchMapping$1[ExchangeReason.valueOf(upperCase).ordinal()];
            if (i == 1) {
                str = "고객변심";
            } else if (i == 2) {
                str = "주문실수";
            } else if (i == 3) {
                str = "상품하자";
            } else if (i == 4) {
                str = "오배송 및 지연";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" / ");
            sb.append(refundApplyResponse.getDetailReason());
            return sb.toString();
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public final String getProductDetailSummary(@NotNull List<VariantInfoOption> list) {
        Intrinsics.checkParameterIsNotNull(list, "options");
        String str = "";
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            VariantInfoOption variantInfoOption = (VariantInfoOption) next;
            if (i == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(variantInfoOption.getOptionValue());
                str = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" / ");
                sb2.append(variantInfoOption.getOptionValue());
                str = sb2.toString();
            }
            i = i2;
        }
        return str;
    }
}
