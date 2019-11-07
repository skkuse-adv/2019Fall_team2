package kr.co.popone.fitts.feature.search.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.C0013R$layout;
import kr.co.popone.fitts.base.type.Status;
import kr.co.popone.fitts.feature.feeds.title.SimplePostHolder;
import kr.co.popone.fitts.feature.post.detail.PostActivity;
import kr.co.popone.fitts.feature.search.adapter.PostResultAdapter;
import kr.co.popone.fitts.feature.search.adapter.PostResultAdapter.Delegate;
import kr.co.popone.fitts.ui.ViewExtensionsKt;
import kr.co.popone.fitts.ui.decorator.PostSearchResultDecorator;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PostSearchResultFragment extends Fragment implements Delegate {
    private HashMap _$_findViewCache;
    @NotNull
    public SearchResultViewModel viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[Status.values().length];

        static {
            $EnumSwitchMapping$0[Status.INIT_RUNNING.ordinal()] = 1;
            $EnumSwitchMapping$0[Status.INIT_SUCCESS.ordinal()] = 2;
            $EnumSwitchMapping$0[Status.FAILED.ordinal()] = 3;
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
        return layoutInflater.inflate(C0013R$layout.fragment_post_search_result, viewGroup, false);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.onViewCreated(view, bundle);
        PostResultAdapter postResultAdapter = new PostResultAdapter(this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerPostSearchResult);
        recyclerView.setAdapter(postResultAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new PostSearchResultFragment$onViewCreated$$inlined$apply$lambda$1(postResultAdapter));
        recyclerView.setLayoutManager(gridLayoutManager);
        if (recyclerView.getItemDecorationCount() < 1) {
            recyclerView.addItemDecoration(new PostSearchResultDecorator(SimplePostHolder.Companion.getId()));
        }
        ((SwipeRefreshLayout) _$_findCachedViewById(C0010R$id.refreshLayout)).setOnRefreshListener(new PostSearchResultFragment$onViewCreated$2(this));
        SearchResultViewModel searchResultViewModel = this.viewModel;
        String str = "viewModel";
        if (searchResultViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel.getPostResult().observe(new PostSearchResultFragment$onViewCreated$3(this), new PostSearchResultFragment$onViewCreated$4(postResultAdapter));
        SearchResultViewModel searchResultViewModel2 = this.viewModel;
        if (searchResultViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel2.isEmptyPosts().observe(new PostSearchResultFragment$onViewCreated$5(this), new PostSearchResultFragment$onViewCreated$6(this));
        SearchResultViewModel searchResultViewModel3 = this.viewModel;
        if (searchResultViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        }
        searchResultViewModel3.getPostNetworkState().observe(new PostSearchResultFragment$onViewCreated$7(this), new PostSearchResultFragment$onViewCreated$8(this, postResultAdapter));
    }

    /* access modifiers changed from: private */
    public final void updateEmptyList(boolean z) {
        String str = "emptyResultView";
        String str2 = "recyclerPostSearchResult";
        if (z) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerPostSearchResult);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, str2);
            ViewExtensionsKt.invisible(recyclerView);
            View _$_findCachedViewById = _$_findCachedViewById(C0010R$id.emptyResultView);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, str);
            ViewExtensionsKt.visible(_$_findCachedViewById);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerPostSearchResult);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, str2);
        ViewExtensionsKt.visible(recyclerView2);
        View _$_findCachedViewById2 = _$_findCachedViewById(C0010R$id.emptyResultView);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, str);
        ViewExtensionsKt.invisible(_$_findCachedViewById2);
    }

    public void onPostClick(long j) {
        PostActivity.Companion.start(getContext(), j, null);
    }

    public void onDestroyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C0010R$id.recyclerPostSearchResult);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerPostSearchResult");
        recyclerView.setAdapter(null);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
