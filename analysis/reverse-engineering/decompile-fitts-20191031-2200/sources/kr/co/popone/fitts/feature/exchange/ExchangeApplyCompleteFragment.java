package kr.co.popone.fitts.feature.exchange;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.product.VariantInfoOption;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector.ExchangeReason;
import kr.co.popone.fitts.viewmodel.exchange.detail.ExchangeDetailViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ExchangeApplyCompleteFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @NotNull
    public ExchangeDetailViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExchangeApplyCompleteFragment newInstance() {
            return new ExchangeApplyCompleteFragment();
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
    public final ExchangeDetailViewModel getViewModel() {
        ExchangeDetailViewModel exchangeDetailViewModel = this.viewModel;
        if (exchangeDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return exchangeDetailViewModel;
    }

    public final void setViewModel(@NotNull ExchangeDetailViewModel exchangeDetailViewModel) {
        Intrinsics.checkParameterIsNotNull(exchangeDetailViewModel, "<set-?>");
        this.viewModel = exchangeDetailViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_exchange_apply_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(C0010R$id.buttonChangeMind)).setOnClickListener(new ExchangeApplyCompleteFragment$onViewCreated$1(this));
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new ExchangeApplyCompleteFragment$onViewCreated$2(this));
        ExchangeDetailViewModel exchangeDetailViewModel = this.viewModel;
        String str = "viewModel";
        if (exchangeDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeDetailViewModel.getExchangeInfoLiveData().observe(new ExchangeApplyCompleteFragment$onViewCreated$3(this), new ExchangeApplyCompleteFragment$onViewCreated$4(this));
        ExchangeDetailViewModel exchangeDetailViewModel2 = this.viewModel;
        if (exchangeDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeDetailViewModel2.getCancelCompleteLiveData().observe(new ExchangeApplyCompleteFragment$onViewCreated$5(this), new ExchangeApplyCompleteFragment$onViewCreated$6(this));
        ExchangeDetailViewModel exchangeDetailViewModel3 = this.viewModel;
        if (exchangeDetailViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeDetailViewModel3.getPaymentMethod().observe(new ExchangeApplyCompleteFragment$onViewCreated$7(this), new ExchangeApplyCompleteFragment$onViewCreated$8(this));
        ExchangeDetailViewModel exchangeDetailViewModel4 = this.viewModel;
        if (exchangeDetailViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        exchangeDetailViewModel4.getErrorLiveData().observe(new ExchangeApplyCompleteFragment$onViewCreated$9(this), new ExchangeApplyCompleteFragment$onViewCreated$10(this));
    }

    public final void updateExchangeDetailUi(@NotNull ExchangeApplyResponse exchangeApplyResponse) {
        Intrinsics.checkParameterIsNotNull(exchangeApplyResponse, "exchangeApplyResponse");
        String exchangeReason = exchangeApplyResponse.getExchangeReason();
        if (exchangeReason != null) {
            String upperCase = exchangeReason.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            int i = WhenMappings.$EnumSwitchMapping$0[ExchangeReason.valueOf(upperCase).ordinal()];
            String str = "layoutExchangeInfoSellerFault";
            String str2 = "layoutExchangeInfoUserFault";
            if (i == 1 || i == 2) {
                TableLayout tableLayout = (TableLayout) _$_findCachedViewById(C0010R$id.layoutExchangeInfoUserFault);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout, str2);
                tableLayout.setVisibility(0);
                TableLayout tableLayout2 = (TableLayout) _$_findCachedViewById(C0010R$id.layoutExchangeInfoSellerFault);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout2, str);
                tableLayout2.setVisibility(8);
            } else if (i == 3 || i == 4) {
                TableLayout tableLayout3 = (TableLayout) _$_findCachedViewById(C0010R$id.layoutExchangeInfoUserFault);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout3, str2);
                tableLayout3.setVisibility(8);
                TableLayout tableLayout4 = (TableLayout) _$_findCachedViewById(C0010R$id.layoutExchangeInfoSellerFault);
                Intrinsics.checkExpressionValueIsNotNull(tableLayout4, str);
                tableLayout4.setVisibility(0);
            }
            TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textSellerName);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textSellerName");
            textView.setText(exchangeApplyResponse.getStoreInfo().getStoreName());
            TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textSellerAddress);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textSellerAddress");
            textView2.setText(exchangeApplyResponse.getStoreInfo().getReturnAddress());
            TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textProductSummary);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "textProductSummary");
            StringBuilder sb = new StringBuilder();
            sb.append(exchangeApplyResponse.getStoreInfo().getStoreName());
            String str3 = " / ";
            sb.append(str3);
            sb.append(exchangeApplyResponse.getOrderLineItemVariant().getVariant().getProduct().getTitle());
            textView3.setText(sb.toString());
            TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textProductOptionSummary);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "textProductOptionSummary");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getProductDetailSummary(exchangeApplyResponse.getOrderLineItemVariant().getVariant().getOption()));
            sb2.append(str3);
            sb2.append(exchangeApplyResponse.getQuantity());
            sb2.append(44060);
            textView4.setText(sb2.toString());
            TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.textExchangeProductOption);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "textExchangeProductOption");
            textView5.setText(exchangeApplyResponse.getExchangeWishOption());
            TextView textView6 = (TextView) _$_findCachedViewById(C0010R$id.textExchangeReason);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "textExchangeReason");
            textView6.setText(getExchangeReason(exchangeApplyResponse));
            TextView textView7 = (TextView) _$_findCachedViewById(C0010R$id.textExchangeDate);
            Intrinsics.checkExpressionValueIsNotNull(textView7, "textExchangeDate");
            textView7.setText(new SimpleDateFormat("yyyy.MM.dd").format(exchangeApplyResponse.getAppliedAt()));
            if (exchangeApplyResponse.getRefundAccount() != null) {
                TextView textView8 = (TextView) _$_findCachedViewById(C0010R$id.textBankName);
                Intrinsics.checkExpressionValueIsNotNull(textView8, "textBankName");
                textView8.setText(exchangeApplyResponse.getRefundAccount().getBankName());
                TextView textView9 = (TextView) _$_findCachedViewById(C0010R$id.textBankAccount);
                Intrinsics.checkExpressionValueIsNotNull(textView9, "textBankAccount");
                textView9.setText(exchangeApplyResponse.getRefundAccount().getAccountNumber());
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public final String getExchangeReason(@NotNull ExchangeApplyResponse exchangeApplyResponse) {
        String str;
        Intrinsics.checkParameterIsNotNull(exchangeApplyResponse, "exchangeApplyResponse");
        String exchangeReason = exchangeApplyResponse.getExchangeReason();
        if (exchangeReason != null) {
            String upperCase = exchangeReason.toUpperCase();
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
            sb.append(exchangeApplyResponse.getDetailReason());
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
