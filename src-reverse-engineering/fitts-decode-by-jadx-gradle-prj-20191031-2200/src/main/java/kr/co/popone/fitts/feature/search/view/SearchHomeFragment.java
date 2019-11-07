package kr.co.popone.fitts.feature.search.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.HotStyleDetailAdapter;
import kr.co.popone.fitts.ui.decorator.HotStyleDetailDecorator;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;
import me.gujun.android.taggroup.TagGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchHomeFragment extends Fragment implements kr.co.popone.fitts.feature.search.HotStyleDetailViewHolder.Delegate {
    public static final Companion Companion = new Companion(null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Delegate listener;
    @NotNull
    public SearchViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchHomeFragment newInstance() {
            return new SearchHomeFragment();
        }
    }

    public interface Delegate {
        void onKeywordInput(@NotNull String str);
    }

    @NotNull
    public static final SearchHomeFragment newInstance() {
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

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.listener = (Delegate) activity;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kr.co.popone.fitts.feature.search.view.SearchHomeFragment.Delegate");
    }

    public void onCreate(@Nullable Bundle bundle) {
        AndroidSupportInjection.inject(this);
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_search_home, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        HotStyleDetailAdapter hotStyleDetailAdapter = new HotStyleDetailAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recommendStyleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(hotStyleDetailAdapter);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new HotStyleDetailDecorator());
        }
        ((TagGroup) _$_findCachedViewById(C0010R$id.hotKeywordTag)).setOnTagClickListener(new SearchHomeFragment$onViewCreated$2(this));
        SearchViewModel searchViewModel = this.viewModel;
        String str = "viewModel";
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchViewModel.getRecommendKeywords().observe(new SearchHomeFragment$onViewCreated$3(this), new SearchHomeFragment$onViewCreated$4(this));
        SearchViewModel searchViewModel2 = this.viewModel;
        if (searchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchViewModel2.getStyleKeywords().observe(new SearchHomeFragment$onViewCreated$5(this), new SearchHomeFragment$onViewCreated$6(hotStyleDetailAdapter));
    }

    public void onStyleClicked(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "style");
        Delegate delegate = this.listener;
        if (delegate != null) {
            delegate.onKeywordInput(str);
        }
    }

    public void onDestroyView() {
        SearchViewModel searchViewModel = this.viewModel;
        String str = "viewModel";
        if (searchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchViewModel.getRecommendKeywords().removeObservers(this);
        SearchViewModel searchViewModel2 = this.viewModel;
        if (searchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchViewModel2.getStyleKeywords().removeObservers(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recommendStyleRecyclerView);
        String str2 = "recommendStyleRecyclerView";
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, str2);
        recyclerView.setAdapter(null);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recommendStyleRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
        recyclerView2.setLayoutManager(null);
        this.listener = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
