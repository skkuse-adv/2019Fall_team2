package kr.co.popone.fitts.feature.search.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.adapter.SearchHistoryAdapter;
import kr.co.popone.fitts.ui.decorator.SearchHistoryDecorator;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHistoryFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    @Nullable
    private Delegate delegate;
    @NotNull
    public SearchViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchHistoryFragment newInstance() {
            return new SearchHistoryFragment();
        }
    }

    public interface Delegate extends kr.co.popone.fitts.feature.search.adapter.SearchHistoryAdapter.Delegate {
    }

    @NotNull
    public static final SearchHistoryFragment newInstance() {
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
    public final SearchViewModel getViewModel() {
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return searchViewModel;
    }

    public final void setViewModel(@NotNull SearchViewModel searchViewModel) {
        Intrinsics.checkParameterIsNotNull(searchViewModel, "<set-?>");
        this.viewModel = searchViewModel;
    }

    @Nullable
    public final Delegate getDelegate$app_productionFittsRelease() {
        return this.delegate;
    }

    public final void setDelegate$app_productionFittsRelease(@Nullable Delegate delegate2) {
        this.delegate = delegate2;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        if (context instanceof SearchActivity) {
            this.delegate = (Delegate) context;
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_search_history, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        SearchHistoryAdapter searchHistoryAdapter = new SearchHistoryAdapter(this.delegate);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerSearchHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(searchHistoryAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new SearchHistoryDecorator());
        }
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        searchViewModel.getHistoryKeywords().observe(new SearchHistoryFragment$onViewCreated$2(this), new SearchHistoryFragment$onViewCreated$3(searchHistoryAdapter));
    }

    public void onDestroy() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerSearchHistory);
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
