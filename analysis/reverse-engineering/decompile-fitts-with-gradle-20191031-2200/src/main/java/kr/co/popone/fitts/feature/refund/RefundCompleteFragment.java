package kr.co.popone.fitts.feature.refund;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class RefundCompleteFragment extends Fragment {
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
        public final RefundCompleteFragment newInstance() {
            return new RefundCompleteFragment();
        }
    }

    @NotNull
    public static final RefundCompleteFragment newInstance() {
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
        return layoutInflater.inflate(C0013R$layout.fragment_return_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new RefundCompleteFragment$onViewCreated$1(this));
        RefundDetailViewModel refundDetailViewModel = this.viewModel;
        if (refundDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        refundDetailViewModel.getRefundInfoLiveData().observe(new RefundCompleteFragment$onViewCreated$2(this), new RefundCompleteFragment$onViewCreated$3(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0181  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateExchangeDetailUi(@org.jetbrains.annotations.NotNull kr.co.popone.fitts.model.remote.refund.RefundApplyResponse r7) {
        /*
            r6 = this;
            java.lang.String r0 = "refundApplyResponse"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
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
            if (r0 != 0) goto L_0x00dc
            goto L_0x0129
        L_0x00dc:
            int r3 = r0.hashCode()
            r4 = -1354573786(0xffffffffaf42d826, float:-1.7720989E-10)
            if (r3 == r4) goto L_0x010a
            r4 = 106845584(0x65e5590, float:4.181642E-35)
            if (r3 == r4) goto L_0x00eb
            goto L_0x0129
        L_0x00eb:
            java.lang.String r3 = "point"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0129
            int r0 = kr.co.popone.fitts.C0010R$id.textPointAdjust
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            int r1 = r7.getAdjustmentValue()
            java.lang.String r1 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r1)
            r0.setText(r1)
            goto L_0x0147
        L_0x010a:
            java.lang.String r3 = "coupon"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0129
            int r0 = kr.co.popone.fitts.C0010R$id.textCouponAdjust
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            int r1 = r7.getAdjustmentValue()
            java.lang.String r1 = kr.co.popone.fitts.utils.IntExtensionsKt.commaString(r1)
            r0.setText(r1)
            goto L_0x0147
        L_0x0129:
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
        L_0x0147:
            kr.co.popone.fitts.model.remote.model.RefundAccount r0 = r7.getRefundAccount()
            java.lang.String r1 = "textRefundDeposit"
            java.lang.String r2 = "tableBankInfo"
            java.lang.String r3 = "textPaymentRefunDesc"
            r4 = 0
            r5 = 8
            if (r0 != 0) goto L_0x0181
            int r7 = kr.co.popone.fitts.C0010R$id.textPaymentRefunDesc
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r3)
            r7.setVisibility(r4)
            int r7 = kr.co.popone.fitts.C0010R$id.tableBankInfo
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.TableLayout r7 = (android.widget.TableLayout) r7
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            r7.setVisibility(r5)
            int r7 = kr.co.popone.fitts.C0010R$id.textRefundDeposit
            android.view.View r7 = r6._$_findCachedViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r1)
            r7.setVisibility(r5)
            goto L_0x01f7
        L_0x0181:
            int r0 = kr.co.popone.fitts.C0010R$id.textPaymentRefunDesc
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r5)
            int r0 = kr.co.popone.fitts.C0010R$id.tableBankInfo
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TableLayout r0 = (android.widget.TableLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setVisibility(r4)
            int r0 = kr.co.popone.fitts.C0010R$id.textRefundDeposit
            android.view.View r0 = r6._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r4)
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
        L_0x01f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.refund.RefundCompleteFragment.updateExchangeDetailUi(kr.co.popone.fitts.model.remote.refund.RefundApplyResponse):void");
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
