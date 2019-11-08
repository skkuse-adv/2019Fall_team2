package kr.co.popone.fitts.feature.search.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.feature.search.adapter.SearchResultAdapter;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SearchResultFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_KEYWORD = "keyword";
    private HashMap _$_findViewCache;
    private final List<Fragment> fragments = CollectionsKt__CollectionsKt.listOf(IntergratedSearchResultFragment.Companion.newInstance(), new PostSearchResultFragment(), new ProductSearchResultFragment(), new FittieSearchResultFragment());
    @NotNull
    public SearchResultViewModel viewModel;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchResultFragment newInstance(@NotNull String str) {
            String str2 = SearchResultFragment.KEY_KEYWORD;
            Intrinsics.checkParameterIsNotNull(str, str2);
            SearchResultFragment searchResultFragment = new SearchResultFragment();
            Bundle bundle = new Bundle();
            bundle.putString(str2, str);
            searchResultFragment.setArguments(bundle);
            return searchResultFragment;
        }
    }

    @NotNull
    public static final SearchResultFragment newInstance(@NotNull String str) {
        return Companion.newInstance(str);
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
    public final SearchResultViewModel getViewModel() {
        SearchResultViewModel searchResultViewModel = this.viewModel;
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return searchResultViewModel;
    }

    public final void setViewModel(@NotNull SearchResultViewModel searchResultViewModel) {
        Intrinsics.checkParameterIsNotNull(searchResultViewModel, "<set-?>");
        this.viewModel = searchResultViewModel;
    }

    public void onAttach(@Nullable Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(C0013R$layout.fragment_search_result, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.pagerSearchResult);
        viewPager.setAdapter(new SearchResultAdapter(this.fragments, getChildFragmentManager()));
        viewPager.setOffscreenPageLimit(3);
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(C0010R$id.tabSearchResult);
        tabLayout.setupWithViewPager((ViewPager) _$_findCachedViewById(C0010R$id.pagerSearchResult));
        tabLayout.addOnTabSelectedListener(new SearchResultFragment$onViewCreated$$inlined$apply$lambda$1(this));
    }

    public final void switchSearchTab(int i) {
        if (getActivity() != null) {
            ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.pagerSearchResult);
            Intrinsics.checkExpressionValueIsNotNull(viewPager, "pagerSearchResult");
            viewPager.setCurrentItem(i);
        }
    }

    public void onDestroyView() {
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(C0010R$id.pagerSearchResult);
        Intrinsics.checkExpressionValueIsNotNull(viewPager, "pagerSearchResult");
        viewPager.setAdapter(null);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
