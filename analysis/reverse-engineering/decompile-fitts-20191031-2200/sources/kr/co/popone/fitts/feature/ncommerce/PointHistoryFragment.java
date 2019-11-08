package kr.co.popone.fitts.feature.ncommerce;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PointHistoryFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public final PointHistoryAdapter pointHistoryAdapter = new PointHistoryAdapter();
    @NotNull
    public NCommerceViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PointHistoryFragment newInstance() {
            return new PointHistoryFragment();
        }
    }

    @NotNull
    public static final PointHistoryFragment newInstance() {
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
        return layoutInflater.inflate(C0013R$layout.fragment_point_history, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ((RecyclerView) _$_findCachedViewById(C0010R$id.recyclerPointHistory)).setAdapter(this.pointHistoryAdapter);
        NCommerceViewModel nCommerceViewModel = this.viewModel;
        String str = "viewModel";
        if (nCommerceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        nCommerceViewModel.requestPointHistory();
        NCommerceViewModel nCommerceViewModel2 = this.viewModel;
        if (nCommerceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData pagedPointHistoryLiveData = nCommerceViewModel2.getPagedPointHistoryLiveData();
        if (pagedPointHistoryLiveData != null) {
            pagedPointHistoryLiveData.observe(new PointHistoryFragment$onViewCreated$2(this), new PointHistoryFragment$onViewCreated$3(this));
        }
        NCommerceViewModel nCommerceViewModel3 = this.viewModel;
        if (nCommerceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData emptyListState = nCommerceViewModel3.getEmptyListState();
        if (emptyListState != null) {
            emptyListState.observe(new PointHistoryFragment$onViewCreated$4(this), new PointHistoryFragment$onViewCreated$5(this));
        }
        NCommerceViewModel nCommerceViewModel4 = this.viewModel;
        if (nCommerceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        LiveData networkState = nCommerceViewModel4.getNetworkState();
        if (networkState != null) {
            networkState.observe(new PointHistoryFragment$onViewCreated$6(this), new PointHistoryFragment$onViewCreated$7(this));
        }
    }
}
