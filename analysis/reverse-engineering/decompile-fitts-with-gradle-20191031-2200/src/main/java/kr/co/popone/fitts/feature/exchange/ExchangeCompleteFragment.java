package kr.co.popone.fitts.feature.exchange;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public final class ExchangeCompleteFragment extends Fragment {
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
        public final ExchangeCompleteFragment newInstance() {
            return new ExchangeCompleteFragment();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[ExchangeReason.values().length];

        static {
            $EnumSwitchMapping$0[ExchangeReason.CUSTOMER_REMORSE.ordinal()] = 1;
            $EnumSwitchMapping$0[ExchangeReason.WRONG_ORDER.ordinal()] = 2;
            $EnumSwitchMapping$0[ExchangeReason.FAULTY_PRODUCT.ordinal()] = 3;
            $EnumSwitchMapping$0[ExchangeReason.SHIPPING_PROBLEM.ordinal()] = 4;
        }
    }

    @NotNull
    public static final ExchangeCompleteFragment newInstance() {
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
        return layoutInflater.inflate(C0013R$layout.fragment_exchange_complete, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((FrameLayout) _$_findCachedViewById(C0010R$id.backButton)).setOnClickListener(new ExchangeCompleteFragment$onViewCreated$1(this));
        ExchangeDetailViewModel exchangeDetailViewModel = this.viewModel;
        if (exchangeDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        exchangeDetailViewModel.getExchangeInfoLiveData().observe(new ExchangeCompleteFragment$onViewCreated$2(this), new ExchangeCompleteFragment$onViewCreated$3(this));
    }

    public final void updateExchangeDetailUi(@NotNull ExchangeApplyResponse exchangeApplyResponse) {
        Intrinsics.checkParameterIsNotNull(exchangeApplyResponse, "exchangeApplyResponse");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textProductSummary);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductSummary");
        StringBuilder sb = new StringBuilder();
        sb.append(exchangeApplyResponse.getStoreInfo().getStoreName());
        String str = " / ";
        sb.append(str);
        sb.append(exchangeApplyResponse.getOrderLineItemVariant().getVariant().getProduct().getTitle());
        textView.setText(sb.toString());
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textProductOptionSummary);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textProductOptionSummary");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getProductDetailSummary(exchangeApplyResponse.getOrderLineItemVariant().getVariant().getOption()));
        sb2.append(str);
        sb2.append(exchangeApplyResponse.getQuantity());
        sb2.append(44060);
        textView2.setText(sb2.toString());
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textExchangeProductOption);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textExchangeProductOption");
        textView3.setText(exchangeApplyResponse.getExchangeWishOption());
        TextView textView4 = (TextView) _$_findCachedViewById(C0010R$id.textExchangeReason);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "textExchangeReason");
        textView4.setText(getExchangeReason(exchangeApplyResponse));
        TextView textView5 = (TextView) _$_findCachedViewById(C0010R$id.textExchangeDate);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "textExchangeDate");
        textView5.setText(new SimpleDateFormat("yyyy.MM.dd").format(exchangeApplyResponse.getAppliedAt()));
    }

    @NotNull
    public final String getExchangeReason(@NotNull ExchangeApplyResponse exchangeApplyResponse) {
        String str;
        Intrinsics.checkParameterIsNotNull(exchangeApplyResponse, "exchangeApplyResponse");
        String exchangeReason = exchangeApplyResponse.getExchangeReason();
        if (exchangeReason != null) {
            String upperCase = exchangeReason.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            int i = WhenMappings.$EnumSwitchMapping$0[ExchangeReason.valueOf(upperCase).ordinal()];
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
