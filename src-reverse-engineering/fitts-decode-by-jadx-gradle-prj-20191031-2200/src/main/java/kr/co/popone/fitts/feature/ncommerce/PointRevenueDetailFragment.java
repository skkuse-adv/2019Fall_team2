package kr.co.popone.fitts.feature.ncommerce;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.model.remote.user.NCommerce;
import kr.co.popone.fitts.ui.custom.circlepercentage.CirclePercentageView;
import kr.co.popone.fitts.ui.decorator.SimpleLinearOffsetDecorator;
import kr.co.popone.fitts.utils.IntExtensionsKt;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointRevenueDetailFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    private final PointLastRevenueAdapter pointLastRevenueAdapter = new PointLastRevenueAdapter();
    /* access modifiers changed from: private */
    public final PointRevenueTopThreeAdapter pointRevenueTopThreeAdapter = new PointRevenueTopThreeAdapter();
    @NotNull
    public NCommerceViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PointRevenueDetailFragment newInstance() {
            return new PointRevenueDetailFragment();
        }
    }

    @NotNull
    public static final PointRevenueDetailFragment newInstance() {
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
    public final NCommerceViewModel getViewModel() {
        NCommerceViewModel nCommerceViewModel = this.viewModel;
        if (nCommerceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return nCommerceViewModel;
    }

    public final void setViewModel(@NotNull NCommerceViewModel nCommerceViewModel) {
        Intrinsics.checkParameterIsNotNull(nCommerceViewModel, "<set-?>");
        this.viewModel = nCommerceViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_revenue_detail, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerViewTopThree);
        recyclerView.setAdapter(this.pointRevenueTopThreeAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new SimpleLinearOffsetDecorator(5, 0, 0, 5));
        }
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerLastRevenue)).setAdapter(this.pointLastRevenueAdapter);
        NCommerceViewModel nCommerceViewModel = this.viewModel;
        String str = "viewModel";
        if (nCommerceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel.getNCommerceResponseLiveData().observe(new PointRevenueDetailFragment$onViewCreated$3(this), new PointRevenueDetailFragment$onViewCreated$4(this));
        NCommerceViewModel nCommerceViewModel2 = this.viewModel;
        if (nCommerceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel2.getErrorLiveData().observe(new PointRevenueDetailFragment$onViewCreated$5(this), new PointRevenueDetailFragment$onViewCreated$6(this));
        NCommerceViewModel nCommerceViewModel3 = this.viewModel;
        if (nCommerceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel3.getMostRevenuePostLiveData().observe(new PointRevenueDetailFragment$onViewCreated$7(this), new PointRevenueDetailFragment$onViewCreated$8(this));
        NCommerceViewModel nCommerceViewModel4 = this.viewModel;
        if (nCommerceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel4.requestNCommerceInfo();
    }

    public final void updateNCommerceInfo(@NotNull NCommerce nCommerce) {
        Intrinsics.checkParameterIsNotNull(nCommerce, "nCommerce");
        TextView textView = (TextView) _$_findCachedViewById(C0010R$id.textTotalIncome);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textTotalIncome");
        textView.setText(IntExtensionsKt.commaString(nCommerce.getTotalPoint()));
        TextView textView2 = (TextView) _$_findCachedViewById(C0010R$id.textFittsPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "textFittsPoint");
        textView2.setText(IntExtensionsKt.commaString(nCommerce.getPoint()));
        TextView textView3 = (TextView) _$_findCachedViewById(C0010R$id.textSharedPoint);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "textSharedPoint");
        textView3.setText(IntExtensionsKt.commaString(nCommerce.getSharedPoint()));
        try {
            float f = (float) 100;
            float point = (((float) nCommerce.getPoint()) / ((float) nCommerce.getTotalPoint())) * f;
            ((CirclePercentageView) _$_findCachedViewById(C0010R$id.circlePercentView)).setPercent((int) point, (int) ((((float) nCommerce.getSharedPoint()) / ((float) nCommerce.getTotalPoint())) * f));
        } catch (ArithmeticException unused) {
            ((CirclePercentageView) _$_findCachedViewById(C0010R$id.circlePercentView)).setPercent(0, 0);
        }
    }

    public final void updateLastRevenueInfo(@NotNull List<NCommerce> list) {
        Intrinsics.checkParameterIsNotNull(list, "nCommerces");
        View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.layoutLastRevenue);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "layoutLastRevenue");
        _$_findCachedViewById.setVisibility(list.isEmpty() ? 8 : 0);
        this.pointLastRevenueAdapter.setItems(list);
    }
}
